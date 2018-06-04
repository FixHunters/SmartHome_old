package com.smarthome.flat.svc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthome.flat.svc.db.DBSupport;
import com.smarthome.flat.svc.model.TppsListReply;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(
  value = "io.swagger.codegen.languages.SpringCodegen",
  date = "2017-11-20T11:14:00.001+01:00"
)
@Controller
@RestController
public class TppsApiController implements TppsApi{

  private static final Logger log = LoggerFactory.getLogger(TppsApiController.class);

  private static final String CERT_ENCODING = "UTF-8";

  private final HttpServletRequest request;

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private Environment env;


  private DBSupport dbSupport;


  @org.springframework.beans.factory.annotation.Autowired
  public TppsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.request = request;
  }

  private DBSupport getDbSupport() {
    if (dbSupport == null) {
      dbSupport = new DBSupport(jdbcTemplate);
      log.debug("TppsApiController:: dbSupport created " + dbSupport);
    }
    return dbSupport;
  }


  @Override
  public ResponseEntity<TppsListReply> getTPPRecords(
      @ApiParam(value = "") @Valid @RequestParam(value = "tppName", required = false)
          String tppName,
      @ApiParam(value = "") @Valid @RequestParam(value = "country", required = false)
          String country,
      @ApiParam(value = "") @Valid @RequestParam(value = "isBlocked", required = false)
          Boolean isBlocked,
      @ApiParam(value = "") @Valid @RequestParam(value = "pageSize", required = false)
          String pageSize,
      @ApiParam(value = "") @Valid @RequestParam(value = "cursor", required = false) String cursor,
      @ApiParam(value = "") @Valid @RequestParam(value = "role", required = false) String role,
      @ApiParam(value = "") @Valid @RequestParam(value = "licenceId", required = false)
          String licenceId,
      @ApiParam(value = "") @Valid @RequestParam(value = "registrator", required = false)
          String registrator,
      @ApiParam(value = "") @Valid @RequestParam(value = "registratorCountry", required = false)
          String registratorCountry) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      return new ResponseEntity<TppsListReply>(
          getDbSupport()
              .getCerts(
                  tppName,
                  country,
                  isBlocked,
                  pageSize,
                  cursor,
                  role,
                  licenceId,
                  registrator,
                  registratorCountry),
          HttpStatus.OK);
    }

    // no accept application/json
    throw new BadRequestException("Wrong format");
  }


}
