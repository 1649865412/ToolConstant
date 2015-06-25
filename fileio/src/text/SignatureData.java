package text;

//////////签名文件////////////////
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.*;

public class SignatureData
{
	public void run()
	{
		try
		{
			String prikeyvalue = "30820277020100300d06092a864886f70d0101010500048202613082025d02010002818100e070a2ec09b9c76e52c09f66b0f4b0b13285ed6e417851ca3a33d13ed1a8c55f886b7025e78848e612b6f828cd5be7ff82e5e858109bb80998ef9a0ad840b65a55f91f5d3569d51d982fc781937e8cc4259f8b86ffe818fd9c99f4a0a1b1ee3e563f5c50fac7b6a7f1e615a65d7beb17eaf20856d82a763ade033c4b54e190430203010001028180040ee5534145c3ae61feaba32eb5edeff64ae7a523b7ea3aaedcbafed8c9a56ff9c67f8b9fe91df0530c4de666f82f74b64833f04bb4951a4f529dc56e6d951e7a5e34d193fdb0c3867b680bee5196db2a7092d73506b4ced67c2f35756c02d1e388e1de5dd5f9ade793334a061c2b1bc11067cc7239da6954dcaa354c13c911024100f2ad9cd4f5ad4a08c62b05643db8e1c58056a83d85805c44d31fc18b3ef92813b2af63d06fd140b99444e57974d1109fb35ef6f884ffbce1d555bb8f311e624b024100ecc2b85f0713dfb84e0965944a6d0e6c53ae25a82133b579a45092372aaae54c0c2c1373dc55677b98ccdb39c8de70329df0a3df135f4c6d483144af8c4e0ee9024100a340256ba1659493387442693f983ad0f8d7d2cfa81a4477cc2ae5b13d88b0ec275d1361698733ea6392c168262c69e974e9e26c26543f8510555f1a21a9d5e702410081a3996ac72855aec86412cfe0f4d819eeb403808d35901fdc1e1601c9062c69b89c85c642162d849ac54920d9e11a944cb11039bc94c8f769b9387fdb167ec902402b214a36505ca371f9ce2f58f8a442c661d5374393888799887cc7034c9b06b740d845e5e0015f0a7961c484e9feeb4a46664a3ccd887673242816fa63bc4a68";// 这是GenerateKeyPair输出的私钥编码30820277020100300d"
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					hexStrToBytes(prikeyvalue)); // PKCS8EncodedKeySpec
			System.out.print(priPKCS8.getFormat());
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey myprikey = keyf.generatePrivate(priPKCS8);

			String myinfo = "orderId=10dkfadsfksdkssdkd&amount=80&orderTime=20060509"; // 要签名的信息
			String name ="杨荣忠";
			
			// 用私钥对信息生成数字签名
			java.security.Signature signet = java.security.Signature
					.getInstance("MD5withRSA");
			signet.initSign(myprikey);
			signet.update(myinfo.getBytes("ISO-8859-1"));
			byte[] signed = signet.sign(); // 对信息的数字签名

			System.out.println("signed(签名内容)原值=" + bytesToHexStr(signed));
			System.out.println("info（原值）=" + myinfo);

			System.out.println("签名并生成文件成功");
		} catch (java.lang.Exception e)
		{
			e.printStackTrace();
			System.out.println("签名并生成文件失败");
		};
	}
	
	private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * Transform the specified byte into a Hex String form.
	 */
	public static final String bytesToHexStr(byte[] bcd)
	{
		StringBuffer s = new StringBuffer(bcd.length * 2);
		for (int i = 0; i < bcd.length; i++)
		{
			s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
			s.append(bcdLookup[bcd[i] & 0x0f]);
		}
		return s.toString();
	}

	/**
	 * Transform the specified Hex String into a byte array.
	 */
	public static final byte[] hexStrToBytes(String s)
	{
		byte[] bytes;
		bytes = new byte[s.length() / 2];
		for (int i = 0; i < bytes.length; i++)
		{
			bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
					16);
		}
		return bytes;
	}

	public static void main(String[] args)
	{
		SignatureData s = new SignatureData();
		s.run();
	}
}