package server;

import java.sql.*;

public class MainDBCrud {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {

        try {
            connect();
          clearTable();
           // prepareAllStatements();
            System.out.println("connected");
         //   fillTable();
            exInsert(2600, "a", "a", "a");
            System.out.println("inserted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

//
//    private static void exRollback() throws SQLException {
//        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 85);");
//        Savepoint sp1 = connection.setSavepoint();
//        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 85);");
//        connection.rollback(sp1);
//        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 85);");
//        connection.setAutoCommit(true);
//    }
//
//    private static void fillTableBatch() throws SQLException {
//        long begin = System.currentTimeMillis();
//        connection.setAutoCommit(false);
//        for (int i = 1; i <= 1000; i++) {
//               psInsert.setString(1, "user " + i);
//            psInsert.setString(2, "user " + i);
//            psInsert.setString(3, "user " + i);
//            psInsert.addBatch();
//        }
//        psInsert.executeBatch();
//        connection.commit();
//        long end = System.currentTimeMillis();
//        System.out.printf("Time %d ms", end - begin);
//    }

    private static void fillTable() throws SQLException {
        long begin = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i <= 1000; i++) {
            psInsert.setInt(1, 100 + i);
            psInsert.setString(4, "user " + i);
            psInsert.setString(2, "user " + i);
            psInsert.setString(3, "user " + i);
            psInsert.executeUpdate();
        }
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.printf("Time %d ms", end - begin);

    }

    private static void prepareAllStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO users (id, login, password, nickname)  VALUES ( ?, ? , ? , ?);");
    }

//    //CRUD create read update delete
//    private static void exSelect() throws SQLException {
//        ResultSet rs = stmt.executeQuery("SELECT name, score FROM students WHERE score > 80;");
//
//        while (rs.next()) {
//            System.out.println(rs.getString("name") + " " + rs.getInt("score"));
//        }
//
//        rs.close();
//    }
//
    private static void clearTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM users;");
    }
//
//    private static void exDelete() throws SQLException {
//        stmt.executeUpdate("DELETE FROM students WHERE score <= 40;");
//    }
//
//    private static void exUpdate() throws SQLException {
//     //   stmt.executeUpdate("UPDATE students SET score = 100 WHERE score >=85;");
////        UPDATE students SET score = 90 WHERE (score >=85) AND (name='Bob6');
////        UPDATE students SET score = 90 WHERE (score >=85) OR (name='Bob6');
  //  }
//
    private static void exInsertMore() throws SQLException {
        stmt.executeUpdate("INSERT INTO users (login, password, nickname) VALUES ('asd', 'asd', 'asd'),('qwe', 'qwe', 'qwe'),('zxc', 'zxc', 'zxc');");
    }
//
    private static void exInsert(int id, String login, String password, String nickname) throws SQLException {
        id = 2000;
        login = "f";
        password = ";";
        nickname = "jjkjkj";
        stmt.executeUpdate("INSERT INTO users (id, login, password, nickname) VALUES (id, login, password, nickname);");
    }
//
    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
//
//}
