package fr.kalipso.valorsky;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.enchant.command.EnchantCommand;
import fr.kalipso.valorsky.manager.privatemessage.command.PrivateMessageCommand;
import fr.kalipso.valorsky.manager.privatemessage.command.ResponseCommand;
import fr.kalipso.valorsky.manager.teleport.command.TeleportCommand;
import fr.kalipso.valorsky.utils.io.IOUtil;
import io.github.rysefoxx.inventory.plugin.pagination.InventoryManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class hEssentials extends JavaPlugin {
    @Getter
    private static hEssentials instance;
    @Getter private Manager manager;
    @Getter private IOUtil ioUtil;
    @Getter private InventoryManager inventoryManager;


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
        inventoryManager = new InventoryManager(this);
        inventoryManager.invoke();
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
