package java_project;

public class feeDTO extends PcroomDTO{
	
	private long time;
	private int fee;
	private boolean member;
	
	public feeDTO() {
//		time = 0;
//		fee = 0;
	}
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time--;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return time + "\t" + fee + "\t" + member;
	}
}
