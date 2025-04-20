package fr.kalipso.valorsky.manager.kits.provider;


import fr.kalipso.valorsky.hEssentials;
import fr.kalipso.valorsky.manager.kits.factory.Kits;
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

public class KitProvider implements IProvider<String, Kits>, IWriteable, IReadable {

    private hEssentials main = hEssentials.getInstance();

    @Getter
    private Map<String, Kits> kitsMap;
    private File path;

    public KitProvider(hEssentials p) {
        this.kitsMap = new HashMap<>();
        this.path = new File(p.getDataFolder(), "/kits/");
    }

    @Override
    public void provide(String key, Kits area) {
        this.kitsMap.put(key, area);
        this.write();
    }

    @Override
    public void remove(String key) throws IOException {

        Kits area = this.kitsMap.get(key);

        if (area == null) return;
        this.kitsMap.remove(key);
        this.write();
        FileUtils.deleteFile(new File(path, key + ".json"));
    }

    @Override
    public Kits get(String key) {
        return this.kitsMap.get(key);
    }

    @Override
    public void read() {
        File[] files = path.listFiles();
        if (files == null) {
            this.kitsMap = new HashMap<>();
            return;
        }

        IOUtil ioUtil = this.main.getIoUtil();

        for (File file : files) {
            if (file.isFile()) {
                final String json = FileUtils.loadContent(file);
                Kits kitData = ioUtil.deserializeKits(json);
                this.kitsMap.put(kitData.getName(), kitData);

            }
        }
    }

    @Override
    public void write() {
        if (this.getKits() == null) return;

        final IOUtil ioUtil = this.main.getIoUtil();
        for (Kits kitData : this.getKits()) {
            final File file = new File(path, kitData.getName() + ".json");

            String json = ioUtil.serializeKits(kitData);
            FileUtils.save(file, json);
        }
    }

    public Collection<Kits> getKits() {
        return this.kitsMap.values();
    }

    public Kits getByName(String name)
    {
        return this.get(name);
    }

}