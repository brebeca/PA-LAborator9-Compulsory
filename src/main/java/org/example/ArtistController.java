package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    Connection con;
    ArtistController(Connection connection) {
       con=connection;
    }
    /**
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul
     * @param name
     * @param country
     * @throws SQLException
     */
    public void create(String name, String country) throws SQLException {

        Statement statement = con.createStatement();
        statement.executeUpdate("insert into  artists(name, country) values('"+name+"','"+country+"')");

    }

    /**
      * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
    * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @param name
     * @throws SQLException
     */
    public void findByName(String name) throws SQLException {

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from artists where name ='"+name+"'");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

    }

    /**
      * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
       * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @throws SQLException
     */
    public void getArtsits() throws SQLException {

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from artists");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

    }

    /**
     * returneaza id ul inregistrarii cu une numele este 'name'
     * @param name numele cautat in tabela
     * @return id-ul inregistrarii
     * @throws SQLException
     */
    public int getIdByName(String name) throws SQLException {

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from artists where name ='"+name+"'");
        rs.next();
        return rs.getInt(1);

    }

}
