/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getinfo;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author profe
 */
public class Getinfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.wikipedia.org/").get();

//        String keywords = doc.select("meta[name=keywords]").first().attr("content");
//        System.out.println("Meta keyword : " + keywords);
//        String description = doc.select("meta[name=description]").get(0).attr("content");
//        System.out.println("Meta description : " + description);
//        
        String html = doc.select("html").get(0).html();
        System.out.println("conteudo : " + html);

    }
}
