package fr.kalipso.hexael.events;

import fr.kalipso.hexael.data.player.listener.ProfilePlayerListener;
import fr.kalipso.hexael.hEssentials;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.back.listener.BackListener;
import fr.kalipso.hexael.manager.bottlexp.listener.BottlexpListener;
import fr.kalipso.hexael.manager.chat.listener.ChatListener;
import fr.kalipso.hexael.manager.coloredchat.ColoredChatModule;
import fr.kalipso.hexael.manager.deathmessages.listener.DeathMessagesListener;
import fr.kalipso.hexael.manager.fly.listener.FlyListener;
import fr.kalipso.hexael.manager.gamemode.listener.GamemodeListener;
import fr.kalipso.hexael.manager.god.listener.GodListener;
import fr.kalipso.hexael.manager.joinquit.listener.JoinQuitListener;
import fr.kalipso.hexael.manager.kits.listener.KitsInventoryListener;
import fr.kalipso.hexael.manager.motd.listener.MotdListener;
import fr.kalipso.hexael.manager.privatemessage.listener.PrivateMessageListener;
import fr.kalipso.hexael.manager.seen.listener.SeenListener;
import fr.kalipso.hexael.manager.spawn.listener.SpawnListener;

public class EventsLoader extends Manager {

    public EventsLoader()
    {
        this.loadAllListeners(this.getInstance());
    }

    public void loadAllListeners(hEssentials instance)
    {
        instance.getServer().getPluginManager().registerEvents(new JoinQuitListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new SpawnListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new MotdListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new DeathMessagesListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new GodListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new BackListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new GamemodeListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new SeenListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new BottlexpListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new KitsInventoryListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new FlyListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new ProfilePlayerListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new PrivateMessageListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new ColoredChatModule(), instance);
        instance.getServer().getPluginManager().registerEvents(new ChatListener(), instance);
    }
}
