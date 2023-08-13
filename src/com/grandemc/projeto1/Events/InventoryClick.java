package com.grandemc.projeto1.Events;

import com.grandemc.projeto1.ItemBuilder;
import com.grandemc.projeto1.objects.WelcomeInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class InventoryClick implements Listener {


    @EventHandler
    public void quandoEntrar(PlayerJoinEvent e){

        Player p = e.getPlayer();

        p.sendMessage("§aSeja bem vindo ao servidor " + p.getName());


    }

    @EventHandler
    public void quandoClicar(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (!e.getInventory().getName().equalsIgnoreCase("§aBem vindo ao servidor")) return;
        e.setCancelled(true);
        ItemStack i = e.getCurrentItem();
        if (i.getType() == Material.DIAMOND){
            ItemStack i1 = new ItemBuilder(Material.DIAMOND, 1, (short) 0).setDisplayName("§bDIAMANTE!!!").build();
            p.sendMessage("§aGostou do diamante?");
            p.sendMessage("§aVocê ganhou um!");
            p.getInventory().addItem(i1);
        }

    }



}
