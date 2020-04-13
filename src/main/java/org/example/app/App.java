package org.example.app;


import org.example.entity.Albums_;
import org.example.entity.Artists_;
import org.example.repo.AlbumRepository;
import org.example.repo.ArtistRepository;

public class App
{
    public static void main( String[] args ){

     Albums_ album= new Albums_();
     album.setArtistId(1);
     album.setName("PUtest2");
     album.setYear(2000);
     album.setId(2);
   //   new AlbumRepository().create(album);
     //new AlbumRepository().findById(1);
     Artists_ artists_=new Artists_();
     artists_.setId(3);
     artists_.setName("artist3");
     artists_.setCountry("US");
     //new ArtistRepository().create(artists_);
}
}
