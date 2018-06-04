package com.smarthome.flat.svc.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LongExtractor implements ResultSetExtractor<Long> {

  @Override
  public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
    if (rs.next()) {
      return rs.getLong(1);
    } else return null;
  }
}
