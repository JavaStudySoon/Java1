package com.mycompany.palendrom;

public class Palendrom {

    private String line;

    public Palendrom() {
    }

    public Palendrom(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean isPalindrome(String text) {

        String clean = text.replaceAll("\\s+", "").toLowerCase();

        int length = clean.length();
        int forward = 0;
        int backward = length - 1;

        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }

}
