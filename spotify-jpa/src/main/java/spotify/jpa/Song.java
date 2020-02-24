package spotify.jpa;

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
    @JoinColumn(name = "artistId", nullable = false, foreignKey = @ForeignKey(name = "fk_flows_artists"))
    private long artistId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "artistId", nullable = false, foreignKey = @ForeignKey(name = "fk_flows_artists"))
//    private Artist artist;


    public Song() {
    }

    public Song(long id, String title, Date dateOfPublishing, int duration, long artistId) {
        this.id = id;
        this.title = title;
        this.dateOfPublishing = dateOfPublishing;
        this.duration = duration;
        this.artistId = artistId;
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

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfPublishing=" + dateOfPublishing +
                ", duration=" + duration +
                ", artist=" + artistId +
                '}';
    }
}
