package dk.infiniteloop.forloop;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sieker
 */
public class Main {
    
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();
    
    
    static String genString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ ) 
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
    
    static List<String> genList(int len) {
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < len; i++)
            strings.add(genString(10));
        return strings;
    }
    
    static long[] runTest(List<String> strings) {
        
        long[] times = new long[7];
        times[0] = strings.size();
        
        Stopwatch sw = Stopwatch.createStarted();
        for(int i = 0; i < strings.size(); i++) {
            strings.get(i).startsWith("a");
        }
        sw.stop();
        times[1] = sw.elapsed(TimeUnit.MILLISECONDS);
                
        sw.reset().start();
        for(Iterator i = strings.iterator(); i.hasNext();) {
            ((String)i.next()).startsWith("a");
        }
        sw.stop();
        times[2] = sw.elapsed(TimeUnit.MILLISECONDS);
        
        sw.reset().start();
        for(String s: strings) {
            s.startsWith("a");
        }
        sw.stop();
        times[3] = sw.elapsed(TimeUnit.MILLISECONDS);
        
        sw.reset().start();
        strings.forEach(string -> string.startsWith("a"));
        sw.stop();
        times[4] = sw.elapsed(TimeUnit.MILLISECONDS);
        
        sw.reset().start();
        strings.stream().forEach(string -> string.startsWith("a"));
        sw.stop();
        times[5] = sw.elapsed(TimeUnit.MILLISECONDS);
        
        sw.reset().start();
        strings.parallelStream().forEach(string -> string.startsWith("a"));
        sw.stop();
        times[6] = sw.elapsed(TimeUnit.MILLISECONDS);
        
        return times;
    }
    
    static void printTimes(long[] times) {
            System.out.println(
                    + times[1] + "\t"
                    + times[2] + "\t"
                    + times[3] + "\t"
                    + times[4] + "\t"
                    + times[5] + "\t"
                    + times[6] + "\t"
                    + times[0]);
    }
    
    public static void main(String[] args) {
        List<String> strings = genList(10000000);
        System.out.println("For\tIt\tEnh\tForeach\tStream\tPar\tLength");
        runTest(strings.subList(0, 10));
        printTimes(runTest(strings.subList(0, 10)));
        printTimes(runTest(strings.subList(0, 100)));
        printTimes(runTest(strings.subList(0, 1000)));
        printTimes(runTest(strings.subList(0, 10000)));
        printTimes(runTest(strings.subList(0, 100000)));
        printTimes(runTest(strings.subList(0, 1000000)));
        printTimes(runTest(strings.subList(0, 10000000)));
    }
}
