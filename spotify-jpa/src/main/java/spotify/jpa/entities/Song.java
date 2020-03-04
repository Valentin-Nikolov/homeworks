package spotify.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private Date dateOfPublishing;
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false, foreignKey = @ForeignKey(name = "fk_songs_artists"))
    private Artist artist;


    public Song() {
    }

    public Song(long id, String title, Date dateOfPublishing, int duration, Artist artist) {
        this.id = id;
        this.title = title;
        this.dateOfPublishing = dateOfPublishing;
        this.duration = duration;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(Date dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfPublishing=" + dateOfPublishing +
                ", duration=" + duration +
                ", artist=" + artist +
                '}';
    }
}
