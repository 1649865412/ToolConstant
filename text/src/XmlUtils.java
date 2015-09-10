import java.util.*;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *  map转xml,xml转map
 *  <code>XmlUtils.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-8-17 下午06:07:15	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class XmlUtils
{
	
	/**
	 * 根据Map组装xml消息体，值对象仅支持基本数据类型、String、BigInteger、BigDecimal，
	 * 以及包含元素为上述支持数据类型的Map
	 * 
	 * @param vo
	 * @param rootElement
	 * @return
	 * @author 蔡政滦 modify by 2015-6-5
	 */
	public static String map2xmlBody(Map<String, Object> vo, String rootElement)
	{
		org.dom4j.Document doc = DocumentHelper.createDocument();
		Element body = DocumentHelper.createElement(rootElement);
		doc.add(body);
		__buildMap2xmlBody(body, vo);
		System.out.println("xml:" + doc.asXML());
		return doc.asXML();
	}
	
	
	/**
	 * 功能: map转xml方法
	 * <p>作者 杨荣忠 2015-7-24 下午02:36:43
	 * @param body
	 * @param vo
	 */
	private static void __buildMap2xmlBody(Element body, Map<String, Object> vo)
	{
		if (vo != null)
		{
			Iterator<String> it = vo.keySet().iterator();
			while (it.hasNext())
			{
				String key = (String) it.next();
				if (!key.trim().equals(""))
				{
					Object obj = vo.get(key);
					Element element = DocumentHelper.createElement(key);
					if (obj != null)
					{
						if (obj instanceof java.lang.String)
						{
							element.setText((String) obj);
						}
						else
						{
							if (obj instanceof java.lang.Character || obj instanceof java.lang.Boolean
									|| obj instanceof java.lang.Number || obj instanceof java.math.BigInteger
									|| obj instanceof java.math.BigDecimal)
							{
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", obj
										.getClass().getCanonicalName());
								element.add(attr);
								element.setText(String.valueOf(obj));
							}
							else if (obj instanceof java.util.Map)
							{
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type",
										java.util.Map.class.getCanonicalName());
								element.add(attr);
								__buildMap2xmlBody(element, (Map<String, Object>) obj);
							}
							else
							{
							}
						}
					}
					body.add(element);
				}
			}
		}
	}
	
	/**
	 * 根据xml消息体转化为Map
	 * 
	 * @param xml
	 * @param rootElement
	 * @return
	 * @throws DocumentException
	 * @author 蔡政滦 modify by 2015-6-5
	 */
	public static Map xmlBody2map(String xml, String rootElement) throws DocumentException
	{
		org.dom4j.Document doc = DocumentHelper.parseText(xml);
		Element body = (Element) doc.selectSingleNode("/" + rootElement);
		Map vo = __buildXmlBody2map(body);
		return vo;
	}
	
	
	
	private static Map __buildXmlBody2map(Element body)
	{
		Map vo = new HashMap();
		if (body != null)
		{
			List<Element> elements = body.elements();
			for (Element element : elements)
			{
				String key = element.getName();
				if (!key.trim().equals(""))
				{
					String type = element.attributeValue("type", "java.lang.String");
					String text = element.getText().trim();
					Object value = null;
					if (java.lang.String.class.getCanonicalName().equals(type))
					{
						value = text;
					}
					else if (java.lang.Character.class.getCanonicalName().equals(type))
					{
						value = new java.lang.Character(text.charAt(0));
					}
					else if (java.lang.Boolean.class.getCanonicalName().equals(type))
					{
						value = new java.lang.Boolean(text);
					}
					else if (java.lang.Short.class.getCanonicalName().equals(type))
					{
						value = java.lang.Short.parseShort(text);
					}
					else if (java.lang.Integer.class.getCanonicalName().equals(type))
					{
						value = java.lang.Integer.parseInt(text);
					}
					else if (java.lang.Long.class.getCanonicalName().equals(type))
					{
						value = java.lang.Long.parseLong(text);
					}
					else if (java.lang.Float.class.getCanonicalName().equals(type))
					{
						value = java.lang.Float.parseFloat(text);
					}
					else if (java.lang.Double.class.getCanonicalName().equals(type))
					{
						value = java.lang.Double.parseDouble(text);
					}
					else if (java.math.BigInteger.class.getCanonicalName().equals(type))
					{
						value = new java.math.BigInteger(text);
					}
					else if (java.math.BigDecimal.class.getCanonicalName().equals(type))
					{
						value = new java.math.BigDecimal(text);
					}
					else if (java.util.Map.class.getCanonicalName().equals(type))
					{
						value = __buildXmlBody2map(element);
					}
					else
					{
					}
					vo.put(key, value);
				}
			}
		}
		return vo;
	}
	
	public static void main(String[] args)
	{
		Map<String, Object> vo = new HashMap();
		vo.put("name", "yang");
		vo.put("age", 25);
		/*
		 * <?xml version="1.0" encoding="UTF-8"?> <type><age
		 * type="java.lang.Integer">25</age><name>yang</name></type>
		 */
		map2xmlBody(vo, "type");
		
		String xml = "<type><age type='java.lang.Integer'>25</age><name>yang</name></type>";
		try
		{
			Map<String, Object> valueMap = xmlBody2map(xml, "type");
			System.out.println("通过Map.entrySet遍历key和value");
			for (Map.Entry<String,Object> entry : valueMap.entrySet())
			{
				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			}
		}
		catch (DocumentException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}