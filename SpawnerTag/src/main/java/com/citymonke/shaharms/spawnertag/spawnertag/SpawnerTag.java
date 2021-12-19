package com.citymonke.shaharms.spawnertag.spawnertag;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnerTag extends JavaPlugin {
    public Location currentSpawnerLocation;
    @EventHandler
    public void Break(BlockBreakEvent onBlockBreak){

        if (onBlockBreak.getBlock().getBlockData().getMaterial() == Material.SPAWNER && onBlockBreak.getBlock().getLocation() == currentSpawnerLocation) {
            Bukkit.broadcastMessage(ChatColor.BOLD +""+ ChatColor.AQUA + "Congratulations! " + ChatColor.RED + onBlockBreak.getPlayer() + ChatColor.AQUA + " Caught The Spawner!");

        }
    }

    @Override
    public boolean onCommand(CommandSender sender , Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("locateSpawner")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
            sender.sendMessage("Current Spawner is at: " + currentSpawnerLocation.getX() + ", " + currentSpawnerLocation.getY() + ", " + currentSpawnerLocation.getZ() + ", ");
            return true;
        } //If this has happened the function will return true.
        // If this hasn't happened the value of false will be returned.
        return false;
    }

    @Override
    public void onEnable() {
        System.out.print("Initializing plugin...");
        currentSpawnerLocation.setX(Math.floor(Math.random()*(-1100+100+1)-100));  
        currentSpawnerLocation.setY(Math.floor(Math.random()*(100-200+1)+100));
        currentSpawnerLocation.setZ(Math.floor(Math.random()*(-1900+900+1)-900));
        if (getServer().getWorld("world").getBlockAt(currentSpawnerLocation).getType() == Material.AIR)
        getServer().getWorld("world").getBlockAt(currentSpawnerLocation).setType(Material.SPAWNER);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
