
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

/**
 *  url参数拦截，防止注入html和js代码
 *  <code>UrlFilter.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-12 上午11:24:26	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class UrlFilter implements Filter {
 
    public void destroy() {
 
    }
 
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
 
        HttpServletResponse response = (HttpServletResponse) resp;
 
        Map<String, String[]> parameterMap = request.getParameterMap();
 
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String[] value = entry.getValue();
            if (value != null) {
                int strLength = value.length;
                for (int i = 0; i < strLength; i++) {
                    boolean result = stripXSS(value[i]);
                    if (result)
                        response.sendRedirect("error.jsp");
                }
            }
        }
        chain.doFilter(req, resp);
 
    }
 
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    /**
     * 如果找到非法字符则返回true,如果没找到则返回false
     * 
     * @param value
     * @return
     */
    public static boolean stripXSS(String value) {
        boolean result = false;
        if (value != null) {
 
            // Avoid null characters
            value = value.replaceAll("", "");
 
            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            // //如果找到则为true
            if (result)
                return result;
 
            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("vbscript:",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            // Avoid alert:... expressions
            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
        }
        return result;
    }
 
}