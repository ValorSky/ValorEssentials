package fr.kalipso.hexael.manager.economy.vault;

import com.google.common.collect.ImmutableList;
import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.hEssentials;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class EconomyProvider implements Economy{

    private hEssentials instance = hEssentials.getInstance();

    public boolean isEnabled() {
        return hEssentials.getInstance().isEnabled();
    }

    public String getName() {
        return "Doublon";
    }

    public boolean hasBankSupport() {
        return false;
    }

    public int fractionalDigits() {
        return -1;
    }

    public String format(final double v) {
        return instance.getManager().getEconomyManager().format(v);
    }

    public String currencyNamePlural() {
        return "Doublons";
    }

    public String currencyNameSingular() {
        return "Doublon";
    }

    public boolean hasAccount(final String target) {
        return instance.getManager().getEconomyManager().hasAccount(target, null);
    }

    public boolean hasAccount(final OfflinePlayer offlinePlayer) {
        return instance.getManager().getEconomyManager().hasAccount(null, offlinePlayer);
    }

    public boolean hasAccount(final String target, final String worldName) {
        return this.hasAccount(target);
    }

    public boolean hasAccount(final OfflinePlayer offlinePlayer, final String worldName) {
        return this.hasAccount(offlinePlayer);
    }

    public double getBalance(final String target) {
        return instance.getManager().getEconomyManager().getBalance(target, null);
    }

    public double getBalance(final OfflinePlayer offlinePlayer) {
        return instance.getManager().getEconomyManager().getBalance(null, offlinePlayer);
    }

    public double getBalance(final String target, final String worldName) {
        return this.getBalance(target);
    }

    public double getBalance(final OfflinePlayer offlinePlayer, final String worldName) {
        return this.getBalance(offlinePlayer);
    }

    public boolean has(final String target, final double amount) {
        return instance.getManager().getEconomyManager().has(target, null, amount);
    }

    public boolean has(final OfflinePlayer offlinePlayer, final double amount) {
        return instance.getManager().getEconomyManager().has(null, offlinePlayer, amount);
    }

    public boolean has(final String target, final String worldName, final double amount) {
        return this.has(target, amount);
    }

    public boolean has(final OfflinePlayer offlinePlayer, final String worldName, final double amount) {
        return this.has(offlinePlayer, amount);
    }

    public EconomyResponse withdrawPlayer(final String target, final double amount) {
        return this.withdraw(target, null, amount);
    }

    public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final double amount) {
        return this.withdraw(null, offlinePlayer, amount);
    }

    public EconomyResponse withdrawPlayer(final String playerName, final String worldName, final double v) {
        return this.withdrawPlayer(playerName, v);
    }

    public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final String s, final double v) {
        return this.withdrawPlayer(offlinePlayer, v);
    }

    public EconomyResponse depositPlayer(final String target, final double amount) {
        return this.deposit(target, null, amount);
    }

    public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final double amount) {
        return this.deposit(null, offlinePlayer, amount);
    }

    public EconomyResponse depositPlayer(final String playerName, final String worldName, final double v) {
        return this.depositPlayer(playerName, v);
    }

    public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final String worldName, final double v) {
        return this.depositPlayer(offlinePlayer, v);
    }

    public EconomyResponse createBank(final String s, final String s1) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse createBank(final String s, final OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse deleteBank(final String s) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse bankBalance(final String s) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse bankHas(final String s, final double v) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse bankWithdraw(final String s, final double v) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse bankDeposit(final String s, final double v) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse isBankOwner(final String s, final String s1) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse isBankOwner(final String s, final OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse isBankMember(final String s, final String s1) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public EconomyResponse isBankMember(final String s, final OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, (String)null);
    }

    public List<String> getBanks() {
        return (ImmutableList.of());
    }

    public boolean createPlayerAccount(final String s) {
        return true;
    }

    public boolean createPlayerAccount(final OfflinePlayer offlinePlayer) {
        return true;
    }

    public boolean createPlayerAccount(final String s, final String s1) {
        return true;
    }

    public boolean createPlayerAccount(final OfflinePlayer offlinePlayer, final String s) {
        return true;
    }

    private EconomyResponse withdraw(String playerName, OfflinePlayer uuid, double amount)
    {
        if (amount < 0.0D) {
            System.out.println("failure amount null");
            return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Retrait de somme négative désactivé");
        }
        if(playerName == null)
        {
            ProfilePlayer account = instance.getManager().getEconomyManager().getAccountByUUID(uuid.getUniqueId());
            if (account == null) {
                System.out.println("failure account null");
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Joueur inexistant");
            }
            if(!has(uuid, amount))
            {
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Montant inconnu");
            }
                account.withdrawDoublons(amount);
                return new EconomyResponse(amount, account.getDoublons(), EconomyResponse.ResponseType.SUCCESS, "");
        }
        else {
            ProfilePlayer account = instance.getManager().getEconomyManager().getAccountByName(playerName);
            if (account == null) {
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Joueur inexistant");
            }
            if(!has(playerName, amount))
            {
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Montant inconnu");
            }
            account.withdrawDoublons(amount);
            return new EconomyResponse(amount, account.getDoublons(), EconomyResponse.ResponseType.SUCCESS, "");
        }
    }

    private EconomyResponse deposit(String playerName, OfflinePlayer uuid, double amount)
    {
        if (amount < 0.0D) {
            return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Depot de somme négative désactivé");
        }
        if(playerName == null)
        {
            ProfilePlayer account = instance.getManager().getEconomyManager().getAccountByUUID(uuid.getUniqueId());
            if (account == null) {
                System.out.println("account null");
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Joueur inexistant");
            }
            account.depositDoublons(amount);
            return new EconomyResponse(amount, account.getDoublons(), EconomyResponse.ResponseType.SUCCESS, "");
        }
        else {
            ProfilePlayer account = instance.getManager().getEconomyManager().getAccountByName(playerName);
            if (account == null) {
                return new EconomyResponse(0.0D, 0.0D, EconomyResponse.ResponseType.FAILURE, "Joueur inexistant");
            }
            account.depositDoublons(amount);
            return new EconomyResponse(amount, account.getDoublons(), EconomyResponse.ResponseType.SUCCESS, "");
        }
    }

}