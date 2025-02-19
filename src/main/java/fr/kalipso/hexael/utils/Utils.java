package fr.kalipso.hexael.utils;

import fr.kalipso.hexael.hEssentials;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static final String[] ENCHANTMENT_NAMES = new String[] { "AQUA_AFFINITY", "BANE_OF_ARTHROPODS", "BLAST_PROTECTION",
            "DURABILITY", "EFFICIENCY", "FEATHER_FALLING", "FIRE_ASPECT", "FIRE_PROTECTION", "FLAME", "FORTUNE", "INFINITY, KNOCKBACK",
            "LOOTING", "LUCK", "LURE", "POWER", "PROJECTILE_PROTECTION", "PROTECTION", "PUNCH", "RESPIRATION", "SHARPNESS",
            "SILK_TOUCH", "SMITE", "THORNS", "UNBREAKING" };
    private static Map<String, String> ITEMS_BY_NAME;
    private static Map<String, String> ITEMS_BY_MATERIAL;
    private static hEssentials instance = hEssentials.getInstance();

    public static boolean eventOccurs(int chance) {
        if (chance < 0 || chance > 100)
            throw new IllegalArgumentException("Chance must be between 0.0 and 100.0");
        return (ThreadLocalRandom.current().nextInt(100) <= chance);
    }
    public static boolean isInteger(String string) {
        boolean isInteger = true;
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            isInteger = false;
        }
        return isInteger;
    }

    public static boolean isDouble(String string) {
        boolean isInteger = true;
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException exception) {
            isInteger = false;
        }
        return isInteger;
    }
    public static File getFormatedFile(Plugin plugin, String fileName) {
        return new File(plugin.getDataFolder(), fileName);
    }

    public static boolean isInventoryFull(Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    public static String getRandomNumberString() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public static String getEnchantName(String enchant) {
        switch(enchant) {
            case "PROTECTION": return "PROTECTION_ENVIRONMENTAL";
            case "FIRE_PROTECTION": return "PROTECTION_FIRE";
            case "FEATHER_FALLING": return "PROTECTION_FALL";
            case "BLAST_PROTECTION": return "PROTECTION_EXPLOSIONS";
            case "PROJECTILE_PROTECTION": return "PROTECTION_PROJECTILE";
            case "RESPIRATION": return "OXYGEN";
            case "AQUA_AFFINITY": return "WATER_WORKER";
            case "THORNS": return "THORNS";
            case "SHARPNESS": return "DAMAGE_ALL";
            case "SMITE": return "DAMAGE_UNDEAD";
            case "BANE_OF_ARTHROPODS": return "DAMAGE_ARTHROPODS";
            case "KNOCKBACK": return "KNOCKBACK";
            case "FIRE_ASPECT": return "FIRE_ASPECT";
            case "LOOTING": return "LOOT_BONUS_MOBS";
            case "EFFICIENCY": return "DIG_SPEED";
            case "SILK_TOUCH": return "SILK_TOUCH";
            case "UNBREAKING": return "DURABILITY";
            case "DURABILITY": return "DURABILITY";
            case "FORTUNE": return "LOOT_BONUS_BLOCKS";
            case "POWER": return "ARROW_DAMAGE";
            case "PUNCH": return "ARROW_KNOCKBACK";
            case "FLAME": return "ARROW_FIRE";
            case "INFINITY": return "ARROW_INFINITE";
            case "LUCK": return "LUCK";
            case "LURE": return "LURE";
            default: return "Unknown enchantment";
        }
    }

    public static String getEnchantName(Enchantment enchantment) {
        switch(enchantment.getName()) {
            case "PROTECTION_ENVIRONMENTAL": return "Protection";
            case "PROTECTION_FIRE": return "Fire Protection";
            case "PROTECTION_FALL": return "Feather Falling";
            case "PROTECTION_EXPLOSIONS": return "Blast Protection";
            case "PROTECTION_PROJECTILE": return "Projectile Protection";
            case "OXYGEN": return "Respiration";
            case "WATER_WORKER": return "Aqua Affinity";
            case "THORNS": return "Thorns";
            case "DAMAGE_ALL": return "Sharpness";
            case "DAMAGE_UNDEAD": return "Smite";
            case "DAMAGE_ARTHROPODS": return "Bane of Arthropods";
            case "KNOCKBACK": return "Knockback";
            case "FIRE_ASPECT": return "Fire Aspect";
            case "LOOT_BONUS_MOBS": return "Looting";
            case "DIG_SPEED": return "Efficiency";
            case "SILK_TOUCH": return "Silk Touch";
            case "DURABILITY": return "Unbreaking";
            case "LOOT_BONUS_BLOCKS": return "Fortune";
            case "ARROW_DAMAGE": return "Power";
            case "ARROW_KNOCKBACK": return "Punch";
            case "ARROW_FIRE": return "Flame";
            case "ARROW_INFINITE": return "Infinity";
            case "LUCK": return "Luck";
            case "LURE": return "Lure";
            default: return "Unknown enchantment";
        }
    }

    public static ItemStack parseItem(String value) {
        String itemData = ITEMS_BY_NAME.get(value);

        if(itemData != null) {
            String[] itemArray = itemData.split(":");
            return new ItemStack(Material.getMaterial(String.valueOf(Integer.parseInt(itemArray[0]))), 1, Short.parseShort(itemArray[1]));
        }

        Material material = Material.getMaterial(value);
        if(material != null) return new ItemStack(material);

        String type;
        String durability;

        if(value.contains(":")) {
            String[] itemArray = value.split(":");
            if(itemArray.length < 2) return null;

            type = itemArray[0];
            durability = itemArray[1];
        } else {
            type = value;
            durability = "0";
        }

        if(!StringUtils.isInteger(type)) return null;

        material = Material.getMaterial(String.valueOf(Integer.parseInt(type)));
        if(material == null || !StringUtils.isInteger(durability)) return null;

        return new ItemStack(material, 1, Short.parseShort(durability));
    }

    public static boolean isRepairable(Material material) {
        switch(material) {
            case DIAMOND_HELMET:
            case GOLDEN_HELMET:
            case IRON_HELMET:
            case CHAINMAIL_HELMET:
            case LEATHER_HELMET:
            case DIAMOND_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case IRON_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case LEATHER_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case IRON_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case LEATHER_LEGGINGS:
            case DIAMOND_BOOTS:
            case GOLDEN_BOOTS:
            case IRON_BOOTS:
            case CHAINMAIL_BOOTS:
            case LEATHER_BOOTS:
            case DIAMOND_SWORD:
            case GOLDEN_SWORD:
            case IRON_SWORD:
            case STONE_SWORD:
            case WOODEN_SWORD:
            case DIAMOND_PICKAXE:
            case GOLDEN_PICKAXE:
            case IRON_PICKAXE:
            case STONE_PICKAXE:
            case WOODEN_PICKAXE:
            case DIAMOND_AXE:
            case GOLDEN_AXE:
            case IRON_AXE:
            case STONE_AXE:
            case WOODEN_AXE:
            case DIAMOND_SHOVEL:
            case GOLDEN_SHOVEL:
            case IRON_SHOVEL:
            case STONE_SHOVEL:
            case WOODEN_SHOVEL:
            case DIAMOND_HOE:
            case GOLDEN_HOE:
            case IRON_HOE:
            case STONE_HOE:
            case WOODEN_HOE:

            case FISHING_ROD:
            case BOW:
            case FLINT_AND_STEEL:
                return true;
            default:
                return false;
        }
    }

    public static String millisFormat(long millis)
    {
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return hms;
    }
    public static String millisFormatted(long millis)
    {
        String hms = String.format("%02dh%02dm%02ds", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return hms;
    }


    public static boolean isFullyGrownPlant(Block block) {
        Crops crops;
        if (isBreakablePlant(block))
            return true;
        switch (block.getType()) {
            case NETHER_WART:
                return (block.getState().getData().getData() == 3);
            case COCOA:
                return (block.getState().getData().getData() == 9);
            case BEETROOTS:
            case WHEAT:
            case CARROTS:
            case POTATOES:
                crops = (Crops)block.getState().getData();
                return crops.getState().equals(CropState.RIPE);
        }
        return false;
    }
    public static boolean isBreakablePlant(Block block) {
        switch (block.getType()) {
            case PUMPKIN:
            case MELON:
            case KELP_PLANT:
            case SUGAR_CANE:

        }
        return false;
    }

    public static void grow(Block blockAt) {
        Ageable ageable = (Ageable)blockAt.getBlockData();
        ageable.setAge(ageable.getMaximumAge());
        blockAt.setBlockData(ageable);
    }
}
