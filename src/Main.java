import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            fifth();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:db.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void first() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS test (id INTEGER PRIMARY KEY AUTOINCREMENT, sameText TEXT);");
    }

    private static void second() throws SQLException {
        stmt.executeUpdate("INSERT INTO test(sameText) values(\"samesame\");");
    }

    private static void third() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM test;")) {
            while (rs.next()) {
                System.out.printf("%d %s\n", rs.getInt(1), rs.getString("sameText"));
            }
        }
    }

    private static void firth() throws SQLException {
        stmt.executeUpdate("DELETE FROM test WHERE sameText = \"samesame'\"");
    }

    private static void fifth() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS test;");
    }
}
