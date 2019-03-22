package com.chip0.checker.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class GrantsHelper {
    private Connection conn;
    private final static Logger log = LogManager.getLogger(GrantsHelper.class);

    public GrantsHelper(Connection conn)
    {
        this.conn = conn;
    }

    public void getObjectName(String obj_id)
    {
        try {
            conn.setAutoCommit(false);
            log.info("Creating statement");
            PreparedStatement statement = conn.prepareStatement("SELECT NAME FROM NC_OBJECTS WHERE OBJECT_ID = ?");
            statement.setString(1, obj_id);
            log.info("Trying to get result set");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                log.info("Found object with name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
