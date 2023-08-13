package com.grandemc.projeto1.utils.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static com.grandemc.projeto1.Projeto.*;

public class Lista {

    private File file;
    private FileConfiguration fileConfiguration;


    public Lista() {
        file = new File(getInstance().getDataFolder(), "lista.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()){

            try{
                file.createNewFile();
                Bukkit.getConsoleSender().sendMessage("§ao Arquivo lista.yml nao existia, portanto foi criado");
                loadConfiguration();
            }catch (Exception e){
                Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao criar arquivo lista.yml");
            }

        }

    }

    public FileConfiguration getConfig(){
        return fileConfiguration;
    }

    public void saveConfig(){
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage("§cOcorreu um erro ao salvar arquivo lista.yml");
        }
    }

    private void loadConfiguration(){
        getConfig().createSection("mensagens");
        getConfig().set("mensagens.disponivel", "o servidor esta online, venha jogar.");
        getConfig().set("mensagens.offline", "o servidor esta offline, se fudeu.");
        saveConfig();
    }

}
