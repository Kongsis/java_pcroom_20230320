package java_project;

public class PcroomDTO {
	
	private static int memberNumber = 100; // 회원번호
	private int number; // 회원번호(자동증가)
	private String name;
	private String id;
	private String password;
	private String phone; 	// 핸드폰번호
	private long time;		// 충전시간
	private int remainTime; // 남은시간
	private int seatNumber; // 좌석번호
	private boolean status; // 이용상태
	private boolean member; // 회원, 비회원 여부
	
	public PcroomDTO() {
		this.number = memberNumber++;
	}
	public PcroomDTO(String phone) {
		this.number = memberNumber;
		this.phone = phone;
		this.id = "guest";
		this.password= "0000";
		this.seatNumber = -1;
		this.remainTime = 0;
		this.status = false;
		this.member = false;
	}
	public PcroomDTO(String name, String phone, String id, String password) {
		this.number = memberNumber;
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.password = password;
		this.seatNumber = -1;
		this.remainTime = 0;
		this.status = false;
		this.member = true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
		if(member = false) {
//			this.time = "1시간"+ 1+ 1200+ 60;
		}else {
			
		}
	}
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return number + "\t" + name + "\t" + id + "\t" + password + "\t" + phone + "\t" + remainTime + "\t" + seatNumber + "\t" +  status + "\t" + member;
	}
}
