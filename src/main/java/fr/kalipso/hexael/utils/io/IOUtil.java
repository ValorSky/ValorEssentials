package fr.kalipso.hexael.utils.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.kalipso.hexael.data.player.factory.ProfilePlayer;
import fr.kalipso.hexael.data.server.factory.ProfileServer;
import fr.kalipso.hexael.manager.kits.factory.Kits;

public class IOUtil {

    public Gson gson;

    public IOUtil() {
        this.gson = createGsonInstance();
    }
    public Gson createGsonInstance() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    /** Server **/
    public String serializeServer(ProfileServer serverData) {
        return this.gson.toJson(serverData);
    }
    public ProfileServer deserializeServer(String json) {
        return this.gson.fromJson(json, ProfileServer.class);
    }

    /** Server **/

    /** Player **/
    public String serializeProfile(ProfilePlayer profileData) {
        return this.gson.toJson(profileData);
    }
    public ProfilePlayer deserializeProfile(String json) {
        return this.gson.fromJson(json, ProfilePlayer.class);
    }

    /** Player **/

    /** Kits **/
    public String serializeKits(Kits kitsData) {
        return this.gson.toJson(kitsData);
    }
    public Kits deserializeKits(String json) {
        return this.gson.fromJson(json, Kits.class);
    }

    /** Kits **/
}