package net.vybemc.lobbysystem.util;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.vybemc.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar {

    private boolean running = false;
    private final String actionBarText;

    public ActionBar(String actionBarText) {
        this.actionBarText = actionBarText;
        setRunning(true);

        runLoop();
    }

    private boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void sendActionBarText(Player p, String text){
        PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText(text), (byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public void sendActionBarToEveryone(String text){
        for (Player all : Bukkit.getOnlinePlayers()){
            sendActionBarText(all, text);
        }
    }

    private void runLoop(){
        new BukkitRunnable() {
            @Override
            public void run() {
                if (isRunning()){
                    sendActionBarToEveryone(actionBarText);
                }
            }
        }.runTaskTimer(LobbySystem.getPlugin(), 0 , 20);
    }

}
