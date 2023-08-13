package com.grandemc.projeto1.Events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import static com.grandemc.projeto1.Projeto.*;

public class MotdEvent implements Listener {

    @EventHandler
    public void quandoPingar(ServerListPingEvent e){

        ConfigurationSection cfg = getLista().getConfig().getConfigurationSection("mensagens");

        String come = cfg.getString("disponivel").replace("&", "§");
        String offline = cfg.getString("offline").replace("&", "§");


        if (Bukkit.hasWhitelist()) e.setMotd(offline);
        else e.setMotd(come);

    }


}
