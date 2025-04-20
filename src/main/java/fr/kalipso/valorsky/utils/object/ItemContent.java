package fr.kalipso.valorsky.utils.object;

import fr.kalipso.valorsky.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class ItemContent {

    private String name;
    private List<String> lore;
    private Map<Enchantment, Integer> enchantments;
    private Material mat;
    private ItemStack itemStack;

    public ItemContent(String name, List<String> lore, Map<Enchantment, Integer> enchantments, Material mat)
    {
        this.name = name;
        this.lore = lore;
        this.enchantments = enchantments;
        this.mat = mat;
    }

    public ItemStack toItemStack()
    {
        ItemBuilder item = new ItemBuilder(mat)
                .setName(name)
                .setLore(lore)
                .addEnchantments(enchantments);
        return item.toItemStack();
    }
}
