package fr.kalipso.valorsky.manager;

import fr.kalipso.valorsky.commands.CommandsLoader;
import fr.kalipso.valorsky.data.DataManager;
import fr.kalipso.valorsky.events.EventsLoader;
import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.manager.anvil.AnvilModule;
import fr.kalipso.valorsky.manager.autoannounce.AutoAnnounceModule;
import fr.kalipso.valorsky.manager.back.BackModule;
import fr.kalipso.valorsky.manager.border.BorderModule;
import fr.kalipso.valorsky.manager.broadcast.BroadcastModule;
import fr.kalipso.valorsky.manager.chat.ChatManager;
import fr.kalipso.valorsky.manager.clearinventory.ClearInventoryModule;
import fr.kalipso.valorsky.manager.condense.CondenseModule;
import fr.kalipso.valorsky.manager.config.ConfigManager;
import fr.kalipso.valorsky.manager.craft.CraftModule;
import fr.kalipso.valorsky.manager.deathmessages.DeathMessagesModule;
import fr.kalipso.valorsky.manager.economy.EconomyManager;
import fr.kalipso.valorsky.manager.economy.gemmes.GemmesManager;
import fr.kalipso.valorsky.manager.enchant.EnchantModule;
import fr.kalipso.valorsky.manager.enderchest.EnderchestModule;
import fr.kalipso.valorsky.manager.feed.FeedModule;
import fr.kalipso.valorsky.manager.fly.FlyModule;
import fr.kalipso.valorsky.manager.furnace.FurnaceModule;
import fr.kalipso.valorsky.manager.gamemode.GamemodeModule;
import fr.kalipso.valorsky.manager.give.GiveModule;
import fr.kalipso.valorsky.manager.god.GodModule;
import fr.kalipso.valorsky.manager.hat.HatModule;
import fr.kalipso.valorsky.manager.heal.HealModule;
import fr.kalipso.valorsky.manager.home.HomeModule;
import fr.kalipso.valorsky.manager.infos.InfosModule;
import fr.kalipso.valorsky.manager.joinquit.JoinQuitModule;
import fr.kalipso.valorsky.manager.kill.KillModule;
import fr.kalipso.valorsky.manager.kits.KitsModule;
import fr.kalipso.valorsky.manager.list.ListModule;
import fr.kalipso.valorsky.manager.mail.MailManager;
import fr.kalipso.valorsky.manager.motd.MotdModule;
import fr.kalipso.valorsky.manager.nick.NickModule;
import fr.kalipso.valorsky.manager.poubelle.PoubelleModule;
import fr.kalipso.valorsky.manager.privatemessage.PrivateMessageManager;
import fr.kalipso.valorsky.manager.repair.RepairModule;
import fr.kalipso.valorsky.manager.seen.SeenModule;
import fr.kalipso.valorsky.manager.spawn.SpawnModule;
import fr.kalipso.valorsky.manager.speed.SpeedModule;
import fr.kalipso.valorsky.manager.teleport.TeleportModule;
import fr.kalipso.valorsky.manager.top.TopModule;
import fr.kalipso.valorsky.manager.vanish.VanishModule;
import fr.kalipso.valorsky.manager.voteparty.VotepartyModule;
import fr.kalipso.valorsky.manager.warp.WarpModule;
import fr.kalipso.valorsky.placeholder.PlaceholderManager;
import lombok.Getter;
import fr.kalipso.valorsky.manager.bottlexp.BottlexpModule;

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
    @Getter private TopModule topModule;
    @Getter private ChatManager chatManager;
    @Getter private MailManager mailManager;

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
        this.topModule = new TopModule();
        this.chatManager = new ChatManager();
        this.mailManager = new MailManager();

        new CommandsLoader();
        new EventsLoader();
        new PlaceholderManager();
    }

    public void saveAll()
    {
        this.dataManager.saveData();
    }
}
