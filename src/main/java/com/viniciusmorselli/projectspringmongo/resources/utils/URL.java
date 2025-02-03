package com.viniciusmorselli.projectspringmongo.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class URL {

  public static String decodeParam(String text) {
    try {
      return URLDecoder.decode(text, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return "";
    }
  }

  public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    fmt.withZone(ZoneId.of("Etc/UTC"));

    try {
      return LocalDate.parse(textDate, fmt);
    } catch (Exception e) {
      return defaultValue;
    }
    
  }
}
