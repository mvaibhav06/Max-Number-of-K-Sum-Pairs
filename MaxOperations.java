class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> temp = new HashMap<>();
        int out = 0;
        for(int i=0; i<nums.length; i++){
            temp.put(nums[i], temp.getOrDefault(nums[i],0)+1);
        }

        for(int key : temp.keySet()){
            if(temp.get(key) > 0){
                int diff = k - key;
                if(key == diff){
                    if(temp.get(key)>1){
                        int rem = temp.get(key)/2;
                        out += rem;
                        temp.put(key, temp.get(key)-(2*rem));
                    }                    
                }else if(temp.containsKey(diff) && temp.get(diff)>0){
                    int removal = Math.min(temp.get(key), temp.get(diff));
                    out += removal;
                    temp.put(key, temp.get(key)-removal);
                    temp.put(diff, temp.get(diff)-removal);
                }
            }
        }
        return out;
    }
}
