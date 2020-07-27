import java.util.*;

public class ExploringIterators {
    public static void main(String[] args) {
        Random rand = new Random();
        GrabBag<String> things = new GrabBag<>();
        populate(things,5,rand);
        System.out.println(things.toString());
        for(String thing: things){
            System.out.println(thing);

        }
        System.out.println();
        Iterator it = things.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public static void populate(GrabBag<String> bag, int num, Random r) {

        for(int i=0;i<num;i++){
            int rand=r.nextInt(100)+1;
            bag.add("Thing "+rand);
        }


    }
}