package org.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name="Albums_.findById",
                query="SELECT c FROM Albums_ c WHERE c.id=:id"),
        @NamedQuery(name="Albums_.findByArtist",
                query="SELECT c FROM Albums_ c WHERE c.artist_id=:id"),
        @NamedQuery(name="Albums_.findByName",
                query="SELECT c FROM Albums_ c WHERE c.name=:name")
})
@Table(name="albums_")
public class Albums_  implements Serializable {
    @Id
    @Column(name = "id")
    int id ;

    @Column(name = "artist_id")
    int artist_id;

    @Column(name="name")
    String name ;

    @Column(name="release_year")
    int  year;

    public void setArtistId(int artistId) {
        this.artist_id = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artist_id;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
