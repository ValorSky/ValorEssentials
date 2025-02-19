package fr.kalipso.hexael.data.player.provider;

import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.manager.Manager;
import fr.kalipso.hexael.utils.FileUtils;
import fr.kalipso.hexael.utils.io.IOUtil;
import fr.kalipso.hexael.utils.io.IProvider;
import fr.kalipso.hexael.utils.io.IReadable;
import fr.kalipso.hexael.utils.io.IWriteable;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProfilePlayerProvider extends Manager implements IProvider<String, ProfilePlayer>, IWriteable, IReadable {

    @Getter
    private Map<String, ProfilePlayer> profilePlayerMap;
    private File path;

    public ProfilePlayerProvider() {
        this.profilePlayerMap = new HashMap<>();
        this.path = new File(this.getInstance().getDataFolder(), "/player/");
    }

    @Override
    public void provide(String key, ProfilePlayer profilePlayer) {
        this.profilePlayerMap.put(key, profilePlayer);
        this.write();
    }

    @Override
    public void remove(String key) throws IOException {

        ProfilePlayer profilePlayer = this.profilePlayerMap.get(key);

        if (profilePlayer == null) return;
        this.profilePlayerMap.remove(key);
        this.write();
        FileUtils.deleteFile(new File(path, key + ".json"));
    }

    @Override
    public ProfilePlayer get(String key) {
        return this.profilePlayerMap.get(key);
    }

    @Override
    public void read() {
        File[] files = path.listFiles();
        if (files == null) {
            this.profilePlayerMap = new HashMap<>();
            return;
        }

        IOUtil ioUtil = this.getInstance().getIoUtil();

        for (File file : files) {
            if (file.isFile()) {
                final String json = FileUtils.loadContent(file);
                ProfilePlayer profilePlayerData = ioUtil.deserializeProfile(json);
                this.profilePlayerMap.put(profilePlayerData.getName(), profilePlayerData);

            }
        }
    }

    @Override
    public void write() {
        if (this.getProfiles() == null) return;

        final IOUtil ioUtil = this.getInstance().getIoUtil();
        for (ProfilePlayer profilePlayerData : this.getProfiles()) {
            final File file = new File(path, profilePlayerData.getName() + ".json");

            String json = ioUtil.serializeProfile(profilePlayerData);
            FileUtils.save(file, json);
        }
    }

    public Collection<ProfilePlayer> getProfiles() {
        return this.profilePlayerMap.values();
    }
}
