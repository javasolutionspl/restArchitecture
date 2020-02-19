/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.example.model;

/**
 * @author PUMA SE
 * @copyright Copyright (c) PUMA SE
 */
public class CheckKeyResult {

    private boolean correct;

    public CheckKeyResult() {
    }

    public CheckKeyResult(boolean correct) {

        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean isCorrect) {
        this.correct = isCorrect;
    }
}
