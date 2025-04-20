package fr.kalipso.valorsky.data.server.provider;

import fr.kalipso.valorsky.data.server.factory.ProfileServer;
import fr.kalipso.valorsky.manager.Manager;
import fr.kalipso.valorsky.utils.FileUtils;
import fr.kalipso.valorsky.utils.io.IOUtil;
import fr.kalipso.valorsky.utils.io.IProvider;
import fr.kalipso.valorsky.utils.io.IReadable;
import fr.kalipso.valorsky.utils.io.IWriteable;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProfileServerProvider extends Manager implements IProvider<String, ProfileServer>, IWriteable, IReadable {


    @Getter
    private Map<String, ProfileServer> profileServerMap;
    private File path;

    public ProfileServerProvider() {
        this.profileServerMap = new HashMap<>();
        this.path = new File(this.getInstance().getDataFolder(), "/server/");
    }

    @Override
    public void provide(String key, ProfileServer profileServer) {
        this.profileServerMap.put(key, profileServer);
        this.write();
    }

    @Override
    public void remove(String key) throws IOException {

        ProfileServer profileServer = this.profileServerMap.get(key);

        if (profileServer == null) return;
        this.profileServerMap.remove(key);
        this.write();
        FileUtils.deleteFile(new File(path, key + ".json"));
    }

    @Override
    public ProfileServer get(String key) {
        return this.profileServerMap.get(key);
    }

    @Override
    public void read() {
        File[] files = path.listFiles();
        if (files == null) {
            this.profileServerMap = new HashMap<>();
            return;
        }

        IOUtil ioUtil = this.getInstance().getIoUtil();

        for (File file : files) {
            if (file.isFile()) {
                final String json = FileUtils.loadContent(file);
                ProfileServer profileServerData = ioUtil.deserializeServer(json);
                this.profileServerMap.put(profileServerData.getName(), profileServerData);

            }
        }
    }

    @Override
    public void write() {
        if (this.getProfiles() == null) return;

        final IOUtil ioUtil = this.getInstance().getIoUtil();
        for (ProfileServer profileServerData : this.getProfiles()) {
            final File file = new File(path, profileServerData.getName() + ".json");

            String json = ioUtil.serializeServer(profileServerData);
            FileUtils.save(file, json);
        }
    }

    public Collection<ProfileServer> getProfiles() {
        return this.profileServerMap.values();
    }
}
