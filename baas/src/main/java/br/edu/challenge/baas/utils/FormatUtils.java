package br.edu.challenge.baas.utils;

public class FormatUtils {
    public String toWithoutFormatDocument(String document) {
        return document.replaceAll("[ˆ0-9]", "");
    }
}