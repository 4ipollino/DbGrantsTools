package com.chip0.checker.main;

import com.chip0.checker.connection.NcDbConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mainApp {
    static Logger log = LogManager.getLogger(mainApp.class);

    public static void main(String[] args) {
        log.info("Starting...");
        log.info("Trying to connect...");
        NcDbConnection.connect();
    }
}
