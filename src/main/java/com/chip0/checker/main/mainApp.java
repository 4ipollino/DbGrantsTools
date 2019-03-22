package com.chip0.checker.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mainApp {
    static Logger logger = LogManager.getLogger(mainApp.class);

    public static void main(String[] args) {
        logger.error("test error");
        logger.info("test info");
        logger.debug("test debug");
    }
}
