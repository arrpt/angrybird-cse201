package com.github.angrybird;

import com.badlogic.gdx.Game;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LevelStatusManager {
    public static final String FILE_PATH = "level_status.ser";
    public static Map<String, String> levelStatus;
    public static Level1Screen level1screen;
    public static Level2Screen level2screen;
    public static Level3Screen level3screen;
    //public LevelStatusManager db;

    public LevelStatusManager(Main game) {
        loadStatus();
        if (levelStatus == null) {
            levelStatus = new HashMap<>();
        }
        if (levelStatus.isEmpty()) {
            levelStatus.put("level1", "not_started");
            levelStatus.put("level2", "not_started");
            levelStatus.put("level3", "not_started");
        }
        if (level1screen == null){
            level1screen = new Level1Screen(game);
        }
        if (level2screen == null){
            level2screen = new Level2Screen(game);
        }
        if (level3screen == null){
            level3screen = new Level3Screen(game);
        }
    }

    public Level1Screen getLevel1Screen(Main game){
        level1screen.game = game;
        return level1screen;
    }

    public Level2Screen getLevel2Screen(Main game){
        level2screen.game = game;
        return level2screen;
    }

    public Level3Screen getLevel3Screen(Main game){
        level3screen.game = game;
        return level3screen;
    }

    public void setLevelStatus(String level, String status) {
        levelStatus.put(level, status);
        saveStatus();
    }

    public String getLevelStatus(String level) {
        return levelStatus.getOrDefault(level, "not_started");
    }

    public void saveStatus() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStatus() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            saveStatus(); // Create the file if it does not exist
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                this.db = (LevelStatusManager) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
