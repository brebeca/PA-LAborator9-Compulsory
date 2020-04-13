package org.example.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="artists_")
@NamedQueries({
        @NamedQuery(name="Artist.findById",
                query="SELECT c FROM Artists_ c WHERE c.id=:id"),
        @NamedQuery(name="Artist.findByName",
                query="SELECT c FROM Artists_ c WHERE c.name=:name")
})
public class Artists_  implements Serializable {
    @Id
    @Column(name = "id")
    int id ;

    @Column(name="name")
    String name;

    @Column(name="country")
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
