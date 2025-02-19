package fr.kalipso.hexael.manager.kits;

import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.manager.kits.factory.Kits;
import fr.kalipso.hexael.manager.kits.factory.KitsTime;
import fr.kalipso.hexael.manager.kits.inventory.PreviewHolder;
import fr.kalipso.hexael.manager.kits.provider.KitProvider;
import fr.kalipso.hexael.utils.MessageUtils;
import fr.kalipso.hexael.utils.object.ItemContent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class KitsModule extends Manager {

    private KitProvider kitProvider;
    private PreviewHolder previewInventory;

    public KitsModule()
    {
        kitProvider = new KitProvider(this.getInstance());
        kitProvider.read();
    }

    public void saveData()
    {
        kitProvider.write();
    }

    public void createKit(Player sender, String name, int delay)
    {
        if(kitProvider.get(name) != null)
        {
            sender.sendMessage(MessageUtils.sendError("kit-already-exist"));
            return;
        }
        if(sender.getInventory().firstEmpty() == -1)
        {
            sender.sendMessage(MessageUtils.sendError("kit-no-item"));
            return;
        }
        List<ItemContent> contents = new ArrayList<>();
        for(ItemStack is: sender.getInventory().getContents())
        {
            contents.add(new ItemContent(is.getItemMeta().getDisplayName(), is.getItemMeta().getLore(), is.getEnchantments(), is.getType()));
        }
        Kits kit = new Kits(name, contents , delay, "essentials.kits" + name);
        kitProvider.provide(name, kit);
        sender.sendMessage(MessageUtils.sendMessage("kit-create").replace("%name%", name));
    }

    public void removeKit(Player sender, String name) throws IOException {
        Kits kit = kitProvider.getByName(name);
        if(kit == null)
        {
            sender.sendMessage(MessageUtils.sendError("kit-no-exist"));
            return;
        }
        sender.sendMessage(MessageUtils.sendMessage("kit-remove").replace("%name%", name));
        kitProvider.remove(name);
    }

    public void giveKit(Player sender, String name)
    {
        Kits kit = kitProvider.getByName(name);
        if(kit == null)
        {
            sender.sendMessage(MessageUtils.sendError("kit-no-exist"));
            return;
        }
        if(!sender.hasPermission("essentials.kits." + name))
        {
            sender.sendMessage(MessageUtils.sendError("no-permission"));
            return;
        }
        if(sender.hasPermission("essentials.kits.bypass"))
        {
            kit.getContents().forEach(item -> {
                sender.getInventory().addItem(item.toItemStack());
            });
            sender.sendMessage(MessageUtils.sendMessage("kit-receive").replace("%name%", name));
            return;
        }
        ProfilePlayer profile = this.getInstance().getManager().getDataManager().getPlayer(sender.getName());
        long secondActual = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if(!profile.getKitsTake().contains(kit.getName()))
        {
            sender.sendMessage(MessageUtils.sendMessage("kit-receive").replace("%name%", name));
            profile.getKitsTake().add(new KitsTime(kit.getName(), secondActual));
            kit.getContents().forEach(item -> {
                sender.getInventory().addItem(item.toItemStack());
            });
        }
        else
        {
            profile.getKitsTake().forEach(kitsTime -> {
                if(kitsTime.getName().equalsIgnoreCase(kit.getName()))
                {
                    if((kitsTime.getLastTake() + kit.getDelay()) <= secondActual)
                    {
                        kit.getContents().forEach(item -> {
                            sender.getInventory().addItem(item.toItemStack());
                        });
                        sender.sendMessage(MessageUtils.sendMessage("kit-receive").replace("%name%", name));
                        profile.getKitsTake().remove(kitsTime);
                        profile.getKitsTake().add(new KitsTime(kit.getName(), secondActual));
                    }
                    else
                    {
                        sender.sendMessage(MessageUtils.sendError("kit-cant-take").replace("%secondes%", String.valueOf(secondActual - (kitsTime.getLastTake() + kit.getDelay()))));
                    }
                }
            });

        }
    }

    public void giveKit(CommandSender sender, Player target, String name)
    {
        Kits kit = kitProvider.getByName(name);
        if(kit == null)
        {
            sender.sendMessage(MessageUtils.sendError("kit-no-exist"));
            return;
        }
        if(target == null)
        {
            sender.sendMessage(MessageUtils.sendError("no-player"));
            return;
        }
        kit.getContents().forEach(item -> {
            target.getInventory().addItem(item.toItemStack());
        });
        target.sendMessage(MessageUtils.sendMessage("kit-receive").replace("%name%", name));
    }

    public void showPreviewKit(Player sender, String name)
    {
        Kits kit = kitProvider.getByName(name);
        if(kit == null)
        {
            sender.sendMessage(MessageUtils.sendError("kit-no-exist"));
            return;
        }
        previewInventory = new PreviewHolder(this.getInstance(), name);
        kit.getContents().forEach(content -> {
            previewInventory.getInventory().addItem(content.toItemStack());
        });
        sender.openInventory(previewInventory.getInventory());
    }

    public void showListKit(Player sender)
    {
        Collection<Kits> kitList = kitProvider.getKits();
        if(kitList == null || kitList.isEmpty())
        {
            sender.sendMessage(MessageUtils.sendError("kit-any"));
            return;
        }
        StringJoiner listKits = new StringJoiner("§7, §f");
        kitList.forEach(kit -> {
            listKits.add(kit.getName());
        });
        sender.sendMessage(MessageUtils.sendMessage("kit-available").replace("%s", listKits.toString()));
    }
}
