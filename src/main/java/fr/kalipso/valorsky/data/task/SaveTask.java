package fr.kalipso.valorsky.data.task;

import fr.kalipso.valorsky.hEssentials;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveTask extends BukkitRunnable {

    public SaveTask()
    {
        this.runTaskTimerAsynchronously(hEssentials.getInstance(), 0L, 20L * 180);
    }

    @Override
    public void run() {
        hEssentials.getInstance().getManager().getDataManager().saveData();
    }
}
