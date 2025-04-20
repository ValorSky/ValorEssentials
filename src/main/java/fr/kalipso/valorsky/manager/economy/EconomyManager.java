package fr.kalipso.valorsky.manager.economy;

import fr.kalipso.valorsky.data.player.factory.ProfilePlayer;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.manager.economy.vault.EconomyProvider;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.ServicePriority;

import java.text.DecimalFormat;
import java.util.UUID;

@SuppressWarnings("deprecation")

public class EconomyManager extends Manager {

    private static EconomyProvider economy;

    public EconomyManager()
    {
        economy = new EconomyProvider();
        Bukkit.getServicesManager().register(Economy.class, economy, this.getInstance(), ServicePriority.Highest);
    }


    public static double getBalance(String user) {
        return economy.getBalance(user);
    }

    public static double getBalance(Player player) {
        return economy.getBalance((OfflinePlayer) player);
    }


    public ProfilePlayer getAccountByUUID(UUID uuid) {
        for(ProfilePlayer account : this.getInstance().getManager().getDataManager().getProfilePlayer().getProvider().getProfiles()) {
            if(account.getUuid().equals(uuid)) {
                return account;
            }
        }
        return null;
    }

    public ProfilePlayer getAccountByName(String uuid) {
        for(ProfilePlayer account : this.getInstance().getManager().getDataManager().getProfilePlayer().getProvider().getProfiles()) {
            if(account.getName().equals(uuid)) {
                return account;
            }
        }
        return null;
    }
    public double getBalance(String name, OfflinePlayer uuid) {
        if (name == null && uuid == null) {
            return 0;
        }
        else {
            if (name == null) {
                if (this.getAccountByUUID(uuid.getUniqueId()) != null) {
                    return this.getAccountByUUID(uuid.getUniqueId()).getDoublons();
                } else {
                    return 0;
                }
            } else if (uuid == null) {
                if (this.getAccountByName(name) != null) {
                    return this.getAccountByName(name).getDoublons();
                } else {
                    return 0;
                }
            }
        }
        return this.getAccountByName(name).getDoublons();
    }
    public boolean has(String name, OfflinePlayer uuid, final double amount) {
        if(this.getBalance(name, uuid) >= amount) {
            return true;
        }
        return false;
    }
    public boolean hasAccount(String name, OfflinePlayer uuid) {
        if(name == null && uuid == null) {
            return false;
        } else {
            if(name == null) {
                if(this.getAccountByUUID(uuid.getUniqueId()) != null) {
                    return true;
                } else {
                    return false;
                }
            } else if(uuid == null) {
                if(this.getAccountByName(name) != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }



    public static void setBalance(Player player, double value) {
        economy.withdrawPlayer((OfflinePlayer) player, value);
        economy.depositPlayer((OfflinePlayer) player, value);
    }

    public static boolean has(Player player, double value) {
        return economy.has((OfflinePlayer) player, value);
    }

    public static void depositMoney(Player player, double value) {
        economy.depositPlayer((OfflinePlayer) player, value);
    }

    public static void depositMoney(String player, double value) {
        economy.depositPlayer(player, value);
    }

    public static void withdrawMoney(Player player, double value) {
        economy.withdrawPlayer((OfflinePlayer) player, value);
    }
    public static void withdrawMoney(String player, double value) {
        economy.withdrawPlayer(player, value);
    }

    public static Economy getEconomy() {
        return economy;
    }
    public double getMoneyRounded(double amount)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");

        String formattedAmount = twoDForm.format(amount);

        formattedAmount = formattedAmount.replace(",", ".");

        return Double.valueOf(formattedAmount).doubleValue();
    }
    public String format(double amount) {
        amount = getMoneyRounded(amount);

        String suffix = " ";

        if (amount == 1.0D)
        {
            suffix = suffix + "Doublon";
        }
        else
        {
            suffix = suffix + "Doublons";
        }
        if (suffix.equalsIgnoreCase(" ")) {
            suffix = "";
        }

        return String.valueOf(amount) + suffix;

    }
}