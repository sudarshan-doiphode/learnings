By using synchronized keyword we aquire either class level lock or object level intrinsic lock. 
1. there is a single intrinsic lock associated with every object or class in Java \
2. a given  thread that needs exclusive and consistent access to an object's fields
has to acquire the object's intrinsic lock before accessing them, \
3. and then the thread releases the intrinsic lock when it's done with them 

Let's understand problem with synchronization:

    public static void increment() {
    synchronized (WithClassLevelLocking.class) {
        COUNTER++;
    }
    }

    public static void decrement() {
        synchronized (WithClassLevelLocking.class) {
            COUNTER--;
        }
    }

Over here we are having 2 method with 
synchronized keyword, When we have 2 
threads one thread calling increment 
and other thread calling decrement, 
At each time one thread can acquire 
the intrinsic lock and release once done with task. 
Then as per time slicing second thread can aquire lock and release once task is executed.


But sometimes we are having multiple method independent of each other like
    
    public static int COUNTER1 = 0;
    public static int COUNTER2 = 0;
    public static void increment1() {
        synchronized (WithClassLevelLocking.class) {
            COUNTER1++;
        }
    }

    public static void increment2() {
        synchronized (WithClassLevelLocking.class) {
            COUNTER2++;
        }
    }

As you see this are independent increment operation and if two thread want to execute them concurrently they need at least 2 locks that's why we can create our own locks and assign them in synchronized block
Here is the solution:
     
    public class ResolvingProblemWithSingleLockInSync {

    public static int COUNTER1 = 0;
    public static int COUNTER2 = 0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void increment1(){
        synchronized (lock1){
            for (int i = 0; i < 100; i++) {
                COUNTER1++;
            }
        }
    }

    public static void increment2(){
        synchronized (lock2){
            for (int i = 0; i < 100; i++) {
                COUNTER2++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment2();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(COUNTER1);
        System.out.println(COUNTER2);
    }
    }
