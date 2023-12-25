import java.util.ArrayList;

public class TheradRace {

    public ArrayList<ArrayList<Integer>> myNumberList = new ArrayList<>();
    public ArrayList<Integer> doubleNumberList = new ArrayList<>();
    public ArrayList<Integer> singleNumberList = new ArrayList<>();

    public void fillArrays(){

        myNumberList.add(new ArrayList<>());
        myNumberList.add(new ArrayList<>());
        myNumberList.add(new ArrayList<>());
        myNumberList.add(new ArrayList<>());

        int multiple = 2500;
        int index = 0;
        for (int i = 1; i <= 10000; i++) {
            if(i % multiple != 0){
                myNumberList.get(index).add(i);
            }else{
                myNumberList.get(index).add(i);
                multiple += 2500;
                index += 1;
            }
        }
    }

    public synchronized void addDoubleNumber(int number){
        doubleNumberList.add(number);
    }

    public synchronized void addSingleNumber(int number){
        singleNumberList.add(number);
    }

    public void runThreads() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer myNumber: myNumberList.get(0)) {
                    if(myNumber % 2 == 0){
                        addDoubleNumber(myNumber);
                    }else{
                        addSingleNumber(myNumber);
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer myNumber: myNumberList.get(1)) {
                    if(myNumber % 2 == 0){
                        addDoubleNumber(myNumber);
                    }else{
                        addSingleNumber(myNumber);
                    }
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer myNumber: myNumberList.get(2)) {
                    if(myNumber % 2 == 0){
                        addDoubleNumber(myNumber);
                    }else{
                        addSingleNumber(myNumber);
                    }
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer myNumber: myNumberList.get(3)) {
                    if(myNumber % 2 == 0){
                        addDoubleNumber(myNumber);
                    }else{
                        addSingleNumber(myNumber);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }

    public static void main(String[] args) {

        TheradRace theradRace = new TheradRace();
        theradRace.fillArrays();
        try {
            theradRace.runThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(theradRace.doubleNumberList.size());
        System.out.println(theradRace.singleNumberList.size());
        System.out.println((theradRace.doubleNumberList.size() + theradRace.singleNumberList.size()));
    }
}
