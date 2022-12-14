package com.kamitbrains.nkaurelien.ionis_stm.csvreader;

import java.io.IOException;

public class Helper {

    public static String cwd() {
        String currentPath = null;
        try {
            currentPath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return currentPath;
    }
}
