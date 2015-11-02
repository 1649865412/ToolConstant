package mail;


public class EmailDemo {
		
		public static void  demo(){
			Mail mail=new Mail();
			mail.setSmtpHost("smtp.exmail.qq.com");/** 设置SMTP **/
			String mailFrom="yrz@sifangstreet.com";
			String password="md20151";
			mail.setFrom(mailFrom);
			mail.setSmtpAuthentication(mailFrom, password);/** 账号及密码 **/
			mail.setTo("1649865412@qq.com");/** 发送给谁 **/
			mail.setContentType(Mail.MODE_HTML);
			mail.setSubject("测试");/** 邮件主题 **/
			mail.setBody("测试！！！！");/** 邮件内容 **/
			mail.send();
		}
		
		
		public static void main(String[] args) {
			demo();
		}
		
		
	}


