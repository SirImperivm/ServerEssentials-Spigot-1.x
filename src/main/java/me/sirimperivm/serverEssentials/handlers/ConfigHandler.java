package me.sirimperivm.serverEssentials.handlers;

import me.sirimperivm.serverEssentials.ServerEssentials;
import me.sirimperivm.serverEssentials.utils.Colors;
import me.sirimperivm.serverEssentials.utils.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;

@SuppressWarnings("all")
public class ConfigHandler {

    private ServerEssentials plugin;

    private File folder;
    private File settingsFile, messagesFile, modulesFile, storageFile;
    private FileConfiguration settings, messages, modules, storage;

    public ConfigHandler(ServerEssentials plugin) {
        this.plugin = plugin;

        folder = plugin.getDataFolder();
        settingsFile = new File(folder, "settings.yml");
        settings = new YamlConfiguration();
        messagesFile = new File(folder, "messages.yml");
        messages = new YamlConfiguration();
        modulesFile = new File(folder, "modules.yml");
        modules = new YamlConfiguration();
        storageFile = new File(folder, "storage.yml");
        storage = new YamlConfiguration();

        if (!folder.exists()) {
            folder.mkdirs();
        }

        createAll();
        loadAll();
    }

    private void create(File f) {
        String n = f.getName();
        if (f.exists()) return;

        try {
            Files.copy(plugin.getResource(n), f.toPath(), new CopyOption[0]);
        } catch (IOException e) {
            Logger.error("Could not create " + n + " file!");
            e.printStackTrace();
        }
    }

    public void save(FileConfiguration c, File f) {
        String n = f.getName();
        try {
            c.save(f);
        } catch (IOException e) {
            Logger.error("Could not save " + n + " file!");
            e.printStackTrace();
        }
    }

    public void load(FileConfiguration c, File f) {
        String n = f.getName();
        try {
            c.load(f);
        } catch (IOException | InvalidConfigurationException e) {
            Logger.error("Could not load " + n + " file!");
            e.printStackTrace();
        }
    }

    public void createAll() {
        create(settingsFile);
        create(messagesFile);
        create(modulesFile);
        create(storageFile);
    }

    public void saveAll() {
        save(settings, settingsFile);
        save(messages, messagesFile);
        save(modules, modulesFile);
        save(storage, storageFile);
    }

    public void loadAll() {
        load(settings, settingsFile);
        load(messages, messagesFile);
        load(modules, modulesFile);
        load(storage, storageFile);
    }

    public File getSettingsFile() {
        return settingsFile;
    }

    public FileConfiguration getSettings() {
        return settings;
    }

    public File getMessagesFile() {
        return messagesFile;
    }

    public FileConfiguration getMessages() {
        return messages;
    }

    public File getModulesFile() {
        return modulesFile;
    }

    public FileConfiguration getModules() {
        return modules;
    }

    public File getStorageFile() {
        return storageFile;
    }

    public FileConfiguration getStorage() {
        return storage;
    }

    public static String getTranslatedString(FileConfiguration c, String p) {
        return Colors.translate(c.getString(p));
    }

    public static String getTranslatedString(FileConfiguration c, String p, String d) {
        return Colors.translate(c.getString(p, d));
    }
}
