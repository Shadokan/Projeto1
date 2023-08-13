package com.grandemc.projeto1.commands;

import com.grandemc.projeto1.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;

public class Entidades implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;


        if (cmd.getName().equalsIgnoreCase("entidade")){

            p.sendMessage("§4Ele apareceu mais bravo que um ximpanze");

            spawnarEntidade(p);


        }

        return false;
    }


        public void spawnarEntidade(Player p){

        ItemStack i = new ItemBuilder(Material.DIAMOND_AXE, 1, (short) 0).build();


        Skeleton skeleton = (Skeleton) p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);
        skeleton.getEquipment().setItemInHand(i);
            skeleton.setCustomNameVisible(true);
        skeleton.setCustomName("§4Ximpanzeee");


        }


    }
