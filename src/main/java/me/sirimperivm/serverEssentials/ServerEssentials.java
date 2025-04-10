package me.sirimperivm.serverEssentials;

import me.sirimperivm.serverEssentials.utils.Logger;
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
        Logger.success("ServerEssentials has been enabled!");
    }

    @Override
    public void onDisable() {
        Logger.success("ServerEssentials has been disabled!");
    }

    public ServerEssentials getPlugin() {
        return plugin;
    }

    public static ServerEssentials getInstance() {
        return instance;
    }
}
