//Question No: 2836
//Title: 수상 택시
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long totalLength = Long.parseLong(st.nextToken());
        long fixedLength = Long.parseLong(st.nextToken());
        
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < totalLength; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if (start > end) {
                segments.add(new Segment(end, start));
            }
        }
        
        Collections.sort(segments);
        
        long lastEnd = segments.get(0).end;
        long combinedLength = segments.get(0).end - segments.get(0).start;
        for (int i = 1; i < segments.size(); i++) {
            Segment seg = segments.get(i);
            if (lastEnd >= seg.start) {
                if (lastEnd < seg.end) {
                    combinedLength += seg.end - lastEnd;
                    lastEnd = seg.end;
                }
            } else {
                combinedLength += seg.end - seg.start;
                lastEnd = seg.end;
            }
        }
        
        System.out.println(fixedLength + combinedLength * 2);
    }
    
    static class Segment implements Comparable<Segment> {
        long start;
        long end;
        
        Segment(long start, long end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Segment other) {
            return Long.compare(this.start, other.start);
        }
    }
}