package de.ghosterapi;

import de.ghosterapi.commands.CrashCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ghoster#0001
 * @copyright Ghoster
 * Created on 22.07.2021 «» 11:32
 * Class «» Main
 **/

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("crash").setExecutor(new CrashCommand());
        Bukkit.getConsoleSender().sendMessage("§aThe plugin was activated successfully! §eThe plugin was written by §cGhosterAPI§e!");
    }
}
