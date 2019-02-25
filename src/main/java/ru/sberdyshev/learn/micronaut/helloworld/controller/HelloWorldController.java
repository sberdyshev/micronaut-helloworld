package ru.sberdyshev.learn.micronaut.helloworld.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {
    @Get("/")
    public HttpResponse<?> index(final HttpHeaders headers) {
        final String message = "Hello World";
        if (headerAcceptXml(headers)) {
            final String xml = encodeAsXml(message);
            return HttpResponse.ok(xml)
                    .contentType(MediaType.APPLICATION_XML_TYPE);
        }
        return HttpResponse.ok(message).contentType(MediaType.APPLICATION_JSON);
    }

    private boolean headerAcceptXml(final HttpHeaders headers) {
        return headers.accept().contains(MediaType.APPLICATION_XML_TYPE);
    }

    private String encodeAsXml(final String message) {
        return String.format("<content>%s</content>", message);
    }
}