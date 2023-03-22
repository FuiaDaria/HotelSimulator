package org.hotelsimulator.utils;

import org.postgresql.core.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DBURL = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
    private static final String USER = "postgres";
    private static final String PASSWORD = "badita26";

    private static DatabaseConnectionFactory dbConnectionFactory = new DatabaseConnectionFactory();

    private DatabaseConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return connection;
    }

    public static Connection getConnection() {
        return dbConnectionFactory.createConnection();
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException sqlException) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                LOGGER.log(Level.WARNING, "An error occrued while trying to close the ResultSet");
            }
        }
    }
}
