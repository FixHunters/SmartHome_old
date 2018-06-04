package com.smarthome.flat.svc.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class IntegerExtractor implements ResultSetExtractor<Integer> {

  @Override
  public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
    if (rs.next()) {
      return rs.getInt(1);
    } else return null;
  }
}
