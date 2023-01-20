package utils;

public class Timer {
  private   Thread nThread;
  private TimerTask timerTask;
   private long times;
    private volatile boolean flag;

    public Timer(TimerTask timerTask,long times) {
        this.timerTask = timerTask;
        this.times = times;
    }

    public     void start(){
        flag=true;
        nThread=new Thread(()->{
            while (true){
                while (flag){
                    timerTask.run();
                    try {
                        Thread.sleep(times);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }            }
        });
        nThread.start();

    }
}
