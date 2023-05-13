package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtility {

    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    //---------------This method create connection to the database, execute query and return object ResulSet----------

    public static ResultSet getResultSet(String sqlQuery) {

        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUsername"),
                    ConfigReader.getPropertyValue("dbPassword"));

            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    // --------------------------This method return an Object of ResultSetMetaData---------------------------

    public static ResultSetMetaData getResultSetMetaData(String query) {
        resultSet = getResultSet(query);
        resultSetMetaData = null;
        // we use this line to get the data in particular format so that
        // we can use these in column keys and values for retrieval operation
        try {
            resultSetMetaData = resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSetMetaData;
    }
    //---------------------This method extract data from ResultSet and stores into List of Maps--------------------

    //this method is extracting the data which will be stored in list of maps
    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        resultSetMetaData =getResultSetMetaData(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = resultSetMetaData.getColumnName(i);
                    String value = resultSet.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtility.closeResultSet(resultSet);
            DataBaseUtility.closeStatement(statement);
            DataBaseUtility.closeConnection(conn);
        }
        return listFromRset;
    }
    //order to make connection
    //connection
    //statement
    //resultset

    // order to close connection
    //close resultset
    //close statement
    //close connection
    public static void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try {
               resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}