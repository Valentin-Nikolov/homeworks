package spotify.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.repository.mappers.CustomerRowMapper;
import spotify.repository.mappers.SongRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public SongRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void add(final Song song) {
    final String sql = "INSERT INTO songs (title, date_of_publishing, duration, artist_id) "
        + "VALUES (:title, :date_of_publishing, :duration, :artist_id)";

    final Map<String, Object> params = new HashMap<>();
    params.put("title", song.getTitle());
    params.put("date_of_publishing", song.getDateOfPublishing());
    params.put("duration", song.getDuration());
    params.put("artist_id", song.getArtistId());

    jdbcTemplate.update(sql, params);
  }

  public void delete(final long id) {
    final String sql = "DELETE FROM songs WHERE id = " + id;

    jdbcTemplate.update(sql, new HashMap<>());
  }

  public Song get(final long id) {
    final String sql = "SELECT * FROM songs WHERE id = " + id;

    return jdbcTemplate.queryForObject(sql, new HashMap<>(), new SongRowMapper());
  }

  public String getTitle(final long id) {
    final String sql = "SELECT title FROM songs WHERE id = " + id;

    final String[] title = new String[1];
    jdbcTemplate.query(sql, (rs, rowNum) -> title[0] = rs.getString("title"));

    return title[0];
  }

  public List<Song> getAll() {
    final String sql = "SELECT * FROM songs";

    return jdbcTemplate.query(sql, new SongRowMapper());
  }

  public void update(final Song song) {
    final String sql = "UPDATE songs SET "
        + "title = :title,"
        + "date_of_publishing = :date_of_publishing,"
        + "duration = :duration,"
        + "artist_id = :artist_id "
        + "WHERE id = :id";

    final Map<String, Object> params = new HashMap<>();
    params.put("id", song.getId());
    params.put("title", song.getTitle());
    params.put("date_of_publishing", song.getDateOfPublishing());
    params.put("duration", song.getDuration());
    params.put("artist_id", song.getArtistId());

    jdbcTemplate.update(sql, params);
  }
}
