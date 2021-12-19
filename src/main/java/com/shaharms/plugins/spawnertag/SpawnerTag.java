package com.shaharms.plugins.spawnertag;

import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class SpawnerTag extends JavaPlugin {

    @EventHandler
    public void Break(BlockBreakEvent onBlockBreak){
        if (onBlockBreak.getBlock().getX() == -627 && onBlockBreak.getBlock().getY() == 93 && onBlockBreak.getBlock().getZ() == -1430) getServer().getWorld("world").getBlockAt(-625, 94, -1430).setType(getTypeByChance());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent onBlockPlace) {
        if (onBlockPlace.getBlock().getX() == -627 && onBlockPlace.getBlock().getY() == 93 && onBlockPlace.getBlock().getZ() == -1430) {
            if (onBlockPlace.getBlock().getType() == Material.CHEST) {
                BlockState state = onBlockPlace.getBlock().getState();
                Chest chest = (Chest) state;
                int chance = new Random().nextInt(20);
                if (chance < 3) chest.getBlockInventory().addItem(new ItemStack(Material.SKELETON_SPAWN_EGG, 2));
                else if (chance < 7) chest.getBlockInventory().addItem(new ItemStack(Material.ZOMBIE_SPAWN_EGG, 2));
                else if (chance < 11) chest.getBlockInventory().addItem(new ItemStack(Material.SPIDER_SPAWN_EGG, 2));
                else if (chance < 15) chest.getBlockInventory().addItem(new ItemStack(Material.COW_SPAWN_EGG, 2));
                else if (chance < 19) chest.getBlockInventory().addItem(new ItemStack(Material.CREEPER_SPAWN_EGG, 2));
                else chest.getBlockInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG, 2));


            }
        }
    }

    Material getTypeByChance() {
        int chance;
        chance = new Random().nextInt(1000);
        if (chance < 500) return Material.STONE;
        if (chance < 700) return Material.TUFF;
        if (chance < 800) return Material.ANDESITE;
        if (chance < 850) return Material.GRANITE;
        if (chance < 900) return Material.DIORITE;
        if (chance < 920) return Material.COAL_ORE;
        if (chance < 940) return Material.COPPER_ORE;
        if (chance < 950) return Material.IRON_ORE;
        if (chance < 960) return Material.MOSS_BLOCK;
        if (chance < 980) return Material.MOSSY_COBBLESTONE;
        if (chance < 985) return Material.DIAMOND_ORE;
        if (chance < 990) return Material.CHEST;
        return Material.SPAWNER;


    }
    @Override
    public void onEnable() {
        getServer().getWorld("world").getBlockAt(-627, 93, -1430).setType(getTypeByChance());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
