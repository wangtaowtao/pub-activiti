package com.eyaoshun.activiti.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils�?
 * 
 * @author
 * @version
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils
{
    
    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";
    
    /**
     * 转换为字节数�?
     * 
     * @param str
     * @return
     */
    public static byte[] getBytes(String str)
    {
        if (str != null)
        {
            try
            {
                return str.getBytes(CHARSET_NAME);
            }
            catch (UnsupportedEncodingException e)
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 转换为字节数�?
     * 
     * @param str
     * @return
     */
    public static String toString(byte[] bytes)
    {
        try
        {
            return new String(bytes, CHARSET_NAME);
        }
        catch (UnsupportedEncodingException e)
        {
            return EMPTY;
        }
    }
    
    /**
     * 是否包含字符�?
     * 
     * @param str 验证字符�?
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs)
    {
        if (str != null)
        {
            for (String s : strs)
            {
                if (str.equals(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html)
    {
        if (isBlank(html))
        {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }
    
    /**
     * 替换为手机识别的HTML，去掉样式及属�?�，保留回车�?
     * 
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html)
    {
        if (html == null)
        {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }
    
    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val)
    {
        if (val == null)
        {
            return 0D;
        }
        try
        {
            return Double.valueOf(trim(val.toString()));
        }
        catch (Exception e)
        {
            return 0D;
        }
    }
    
    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val)
    {
        return toDouble(val).floatValue();
    }
    
    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val)
    {
        return toDouble(val).longValue();
    }
    
    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val)
    {
        return toLong(val).intValue();
    }
    
    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request)
    {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }
        else if (isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }
        else if (isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }
    
    /**
     * 驼峰命名法工�?
     * 
     * @return toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld"
     *         toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (c == SEPARATOR)
            {
                upperCase = true;
            }
            else if (upperCase)
            {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    /**
     * 驼峰命名法工�?
     * 
     * @return toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld"
     *         toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    /**
     * 驼峰命名法工�?
     * 
     * @return toCamelCase("hello_world") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld"
     *         toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            boolean nextUpperCase = true;
            
            if (i < (s.length() - 1))
            {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }
            
            if ((i > 0) && Character.isUpperCase(c))
            {
                if (!upperCase || !nextUpperCase)
                {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            }
            else
            {
                upperCase = false;
            }
            
            sb.append(Character.toLowerCase(c));
        }
        
        return sb.toString();
    }
    
    /**
     * 如果不为空，则设置�??
     * 
     * @param target
     * @param source
     */
    public static void setValueIfNotBlank(String target, String source)
    {
        if (isNotBlank(source))
        {
            target = source;
        }
    }
    
    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     * 
     * @param objectString 对象�? 例如：row.user.id 返回�?!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");
        for (int i = 0; i < vals.length; i++)
        {
            val.append("." + vals[i]);
            result.append("!" + (val.substring(1)) + "?'':");
        }
        result.append(val.substring(1));
        return result.toString();
    }
    
}
