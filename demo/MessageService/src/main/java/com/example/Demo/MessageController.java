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
public class MessageController {

    private static final String SECRET_MESSAGE = "Super tajna wiadomosc";

    @GetMapping("/getMessage")
    public SecretMessage getMessage() {

        return new SecretMessage(SECRET_MESSAGE);
    }
}
