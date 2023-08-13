package com.grandemc.projeto1;
import org.bukkit.Bukkit;

import static com.grandemc.projeto1.Projeto.*;

public class ClasseTeste {

    public static void exibirPessoas(){
        for (String mensagem : getInstance().getConfig().getConfigurationSection("pessoas").getKeys(false)){
            Bukkit.getConsoleSender().sendMessage(mensagem);
            Bukkit.getConsoleSender().sendMessage(getInstance().getConfig().getString("pessoas." + mensagem + ".idade"));
            Bukkit.getConsoleSender().sendMessage(getInstance().getConfig().getString("pessoas." + mensagem + ".nome"));
        }
    }

}
