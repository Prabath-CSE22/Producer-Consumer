public class Printjob {
    private int jobid;
    private String type;
    public Printjob(int jobid, String type) {
        this.jobid = jobid;
        if(type!= ".exe"){
            this.type = type;
        }else{
            throw new TypeNotSupportedException(Thread.currentThread().getName()+" sends "+type+" type file to the queue");
            
        }
    }

    public int getJobid() {
        return jobid;
    }

    public String getType() {
        return type;
    }
    
}
