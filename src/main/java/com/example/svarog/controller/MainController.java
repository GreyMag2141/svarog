package com.example.svarog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "MainController", description = "API for svarog")
public class MainController {

    @ApiOperation(value = "getProduct", nickname = "getHello")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful",
                    response = Process.class)})
    @RequestMapping(method = RequestMethod.GET, value = "/getHello")
    public String getHello(@RequestParam String name) {
        return "hello " + name;
    }
}
