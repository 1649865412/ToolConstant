package text;

//////////验证文件////////////////

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class VerifySignature
{

	public void run1()
	{
		try
		{
			String pubkeyvalue = "30819f300d06092a864886f70d010101050003818d0030818902818100e070a2ec09b9c76e52c09f66b0f4b0b13285ed6e417851ca3a33d13ed1a8c55f886b7025e78848e612b6f828cd5be7ff82e5e858109bb80998ef9a0ad840b65a55f91f5d3569d51d982fc781937e8cc4259f8b86ffe818fd9c99f4a0a1b1ee3e563f5c50fac7b6a7f1e615a65d7beb17eaf20856d82a763ade033c4b54e190430203010001";// 这是GenerateKeyPair输出的公钥编码30819f300d06092a864886f70d01010105
			X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
					hexStrToBytes(pubkeyvalue));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);

			//String info = "orderId=10dkfadsfksdkssdkd&amount=80&orderTime=20060509";
			String info = "2杨荣忠";
			//byte[] signed = hexStrToBytes("6aaac23abeca3d314bb7cb945465afd80651eb0e83718b45a2fa3e6102c879024b304d55276a4831f8127583b73c20a32843aead3375a9a2516ef76cdd628ccb90f40e67ed3abc78e4226d94d99b4e7067e7696c964a133cc9c7d78aecf26d68c0011d792ace21f986de49c3f4d98f9db5ad1d876ab1fa22c294d6d51299571e");// 这是SignatureData输出的数字签名2292e02ba6bf6f1b1688a6fa2
			byte[] signed = hexStrToBytes("8312d61e6cfd816e9a11591327f3cf31c4a14cce902876d27e3fe83767352e017485f37336f20f6f68d6779079f8996dfc7e05d601fb8ee975b0ab994b73241bcd04addbfe2ed75ab29f13ca286ce5da025fcd9ff5983abf55965e6fe45b4624b953571bc3cbca4a4e39826850e4eed71ebb4519fa6b740ca0bb4c13a6c35fb3");// 这是SignatureData输出的数字签名2292e02ba6bf6f1b1688a6fa2
			java.security.Signature signetcheck = java.security.Signature
					.getInstance("MD5withRSA");
			signetcheck.initVerify(pubKey);
			signetcheck.update(info.getBytes());

			if (signetcheck.verify(signed))
			{
				System.out.println("info=" + info);
				System.out.println("签名正常");
			} else
				System.out.println("非签名正常");
		} catch (java.lang.Exception e)
		{
			e.printStackTrace();
		}
	}

	
	private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		VerifySignature n = new VerifySignature();
		n.run1();
	}
}
