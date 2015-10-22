import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.util.JSONUtils;

import com.mysql.jdbc.ResultSet;


public class JsonText
{
	
	/**功能:
	 * <p>作者 杨荣忠 2015-10-22 下午01:41:36
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	


    public static final JSONArray ResultSetToJsonArray(ResultSet rs) {
        JSONObject element = null;
        JSONArray ja = new JSONArray();
        ResultSetMetaData rsmd = null;
        String columnName, columnValue = null;
        try {
            rsmd = rs.getMetaData();
            while (rs.next()) {
                element = new JSONObject();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnName = rsmd.getColumnName(i + 1);
                    columnValue = rs.getString(columnName);
                    element.put(columnName, columnValue);
                }
                ja.add(element);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }
    
    
/*	
	*//**
	 * 功能:hibernate原生态查询纯SQL,返回获取beanList;
	 * <p>作者 杨荣忠 2015-7-15 下午04:38:56
	 * @param <T>
	 * @param sql
	 * @param clazz
	 * @return
	 *//*
	public final  <T> List<T>  getObjectList(String sql,T clazz){
		List<T> objs = null;
		SQLQuery sqlQuery=this.getSession().createSQLQuery(sql);
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List resultList = sqlQuery.list();
		objs = SqlHelp.getJavaCollection(clazz,resultList);
		return objs;
	}*/
	
	/**
	 * * 封装将jsonArray对象转换为java集合对象 * *
	 * 
	 * @param <T> *
	 * @param clazz *
	 * @param jsons *
	 * @return
	 */
	@SuppressWarnings("all")
	private static <T> List<T> getJavaCollection(T clazz, JSONArray jsonArray) {
		List<T> objs = null;
		//JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsons);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
		if (jsonArray != null) {
			objs = new ArrayList<T>();
			List list = (List) JSONSerializer.toJava(jsonArray);
			for (Object o : list) {
				JSONObject jsonObject = JSONObject.fromObject(o);
				T obj = (T) JSONObject.toBean(jsonObject, clazz.getClass());
				objs.add(obj);
			}
		}
		return objs;
	}
	
}
