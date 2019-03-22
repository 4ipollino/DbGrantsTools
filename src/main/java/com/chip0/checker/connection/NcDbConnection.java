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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setSid(String sid) {
        this.sid = sid;
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