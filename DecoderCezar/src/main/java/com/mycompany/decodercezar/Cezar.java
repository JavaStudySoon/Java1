package com.mycompany.decodercezar;

public class Cezar {

    private int k;
    private String line;

    public Cezar() {
    }

    public Cezar(String line, int k) {
        this.line = line;
        this.k = k;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getKoeficient() {
        return k;
    }

    public void setKoeficient(int k) {
        this.k = k;
    }

    public String CezarDecoder() {

        String alfabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСЕУФХЦЧШЩЬЮЯ";
        String lineUpper = line.toUpperCase();
        int letterQty = alfabet.length();
        String retVal = "";

        for (int i = 0; i < lineUpper.length(); i++) {
            char c = lineUpper.charAt(i);
            int index = alfabet.indexOf(c);
            if (index < 0) {
                retVal += c;
            } else {
                int codeIndex = (letterQty + index - k) % letterQty;
                retVal += alfabet.charAt(codeIndex);
            }
        }
        return retVal;
    }

    public String CezarCoder() {

        String alfabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСЕУФХЦЧШЩЬЮЯ";
        String lineUpper = line.toUpperCase();
        int letterQty = alfabet.length();
        String retVal = "";

        for (int i = 0; i < lineUpper.length(); i++) {
            char c = lineUpper.charAt(i);
            int index = alfabet.indexOf(c);
            if (index < 0) {
                retVal += c;
            } else {
                int codeIndex = (letterQty + index + k) % letterQty;
                retVal += alfabet.charAt(codeIndex);
            }
        }
        return retVal;
    }
}
