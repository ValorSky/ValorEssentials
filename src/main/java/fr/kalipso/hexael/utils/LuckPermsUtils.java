package fr.kalipso.hexael.utils;

import net.luckperms.api.LuckPermsProvider;
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
}
