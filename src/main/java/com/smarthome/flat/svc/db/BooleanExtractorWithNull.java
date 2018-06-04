package com.smarthome.flat.svc.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BooleanExtractorWithNull implements ResultSetExtractor<Boolean> {

  @Override
  public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
    if (rs.next()) {
      return rs.getBoolean(1);
    } else {
      return null;
    }
  }
}
