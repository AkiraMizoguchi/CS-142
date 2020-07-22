public boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> soreStack=new Stack<>();
        if(s1.size()!=s2.size()){
            return false;
        }
        while(!s1.isEmpty()){
            int s1Num=s1.pop();
            int s2Num=s2.pop();
            if(s1Num!=s2Num){
                s2.push(s2Num);
                s1.push(s1Num);
                while(!soreStack.isEmpty()){
                    int num=soreStack.pop();
                    s1.push(num);
                    s2.push(num);
                }
                return false;
            }
            soreStack.add(s1Num);

        }
        while(!soreStack.isEmpty()){
            int num=soreStack.pop();
            s1.push(num);
            s2.push(num);
        }
        return true;

    }
