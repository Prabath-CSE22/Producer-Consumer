public class Printer implements Runnable{
    SharedQueue queue;
    
    public Printer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.removePrintJobs();
        }
    }

}
