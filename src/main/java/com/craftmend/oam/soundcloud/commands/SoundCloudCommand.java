package com.craftmend.oam.soundcloud.commands;

import com.craftmend.oam.soundcloud.SoundCloud;
import com.craftmend.openaudiomc.modules.commands.interfaces.SubCommand;
import com.craftmend.openaudiomc.modules.commands.objects.Argument;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SoundCloudCommand extends SubCommand {

    private SoundCloud main;

    public SoundCloudCommand(SoundCloud soundCloud) {
        super("soundcloud");
        registerArguments(new Argument("", "Prints a list of all SoundCloud sounds that have been used in the server. This is required by the SoundCloud API rules."));
        main = soundCloud;
    }

    @Override
    public void onExecute(CommandSender commandSender, String[] strings) {
        message(commandSender, "Sounds used via the SoundCloud addon:");
        main.getSounds().forEach(sound -> message(commandSender, " - " + ChatColor.AQUA + sound));
    }
}
