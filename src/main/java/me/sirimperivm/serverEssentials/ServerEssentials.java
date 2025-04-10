package me.sirimperivm.serverEssentials;

import me.sirimperivm.serverEssentials.handlers.ConfigHandler;
import me.sirimperivm.serverEssentials.utils.Logger;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public final class ServerEssentials extends JavaPlugin {

    private ServerEssentials plugin;
    private static ServerEssentials instance;

    private ConfigHandler configHandler;

    @Override
    public void onLoad() {
        plugin = this;
        instance = this;
    }

    @Override
    public void onEnable() {
        configHandler = new ConfigHandler(plugin);
        Logger.setDebug(configHandler.getDebugMode());

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

    public ConfigHandler getConfigHandler() {
        return configHandler;
    }
}
