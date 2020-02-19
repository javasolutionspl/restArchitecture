/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.example.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class KeyController {

    private static final String SECRET_KEY = "123";

    @GetMapping("/checkKey")
    public CheckKeyResult checkKey(@RequestParam(value = "key", defaultValue = "") String key) {

        boolean isKeyCorrect = SECRET_KEY.equals(key);
        return new CheckKeyResult(isKeyCorrect);
    }
}
