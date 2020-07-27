import java.util.*;

public class JobSim {
    //field
    protected Stack<String> employedList;
    protected Queue<String> waitingList;

    public JobSim(int workers, int jobs) {

        //initialize
        employedList=new Stack<>();
        waitingList=new LinkedList<>();

        //putAll_data in these store.
        for(int i=1;i<=workers;i++){
            waitingList.add("Worker #"+i);
        }
        for(int i=1;i<=jobs;i++){
            employedList.push(waitingList.remove());
        }
    }

    public String toString() {
        String newStr="Employed: "+employedList+"\n"+"Waitlist: "+waitingList;
        return newStr;
    }

    public void cycle() {
        Random die=new Random();
        int num=die.nextInt(6)+1;
        System.out.println();
        System.out.println("-------Cycle 1-------\n" +
                "Managers roll a "+num+"\n" +
                "---------------------");
        //when people fired
        for(int i=1;i<=num;i++){
            String firedWorker=employedList.pop();
            System.out.println("FIRE:\t"+firedWorker);
            waitingList.add(firedWorker);
        }
        for(int i=1;i<=num;i++){
            String hiredWorker=waitingList.poll();
            System.out.println("HIRE:\t"+hiredWorker);
            employedList.push(hiredWorker);
        }

    }
}
