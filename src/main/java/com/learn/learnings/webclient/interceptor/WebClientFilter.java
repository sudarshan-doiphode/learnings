package com.learn.learnings.webclient.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import reactor.core.publisher.Mono;

@Component
public class WebClientFilter {

    public static final Logger logger = LoggerFactory.getLogger(WebClientFilter.class);

    public ExchangeFilterFunction requestFilter() {

        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            ClientRequest.Builder clientRequest1 = ClientRequest.from(clientRequest)
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            if (clientRequest.url().toString().endsWith("token")) {
                clientRequest1.header(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            } else {
                clientRequest1.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            }
            ClientRequest request = clientRequest1.build();

            request.headers().forEach((h, v) -> logger.info("Request Header Key: and Value: {}{}", h, v));

            logger.info(request.url().toString());
            logger.info(request.method().toString());
            return Mono.just(request);
        });
    }

    //ExchangeStrategy used for response size
    ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024))
            .build();

    public ExchangeFilterFunction responseFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            logger.info("Response Status: {}", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }

}
