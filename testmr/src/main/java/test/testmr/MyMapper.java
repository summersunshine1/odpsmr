package test.testmr;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.Mapper;
import java.io.IOException;

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
        String w = record.getString("html");
        String r = CommonTool.parseHtml(w);
        String id = record.getString("id");
        String risk = record.getString("risk");
       // String r = CommonTool.delHTMLTag(w);
        key.set(0, id);
        key.set(1, r);
        key.set(2, risk);

        //System.out.println(sb.toString()); 
        context.write(key);
    }

    public void cleanup(TaskContext context) throws IOException {

    }
}