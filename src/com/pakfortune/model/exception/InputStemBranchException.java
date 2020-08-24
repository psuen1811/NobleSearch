package com.pakfortune.model.exception;

public class InputStemBranchException extends Exception {
    public InputStemBranchException() {
        super("請用繁體填寫正確干支。。。");
    }

    @SuppressWarnings("unused")
    public InputStemBranchException(String message) {
        super(message);
    }
}
