public static int numUnique(int[] list) {
        int uniqueNum=0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i : list) {
            set.add(i);
        }
        for (int i:set){
            uniqueNum++;
        }
        return  uniqueNum;
    }
