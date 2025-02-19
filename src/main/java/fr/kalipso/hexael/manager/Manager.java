package fr.kalipso.hexael.manager;

import fr.kalipso.hexael.commands.CommandsLoader;
import fr.kalipso.hexael.data.DataManager;
import fr.kalipso.hexael.events.EventsLoader;
import fr.kalipso.hexael.hEssentials;
import fr.kalipso.hexael.manager.anvil.AnvilModule;
import fr.kalipso.hexael.manager.autoannounce.AutoAnnounceModule;
import fr.kalipso.hexael.manager.back.BackModule;
import fr.kalipso.hexael.manager.border.BorderModule;
import fr.kalipso.hexael.manager.broadcast.BroadcastModule;
import fr.kalipso.hexael.manager.clearinventory.ClearInventoryModule;
import fr.kalipso.hexael.manager.condense.CondenseModule;
import fr.kalipso.hexael.manager.config.ConfigManager;
import fr.kalipso.hexael.manager.craft.CraftModule;
import fr.kalipso.hexael.manager.deathmessages.DeathMessagesModule;
import fr.kalipso.hexael.manager.economy.EconomyManager;
import fr.kalipso.hexael.manager.economy.gemmes.GemmesManager;
import fr.kalipso.hexael.manager.enchant.EnchantModule;
import fr.kalipso.hexael.manager.enderchest.EnderchestModule;
import fr.kalipso.hexael.manager.feed.FeedModule;
import fr.kalipso.hexael.manager.fly.FlyModule;
import fr.kalipso.hexael.manager.furnace.FurnaceModule;
import fr.kalipso.hexael.manager.gamemode.GamemodeModule;
import fr.kalipso.hexael.manager.give.GiveModule;
import fr.kalipso.hexael.manager.god.GodModule;
import fr.kalipso.hexael.manager.hat.HatModule;
import fr.kalipso.hexael.manager.heal.HealModule;
import fr.kalipso.hexael.manager.home.HomeModule;
import fr.kalipso.hexael.manager.infos.InfosModule;
import fr.kalipso.hexael.manager.joinquit.JoinQuitModule;
import fr.kalipso.hexael.manager.kill.KillModule;
import fr.kalipso.hexael.manager.kits.KitsModule;
import fr.kalipso.hexael.manager.list.ListModule;
import fr.kalipso.hexael.manager.motd.MotdModule;
import fr.kalipso.hexael.manager.nick.NickModule;
import fr.kalipso.hexael.manager.poubelle.PoubelleModule;
import fr.kalipso.hexael.manager.privatemessage.PrivateMessageManager;
import fr.kalipso.hexael.manager.repair.RepairModule;
import fr.kalipso.hexael.manager.seen.SeenModule;
import fr.kalipso.hexael.manager.spawn.SpawnModule;
import fr.kalipso.hexael.manager.speed.SpeedModule;
import fr.kalipso.hexael.manager.teleport.TeleportModule;
import fr.kalipso.hexael.manager.vanish.VanishModule;
import fr.kalipso.hexael.manager.voteparty.VotepartyModule;
import fr.kalipso.hexael.manager.warp.WarpModule;
import fr.kalipso.hexael.placeholder.PlaceholderManager;
import lombok.Getter;
import fr.kalipso.hexael.manager.bottlexp.BottlexpModule;

public class Manager {

    @Getter private hEssentials instance;
    @Getter private ConfigManager configManager;
    @Getter private DataManager dataManager;
    @Getter private SpawnModule spawnModule;
    @Getter private JoinQuitModule joinQuitModule;
    @Getter private MotdModule motdModule;
    @Getter private AutoAnnounceModule autoAnnounceModule;
    @Getter private DeathMessagesModule deathMessagesModule;
    @Getter private GodModule godModule;
    @Getter private ListModule listModule;
    @Getter private CraftModule craftModule;
    @Getter private EnderchestModule enderchestModule;
    @Getter private BackModule backModule;
    @Getter private BroadcastModule broadcastModule;
    @Getter private GamemodeModule gamemodeModule;
    @Getter private SeenModule seenModule;
    @Getter private HealModule healModule;
    @Getter private AnvilModule anvilModule;
    @Getter private BottlexpModule bottlexpModule;
    @Getter private FeedModule feedModule;
    @Getter private FurnaceModule furnaceModule;
    @Getter private HatModule hatModule;
    @Getter private InfosModule infosModule;
    @Getter private KillModule killModule;
    @Getter private WarpModule warpModule;
    @Getter private NickModule nickModule;
    @Getter private TeleportModule teleportModule;
    @Getter private BorderModule borderModule;
    @Getter private PoubelleModule poubelleModule;
    @Getter private SpeedModule speedModule;
    @Getter private VanishModule vanishModule;
    @Getter private HomeModule homeModule;
    @Getter private CondenseModule condenseModule;
    @Getter private RepairModule repairModule;
    @Getter private KitsModule kitsModule;
    @Getter private EnchantModule enchantModule;
    @Getter private GiveModule giveModule;
    @Getter private FlyModule flyModule;
    @Getter private ClearInventoryModule clearInventoryModule;
    @Getter private EconomyManager economyManager;
    @Getter private GemmesManager gemmesManager;
    @Getter private VotepartyModule votepartyModule;
    @Getter private PrivateMessageManager privateMessageManager;

    public Manager()
    {
        this.instance = hEssentials.getInstance();
    }

    public void loadManagers()
    {
        this.configManager = new ConfigManager();
        this.dataManager = new DataManager();
        this.dataManager.loadProfiles();
        this.economyManager = new EconomyManager();
        this.gemmesManager = new GemmesManager();
        this.spawnModule = new SpawnModule();
        this.joinQuitModule = new JoinQuitModule();
        this.motdModule = new MotdModule();
        this.autoAnnounceModule = new AutoAnnounceModule();
        this.deathMessagesModule = new DeathMessagesModule();
        this.godModule = new GodModule();
        this.listModule = new ListModule();
        this.craftModule = new CraftModule();
        this.enderchestModule = new EnderchestModule();
        this.backModule = new BackModule();
        this.broadcastModule = new BroadcastModule();
        this.gamemodeModule = new GamemodeModule();
        this.seenModule = new SeenModule();
        this.healModule = new HealModule();
        this.anvilModule = new AnvilModule();
        this.bottlexpModule = new BottlexpModule();
        this.feedModule = new FeedModule();
        this.furnaceModule = new FurnaceModule();
        this.hatModule = new HatModule();
        this.infosModule = new InfosModule();
        this.killModule = new KillModule();
        this.warpModule = new WarpModule();
        this.nickModule = new NickModule();
        this.teleportModule = new TeleportModule();
        this.borderModule = new BorderModule();
        this.poubelleModule = new PoubelleModule();
        this.speedModule = new SpeedModule();
        this.vanishModule = new VanishModule();
        this.homeModule = new HomeModule();
        this.condenseModule = new CondenseModule();
        this.repairModule = new RepairModule();
        this.kitsModule = new KitsModule();
        this.enchantModule = new EnchantModule();
        this.giveModule = new GiveModule();
        this.flyModule = new FlyModule();
        this.clearInventoryModule = new ClearInventoryModule();
        this.votepartyModule = new VotepartyModule();
        this.privateMessageManager = new PrivateMessageManager();

        new CommandsLoader();
        new EventsLoader();
        new PlaceholderManager();
    }

    public void saveAll()
    {
        this.dataManager.saveData();
    }
}
