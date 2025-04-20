package fr.kalipso.valorsky.manager.economy.vault.command;


import fr.kalipso.valorsky.utils.MessageUtils;
import fr.kalipso.valorsky.utils.command.CommandArgs;
import fr.kalipso.valorsky.utils.command.ICommand;
import fr.kalipso.valorsky.utils.command.annotations.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public class EconomyCommand extends ICommand {


    @Command(name={"eco", "economy", "balance", "bal", "money"}, isConsole = true, permissionNode = "essentials.economy")
    public void onCommand(CommandArgs args) throws IOException {

        if(args.length() == 0)
        {
            args.getSender().sendMessage(MessageUtils.sendMessage("eco-balance")
                    .replace("%money%", String.valueOf(getInstance().getManager().getEconomyManager().getBalance(args.getPlayer().getName()))));
        }
        else if(args.length() == 1)
        {
            if(Bukkit.getPlayer(args.getArgs(0)) == null)
            {
                args.getSender().sendMessage(MessageUtils.sendError("no-player"));
                return;
            }

            args.getSender().sendMessage(MessageUtils.sendMessage("eco-balance-other")
                    .replace("%money%", String.valueOf(getInstance().getManager().getEconomyManager().getBalance(Bukkit.getPlayer(args.getArgs(0)).getName(), Bukkit.getPlayer(args.getArgs(0)))))
                    .replace("%player%", Bukkit.getPlayer(args.getArgs(0)).getName()));
        }
          else if (args.getArgs(0).equalsIgnoreCase("give") && args.length() == 3) {
              if(args.getSender() instanceof Player) {
                  if (args.getPlayer().hasPermission("essentials.economy.admin")) {

                      if (Bukkit.getPlayer(args.getArgs(1)) == null) {
                          args.getSender().sendMessage(MessageUtils.sendError("no-player"));
                          return;

                      }
                      if (args.getArgs(1).equalsIgnoreCase("@all")) {
                          Bukkit.getOnlinePlayers().forEach(players -> {
                              getInstance().getManager().getEconomyManager().depositMoney(players.getName(), Double.parseDouble(args.getArgs(2)));
                          });
                          return;
                      }
                      args.getSender().sendMessage(MessageUtils.sendMessage("eco-give")
                              .replace("%money%", args.getArgs(2))
                              .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                      Bukkit.getPlayer(args.getArgs(1)).sendMessage(MessageUtils.sendMessage("eco-receive")
                              .replace("%money%", args.getArgs(2))
                              .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                      getInstance().getManager().getEconomyManager().depositMoney(Bukkit.getPlayer(args.getArgs(1)).getName(), Double.parseDouble(args.getArgs(2)));
                  }
              }
              else if(!(args.getSender() instanceof Player)) {

                    if (Bukkit.getPlayer(args.getArgs(1)) == null) {
                        args.getSender().sendMessage(MessageUtils.sendError("no-player"));
                        return;

                    }
                    if (args.getArgs(1).equalsIgnoreCase("@all")) {
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            getInstance().getManager().getEconomyManager().depositMoney(players.getName(), Double.parseDouble(args.getArgs(2)));
                        });
                        return;
                    }
                    args.getSender().sendMessage(MessageUtils.sendMessage("eco-give")
                            .replace("%money%", args.getArgs(2))
                            .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                    Bukkit.getPlayer(args.getArgs(1)).sendMessage(MessageUtils.sendMessage("eco-receive")
                            .replace("%money%", args.getArgs(2))
                            .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                    getInstance().getManager().getEconomyManager().depositMoney(Bukkit.getPlayer(args.getArgs(1)).getName(), Double.parseDouble(args.getArgs(2)));

            }
        }
        else if (args.getArgs(0).equalsIgnoreCase("take") && args.length() == 3) {
            if(args.getPlayer().hasPermission("essentials.economy.admin")) {

                if (Bukkit.getPlayer(args.getArgs(1)) == null) {
                    args.getSender().sendMessage(MessageUtils.sendError("no-player"));
                    return;

                }
                if(args.getArgs(1).equalsIgnoreCase("@all"))
                {
                    Bukkit.getOnlinePlayers().forEach(players ->  {
                        getInstance().getManager().getEconomyManager().withdrawMoney(players, Double.parseDouble(args.getArgs(2)));
                    });
                    return;
                }
                args.getSender().sendMessage(MessageUtils.sendMessage("eco-take")
                        .replace("%money%", args.getArgs(2))
                        .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                Bukkit.getPlayer(args.getArgs(1)).sendMessage(MessageUtils.sendMessage("eco-withdraw")
                        .replace("%money%", args.getArgs(2))
                        .replace("%player%", Bukkit.getPlayer(args.getArgs(1)).getName()));
                getInstance().getManager().getEconomyManager().withdrawMoney(Bukkit.getPlayer(args.getArgs(1)).getName(), Double.parseDouble(args.getArgs(2)));
            }
        }

    }
}
