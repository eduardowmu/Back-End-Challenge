package br.com.challenge.baas.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtils {
    public static String toWithoutFormat(String document) {
        return document.replaceAll("[^0-9]", "");
    }

    public static BigDecimal toBigDecimal(Double value) {
        return new BigDecimal(value);
    }

    public static String dateToText(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}