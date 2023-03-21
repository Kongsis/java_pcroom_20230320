package java_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PcroomRepository {
	private static PcroomRepository repository = new PcroomRepository(); // 싱글톤(접근제한)
	private PcroomRepository() {}
	public static PcroomRepository getInstance() {
		return repository;
	}
	
	List<PcroomDTO> list = new ArrayList<>();
	
	public boolean save(PcroomDTO pcroomDTO) {
		return list.add(pcroomDTO);
	}
	
	public boolean checkId(String id) {
		for(PcroomDTO p : list) {
			if(p.getId().equals(id)) {
				return false; 
			}
		}
		return true;
	}
	
	public boolean loginCheck(String id, String pw) {
		for(PcroomDTO p : list) {
			if(id.equals(p.getId()) && pw.equals(p.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public PcroomDTO finById(String id) {
		for(PcroomDTO p : list) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public PcroomDTO findByIdPw(String name, String phone) {
		for(PcroomDTO p : list) {
			if(p.getName().equals(name) && p.getPhone().equals(phone)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean update(PcroomDTO pcroomDTO, String pw) {
		for(PcroomDTO p : list) {
			if(p.getPassword().equals(pw)) {
				p.setPassword(pcroomDTO.getPassword());
				return true;
			}
		}
		return false;
	}
	
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	public void start(long time) {
//		feeDTO fee = new feeDTO();
//		fee.setStartTime(time);
//	}
//	
//	public int stop(long time) {
//		feeDTO fee = new feeDTO();
//		long dif = 0;
//		int money = 0;
//		fee.setFinishTime(time);
//		dif = (fee.getFinishTime()-fee.getStartTime()) / 1000;
//		if(dif < 60) {
//			money = 500;
//		}else {
//			money = (int)(500 + (dif-60) / 10*10);
//		}
//		fee.setFee(fee.getFee()+money);
//		return money;
//	}
	
	public boolean update1(PcroomDTO pcroomDTO, String pw) {
		for(PcroomDTO p : list) {
			if(p.getPassword().equals(pw)) {
				p.setName(pcroomDTO.getName());
				p.setPhone(pcroomDTO.getPhone());
				p.setPassword(pcroomDTO.getPassword());
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String pw) {
		for(PcroomDTO p : list) {
			if(p.getPassword().equals(pw)) {
				list.remove(p);
				return true;
			}
		}
		return false;
	}
	
}
