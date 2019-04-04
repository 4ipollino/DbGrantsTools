package com.chip0.checker.main;

import com.chip0.checker.connection.GrantsHelper;
import com.chip0.checker.connection.NcDbConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class mainApp {
    private final static Logger log = LogManager.getLogger(mainApp.class);

    public static void main(String[] args) {
        Connection conn = null;

        try {
            log.info("Starting...");
            log.info("Trying to connect...");

            NcDbConnection.setServer("10.112.251.194");
            NcDbConnection.setPort("1524");
            NcDbConnection.setSid("DBG129");
            NcDbConnection.setUsername("U234_DEV_6300");
            NcDbConnection.setPassword("U234_DEV_6300");

            conn = NcDbConnection.connect();
            GrantsHelper helper = new GrantsHelper(conn);
            helper.getObjectNameByID("9146598830013700836");
            helper.getGrantsForObjectByID("1050");
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }
}
