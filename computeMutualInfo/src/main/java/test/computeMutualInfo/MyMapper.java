package test.computeMutualInfo;

import com.aliyun.odps.data.Record;
import com.aliyun.odps.mapred.Mapper;

import java.io.IOException;

import org.omg.CORBA.portable.ValueBase;

/**
 * Mapper模板。请用真实逻辑替换模板内容
 */
public class MyMapper implements Mapper {
    private Record res;

    public void setup(TaskContext context) throws IOException {
        res = context.createOutputRecord();
    }

    public void map(long recordNum, Record record, TaskContext context) throws IOException {
    	Long riskwordcount = record.getBigint("riskwordcount");
    	Long riskcount = record.getBigint("riskcount");
    	Long riskwordtotalcount = record.getBigint("riskwordtotalcount");
    	Long wordcount = record.getBigint("wordcount");
    	int totalcount =82160123;//87171127;
    	int word_totalcount =14287; //36678;//record.getBigint("wordtotalcount");
    	
    	double wc = (double) ((1+riskwordcount)*1.0/(riskwordtotalcount+riskcount));
    	double w = (double) ((1+wordcount)*1.0/(totalcount+word_totalcount));
    	double minfo = Math.log((double)wc/(double)w);
    	double tf = (riskwordcount+1)*1.0/(wordcount+riskwordtotalcount);
    	
    	res.set(0,record.getString("risk"));
    	res.set(1,record.getString("word"));
    	res.set(2,minfo);
    	res.set(3,riskwordcount);
        context.write(res);
    }

    public void cleanup(TaskContext context) throws IOException {

    }
}