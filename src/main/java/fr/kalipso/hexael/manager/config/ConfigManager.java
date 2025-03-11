package fr.kalipso.hexael.manager.config;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.config.BukkitConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager extends Manager {

    private BukkitConfiguration mainConfig;
    private BukkitConfiguration messagesConfig;
    private BukkitConfiguration motdConfig;
    private BukkitConfiguration autoannounceConfig;
    private BukkitConfiguration deathmessageConfig;
    private BukkitConfiguration votepartyConfig;
    private BukkitConfiguration chatConfig;

    public ConfigManager()
    {
        this.loadConfigs();
    }

    public void loadConfigs()
    {
        mainConfig = new BukkitConfiguration(this.getInstance(), "config", this.getInstance().getDataFolder().getAbsolutePath());
        mainConfig.load();
        messagesConfig = new BukkitConfiguration(this.getInstance(), "messages", this.getInstance().getDataFolder().getAbsolutePath());
        messagesConfig.load();
        motdConfig = new BukkitConfiguration(this.getInstance(), "motd", this.getInstance().getDataFolder().getAbsolutePath());
        motdConfig.load();
        autoannounceConfig = new BukkitConfiguration(this.getInstance(), "autoannounce", this.getInstance().getDataFolder().getAbsolutePath());
        autoannounceConfig.load();
        deathmessageConfig = new BukkitConfiguration(this.getInstance(), "deathmessages", this.getInstance().getDataFolder().getAbsolutePath());
        deathmessageConfig.load();
        votepartyConfig = new BukkitConfiguration(this.getInstance(), "voteparty", this.getInstance().getDataFolder().getAbsolutePath());
        votepartyConfig.load();
        chatConfig = new BukkitConfiguration(this.getInstance(), "chat", this.getInstance().getDataFolder().getAbsolutePath());
        chatConfig.load();
    }

    public YamlConfiguration get(String name)
    {
        if(name.equals("main")) {
            return mainConfig.getImplementation();
        }
        else if(name.equals("chat"))
        {
            return chatConfig.getImplementation();
        }
        else if(name.equals("messages"))
        {
            return messagesConfig.getImplementation();
        }
        else if(name.equals("motd"))
        {
            return motdConfig.getImplementation();
        }
        else if(name.equals("autoannounce"))
        {
            return autoannounceConfig.getImplementation();
        }
        else if(name.equals("deathmessage"))
        {
            return deathmessageConfig.getImplementation();
        }
        else if(name.equals("voteparty"))
        {
            return votepartyConfig.getImplementation();
        }
        return null;
    }
}
