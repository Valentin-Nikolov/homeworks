package spotify.repository.mappers;

import spotify.repository.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

  @Override
  public Customer mapRow(ResultSet rs, int i) throws SQLException {
    final Customer customer = new Customer();
    customer.setId(rs.getLong("id"));
    customer.setFirstName(rs.getString("first_name"));
    customer.setLastName(rs.getString("last_name"));
    customer.setEmail(rs.getString("email"));
    customer.setDateOfBirth(rs.getDate("date_of_birth"));
    customer.setIsPayed(rs.getBoolean("is_payed"));
    return customer;
  }
}
