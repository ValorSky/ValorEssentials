package fr.kalipso.hexael;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.enchant.command.EnchantCommand;
import fr.kalipso.hexael.manager.privatemessage.command.PrivateMessageCommand;
import fr.kalipso.hexael.manager.privatemessage.command.ResponseCommand;
import fr.kalipso.hexael.manager.teleport.command.TeleportCommand;
import fr.kalipso.hexael.utils.io.IOUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class hEssentials extends JavaPlugin {
    @Getter
    private static hEssentials instance;
    @Getter private Manager manager;
    @Getter private IOUtil ioUtil;

    public void onEnable()
    {
        this.load();
        System.out.println("");
        System.out.println("hEssentials - Hexael");
        System.out.println("  ENABLED");
        System.out.println("Made by Kalipso");
        System.out.println("");
    }

    public void onDisable()
    {
        this.unload();
        System.out.println("");
        System.out.println("hEssentials - Hexael");
        System.out.println("  DISABLED");
        System.out.println("Made by Kalipso");
        System.out.println("");
    }

    public void load()
    {
        instance = this;
        ioUtil = new IOUtil();
        manager = new Manager();
        manager.loadManagers();
        getCommand("msg").setExecutor(new PrivateMessageCommand());
        getCommand("response").setExecutor(new ResponseCommand());
        getCommand("enchant").setExecutor(new EnchantCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());

    }

    public void unload()
    {
        this.manager.saveAll();
    }
}
