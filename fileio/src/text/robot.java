package text;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * <code>robot.java</code>
 * <p>
 * <p>
 * Copyright 2015 All right reserved.
 * @author 杨荣忠 时间 2015-3-3 下午05:13:25
 * @version 1.0 </br>最后修改人 无
 */
public class robot
{
	public static void main(String[] args) throws MalformedURLException,
			IOException, URISyntaxException, AWTException
	{
		
		// 此方法仅适用于JdK1.6及以上版本
		Desktop.getDesktop().browse(
				new URL("http:/jd.com").toURI());
		Robot robot = new Robot();
		robot.delay(1000);
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int width = (int) d.getWidth();
		int height = (int) d.getHeight();
		
		
		//滚动鼠标滚轴      
        for(int i=0;i<20;i++)
        {    
        	 System.out.println("滚动"+i);
        	 robot.mouseWheel(i);
        	 robot.delay(100);
        }
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
        
        robot.delay(3000);
      
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
           
        
	/*	Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
				height));
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		// 保存图片
		ImageIO.write(bi, "jpg", new File("google.jpg"));*/
	}
	
	
}

