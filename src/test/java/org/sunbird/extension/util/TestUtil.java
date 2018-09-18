package org.sunbird.extension.util;

import static org.junit.Assert.fail;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class TestUtil {

  private static ObjectMapper mapper = new ObjectMapper();

  @SuppressWarnings("rawtypes")
  public static Map getJSONFileAsMap(String fileName) {
    Map jsonFileAsMap = null;
    try {
      jsonFileAsMap = mapper.readValue(getFileAsInputStream(fileName), Map.class);
    } catch (IOException e) {
      fail();
    }
    return jsonFileAsMap;
  }

  public static String getJSONFileAsString(String fileName) {
    return new BufferedReader(new InputStreamReader(getFileAsInputStream(fileName)))
        .lines()
        .collect(Collectors.joining("\n"));
  }

  public static InputStream getFileAsInputStream(String fileName) {
    return TestUtil.class.getClassLoader().getResourceAsStream(fileName);
  }
}
