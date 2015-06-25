/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 
public class Test14 {
 
    public static int DEFAULT_IMAGE_WIDTH = 1024;
    public static int DEFAULT_IMAGE_HEIGHT = 1348;
    public static int DEFAULT_MAX_LENGTH = 900;
 
    *//**
     * html转换为图片格式jpg文件
     * @param bgColor 图片的背景色
     * @param html html的文本信息
     * @param width 显示图片的text容器的宽度
     * @param height 显示图片的text容器的高度
     * @param eb 設置容器的边框
     * @return
     * @throws Exception
     *//*
    public static ArrayList<String> htmlToImg(Color bgColor, String html, int width, int height,String outFileImagePath) throws Exception {
        ArrayList<String> ret = new ArrayList<String>();
        try {
            JTextPane jTextPane = new JTextPane();
            jTextPane.setSize(width, height);
            EmptyBorder eb = new EmptyBorder(0, 0, 0, 0);
            if (bgColor != null) {
                jTextPane.setBackground(bgColor);
            }
            jTextPane.setBorder(eb);
            jTextPane.setContentType("text/html");
            jTextPane.setText(html);
            PrintView m_printView = new PrintView(jTextPane);
            int pageIndex = 1;
            boolean bcontinue = true;
            while (bcontinue) {
                BufferedImage image = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
                Graphics g = image.getGraphics();
                g.setClip(0, 0, width, height);
                bcontinue = m_printView.paintPage(g, height, pageIndex);
                g.dispose();
                String path = saveToImg(image,outFileImagePath);
                ret.add(path);
                pageIndex++;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return ret;
    }
 
    *//**
     * 将BufferedImage转换为图片的信息
     * @param image
     * @return
     *//*
    private static String saveToImg(BufferedImage image ,String outFileImagePath) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
            param.setQuality(1.0f, false);
            encoder.setJPEGEncodeParam(param);
            encoder.encode(image);
            byte[] buff = baos.toByteArray();
            baos.close();
            FileUtils.writeByteArrayToFile(new File(outFileImagePath), buff);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outFileImagePath;
    }
 
    *//**
     * 替换模板中的key值
     * @param html
     * @param map
     * @return
     *//*
    private static String replaceHtml(String html,Map<String, String> map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getValue() != null){
                html = html.replace("${" + entry.getKey() + "}", entry.getValue());
            }else{
                html = html.replace("${" + entry.getKey() + "}", " ");
            }
        }
        return html;
    }
     
    *//**
     * Img标签的过滤，过滤以"<img"开头以"/img>"结尾的标签
     * @param content
     * @return String
     *//*
    private static String filterImgTag(String content) {
        Pattern pattern = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
 
    *//**
     * 读取本地文件
     * @param filepath
     * @param encoding
     * @return
     *//*
    private static String readFile(String filepath,String encoding){
        File file = new File(filepath);
        String content = "";
        try {
            if(file.isFile() && file.exists()){ //判断文件是否存在
 
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    content += lineTxt;
                }
                read.close();
            }else{
                System.out.println("[INFO]找不到指定的文件!");
            }
        } catch (Exception e) {
            System.out.println("[INFO]读取文件内容出错!");
            e.printStackTrace();
        }
        return content;
    }
 
    public static void main(String[] args) {
        try {
            JdbcDao jdbcDao = new JdbcDaoImpl();
            List<Object> para = new ArrayList<Object>();
            para.add(29);
            Map<String, String> map = jdbcDao.queryBySingle("select * from wcmdocument where id=?", para );
            String dochtmlcon = filterImgTag(map.get("dochtmlcon"));
            if(dochtmlcon != null && dochtmlcon.length() >= DEFAULT_MAX_LENGTH){
                dochtmlcon = dochtmlcon.substring(0, DEFAULT_MAX_LENGTH);
                map.put("dochtmlcon", dochtmlcon);
            }else{
                map.put("dochtmlcon", dochtmlcon);
            }
 
            String html = readFile("D:/templet.html", "utf-8");
            html = replaceHtml(html, map);
            InputStream in = new ByteArrayInputStream(html.getBytes("utf-8"));
            MyTools.inputStreamToFile(in, "D:/test.html");
            String outFileImagePath = "D:/Test.jpg";
            Test14.htmlToImg(null, html, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT, outFileImagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/