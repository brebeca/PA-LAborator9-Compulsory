package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    Connection conn;
    AlbumController(Connection connection){
        this.conn=connection;
    }
    /**
     * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul
     * @param name
     * @param artistId
     * @param releaseYear
     * @throws SQLException
     */
    public void create(String name, int artistId, int releaseYear) throws SQLException {

        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into  albums(name, artist_id , release_year) values('"+name+"','"+artistId+"'"+","+"'"+ releaseYear+"')");

    }

    /**
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @param id
     * @throws SQLException
     */

    public void findByArtist(int id ) throws SQLException {

        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from albums where artist_id='"+id+"'");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));

    }

    /**
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @throws SQLException
     */
    public void getSongs() throws SQLException {

        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from albums");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));

    }

    /**
     * returneaza numerul de randuri din tabela prin interogarea cu count(*) a aceasteaia
     * @return
     * @throws SQLException
     */
    public int getCount() throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select count(*) from albums");
        rs.next();
        return rs.getInt(1);
    }
}
