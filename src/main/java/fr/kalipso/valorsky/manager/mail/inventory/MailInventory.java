package fr.kalipso.valorsky.manager.mail.inventory;

import de.tr7zw.nbtapi.NBT;
import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.item.ItemBuilder;
import io.github.rysefoxx.inventory.plugin.content.IntelligentItem;
import io.github.rysefoxx.inventory.plugin.content.InventoryContents;
import io.github.rysefoxx.inventory.plugin.content.InventoryProvider;
import io.github.rysefoxx.inventory.plugin.pagination.RyseInventory;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MailInventory extends Manager implements InventoryProvider {

    private static YamlConfiguration config = hEssentials.getInstance().getManager().getConfigManager().get("mail");
    private Player player;

    public MailInventory(Player player)
    {
        this.player = player;
    }

    public static RyseInventory getInventory(Player player)
    {
        return RyseInventory.builder().rows(9).provider(new MailInventory(player)).title(config.getString("inventory.name").replace("&", "§")).build(hEssentials.getInstance());
    }

    public void init(Player player, InventoryContents contents)
    {
        this.getInstance().getManager().getMailManager().getProfilePlayer(player).getMails().forEach(mail -> {
            ItemBuilder builder = new ItemBuilder(Material.getMaterial(config.getString("inventory.item.material")));
            builder.setName(config.getString("inventory.item.name").replace("&", "§"));
            builder.setCustomModelData(config.getInt("inventory.item.customModelData"));
            List<String> lore = new ArrayList<>();
            config.getStringList("inventory.item.lore").forEach(line -> {
                lore.add(PlaceholderAPI.setPlaceholders(player, line.replace("&", "§")));
            });
            builder.setLore(lore);
            ItemStack itemStack = builder.toItemStack();
            NBT.modify(itemStack, nbt -> {
                nbt.setUUID("mail-id", mail.getId());
            });
            contents.add(IntelligentItem.of(itemStack, (event) -> {
                getInstance().getManager().getMailManager().takeMail(player, mail.getId());
            }));
        });
    }
}
