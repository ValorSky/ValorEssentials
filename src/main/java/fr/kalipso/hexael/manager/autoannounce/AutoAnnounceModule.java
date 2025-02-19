package fr.kalipso.hexael.manager.autoannounce;

import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.autoannounce.factory.AutoAnnounce;
import fr.kalipso.hexael.utils.MessageUtils;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoAnnounceModule extends Manager {

    private List<AutoAnnounce> announceList = new ArrayList<>();

    public AutoAnnounceModule()
    {
        this.loadAnnounce();
        this.scheduleAnnounce();
    }

    public void loadAnnounce()
    {
        this.getInstance().getManager().getConfigManager().get("autoannounce").getConfigurationSection("autoannounce").getKeys(false).forEach(an -> {
            AutoAnnounce announce = new AutoAnnounce(Integer.valueOf(an), this.getInstance().getManager().getConfigManager().get("autoannounce").getConfigurationSection("autoannounce").getStringList(an + ".content"));
            this.announceList.add(announce);
        });
    }

    public void scheduleAnnounce()
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this.getInstance(), new Runnable() {
            @Override
            public void run() {
                AutoAnnounce msg = announceList.get(new Random().nextInt(announceList.size()));
                MessageUtils.sendAllMessage(msg.getContent());
            }
        }, 0, 20 * this.getInstance().getManager().getConfigManager().get("autoannounce").getInt("delay"));
    }
}
