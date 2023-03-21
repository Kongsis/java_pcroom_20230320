package java_project;

import java.util.Timer;
import java.util.TimerTask;

public class TimeCharge1 {
    private int remainingTime;
    private Timer timer;

    public TimeCharge1(int initialTime) {
        this.remainingTime = initialTime;
        this.timer = new Timer();
    }

    public void startCharging() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                remainingTime--;
                System.out.println("[남은시간 : " + remainingTime+"]");
                if (remainingTime <= 0) {
                    timer.cancel();
                    System.out.println("[남은시간 : 종료]");
                }
            }
        }, 0, 1000); // 1초마다 실행
    }

    public static void main(String[] args) {
        TimeCharge1 timeCharge = new TimeCharge1(10);
        timeCharge.startCharging();
    }
}
