package com.craftmend.oam.soundcloud;

import com.craftmend.oam.soundcloud.commands.SoundCloudCommand;
import com.craftmend.oam.soundcloud.mutations.SoundCloudMutation;
import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.modules.api.objects.OpenAudioApi;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class SoundCloud extends JavaPlugin {

    private List<String> soundList = new ArrayList<>();

    @Override
    public void onEnable() {
        OpenAudioApi api = OpenAudioMc.getApi();

        //register command
        api.registerAddonCommand(new SoundCloudCommand(this));
        api.registerMutation("https://soundcloud.com", new SoundCloudMutation(this));
        api.registerMutation("http://soundcloud.com", new SoundCloudMutation(this));
    }

    public List<String> getSounds() {
        return this.soundList;
    }

    public void registerSound(String url) {
        if (!soundList.contains(url)) soundList.add(url);
    }

}
