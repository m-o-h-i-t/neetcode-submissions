class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // [1 2 4 5]
        //[1 2 2 3 3]
        // left 1 - 2
        // right 0 - 1

        // 3 5 3 4
        // 3 3 4 5 - 5

        // 1 2 4 5




        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int minBoats = 0;
        while(left < right){

            int valL = people[left];
            int valR = people[right];

            if(valR == limit){
                minBoats++;
                right--;
                continue;
            }

            if(valL == limit){
                minBoats++;
                left++;
                continue;
            }

            int sum = valL + valR;
            if(sum == limit){
                left++;
                right--;
                minBoats++;
            }else if(sum > limit){
                right--;
                minBoats++;
            }else{
                left++;
                right--;
                minBoats++;
            }
            
        }

        System.out.println(left + "----"  +right + "-----" + minBoats);
        if(left == right){
                minBoats++;
            }

        return minBoats;
    }
}