package jack.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

//切分句子
public class FlinkWordCountTokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {
    public FlinkWordCountTokenizer() {
    }

    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
        String[] tokens = value.toLowerCase().split("\\W+");
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String tmp = tokens[i];
            if (tmp.length() > 0) {
                out.collect(new Tuple2<String, Integer>(tmp, Integer.valueOf(1)));
            }
        }
    }
}