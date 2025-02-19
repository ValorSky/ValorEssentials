package fr.kalipso.hexael.manager.kits.inventory;

import fr.kalipso.hexael.hEssentials;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class PreviewHolder implements InventoryHolder {

    private final Inventory preview;

    public PreviewHolder(hEssentials instance, String name)
    {
        this.preview = Bukkit.createInventory(this, 54, "Kit " + name);
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        return this.preview;
    }
}
