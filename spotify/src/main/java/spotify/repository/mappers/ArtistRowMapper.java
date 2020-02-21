package spotify.repository.mappers;

import org.springframework.jdbc.core.RowMapper;
import spotify.repository.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRowMapper implements RowMapper<Artist> {

  @Override
  public Artist mapRow(ResultSet rs, int i) throws SQLException {
    final Artist artist = new Artist();
    artist.setId(rs.getLong("id"));
    artist.setFirstName(rs.getString("first_name"));
    artist.setLastName(rs.getString("last_name"));
    artist.setDateOfBirth(rs.getDate("date_of_birth"));
    artist.setGenre(rs.getString("genre"));
    return artist;
  }
}
