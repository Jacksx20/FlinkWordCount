package jack.flink;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkWordCount {
    public FlinkWordCount() {
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();
        senv.setRuntimeMode(RuntimeExecutionMode.BATCH);
        Object text;
        text = FlinkWordCountData.getDefaultTextLineDataStream(senv);
        DataStream<Tuple2<String, Integer>> counts = ((DataStream<String>) text).flatMap(new FlinkWordCountTokenizer())
                .keyBy(0)
                .sum(1);
        counts.print();
        senv.execute();
    }
}