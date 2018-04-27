import java.io.*;
import java.net.*;

/**
 * @author Daniel Santos
 */
public final class VSlack {

  private static final String USER_AGENT="Mozilla/5.0";
  final static String webhookURL = "your-webhook-url";//https://hooks.slack.com/services/
  
  public static void sendMessage(String message) {
    String payload = "{\"text\" : \""+message+"\"}";
    String tjson="";
    try {
      URL url=new URL(webhookURL);
      HttpURLConnection conn=(HttpURLConnection)url.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Accept","application/json");
      conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      
      OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
      writer.write(payload);
      writer.close();
      
      if (conn.getResponseCode()!=200) {
        //throw new RuntimeException("Failed : HTTP error code : "+conn.getResponseCode());
      }
      BufferedReader br=new BufferedReader(new InputStreamReader((conn.getInputStream())));
      String output;
      while ((output=br.readLine())!=null) {
        tjson+=output;
      }
      conn.disconnect();
    }
    catch (MalformedURLException e) {
     // e.printStackTrace();
    }
    catch (IOException e) {
     // e.printStackTrace();
    }
    //System.out.println(tjson);
  }
}
