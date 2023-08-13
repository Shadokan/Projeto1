package com.grandemc.projeto1.objects;

import com.grandemc.projeto1.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WelcomeInventory {

    private Inventory inventory;


    public WelcomeInventory(){
        inventory = Bukkit.createInventory(null, 3 * 9, "§aBem vindo ao servidor");
        insertItens();
    }


    private void insertItens(){

        ItemStack i = new ItemBuilder(Material.DIAMOND, 1, (short) 0).setDisplayName("§aAloha!").build();
        ItemStack i2 = new ItemBuilder(Material.GOLD_INGOT, 1, (short) 0).setDisplayName("§aAloha!").build();

        inventory.setItem(12, i);
        inventory.setItem(14, i2);


    }

    public Inventory getInventory() {
        return inventory;
    }
}
