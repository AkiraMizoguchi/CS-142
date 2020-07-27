import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.util.*;

public class First {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(2);
        stack.push(-4);
        stack.push(3);
        stack.push(1);
        Queue<Integer> Queue=new LinkedList<>();
        Queue.add(1);
        Queue.add(3);
        Queue.add(2);
        Queue.add(5);



//        System.out.println(Queue.poll());
//        System.out.println(stack.pop());
//
//        splitStack(stack);
////        stutter(stack);
//
//        System.out.println(stack);
//        System.out.println();
//
//        int[] nums = {1,1,2,3,3,4,6,4};
//        System.out.println(removeDuplicates(nums));
        System.out.println(stack);

        collapse(stack);
        System.out.println(stack);
    }
    public static void splitStack(Stack<Integer> s) {
        Queue<Integer> positiveNum=new LinkedList<>();
        Queue<Integer> negativeNum=new LinkedList<>();
        while(!s.empty()){
            int num=s.pop();
            if(num>=0){
                positiveNum.add(num);
            }else{
                negativeNum.add(num);
            }
        }
        while(!negativeNum.isEmpty()){
            s.add(negativeNum.poll());
        }
        while(!positiveNum.isEmpty()){
            s.add(positiveNum.poll());
        }

    }

    public static void stutter(Stack<Integer> s){
        Stack<Integer> stack=new Stack<>();
        for(int num: s){
            s.pop();
        }
        while(!s.isEmpty()){
            stack.add(s.pop());
        }
        while(!stack.isEmpty()){
            int num=stack.pop();
            s.push(num);
            s.push(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set=new TreeSet<>();
        for(int num: nums){
            set.add(num);
            System.out.println(num);
        }
        System.out.println(set);
        return set.size();
    }

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

}
