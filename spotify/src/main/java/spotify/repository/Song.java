package spotify.repository;

import lombok.Data;

import java.util.Date;

@Data
public class Song {

    private long id;
    private String title;
    private Date dateOfPublishing;
    private int duration;
    private long artistId;
}
