package com.chip0.checker.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class NcDbConnection {
    private static final Logger log = LogManager.getLogger(NcDbConnection.class);

    /* parameters for connection */

    private static String username;
    private static String password;
    private static String server;
    private static String port;
    private static String sid;
    private static String connUrl;

    /* we need to set connection parameters before connect */

    public static void setUsername(String username) {
        NcDbConnection.username = username;
    }

    public static void setPassword(String password) {
        NcDbConnection.password = password;
    }

    public static void setServer(String server) {
        NcDbConnection.server = server;
    }

    public static void setPort(String port) {
        NcDbConnection.port = port;
    }

    public static void setSid(String sid) {
        NcDbConnection.sid = sid;
    }

    /* connect and return the connection */

    public static Connection connect()
    {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            log.info("Driver found successfully");
        } catch (ClassNotFoundException e) {
            log.error("JDBC driver not found");
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":" + port + ":" + sid, username, password);
            log.info("Connected successfully");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return conn;
    }
}