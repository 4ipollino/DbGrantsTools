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

    public void getObjectNameByID(String objId)
    {
        try {
            log.info("Creating statement for getObjectNameByID(" + objId + ")");
            PreparedStatement statement = conn.prepareStatement("SELECT NAME FROM NC_OBJECTS WHERE OBJECT_ID = ?");
            statement.setString(1, objId);
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

    public void getGrantsForObjectByID(String objId)
    {
        try {
            log.info("Creating statement for getGrantsForObjectByID(" + objId + ")");
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT O.NAME, O.OBJECT_ID, G.GRANTS " +
                            "FROM NC_OBJECTS O, NC_GRANTS G " +
                            "WHERE O.OBJECT_ID = G.USER_ID " +
                            "AND G.OBJECT_ID = ?");
            statement.setString(1, objId);
            log.info("Trying to get result set");
            ResultSet resultSet = statement.executeQuery();
            log.info("USER\t\tUSER_ID\t\tGRANTS");
            while (resultSet.next())
            {
                log.info(resultSet.getString("NAME") + "\t\t"
                        + resultSet.getString("OBJECT_ID") + "\t\t"
                        + resultSet.getString("GRANTS"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
