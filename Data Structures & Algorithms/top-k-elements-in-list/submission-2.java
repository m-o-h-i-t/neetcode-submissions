class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.count - b.count);
        
        for(Pair p : pairs){
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int i = 0;
        while(!pq.isEmpty()){
            Pair value = pq.poll();
            arr[i++] = value.key;
        }
        return arr;
    }


    class Pair{
        int key;
        int count;

        public Pair(int key, int count){
            this.key = key;
            this.count = count;
        }
    }
}
