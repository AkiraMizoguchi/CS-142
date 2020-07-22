public static void collapse(Stack<Integer> stack){
        Stack<Integer> Queue=new Stack<>();
        while(!stack.isEmpty()){
            Queue.add(stack.pop());
        }
        if(Queue.size()%2==0) {
            while (!Queue.isEmpty()) {
                int takeNum1=Queue.pop();
                int takeNum2=Queue.pop();
                stack.push(takeNum1+takeNum2);
            }
        }else {
            while(!Queue.isEmpty()){
                if(Queue.size()==1){
                    int lastNum=Queue.pop();
                    stack.push(lastNum);
                }else {
                    int takeNum1=Queue.pop();
                    int takeNum2=Queue.pop();
                    stack.push(takeNum1+takeNum2);
                }
            }

        }
    }
