 public static int maxLength(Set<String> set){
        int max=0;
        for (String str: set){
            if(str.length()>max){
                max=str.length();
            }
        }

        return max;
    }
