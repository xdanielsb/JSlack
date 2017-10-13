import java.io.*;
import java.net.*;


/*
 *https://api.slack.com/incoming-webhooks
 */
public class SlackTest {
  public static void main(String args[]) {
    String message = "Love you daniel.";
    VSlack.sendMessage(message);
  }
}
