package fr.kalipso.hexael.manager.vanish.task;

import fr.kalipso.hexael.hEssentials;
import org.bukkit.scheduler.BukkitRunnable;

public class VanishTask extends BukkitRunnable {

    private hEssentials instance = hEssentials.getInstance();

    public VanishTask()
    {
        this.runTaskAsynchronously(instance);
    }

    @Override
    public void run() {
        instance.getManager().getVanishModule().vanish();
    }
}
