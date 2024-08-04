public class Main {
    public static void main(String[] args) {
        SharedQueue q = new SharedQueue(5);
        Thread c1 = new Thread(new Computer(q, 1), "Computer 1");
        Thread c2 = new Thread(new Computer(q, 2), "Computer 2");
        Thread c3 = new Thread(new Computer(q,3), "Computer 3");
        Thread c4 = new Thread(new Computer(q, 4), "Computer 4");
        Thread c5 = new Thread(new Computer(q,5), "Computer 5");

        Thread p1 = new Thread(new Printer(q), "Printer 1");
        Thread p2 = new Thread(new Printer(q), "Printer 2");
        Thread p3 = new Thread(new Printer(q), "Printer 3");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        p1.start();
        p2.start();
        p3.start();

    }
}
