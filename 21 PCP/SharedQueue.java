import java.util.ArrayList;
import java.util.List;

public class SharedQueue {
    List<Printjob> printjobs;
    private int capacity;

    public SharedQueue(int capacity) {
        this.capacity = capacity;
        printjobs = new ArrayList<>();
    }
    
    public synchronized void addPrintJobs(Printjob printjob){
        while (printjobs.size() >= capacity) {
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(" "+Thread.currentThread().getName() + " sends "+printjob.getJobid()+".pdf");
        printjobs.add(printjob);
        notifyAll();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void removePrintJobs(){
        while (printjobs.isEmpty()) {
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        Printjob printjob = printjobs.remove(0);
        System.out.println(Thread.currentThread().getName()+" prints "+ printjob.getJobid()+" "+printjob.getType());
        notifyAll();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
