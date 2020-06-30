public static int maxLength(ArrayList<String> ArrayListString){
        int longest=0;
        for (int i=0;i<ArrayListString.size();i++){
            if(ArrayListString.get(i).length()>longest){
                longest=ArrayListString.get(i).length();
            }
        }
        return longest;
    }
