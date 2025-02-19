package fr.kalipso.hexael.data.server;

import fr.kalipso.hexael.data.server.factory.ProfileServer;
import fr.kalipso.hexael.data.server.provider.ProfileServerProvider;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.MessageUtils;
import lombok.Getter;

import java.util.HashMap;

public class ServerData extends Manager {
    @Getter
    private ProfileServerProvider provider;

    public ServerData()
    {
        this.loadProvider();
        this.loadServer(getInstance().getManager().getConfigManager().get("main").getString("server-name"));
    }

    public void loadProvider()
    {
        this.provider = new ProfileServerProvider();
        this.provider.read();
    }

    public void save()
    {
        this.provider.write();
    }

    public void loadServer(String name)
    {
        if(provider.get(name) == null)
        {
            ProfileServer profileServer = new ProfileServer(name, null, 0, new HashMap(), 0, 300);
            this.provider.provide(name, profileServer);
            return;
        }
        MessageUtils.sendLog("Server chargé. (" + name + ")");
    }

}
