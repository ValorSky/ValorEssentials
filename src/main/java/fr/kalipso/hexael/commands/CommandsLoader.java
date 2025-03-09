package fr.kalipso.hexael.commands;

import fr.kalipso.hexael.data.command.ProfileCommand;
import fr.kalipso.hexael.data.command.subcommand.ProfileSaveCommand;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.anvil.command.AnvilCommand;
import fr.kalipso.hexael.manager.back.command.BackCommand;
import fr.kalipso.hexael.manager.bottlexp.command.BottlexpCommand;
import fr.kalipso.hexael.manager.broadcast.command.BroadcastCommand;
import fr.kalipso.hexael.manager.broadcast.command.PubCommand;
import fr.kalipso.hexael.manager.clearinventory.command.ClearInventoryCommand;
import fr.kalipso.hexael.manager.condense.command.CondenseCommand;
import fr.kalipso.hexael.manager.craft.command.CraftCommand;
import fr.kalipso.hexael.manager.economy.gemmes.command.GemmesCommand;
import fr.kalipso.hexael.manager.economy.gemmes.command.subcommand.GemmesAddCommand;
import fr.kalipso.hexael.manager.economy.gemmes.command.subcommand.GemmesResetCommand;
import fr.kalipso.hexael.manager.economy.gemmes.command.subcommand.GemmesSetCommand;
import fr.kalipso.hexael.manager.economy.gemmes.command.subcommand.GemmesTakeCommand;
import fr.kalipso.hexael.manager.economy.vault.command.EconomyCommand;
import fr.kalipso.hexael.manager.enchant.command.EnchantCommand;
import fr.kalipso.hexael.manager.enderchest.command.EnderchestCommand;
import fr.kalipso.hexael.manager.feed.command.FeedCommand;
import fr.kalipso.hexael.manager.fly.command.FlyCommand;
import fr.kalipso.hexael.manager.furnace.command.FurnaceCommand;
import fr.kalipso.hexael.manager.gamemode.command.GamemodeCommand;
import fr.kalipso.hexael.manager.give.command.GiveCommand;
import fr.kalipso.hexael.manager.god.command.GodCommand;
import fr.kalipso.hexael.manager.heal.command.HealCommand;
import fr.kalipso.hexael.manager.home.command.HomeCommand;
import fr.kalipso.hexael.manager.home.command.subcommand.HomeDeleteCommand;
import fr.kalipso.hexael.manager.home.command.subcommand.HomeListCommand;
import fr.kalipso.hexael.manager.home.command.subcommand.HomeSetCommand;
import fr.kalipso.hexael.manager.infos.command.InfosCommand;
import fr.kalipso.hexael.manager.kill.command.KillCommand;
import fr.kalipso.hexael.manager.kits.commands.KitsCommand;
import fr.kalipso.hexael.manager.kits.commands.subcommand.KitsCreateCommand;
import fr.kalipso.hexael.manager.kits.commands.subcommand.KitsDeleteCommand;
import fr.kalipso.hexael.manager.kits.commands.subcommand.KitsPreviewCommand;
import fr.kalipso.hexael.manager.list.command.ListCommand;
import fr.kalipso.hexael.manager.nick.command.NickCommand;
import fr.kalipso.hexael.manager.nick.command.subcommand.NickRemoveCommand;
import fr.kalipso.hexael.manager.poubelle.command.PoubelleCommand;
import fr.kalipso.hexael.manager.privatemessage.command.IgnoreCommand;
import fr.kalipso.hexael.manager.privatemessage.command.PrivateMessageCommand;
import fr.kalipso.hexael.manager.repair.command.RepairCommand;
import fr.kalipso.hexael.manager.repair.command.subcommand.RepairAllCommand;
import fr.kalipso.hexael.manager.repair.command.subcommand.RepairHandCommand;
import fr.kalipso.hexael.manager.seen.command.SeenCommand;
import fr.kalipso.hexael.manager.spawn.command.SpawnCommand;
import fr.kalipso.hexael.manager.spawn.command.subcommand.SpawnSetCommand;
import fr.kalipso.hexael.manager.speed.command.SpeedCommand;
import fr.kalipso.hexael.manager.teleport.command.TeleportCommand;
import fr.kalipso.hexael.manager.teleport.command.subcommand.*;
import fr.kalipso.hexael.manager.top.command.TopCommand;
import fr.kalipso.hexael.manager.vanish.command.VanishCommand;
import fr.kalipso.hexael.manager.warp.command.WarpCommand;
import fr.kalipso.hexael.manager.warp.command.subcommand.WarpCreateCommand;
import fr.kalipso.hexael.manager.warp.command.subcommand.WarpDeleteCommand;
import fr.kalipso.hexael.manager.warp.command.subcommand.WarpListCommand;
import fr.kalipso.hexael.placeholder.voteparty.command.VotepartyCommand;
import fr.kalipso.hexael.placeholder.voteparty.command.subcommand.VotepartyAddCommand;
import fr.kalipso.hexael.utils.command.CommandFramework;

public class CommandsLoader extends Manager {

    private CommandFramework commandFramework;

    public CommandsLoader()
    {
        this.commandFramework = new CommandFramework(this.getInstance());
        this.registerCommands();
    }

    public void registerCommands()
    {
        this.commandFramework.registerCommands(new ProfileSaveCommand());
        this.commandFramework.registerCommands(new ProfileCommand());
        this.commandFramework.registerCommands(new SpawnCommand());
        this.commandFramework.registerCommands(new SpawnSetCommand());
        this.commandFramework.registerCommands(new GodCommand());
        this.commandFramework.registerCommands(new ListCommand());
        this.commandFramework.registerCommands(new CraftCommand());
        this.commandFramework.registerCommands(new EnderchestCommand());
        this.commandFramework.registerCommands(new BackCommand());
        this.commandFramework.registerCommands(new BroadcastCommand());
        this.commandFramework.registerCommands(new GamemodeCommand());
        this.commandFramework.registerCommands(new SeenCommand());
        this.commandFramework.registerCommands(new HealCommand());
        this.commandFramework.registerCommands(new AnvilCommand());
        this.commandFramework.registerCommands(new BottlexpCommand());
        this.commandFramework.registerCommands(new FeedCommand());
        this.commandFramework.registerCommands(new FurnaceCommand());
        this.commandFramework.registerCommands(new InfosCommand());
        this.commandFramework.registerCommands(new KillCommand());
        this.commandFramework.registerCommands(new WarpCommand());
        this.commandFramework.registerCommands(new WarpListCommand());
        this.commandFramework.registerCommands(new WarpCreateCommand());
        this.commandFramework.registerCommands(new WarpDeleteCommand());
        this.commandFramework.registerCommands(new NickCommand());
        this.commandFramework.registerCommands(new NickRemoveCommand());
        this.commandFramework.registerCommands(new TeleportCommand());
        this.commandFramework.registerCommands(new TeleportAcceptCommand());
        this.commandFramework.registerCommands(new TeleportCoordsCommand());
        this.commandFramework.registerCommands(new TeleportDenyCommand());
        this.commandFramework.registerCommands(new TeleportHereCommand());
        this.commandFramework.registerCommands(new TeleportRequestCommand());
        this.commandFramework.registerCommands(new PoubelleCommand());
        this.commandFramework.registerCommands(new SpeedCommand());
        this.commandFramework.registerCommands(new VanishCommand());
        this.commandFramework.registerCommands(new HomeCommand());
        this.commandFramework.registerCommands(new HomeSetCommand());
        this.commandFramework.registerCommands(new HomeDeleteCommand());
        this.commandFramework.registerCommands(new HomeListCommand());
        this.commandFramework.registerCommands(new CondenseCommand());
        this.commandFramework.registerCommands(new RepairCommand());
        this.commandFramework.registerCommands(new RepairHandCommand());
        this.commandFramework.registerCommands(new RepairAllCommand());
        this.commandFramework.registerCommands(new KitsCommand());
        this.commandFramework.registerCommands(new KitsCreateCommand());
        this.commandFramework.registerCommands(new KitsDeleteCommand());
        this.commandFramework.registerCommands(new KitsPreviewCommand());
        this.commandFramework.registerCommands(new EnchantCommand());
        this.commandFramework.registerCommands(new GiveCommand());
        this.commandFramework.registerCommands(new FlyCommand());
        this.commandFramework.registerCommands(new EconomyCommand());
        this.commandFramework.registerCommands(new GemmesCommand());
        this.commandFramework.registerCommands(new GemmesAddCommand());
        this.commandFramework.registerCommands(new GemmesSetCommand());
        this.commandFramework.registerCommands(new GemmesTakeCommand());
        this.commandFramework.registerCommands(new GemmesResetCommand());
        this.commandFramework.registerCommands(new VotepartyCommand());
        this.commandFramework.registerCommands(new VotepartyAddCommand());
        this.commandFramework.registerCommands(new VotepartyAddCommand());
        this.commandFramework.registerCommands(new ClearInventoryCommand());
        this.commandFramework.registerCommands(new IgnoreCommand());
        this.commandFramework.registerCommands(new PubCommand());
        this.commandFramework.registerCommands(new TopCommand());
    }
}
