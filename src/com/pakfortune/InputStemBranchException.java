package com.pakfortune;

public class InputStemBranchException extends Exception {
    public InputStemBranchException() {
        super("請用繁體填寫正確干支。。。");
    }

    public InputStemBranchException(String message) {
        super(message);
    }
}
