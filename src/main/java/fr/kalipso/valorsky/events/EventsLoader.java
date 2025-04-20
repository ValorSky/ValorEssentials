package fr.kalipso.valorsky.events;

import fr.kalipso.valorsky.data.player.listener.ProfilePlayerListener;
import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.back.listener.BackListener;
import fr.kalipso.valorsky.manager.bottlexp.listener.BottlexpListener;
import fr.kalipso.valorsky.manager.chat.listener.ChatListener;
import fr.kalipso.valorsky.manager.coloredchat.ColoredChatModule;
import fr.kalipso.valorsky.manager.deathmessages.listener.DeathMessagesListener;
import fr.kalipso.valorsky.manager.fly.listener.FlyListener;
import fr.kalipso.valorsky.manager.gamemode.listener.GamemodeListener;
import fr.kalipso.valorsky.manager.god.listener.GodListener;
import fr.kalipso.valorsky.manager.joinquit.listener.JoinQuitListener;
import fr.kalipso.valorsky.manager.kits.listener.KitsInventoryListener;
import fr.kalipso.valorsky.manager.motd.listener.MotdListener;
import fr.kalipso.valorsky.manager.privatemessage.listener.PrivateMessageListener;
import fr.kalipso.valorsky.manager.seen.listener.SeenListener;
import fr.kalipso.valorsky.manager.spawn.listener.SpawnListener;

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
