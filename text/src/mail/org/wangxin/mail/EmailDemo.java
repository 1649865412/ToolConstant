package mail.org.wangxin.mail;


public class EmailDemo {
 
	
	
	
	public static void  demo(){
		Mail mail=new Mail();
		mail.setSmtpHost("smtp.163.com");/** ����SMTP **/
		String mailFrom="wangxin_admin@163.com";
		String password="XXXXXX";
		mail.setFrom(mailFrom);
		mail.setSmtpAuthentication(mailFrom, password);/** �˺ż����� **/
		mail.setTo("wangxin@broadtext.com.cn");/** ���͸�˭ **/
		mail.setContentType(Mail.MODE_HTML);
		mail.setSubject("����");/** �ʼ����� **/
		mail.setBody("���ԣ�������");/** �ʼ����� **/
		mail.send();
	}
	
	public static void main(String[] args) {
		demo();
	}
}
