package text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 


public class SemanticCrawl {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.oschina.net/code/snippet_2243631_46359").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String title = doc.title();
        Elements metas = doc.head().select("meta"); 
        for (Element meta : metas) { 
            String content = meta.attr("content"); 
            if ("keywords".equalsIgnoreCase(meta.attr("name"))) { 
                System.out.println("关键字："+content); 
            } 
            if ("description".equalsIgnoreCase(meta.attr("name"))) { 
                System.out.println("网站内容描述:"+content); 
            } 
        } 
        
        Elements keywords = doc.getElementsByTag("meta");
        System.out.println("标题"+title);
    }
}