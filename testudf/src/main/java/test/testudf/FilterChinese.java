package test.testudf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aliyun.odps.udf.UDF;

/***
 * BASE UDF
 */
public final class FilterChinese extends UDF {
    /**
     * UDF Evaluate接口
     * 
     * UDF在记录层面上是一对一，字段上是一对一或多对一。 Evaluate方法在每条记录上被调用一次，输入为一个或多个字段，输出为一个字段
     */
    public String evaluate(String s) {
        // TODO: 请按需要修改参数和返回值，并在这里实现你自己的逻辑

    	 if (s == null) { return null; }

         String regex="([\u4e00-\u9fa5]+)";
         Matcher matcher = Pattern.compile(regex).matcher(s);
         StringBuilder result = new StringBuilder();

         while(matcher.find()){
             result.append(matcher.group(0));
         }
         return result.toString();
     }
  }
