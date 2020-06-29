// Akira Mizoguchi
// CS 143
// HW Core Topics: setting up my dev environment
//
// This program will produce a "Hello World" program in Java. 
// If user input is yes. This program print "hello World" 5 times

import java.util.*;
import java.util.Scanner;


public class HW0_DevEnv {
   public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      do{
         for (int i=1; i<=5;i++){
            System.out.println("hello World");
         }
      }while(input.nextLine().equalsIgnoreCase("yes"));
   }
}


/*  
 ----jGRASP exec: java HW0_DevEnv
 hello World
 hello World
 hello World
 hello World
 hello World
 yes
 hello World
 hello World
 hello World
 hello World
 hello World
 Yes
 hello World
 hello World
 hello World
 hello World
 hello World
 no
 
  ----jGRASP: operation complete.
 

*/