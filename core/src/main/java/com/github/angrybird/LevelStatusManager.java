package com.github.angrybird;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LevelStatusManager {
    private static final String FILE_PATH = "level_status.ser";
    private Map<String, String> levelStatus;

    public LevelStatusManager() {
        levelStatus = new HashMap<>();
        loadStatus();
    }

    public void setLevelStatus(String level, String status) {
        levelStatus.put(level, status);
        saveStatus();
    }

    public String getLevelStatus(String level) {
        return levelStatus.getOrDefault(level, "not_started");
    }

    private void saveStatus() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(levelStatus);
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
                levelStatus = (Map<String, String>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
