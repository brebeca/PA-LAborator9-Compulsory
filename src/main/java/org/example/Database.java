package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instanta = null;
    private Connection conexiune;

    /**
     * realizeaza conexiunea in obiectul conexiune de tip Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    Database() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
         conexiune= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Birleanu1998");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return conexiune;
    }
    public void closeConnection() throws SQLException {
        conexiune.close();
    }

    /**
     * asigura faptul ca se poate crea o singura instanta a clasei
     * @return daca e prima instanta a clasei returneaza o clasa noua, daca nu o returneaza pe cea creata deja
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Database Database() throws SQLException, ClassNotFoundException {
        if (instanta == null)
            instanta = new Database();
        return instanta;
    }
}





