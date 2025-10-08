package me.SavageUser.CustomDeaths.CFGUtil;

import org.bukkit.util.config.Configuration;

import java.io.File;

public class MainCFG extends Configuration {
    public MainCFG(File file) {
        super(file);
        this.reload();
    }

    public void reload() {
        this.load();
        this.write();
        this.save();
    }

    public void write() {
        generateConfigOption("Settings.enableDiscordLogging", false);
    }

    private void generateConfigOption(String key, Object defaultValue) {
        if (this.getProperty(key) == null) {
            this.setProperty(key, defaultValue);
        }

        Object value = this.getProperty(key);
        this.removeProperty(key);
        this.setProperty(key, value);
    }

    public Object getConfigOption(String key) {
        return this.getProperty(key);
    }

    public Object getConfigOption(String key, Object defaultValue) {
        Object value = this.getConfigOption(key);
        if (value == null) {
            value = defaultValue;
        }

        return value;
    }
}
