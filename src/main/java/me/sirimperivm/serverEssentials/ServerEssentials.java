package me.sirimperivm.serverEssentials;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public final class ServerEssentials extends JavaPlugin {

    private ServerEssentials plugin;
    private static ServerEssentials instance;

    @Override
    public void onLoad() {
        plugin = this;
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ServerEssentials getPlugin() {
        return plugin;
    }

    public static ServerEssentials getInstance() {
        return instance;
    }
}
