    public static boolean isConsecutive(Stack<Integer> stack){
        Queue<Integer> s=new LinkedList<>();
        if(stack.size()==0||stack.size()==1){
            return true;
        }
        int lastNum=stack.pop();
        while(!stack.isEmpty()){
            if(lastNum-1!=stack.peek()){
                while(!s.isEmpty()){
                    stack.push(s.poll());
                }
                return false;
            }
            lastNum=stack.pop();
            s.add(lastNum);
        }
        while(!s.isEmpty()){
            stack.push(s.poll());
        }
        return true;
    }
