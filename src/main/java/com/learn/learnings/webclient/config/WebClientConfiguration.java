package com.learn.learnings.webclient.config;

import com.learn.learnings.webclient.interceptor.WebClientFilter;
import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import javax.net.ssl.SSLException;
import java.time.Duration;

@Configuration
public class WebClientConfiguration {

    private final WebClientFilter webClientFilter;

    @Autowired
    public WebClientConfiguration(WebClientFilter webClientFilter) {
        this.webClientFilter = webClientFilter;
    }

    @Bean
    public ConnectionProvider connectionProvider() {
        return ConnectionProvider.builder("webclient")
                .maxConnections(60000)
                .maxIdleTime(Duration.ofMillis(60000))
                .maxLifeTime(Duration.ofMillis(50000))
                .pendingAcquireTimeout(Duration.ofMillis(60000))
                .evictInBackground(Duration.ofMillis(60000))
                .build();
    }


    @Bean
    public HttpClient createHttpClient(ConnectionProvider connectionProvider) {
        try {
            SslContext sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
            return HttpClient.create(connectionProvider)
                    .secure(t -> t.sslContext(sslContext))
                    .wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60000)
                    .doOnConnected(c ->
                            c.addHandlerLast(new ReadTimeoutHandler(60000))
                                    .addHandlerLast(new ReadTimeoutHandler(60000)))
                    .responseTimeout(Duration.ofMillis(60000));
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public WebClient webClient(HttpClient httpClient) {
        WebClient webClient = null;
        try {
            ReactorClientHttpConnector reactorClientHttpConnector = new ReactorClientHttpConnector(httpClient);
            webClient = WebClient.builder()
                    .clientConnector(reactorClientHttpConnector)
                    .filter(webClientFilter.requestFilter())
                    .filter(webClientFilter.responseFilter())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return webClient;
    }

}
