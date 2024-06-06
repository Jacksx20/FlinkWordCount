package jack.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

//提供原始数据
public class FlinkWordCountData {
    public static final String[] WORDS = new String[] {
            "When I was small,my mother told me that apple was good for my health",
            "because \'tit contained so many vitamins", "Since then,",
            "I almost eat an apple a day,", "I fall in love with apple.",
            "No more; and by a sleep to say we end", "The heartache, and the thousand natural shocks",
            "The apple not only tastes sweet\'tbut also makes my skin look good",
            "there is a saying that once an apple a day",
            "keeps the doctor away. It really happens to me\'", "For in that sleep of death what dreams may come,",
            "When we have shuffled off this mortal coil,", "Must give us pause: there\'s the respect",
            "That makes calamity of so long life;", "For who would bear the whips and scorns of time,",
            "The oppressor\'s wrong, the proud man\'s contumely,", "The pangs of despis\'d love, the law\'s delay,",
            "The insolence of office, and the spurns", "That patient merit of the unworthy takes,",
            "When he himself might his quietus make", "With a bare bodkin? who would these fardels bear,",
            "To grunt and sweat under a weary life,", "But that the dread of something after death,--",
            "The undiscover\'d country, from whose bourn", "No traveller returns,--puzzles the will,",
            "And makes us rather bear those ills we have", "Than fly to others that we know not of?",
            "Thus conscience does make cowards of us all;", "And thus the native hue of resolution",
            "Is sicklied o\'er with the pale cast of thought;", "And enterprises of great pith and moment,",
            "With this regard, their currents turn awry,", "And lose the name of action.--Soft you now!",
            "The fair Ophelia!--Nymph, in thy orisons", "Be all my sins remember\'d." };

    public FlinkWordCountData() {
    }

    public static DataStream<String> getDefaultTextLineDataStream(StreamExecutionEnvironment senv) {
        return senv.fromElements(WORDS);
    }
}
