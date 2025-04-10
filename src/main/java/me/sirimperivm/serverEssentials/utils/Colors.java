package me.sirimperivm.serverEssentials.utils;

import me.sirimperivm.rgbColorsApi.RgbColorApi;

@SuppressWarnings("all")
public class Colors {

    public static String translate(String s) {
        return RgbColorApi.colorize(s);
    }
}
