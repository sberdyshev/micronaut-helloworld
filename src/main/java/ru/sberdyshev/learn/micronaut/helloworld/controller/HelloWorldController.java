package ru.sberdyshev.learn.micronaut.helloworld.controller;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {
    @Get(produces = MediaType.APPLICATION_JSON)
    public String index() {
        return "Hello World";
    }
}