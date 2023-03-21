package java_project;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeCharge {
	
//	private int fee;
//	private boolean member;
    private LocalDateTime lastChargeTime;
    private Duration remainingTime;

    public TimeCharge(Duration initialTime) {
        this.remainingTime = initialTime;
        this.lastChargeTime = LocalDateTime.now();
    }

    public boolean canUse(Duration usageTime) {
        updateRemainingTime();
        return remainingTime.compareTo(usageTime) >= 0;
    }

    public void use(Duration usageTime) {
        if (canUse(usageTime)) {
            remainingTime = remainingTime.minus(usageTime);
        } else {
            throw new IllegalArgumentException("Not enough time remaining");
        }
    }

    private void updateRemainingTime() {
        LocalDateTime now = LocalDateTime.now();
        Duration elapsedTime = Duration.between(lastChargeTime, now);
        remainingTime = remainingTime.minus(elapsedTime);
        lastChargeTime = now;
    }

    public void charge(Duration chargeTime) {
        updateRemainingTime();
        remainingTime = remainingTime.plus(chargeTime);
        lastChargeTime = LocalDateTime.now();
    }

}

//Duration initialTime = Duration.ofHours(1);
//TimeCharge timeCharge = new TimeCharge(initialTime);
//
//// 시간을 충전
//Duration chargeTime = Duration.ofMinutes(30);
//timeCharge.charge(chargeTime);

//// 시간을 사용
//Duration usageTime = Duration.ofMinutes(45);
//if (timeCharge.canUse(usageTime)) {
//    timeCharge.use(usageTime);
//} else {
//    System.out.println("Not enough time remaining");
//}
//
//// 남은 시간을 확인
//Duration remainingTime = timeCharge.getRemainingTime();
//System.out.println("Remaining time: " + remainingTime);
//이 예제에서는 초기 시간을 1시간으로 설정하고 TimeCharge 객체를 만듭니다. 그런 다음 30분을 충전하고 45분을 사용합니다. 마지막으로 남은 시간을 출력합니다.
