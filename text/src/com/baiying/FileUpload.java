package com.baiying;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class FileUpload {

	public FileUpload(){}
	private void createDir(String uploadPath){
		File file = new File(uploadPath);
		//如果该文件目录不存在，则创建一个新的目录
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	private File createFile(String uploadPath){
		File file = new File(uploadPath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return file;
	}
	/**
	 * 得到一个文件输入流
	 */
	private FileInputStream getStream(String filePath){
		FileInputStream fileInputStream  = null;
		try {
			fileInputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件没有找到！");
		}
		return fileInputStream;
	}
	/**
	 * 得到一个文件输出流
	 */
	private FileOutputStream getOutStream(File file){
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileOutputStream;
	}
	/**
	 * 文件大小
	 */
	public Long getFileSize(String filePath){
		//判断该文件是否是一个有效的文件
		File file = new File(filePath);
		if(file.isFile()){
			return file.length();
		}
		return 0l;
	}

	/**
	 * 无限制文件上传
	 * 包含的属性有：上传目录String uploadPath;文件路径String filePath;上传到服务器的文件名称 String fileName;
	 */
	public boolean upLoad(String uploadPath,String filePath,String fileName){
		boolean isSuccess = true;
		this.createDir(uploadPath);
		String extension = "";
		if(filePath!=null&&!filePath.equals("")){
			if(filePath.lastIndexOf(".")!=-1){
				extension = filePath.substring(filePath.lastIndexOf(".")+1);
			}
		}
		uploadPath = uploadPath + fileName +"."+extension;//上传保存的路径+文件名
		File file = this.createFile(uploadPath);//生成新的文件
		Pattern pattern = Pattern.compile("bmp|gif|gepg|png|");
		Matcher matcher = pattern.matcher(extension);
		if(matcher.find()){
			//图片
			BufferedImage src = null;
            try {
				src = javax.imageio.ImageIO.read(new File(filePath));
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Image image = null;
			BufferedImage oimage = null;
			image=src.getScaledInstance(src.getWidth(),src.getHeight(),Image.SCALE_DEFAULT);
			oimage = new BufferedImage(src.getWidth(),src.getHeight(),Image.SCALE_DEFAULT); 
			 Graphics g = oimage.getGraphics(); 
			 g.drawImage(image,0,0, null);
			 g.dispose();
			
			 ByteArrayOutputStream bos = new ByteArrayOutputStream();   
	         try {
				ImageIO.write(oimage,extension,bos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 输出到bos   
			
	         FileOutputStream out = null;
			try {
				out = new FileOutputStream(file);
				out.write(bos.toByteArray());  //写文件   
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 if(out!=null){
						 out.close();
					 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}else{
			//非图片
			FileInputStream fis = this.getStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = this.getOutStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			try {
				while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
					bos.write(buffer, 0, bytesRead);// 将文件写入服务器
				}
				isSuccess = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				isSuccess = false;
				//e.printStackTrace();
			}finally{
				try {
					if(fos!=null){
					    fos.close();
					}
					if(fis!=null){
						fis.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		return isSuccess;
	}
	
	
	/**
	 * 限制文件大小的上传---如果超过一定的大小则压缩或者限制上传
	 * 包含的属性有：上传目录String uploadPath;文件路径String filePath;上传到服务器的文件名称 String fileName;
	 *              文件限制大小:int commitSize,大小以k表示
	 *              boolean flag:true为压缩大小;false为限制上传
	 */
	public boolean upLoad(String uploadPath,String filePath,String fileName,int commitSize,boolean flag){
		//首先要得到上传的文件后缀名，如果不是图片格式的，则将flag属性修改为false，直接限制其上传，如果是图片格式，则对图片进行压缩
		String extension = "";
		if(filePath!=null&&!filePath.equals("")){
			if(filePath.lastIndexOf(".")!=-1){
				extension = filePath.substring(filePath.lastIndexOf(".")+1);
			}
		}
		if(flag){
			Pattern pattern = Pattern.compile("bmp|gif|gepg|png|");
			Matcher matcher = pattern.matcher(extension);
			if(matcher.find()){
				flag = true;
			}else{
				flag = false;
			}
		}
		
		if(flag){
			//压缩大小，主要针对于图片
			this.upLoad(uploadPath, filePath, fileName);//将图片保存到服务器
			//取得服务器的文件，放入一个新的File对象当中
			String filePath_new = uploadPath+fileName + "."+extension;
			File f = new File(filePath_new);
			FileOutputStream out = null;
			while(f.length()>commitSize*1000l){
				
			   try {
				Image img = ImageIO.read(f);
                BufferedImage tag = new BufferedImage(img.getWidth(null)*9/10,img.getHeight(null)*9/10, BufferedImage.TYPE_INT_RGB); 
                 tag.getGraphics().drawImage(img.getScaledInstance(img.getWidth(null)*9/10,img.getHeight(null)*9/10, Image.SCALE_SMOOTH), 0, 0, null);
                 out = new FileOutputStream(filePath_new);
                 // JPEGImageEncoder可适用于其他图片类型的转换 
                 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
                 encoder.encode(tag); 
                 out.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(out!=null){
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			f = new File(filePath_new);	
			}
		}else{
			//限制上传
			long fileSize = this.getFileSize(filePath);
			if(fileSize>commitSize*1000l){
				return false;
			}else{
				return upLoad(uploadPath, filePath, fileName);
			}
		}
		
		return true;
	}
	
	/**
	 * 加水印的图片上传
	 */
	
	
	/**
	 * 图片的上传
	 */
	
	/**
	 * 加水印图片
	 * 包含的属性有：String pressImg,水印图片;String targetImg,目标图片
	 */
	 public  void pressImage(String pressImg, String targetImg,    
	            int x, int y) {    
	        try {    
	            File file = new File(targetImg);  
	            Image src = ImageIO.read(file);    
	            int wideth = src.getWidth(null);    
	            int height = src.getHeight(null);    
	            BufferedImage image = new BufferedImage(wideth, height,    
	                    BufferedImage.TYPE_INT_RGB);    
	            Graphics g = image.createGraphics();    
	            g.drawImage(src, 0, 0, wideth, height, null);    
	   
	            // 水印文件    
	            File _filebiao = new File(pressImg);    
	            Image src_biao = ImageIO.read(_filebiao);    
	            int wideth_biao = src_biao.getWidth(null);    
	            int height_biao = src_biao.getHeight(null);    
	            g.drawImage(src_biao, wideth - wideth_biao - x, height    
	                    - height_biao - y, wideth_biao, height_biao, null);    
	            // /    
	            g.dispose();    
	            FileOutputStream out = new FileOutputStream(targetImg);    
	            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);    
	            encoder.encode(image);    
	            out.close();    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	        }    
	    }    
	  
	 
	 
	/**
	 *删除文件  对应属性 String filePath
	 */
	public  boolean deleteWebFile(String filePath){
	        File file = new File(filePath);    
	        if(file.isFile() && file.exists()){    
	            file.delete();    
	            return true;    
	        }else{    
	            return false;    
	        } 
		}
	
	
	
	public static void main(String [] args){
		FileUpload f = new FileUpload();
		//System.out.println(f.getFileSize("C:\\WINDOWS\\Web\\Wallpaper\\chibi.jpg"));
		//System.out.println(f.getFileSize("C:\\WINS\\Web\\Wallpaper\\chijpg"));
		//f.upLoad("e:/sstext/", "C:\\WINDOWS\\Web\\Wallpaper\\1920CHINA_2011.jpg", "aaaa");
		
		f.upLoad("E:/sstext/","d:\\a.jpg","texst",2,true);
	}
	
}


