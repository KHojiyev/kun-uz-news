package module3.lesson8_CONNECTIONS_URL_HTTP.Task1_News_Line;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsInSite2 {
    public static void main(String[] args) {
        List<String> news = new ArrayList<String>();
        try {
            URL url = new URL("https://kun.uz/");
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(inputLine.contains("news-lenta")){
                    news.add(inputLine);
                }
            }
            in.close();
            for (String s : news) {
                if(s.contains("title")){
                    s=s.trim();
                    int beginTitle = s.indexOf("title")+7;
                    int finishTitle = s.length()-7;
                    System.out.println("   Description:"+s.substring(beginTitle,finishTitle));}
                else if(s.contains("href")) {
                    s=s.trim();
                    int beginTitle = s.indexOf("href")+11;
                    int finishTitle = s.length()-5;
                    System.out.println("News:"+s.substring(beginTitle,finishTitle));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
