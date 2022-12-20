package com.goit.feature;

import com.goit.feature.database.Database;
import com.goit.feature.database.DatabaseInitService;

public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseInitService().initDb();
    }
}
