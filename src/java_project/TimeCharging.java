package java_project;

import java.util.ArrayList;
import java.util.List;

public class TimeCharging {
    private double pricePerHour; // 시간
    private double balance; // 금액
//    List<TimeCharging> list = new ArrayList<>();
//    
//    public List<TimeCharging> feelist(String h, int hours, int balance, int time, boolean b){
//    	//비회원요금목록
//    	list.add("1시간", 1, 1200, 60, false);
//    	list.add("2시간", 2, 2400, 120, false);
//    	list.add("3시간", 3, 3500, 180, false);
//    	list.add("4시간", 4, 4500, 240, false);
//    	list.add("5시간", 5, 5500, 300, false);
//    	list.add("10시간", 6, 10000, 600, false);
//    	list.add("20시간", 7, 20000, 1200, false);
//
//    	// 회원요금목록
//    	list.add("1시간", 1, 900, 60, true);
//    	list.add("2시간", 2, 1800, 120, true);
//    	list.add("3시간", 3, 3000, 180, true);
//    	list.add("4시간", 4, 3500, 240, true);
//    	list.add("5시간", 5, 4500, 300, true);
//    	list.add("10시간", 6, 8000, 600, true);
//    	list.add("20시간", 7, 16000, 1200, true);
////        TimeCharging timeCharging;
////		timeCharging.save(list);
//    }


//	public boolean save(TimeCharging timeCharging) {
//		return list.add(timeCharging);
//	}
    public TimeCharging() {
    	
    }

	public TimeCharging(double pricePerHour, double balance) {
        this.pricePerHour = pricePerHour;
        this.balance = balance;
    }

    public void useTime(double hours) {
        double cost = pricePerHour * hours;
        if (balance < cost) {
            System.out.println("\n잔액이 부족합니다.");
        } else {
            balance -= cost;
            System.out.println("사용자 " + hours + " 시간. 잔액: " + balance);
        }
    }
}