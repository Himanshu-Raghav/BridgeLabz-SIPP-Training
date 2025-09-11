import java.lang.reflect.*;

class SampleTask {
    public void doWork() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class AdvancedMethodTiming {
    public static void main(String[] args) throws Exception {
        SampleTask task = new SampleTask();
        Method method = SampleTask.class.getMethod("doWork");

        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();

        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}
