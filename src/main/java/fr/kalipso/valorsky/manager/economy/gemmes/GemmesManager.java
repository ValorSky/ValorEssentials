package fr.kalipso.valorsky.manager.economy.gemmes;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GemmesManager extends Manager {

    public void addGemmes(CommandSender sender, Player target, String value)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(!Utils.isInteger(value))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(target);
        profile.setGemmes(profile.getGemmes() + Integer.valueOf(value));
        sender.sendMessage(MessageUtils.sendMessage("gemmes-add").replace("%target%", target.getName()).replace("%value%", value));
        target.sendMessage(MessageUtils.sendMessage("gemmes-receive").replace("%value%", value));
    }

    public void takeGemmes(CommandSender sender, Player target, String value)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(!Utils.isInteger(value))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(target);
        profile.setGemmes(profile.getGemmes() - Integer.valueOf(value));
        sender.sendMessage(MessageUtils.sendMessage("gemmes-take").replace("%target%", target.getName()).replace("%value%", value));
        target.sendMessage(MessageUtils.sendMessage("gemmes-withdraw").replace("%value%", value));
    }

    public void setGemmes(CommandSender sender, Player target, String value)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(!Utils.isInteger(value))
        {
            sender.sendMessage(MessageUtils.sendError("no-int"));
            return;
        }
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(target);
        profile.setGemmes(Integer.valueOf(value));
        sender.sendMessage(MessageUtils.sendMessage("gemmes-set").replace("%target%", target.getName()).replace("%value%", value));
        target.sendMessage(MessageUtils.sendMessage("gemmes-modify").replace("%value%", value));
    }

    public void resetGemmes(CommandSender sender, Player target)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }

        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(target);
        profile.setGemmes(0);
        sender.sendMessage(MessageUtils.sendMessage("gemmes-reset-other").replace("%target%", target.getName()));
        target.sendMessage(MessageUtils.sendMessage("gemmes-reset"));
    }

    public void showHelp(CommandSender sender)
    {
        sender.sendMessage("§7§m------------------");
        sender.sendMessage("");
        sender.sendMessage("§f/gemmes §7- §bAffiche l'aide des gemmes");
        sender.sendMessage("§f/gemmes add <player> <value> §7- §bAjoute des gemmes");
        sender.sendMessage("§f/gemmes take <player> <value> §7- §bPrend des gemmes");
        sender.sendMessage("§f/gemmes set <player> <value> §7- §bModifie les gemmes");
        sender.sendMessage("§f/gemmes reset <player> §7- §bRénitiliase les gemmes");
        sender.sendMessage("");
        sender.sendMessage("§7§m------------------");
    }
}
