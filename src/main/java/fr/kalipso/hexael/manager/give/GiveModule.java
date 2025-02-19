package fr.kalipso.hexael.manager.give;


import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.StringUtils;
import fr.kalipso.hexael.utils.Utils;
import fr.kalipso.hexael.utils.command.CommandArgs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveModule {

    public void giveItem(Player sender, CommandArgs args)
    {
        if(args.length() < 1)
        {
            sender.sendMessage("§cSyntaxe: /i <material> <nombre>");
            return;
        }
        ItemStack item = Utils.parseItem(args.getArgs(0));
        if(item == null)
        {
            sender.sendMessage(MessageUtils.sendError("give-no-item").replace("%name%", args.getArgs(0)));
            return;
        }
        int amount = 64;
        if(args.getArgs(1) != null)
        {
            if(!StringUtils.isInteger(args.getArgs(1))) return;
            amount = Integer.valueOf(args.getArgs(1));
        }
        boolean drop = false;
        if(sender.getInventory().firstEmpty() == -1)
        {
            sender.sendMessage(MessageUtils.sendMessage("give-full").replace("%name%", args.getArgs(0)).replace("%number%", String.valueOf(amount)));
            return;
        }
        item.setAmount(amount);
        if(drop)
        {
            sender.getWorld().dropItemNaturally(sender.getLocation(), item);
        }
        else
        {
            sender.getInventory().addItem(item);
        }
        sender.sendMessage(MessageUtils.sendMessage("give").replace("%name%", args.getArgs(0)).replace("%number%", String.valueOf(amount)));

    }

    public void giveItem(Player sender, Player target, CommandArgs args)
    {
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        if(args.length() < 2)
        {
            sender.sendMessage("§cSyntaxe: /give <cible> <material> <nombre>");
            return;
        }
        ItemStack item = Utils.parseItem(args.getArgs(1));
        if(item == null)
        {
            sender.sendMessage(MessageUtils.sendError("give-no-item").replace("%name%", args.getArgs(0)));
            return;
        }
        int amount = 64;
        if(args.getArgs(2) != null)
        {
            if(!StringUtils.isInteger(args.getArgs(2))) return;
            amount = Integer.valueOf(args.getArgs(2));
        }
        boolean drop = false;
        if(target.getInventory().firstEmpty() == -1)
        {
            sender.sendMessage(MessageUtils.sendMessage("give-full").replace("%name%", args.getArgs(0)).replace("%number%", String.valueOf(amount)));
            return;
        }
        item.setAmount(amount);
        if(drop)
        {
            target.getWorld().dropItemNaturally(sender.getLocation(), item);
        }
        else
        {
            target.getInventory().addItem(item);
        }
        target.sendMessage(MessageUtils.sendMessage("give").replace("%name%", args.getArgs(0)).replace("%number%", String.valueOf(amount)));
        sender.sendMessage(MessageUtils.sendMessage("give-other").replace("%name%", args.getArgs(0)).replace("%number%", String.valueOf(amount)).replace("%target%", target.getName()));
    }
}
