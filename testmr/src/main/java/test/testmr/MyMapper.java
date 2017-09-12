package test.testmr;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.Mapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Mapper模板。请用真实逻辑替换模板内容
 */
public class MyMapper implements Mapper {
    private Record key;
    //private Record value;
    

    public void setup(TaskContext context) throws IOException {
        key = context.createOutputRecord();
//        value = context.createMapOutputValueRecord();
    }
    
    
    public void map(long recordNum, Record record, TaskContext context) throws IOException {
//        String w = record.getString("html");
//        String r = CommonTool.parseHtml(w);
//        String id = record.getString("id");
//        String risk = record.getString("risk");
//        key.set(0, id);
//        key.set(1, r);
//        key.set(2, risk);
//        context.write(key);
    	
//    	String id = record.getString("id");
//        String risk1 = record.getString("risk1");
//        String risk2 = record.getString("risk2");
//        key.set(0,id);
//        if(risk1.equals(risk2))
//        {
//        	key.set(1,risk1);
//        }
//        else if(risk1.equals("normal") && !risk2.equals("normal")){
//            key.set(1,risk2);
//		}
//        else {
//        	key.set(1,risk1);
//        }
//    	Long label = record.getBigint("maplabel");
//    	String id = record.getString("id");
//    	key.set(0, id);
//    	key.set(1,1);
//    	String id= record.getString("id");
//    	Long risk1 = record.getBigint("risk1");
//    	Long risk2 = record.getBigint("risk2");
//    	Long risk3 = record.getBigint("risk3");
//    	Long risk4 = record.getBigint("risk4");
//    	Long risk5 = record.getBigint("risk5");
//    	Long risk6 = record.getBigint("risk6");
//    	Long[] array = {risk1,risk2,risk3,risk4,risk5,risk6};
//    	Map<Long,Integer> hm = new HashMap();
//        for(Long x:array){
//            if(!hm.containsKey(x)){
//                hm.put(x,1);
//            }else{
//                hm.put(x, hm.get(x)+1);
//            }
//        }
//        Map<Long,Integer> map = sortByValue(hm);
//        List<Map.Entry<Long,Integer>> list = new LinkedList<Map.Entry<Long, Integer>>(map.entrySet());
//        Entry<Long, Integer> lastEntry = list.get(list.size()-1);
//        Long risk = lastEntry.getKey();
//        if(risk==1)
//        {
//            key.set(1,"fake_card");
//        }
//        if(risk==2)
//        {
//            key.set(1,"gambling");
//        }
//        if(risk==3)
//        {
//            key.set(1,"sexy");
//        }
//        if(risk==4)
//        {
//            key.set(1,"normal");
//        }
//        key.set(0,id);
//  
//        context.write(key);
    	String id= record.getString("id");
    	String risk1 = record.getString("risk1");
    	String risk2 = record.getString("risk2");
    	String risk3 = record.getString("risk3");
    	String risk4 = record.getString("risk4");
    	String risk5 = record.getString("risk5");
    	String risk6 = record.getString("risk6");
    	String[] array = {risk1,risk2,risk3,risk4,risk5,risk6};
    	Map<String,Integer> hm = new HashMap();
        for(String x:array){
            if(!hm.containsKey(x)){
                hm.put(x,1);
            }else{
                hm.put(x, hm.get(x)+1);
            }
        }
        Map<String,Integer> map = sortByValue(hm);
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Entry<String, Integer> lastEntry = list.get(list.size()-1);
        String risk = lastEntry.getKey();
//        if(risk==1)
//        {
//            key.set(1,"fake_card");
//        }
//        if(risk==2)
//        {
//            key.set(1,"gambling");
//        }
//        if(risk==3)
//        {
//            key.set(1,"sexy");
//        }
//        if(risk==4)
//        {
//            key.set(1,"normal");
//        }
        key.set(0,id);
        key.set(1,risk);
        context.write(key);
 
    }
    public static <K, V extends Comparable<? super V>> Map<K, V> 
    sortByValue(Map<K, V> map) {
    List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
    Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
            return (o1.getValue()).compareTo( o2.getValue() );
        }
    });

    Map<K, V> result = new LinkedHashMap<K, V>();
    for (Map.Entry<K, V> entry : list) {
        result.put(entry.getKey(), entry.getValue());
    }
    return result;
}

    public void cleanup(TaskContext context) throws IOException {

    }
}