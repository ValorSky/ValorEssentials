package fr.kalipso.valorsky.utils;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedPermissionData;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.entity.Player;

import java.util.Optional;

public class LuckPermsUtils {
    public static Optional<PermissionNode> getTemporaryPermission(Player player, String permission) {
        User user = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());
        return user.getNodes(NodeType.PERMISSION).stream()
                .filter(n -> !n.hasExpired())
                .findFirst();
    }

    public static boolean checkPermission(Player player, String permission)
    {
        CachedPermissionData user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getPermissionData(player);
        return user.checkPermission(permission).asBoolean();
    }

    public static String getRankName(Player player)
    {
        User user = LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId());
        if(user.getPrimaryGroup() == null) return null;
        return user.getPrimaryGroup();
    }

    public static String getGroupPrefix(String groupName)
    {
        Group group = LuckPermsProvider.get().getGroupManager().getGroup(groupName);
        if(group == null) return "lol";
        return group.getDisplayName();
    }
}
