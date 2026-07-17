/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<Pair> pairs = new ArrayList<>();
        for(Interval i : intervals){
            Pair pair = new Pair(i.start, i.end);
            pairs.add(pair);
        }

        Collections.sort(pairs);
        
        for(int i = 1; i < pairs.size(); i++){
            if(pairs.get(i-1).end > pairs.get(i).start){
                return false;
            }
        }
        return true;
    }

    public class Pair implements Comparable<Pair>{
        int start;
        int end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Pair o){
            return this.start - o.start;
        }
    }
}
