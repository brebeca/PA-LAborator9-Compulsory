package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartController {
    Connection conn;
    ChartController(Connection connection){
        conn=connection;
    }

    /**
     * insereza in tabelul chart id-rile
     * @param album_id id-ul albumului
     * @throws SQLException
     */
    public void insert( int album_id) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into  charts(album_id) values("+ album_id+")");
    }

    /**
     * interogheaza cele trei tabele cu un join penru a face legatura de la CHARTS la ARTISTS
     * @throws SQLException
     */
    public void getArtists() throws SQLException {
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select  c.id, art.name, art.country from charts c  join albums alb on c.album_id=alb.id join artists art on alb.artist_id =art.id order by c.id");
        while(rs.next())
            System.out.println("No."+rs.getInt(1)+" : "+rs.getString(2)+" from  "+rs.getString(3));
    }
}
