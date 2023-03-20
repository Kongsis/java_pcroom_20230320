package java_project;

import java.util.*;

public class PcroomService {
	private static PcroomService service = new PcroomService(); // 싱글톤(접근제한)
	private PcroomService() {}
	public static PcroomService getInstance() {
		return service;
	}
	
	private Scanner sc = new Scanner(System.in);
	private PcroomRepository repository = PcroomRepository.getInstance(); //싱글톤 getInstance() 메소드를 통한 객체 사용
	private String loginId = null;
	private String loginPassword = null;
}
