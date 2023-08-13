package com.grandemc.projeto1.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

import static com.grandemc.projeto1.Projeto.*;

public class PlayerEvents implements Listener {

    @EventHandler
    public void quando(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType() != Material.GRASS) return;
        String texto = getInstance().getConfig().getString("mensagem.ready");
        p.getPlayer().sendMessage(texto);
    }

    @EventHandler
    public void matar(EntityDamageByEntityEvent e){

        Entity damager = e.getDamager();
        Entity damagee = e.getEntity();

        if (damager instanceof Player && damagee instanceof LivingEntity){
            Player player = (Player) damager;
            LivingEntity mob = (LivingEntity) damagee;

            double newDamage = e.getDamage() * 50.0;

            e.setDamage(newDamage);

        }




    }


}
