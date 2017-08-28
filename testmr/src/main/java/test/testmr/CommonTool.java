package test.testmr;
import java.awt.print.Printable;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements; 

public class CommonTool{ 
    public static String delHTMLTag(String htmlStr){ 
         String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
         String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
         String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         String regEx_url = "[http]{4}\\:\\/\\/([a-zA-Z]|[0-9])*(\\.([a-zA-Z]|[0-9])*)*(\\/([a-zA-Z]|[0-9])*)*\\s?";
         String regEx="[\\s*`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
         
         Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
         Matcher m_script=p_script.matcher(htmlStr); 
         htmlStr=m_script.replaceAll(""); //过滤script标签 
         
         Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
         Matcher m_style=p_style.matcher(htmlStr); 
         htmlStr=m_style.replaceAll(""); //过滤style标签 
         
         Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
         Matcher m_html=p_html.matcher(htmlStr); 
         htmlStr=m_html.replaceAll(""); //过滤html标签 
         
         Pattern p_sign=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE); 
         Matcher m_sign=p_sign.matcher(htmlStr); 
         htmlStr=m_sign.replaceAll(""); //过滤特殊字符
         
         Pattern p_url=Pattern.compile(regEx_url,Pattern.CASE_INSENSITIVE); 
         Matcher m_url=p_url.matcher(htmlStr); 
         htmlStr=m_url.replaceAll(""); //过滤特殊字符
//         htmlStr = htmlStr.replaceAll(" ", ",");
       //  htmlStr = htmlStr.replaceAll("\\s+", "");  
        return htmlStr.trim(); //返回文本字符串 
     }
    public   static   String StringFilter(String   str)   throws   PatternSyntaxException   {     
		  //String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
		  String regEx = "[^(\\u4e00-\\u9fa5)]";
		  Pattern p = Pattern.compile(regEx);     
		  Matcher   m   =   p.matcher(str);     
		  return   m.replaceAll(" ").trim();     
    }     
    public static String parseHtml(String html)
    {
    	//String res = "";
    	Document document = Jsoup.parse(html);
    	String text = document.text();
    	String tString = StringFilter(text);
    	return tString;
//    	System.out.println(tString);
//    	String title = document.title();
//    	res += title+'\n';
//    	Elements h1 = document.getElementsByTag("h1");
//    	for(Element i:h1)
//    	{
//    		res += i.text()+'\n';
//    	}
//    	Elements elements = document.select("meta[name=keywords]");
//    	for(Element i:elements)
//    	{
//    	 String keywords = i.attr("content");
//    	 if(keywords == null || keywords.trim().length() == 0)
//    		 continue;
//    	 res += keywords+'\n';
//    	}
//    	return res;
    }
    
//    public static List<String> getStopWords() throws IOException {
//  
//    	String filePath = "src/main/resources/stop_words_ch.txt";
//    	FileInputStream inputStream = new FileInputStream(filePath); 
//    	InputStreamReader reader = new InputStreamReader(inputStream, "gbk"); 
//    	BufferedReader in = new BufferedReader(reader);
//    	String str;
//
//    	List<String> list = new ArrayList<String>();
//    	while((str = in.readLine()) != null){
//    	    list.add(str);
//    	}
//
//    	//String[] stringArr = list.toArray(new String[0]);
//    	return list;
//    }
    public static boolean isDigit(String strNum) {  
        return strNum.matches("[0-9]{1,}");  
    } 
   
    public static boolean hasDigit(String content) {
    	boolean flag = false;
    	Pattern p = Pattern.compile(".*\\d+.*");
    	Matcher m = p.matcher(content);
    	if (m.matches())
    		flag = true;
    	return flag;
   }
} 