class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] num : points){
            double value = Math.sqrt(Math.pow(num[0] - 0, 2) + Math.pow(num[1] - 0, 2));
            pq.add(new Pair(value, num));

            if(pq.size() > k){
                pq.poll();
            }

        }
        int i = 0;
        while(pq.size() > 0){
            Pair pair = pq.poll();
            int[] num = pair.num;
            ans[i++] = num;

        }
        return ans;
    }

    public class Pair implements Comparable<Pair>{
        double distance;
        int[] num;

        public Pair(double distance, int[] num){
            this.distance = distance;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o){
            if(this.distance > o.distance){
                return 1;
            }else if(this.distance < o.distance){
                return -1;
            }else{
                return 0;
            }

        }
    }

}
