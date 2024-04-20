package com.learn.learnings.resttemplate.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Perform any custom logic before the request is sent
        System.out.println("Before request: " + request.getMethod() + " " + request.getURI());

        // Proceed with the request
        ClientHttpResponse response = execution.execute(request, body);

        // Perform any custom logic after the response is received
        System.out.println("After response: " + response.getStatusCode());

        return response;
    }
}
