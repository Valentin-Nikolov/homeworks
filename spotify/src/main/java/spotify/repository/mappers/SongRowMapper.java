package spotify.repository.mappers;

import org.springframework.jdbc.core.RowMapper;
import spotify.repository.Customer;
import spotify.repository.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper implements RowMapper<Song> {

  @Override
  public Song mapRow(ResultSet rs, int i) throws SQLException {
    final Song song = new Song();
    song.setId(rs.getLong("id"));
    song.setTitle(rs.getString("title"));
    song.setDateOfPublishing(rs.getDate("date_of_publishing"));
    song.setDuration(rs.getInt("duration"));
    song.setArtistId(rs.getLong("artist_id"));
    return song;
  }
}
