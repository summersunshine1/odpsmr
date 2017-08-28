package test.testmr;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.Reducer;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;

import java.awt.print.Printable;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Reducer模板。请用真实逻辑替换模板内容
 */
public class MyReducer implements Reducer {
    private Record result;
    private List<String> stopArr; 

    public void setup(TaskContext context) throws IOException {
//        result = context.createOutputRecord();
//        StringBuilder importdata = new StringBuilder();
//        BufferedInputStream bufferedInput = null;
//        String filePath = "stop_words_ch.txt";
//        try {
//            byte[] buffer = new byte[1024];
//            int bytesRead = 0;
//            bufferedInput = context.readResourceFileAsStream(filePath);
//
//            while ((bytesRead = bufferedInput.read(buffer)) != -1) {
//              String chunk = new String(buffer, 0, bytesRead);
//              importdata.append(chunk);
//            }
//            String lines[] = importdata.toString().split("\n");
//            stopArr = Arrays.asList(lines);
//        }catch (Exception ex) {
//          
//          } finally {
////        	 FileInputStream input=new FileInputStream("src/main/resources/stop_words_ch.txt");
////        	 BufferedInputStream inputStream = new BufferedInputStream(input,2048);
////        	 int bytesRead = 0;
////        	 byte[] buffer = new byte[1024];
////        	 while ((bytesRead = inputStream.read(buffer)) != -1) {
////                 String chunk = new String(buffer, 0, bytesRead);
////                 importdata.append(chunk);
////               }
////               String lines[] = importdata.toString().split("\n");
////               stopArr = Arrays.asLis t(lines);
//              // System.out.println(stopArr.toString());
//        	 
//          }
    }

    public void reduce(Record key, Iterator<Record> values, TaskContext context) throws IOException {
//        String words = null;
//        String risk = null;
//        while (values.hasNext()) {
//            Record val = values.next();
//        	String html = val.getString("html");
//        	risk = val.getString("risk");
//        	
//        	String r = CommonTool.delHTMLTag(html);
//            JiebaSegmenter segmenter = new JiebaSegmenter();
//            List<SegToken> resultList = segmenter.process(r, SegMode.INDEX);  
//            Iterator<SegToken> it = resultList.iterator();  
//            if (!it.hasNext())  
//                return ;  
//           // List<String> stopArr = CommonTool.getStopWords();
//            StringBuilder sb = new StringBuilder();  
//            while (it.hasNext()) {  
//                SegToken s = it.next(); 
//                String word = s.word.trim();
//                if(!(word.length() == 0) && !CommonTool.hasDigit(word)){
//                    sb.append(s.word).append(',');  
//                }  
//            }  
//            words = sb.toString();
//        }
//        if(words!=null)
//        {
//	        result.set(0,key.getString("id"));
//	        result.set(1,words);
//	        result.set(2,risk);
//	        context.write(result);
//        }
    }

    public void cleanup(TaskContext arg0) throws IOException {

    }
}
