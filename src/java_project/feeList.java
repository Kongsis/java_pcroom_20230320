package java_project;

import java.util.*;

public class feeList {
	List<feeList> fee = new ArrayList<>();
		
	public feeList(String h, int hour, int cost, int min, boolean b) {
		// 비회원요금목록
		this.fee.add(new feeList("1시간", 1, 1200, 60, false));
		this.fee.add(new feeList("2시간", 2, 2400, 120, false));
		this.fee.add(new feeList("3시간", 3, 3500, 180, false));
		this.fee.add(new feeList("4시간", 4, 4500, 240, false));
		this.fee.add(new feeList("5시간", 5, 5500, 300, false));
		this.fee.add(new feeList("10시간", 6, 10000, 600, false));
		this.fee.add(new feeList("20시간", 7, 20000, 1200, false));

		// 회원요금목록
		this.fee.add(new feeList("1시간", 1, 900, 60, true));
		this.fee.add(new feeList("2시간", 2, 1800, 120, true));
		this.fee.add(new feeList("3시간", 3, 3000, 180, true));
		this.fee.add(new feeList("4시간", 4, 3500, 240, true));
		this.fee.add(new feeList("5시간", 5, 4500, 300, true));
		this.fee.add(new feeList("10시간", 6, 8000, 600, true));
		this.fee.add(new feeList("20시간", 7, 16000, 1200, true));
		
	}

//		save("feeList.ser", feeList);
	
	
}
