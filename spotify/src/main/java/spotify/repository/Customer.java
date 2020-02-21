package spotify.repository;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private Boolean isPayed;
}
