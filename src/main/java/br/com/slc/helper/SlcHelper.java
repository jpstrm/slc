package br.com.slc.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author João Paulo Santarém
 */
public class SlcHelper {

  public static String inputStreamToString(final InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();

    return sb.toString();
  }

}
