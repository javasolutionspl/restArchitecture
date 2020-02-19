/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.example.Demo;

/**
 * @author PUMA SE
 * @copyright Copyright (c) PUMA SE
 */
public class CheckKeyResult {

    private boolean isCorrect;

    public CheckKeyResult(boolean isCorrect) {

        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
