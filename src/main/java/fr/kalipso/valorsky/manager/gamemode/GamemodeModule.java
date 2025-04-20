package fr.kalipso.valorsky.manager.gamemode;

import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GamemodeModule extends Manager {

    public void changeGamemode(Player sender, String name)
    {
        if(name.equalsIgnoreCase("creative") || name.equalsIgnoreCase("1") || name.equalsIgnoreCase("c"))
        {
            sender.setGameMode(GameMode.CREATIVE);
        }
        else if(name.equalsIgnoreCase("survival") || name.equalsIgnoreCase("0") || name.equalsIgnoreCase("s"))
        {
            sender.setGameMode(GameMode.SURVIVAL);
        }
        else if(name.equalsIgnoreCase("adventure") || name.equalsIgnoreCase("2") || name.equalsIgnoreCase("a"))
        {
            sender.setGameMode(GameMode.ADVENTURE);
        }
        else if(name.equalsIgnoreCase("spectator") || name.equalsIgnoreCase("3") || name.equalsIgnoreCase("sp"))
        {
            sender.setGameMode(GameMode.SPECTATOR);
        }
        else
        {
            sender.sendMessage(MessageUtils.sendError("gamemode-no-exist"));
        }
    }

    public void changeGamemodeOther(Player sender, Player target, String name)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(name.equalsIgnoreCase("creative") || name.equalsIgnoreCase("1") || name.equalsIgnoreCase("c"))
        {
            target.setGameMode(GameMode.CREATIVE);
            sender.sendMessage(MessageUtils.sendMessage("gamemode-change-other")
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", "CREATIF"));
        }
        else if(name.equalsIgnoreCase("survival") || name.equalsIgnoreCase("0") || name.equalsIgnoreCase("s"))
        {
            target.setGameMode(GameMode.SURVIVAL);
            sender.sendMessage(MessageUtils.sendMessage("gamemode-change-other")
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", "SURVIE"));
        }
        else if(name.equalsIgnoreCase("adventure") || name.equalsIgnoreCase("2") || name.equalsIgnoreCase("a"))
        {
            target.setGameMode(GameMode.ADVENTURE);
            sender.sendMessage(MessageUtils.sendMessage("gamemode-change-other")
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", "AVENTURE"));
        }
        else if(name.equalsIgnoreCase("spectator") || name.equalsIgnoreCase("3") || name.equalsIgnoreCase("sp"))
        {
            target.setGameMode(GameMode.SPECTATOR);
            sender.sendMessage(MessageUtils.sendMessage("gamemode-change-other")
                    .replace("%target%", target.getName())
                    .replace("%gamemode%", "SPECTATEUR"));
        }
        else
        {
            sender.sendMessage(MessageUtils.sendError("gamemode-no-exist"));
        }
    }

    public void sendGamemodeMessage(PlayerGameModeChangeEvent event)
    {
        event.getPlayer().sendMessage(MessageUtils.sendMessage("gamemode-change")
                .replace("%gamemode%", event.getNewGameMode().name()));
    }
}
