package me.sirimperivm.serverEssentials.utils;

import org.bukkit.Bukkit;

@SuppressWarnings("all")
public class Logger {

    public static boolean debug;

    public static void success(String message) {
        Bukkit.getConsoleSender().sendMessage(Colors.translate("&a[ServerEssentials] " + message));
    }

    public static void info(String message) {
        Bukkit.getConsoleSender().sendMessage(Colors.translate("&e[ServerEssentials] " + message));
    }

    public static void error(String message) {
        Bukkit.getConsoleSender().sendMessage(Colors.translate("&c[ServerEssentials] " + message));
    }

    public static void debug(String message) {
        if (debug) Bukkit.getConsoleSender().sendMessage(Colors.translate("&b[SE - Debug] " + message));
    }
}
