/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.example.controller;

import com.example.model.CheckKeyResult;
import com.example.model.KeyModel;
import com.example.model.SecretMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

/**
 * @author PUMA SE
 * @copyright Copyright (c) PUMA SE
 */
@Controller
public class SafeController {

    private static final String KEY_FORM_MODEL_ATTR_NAME = "keyModel";

    private static final String SAFE_OPENED_ATTR_NAME = "isSafeOpened";

    private static final String MESSAGE_ATTR_NAME = "message";

    @GetMapping("/safe")
    public String safeGet(Model model) {

        model.addAttribute(KEY_FORM_MODEL_ATTR_NAME, new KeyModel());
        return "safe";
    }

    @PostMapping("/safe")
    public String safePost(@ModelAttribute(KEY_FORM_MODEL_ATTR_NAME) KeyModel key, Model model) {

        boolean keyCorrect = checkKeyIsCorrect(key);
        model.addAttribute(SAFE_OPENED_ATTR_NAME, keyCorrect);

        if (keyCorrect) {
            String message = fetchSecretMessage();
            model.addAttribute(MESSAGE_ATTR_NAME, message);
        } else {
            model.addAttribute(MESSAGE_ATTR_NAME, "");
        }

        return "safe";
    }

    private boolean checkKeyIsCorrect(KeyModel key) {

        String userKey = key.getKey();
        RestTemplate restTemplate = new RestTemplate();
        CheckKeyResult result = restTemplate.getForObject("http://localhost:8081/checkKey?key={key}", CheckKeyResult.class, Collections.singletonMap("key", userKey));
        return result.isCorrect();
    }

    private String fetchSecretMessage() {

        RestTemplate restTemplate = new RestTemplate();
        SecretMessage result = restTemplate.getForObject("http://localhost:8082/getMessage", SecretMessage.class);
        return result.getText();
    }
}
