package spotify.repository;

import lombok.Data;

import java.util.Date;

@Data
public class Artist {

    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String genre;
}
