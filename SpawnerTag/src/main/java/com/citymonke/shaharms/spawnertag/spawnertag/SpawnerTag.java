package com.citymonke.shaharms.spawnertag.spawnertag;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.World;

public final class SpawnerTag extends JavaPlugin {

    @EventHandler
    public void Break(BlockBreakEvent onBlockBreak){

        if (onBlockBreak.getBlock().getBlockData().matches())
    }

    @Override
    public void onEnable() {
        System.out.print("Initializing plugin...");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void run() {

    }
}
