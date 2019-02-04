package com.craftmend.oam.soundcloud.mutations;

import com.craftmend.oam.soundcloud.SoundCloud;
import com.craftmend.openaudiomc.OpenAudioMc;
import com.craftmend.openaudiomc.modules.media.interfaces.UrlMutation;

public class SoundCloudMutation implements UrlMutation {

    private SoundCloud main;

    public SoundCloudMutation(SoundCloud main) {
        this.main = main;
    }

    @Override
    public String onRequest(OpenAudioMc openAudioMc, String s) {
        main.registerSound(s);
        return "https://api.openaudiomc.net/stream.php?u=" + s;
    }
}
