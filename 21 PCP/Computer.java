import java.util.Random;

public class Computer implements Runnable{
    SharedQueue queue;
    int id; 
    private static int currentjobid = 1;
    
    public Computer(SharedQueue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        Random rc = new Random();

        while (true) {
            String type;
            if(rc.nextInt(2) == 0){
                type = ".pdf";
            }else{
                type = ".exe";
            }

            try{
                queue.addPrintJobs(new Printjob(currentjobid++, type));
            }catch(TypeNotSupportedException e){
                System.out.println(e);
            }
            
        }
    }

}
