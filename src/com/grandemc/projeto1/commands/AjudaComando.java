package com.grandemc.projeto1.commands;

import com.grandemc.projeto1.ItemBuilder;
import com.grandemc.projeto1.SkullBuilder;
import com.grandemc.projeto1.objects.WelcomeInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AjudaComando implements CommandExecutor {

    private HashMap<Player, Long> ajuda = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ajuda")) {


            if (ajuda.containsKey(p) && !(System.currentTimeMillis() >= ajuda.get(p))){
                p.sendMessage("§cAguarde o delay de " + converter(p) + " §aSegundos");
                return false;
            } else ajuda.remove(p);


            ajuda.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));



            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage("§aDigite /ajuda 1 - Para ajuda normal");
                p.sendMessage("§aDigite /ajuda 2 - Para ajuda maxima");
                p.sendMessage("");
                return true;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("1")) {
                    p.sendMessage("");
                    p.sendMessage("§aVocê sabia que o sabia sabia asobiar?");
                    p.sendMessage("");

                    ItemStack i = new ItemStack(Material.DIAMOND, 1, (short) 0);

                    ItemMeta im = i.getItemMeta();

                    im.setDisplayName("§6Um item muito legal");
                    im.setLore(Arrays.asList("§4MUITO TOP", "§aVSF"));

                    i.setItemMeta(im);

                    p.getInventory().addItem(i);

                    p.openInventory(new WelcomeInventory().getInventory());



                    return true;
                }

                if (args[0].equalsIgnoreCase("2")) {
                    p.sendMessage("");
                    p.sendMessage("§4Os deuses ficaram bravos com voce!?");
                    p.sendMessage("");

                    ItemStack i = new ItemBuilder(Material.DIAMOND).build();
                    ItemStack head = new SkullBuilder().setOwner(p.getName()).build();

                    p.getInventory().addItem(i, head);



                    return true;
                }



            }


            Bukkit.dispatchCommand(sender, "ajuda");
        }



        return false;
    }

    private Long converter(Player p){
        long tempo = System.currentTimeMillis() - ajuda.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo) * -1;
    }

}