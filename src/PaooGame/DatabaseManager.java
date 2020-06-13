package PaooGame;

import java.sql.*;

/*! \class DatabaseManager
    \brief clasa pentru a efectua operatii asupra bazei de date
 */
public class DatabaseManager {
    private String databaseName;
    private static boolean isCreated = false;

    /*! \fn DatabaseManager(String databasePath)
        \brief constructorul clasei DatabaseManager

        \param databasePath numele bazei de date
     */
    public DatabaseManager(String databasePath) {
        this.databaseName = databasePath;
    }

    /*! \fn public void Update(int id, int x, int y, int level)
        \brief updateaza o intrare in baza de date in functie de id
     */
    public void Update(int id, int x, int y, int level) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "UPDATE SAVES set X=" + x + ", Y=" + y + ", LEVEL=" + level + " where ID=" + id;

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /*! \fn public void Insert(int id, int x, int y, int level)
        \brief insereaza o noua intrare in baza de date
     */
    public void Insert(int id, int x, int y, int level) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "INSERT INTO SAVES (ID, X, Y, LEVEL) " +
                    "VALUES (" + id + ", " + x + ", " + y + ", " + level + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /*! \fn public int[] Select(int id)
        \brief selecteaza o linie in functie de id si returneaza datele prelucrate sau null in caz de eroare
     */
    public int[] Select(int id) {
        Connection c = null;
        Statement stmt = null;
        int[] data = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            c.setAutoCommit(false);
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM SAVES WHERE ID=" + id);
            while (rs.next()) {
                int x = rs.getInt("X");
                int y = rs.getInt("Y");
                int level = rs.getInt("LEVEL");

                data = new int[3];
                data[0] = x;
                data[1] = y;
                data[2] = level;
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    /*! \fn private void CreateDatabase()
        \brief metoda folosita pentru a creea baza de date
     */
    private void CreateDatabase() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            stmt = c.createStatement();
            String sql = "CREATE TABLE SAVES " +
                    "(ID INT PRIMARY KEY NOT NULL, " +
                    "X INT NOT NULL, " +
                    "Y INT NOT NULL," +
                    "LEVEL INT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            isCreated = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
