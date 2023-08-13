package com.grandemc.projeto1;

import com.grandemc.projeto1.Events.InventoryClick;
import com.grandemc.projeto1.Events.MotdEvent;
import com.grandemc.projeto1.Events.PlayerEvents;
import com.grandemc.projeto1.commands.AjudaComando;
import com.grandemc.projeto1.commands.Entidades;
import com.grandemc.projeto1.utils.files.Lista;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Projeto extends JavaPlugin implements Listener {

    private static Projeto instance;
    private static Lista lista;

    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();
        lista = new Lista();
        registrarEventos();
        registrarComandos();
        startScheduler();

    }


    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new MotdEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
    }

    private void registrarComandos() {
        getCommand("ajuda").setExecutor(new AjudaComando());
        getCommand("entidade").setExecutor(new Entidades());
    }



    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage("§4Fechando!");

    }

    private void loadConfiguration(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Projeto getInstance() {
        return instance;
    }

    public static Lista getLista() {
        return lista;
    }

    public void startScheduler(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {

            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendMessage("§aNem tudo na vida são flores, as vezes é má!");
            }


        }, 0, 20 * 60 * 2);
    }


}
