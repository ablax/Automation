package me.ablax.project.utils;

import java.text.DecimalFormat;

public final class DoubleUtils {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private DoubleUtils() {
    }

    public static Double floorDown(final Double doubleValue) {
        return Math.floor(doubleValue.doubleValue() * 100) / 100.0;
    }

    public static String toString(Double doubleValue) {
        doubleValue = floorDown(doubleValue);
        int i = doubleValue.intValue();
            return doubleValue == i ? String.valueOf(i) : String.format("%.2f",doubleValue).replace(",", ".");
    }
}
