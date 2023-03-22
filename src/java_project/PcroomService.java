package java_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PcroomService {
//	private static final TimeUnit SECONDS = null;
	private static PcroomService service = new PcroomService(); // 싱글톤(접근제한)
	private PcroomService() {}
	public static PcroomService getInstance() {
		return service;
	}
	
	private Scanner sc = new Scanner(System.in);
	private PcroomRepository repository = PcroomRepository.getInstance(); //싱글톤 getInstance() 메소드를 통한 객체 사용
	String loginId = null;
	String loginPassword = null;
	
	public void save() {
//		PcroomDTO pcroomDTO = new PcroomDTO();
		boolean checkResult = true;
		String id = null;
		do {
			System.out.print("아이디> ");
			id = sc.next();
			if (repository.checkId(id)) {
				System.out.println("사용가능한 아이디입니다.");
				checkResult = false;
			} else {
				System.out.println("이미 사용중인 아이디입니다.");
			}
		} while (checkResult);
		System.out.print("비밀번호> ");
		String pw = sc.next();
		System.out.print("이름> ");
		String name = sc.next();
		System.out.print("전화번호> " );
		String phone = sc.next();
		PcroomDTO pcroomDTO = new PcroomDTO(name, phone, id, pw);
		pcroomDTO.setMember(true);
		if (repository.save(pcroomDTO)) {
			System.out.println("\n회원가입이 완료되었습니다.");
			System.out.println(pcroomDTO.toString());
		} else {
			System.out.println("\n회원가입 중 오류가 발생하였습니다.");
		}
	}
	
	public boolean loginCheck(int chk) {
		System.out.print("아이디> ");
		String id = sc.next();
		System.out.print("비밀번호> ");
		String pw = sc.next();
		if(id.equals("admin") && chk == 1) {
			loginId = id;
			loginPassword = pw;
			return true;
		}else if(repository.loginCheck(id, pw) && chk == 2) {
				System.out.println("\n로그인 성공");
				loginId = id;
				loginPassword = pw;
				return true;
		}else {
			System.out.println("\n로그인 실패");
			return false;
		}
	}
	
	public void findByIdPw() {
		System.out.print("이름> ");
		String name = sc.next();
		System.out.print("전화번호> ");
		String phone = sc.next();
		System.out.print("찾기(1.아이디 2.비밀번호)> ");
		int i = sc.nextInt();
		PcroomDTO pcroomDTO = repository.findByIdPw(name, phone);
		if(pcroomDTO == null) {
			System.out.println("\n찾을 수 없는 사용자 입니다.");
		}else {
			if(i == 1) {
				System.out.println("\n"+pcroomDTO.getId());
			}else if(i == 2) {
				System.out.print("아이디> ");
				String id = sc.next();
				PcroomDTO p = repository.finById(id);
				if(p == null) {
					System.out.println("\n등록되지 않은 아이디입니다.");
				}else {
					PcroomDTO pcroomDTO1 = new PcroomDTO();
					System.out.print("수정할 비밀번호 입력> ");
					String pw = sc.next();
					pcroomDTO1.setPassword(pw);
					if(repository.update(pcroomDTO1, pw)) {
						System.out.println("\n비밀번호가 수정되었습니다.");
					}else {
						System.out.println("\n수정에 실패하였습니다.");
					}
				}
			}else {
				System.out.println("\n다시선택");
			}
		}
	}
	
	public void bLoginCheck() {
		System.out.print("전화번호> " );
		String phone = sc.next();
		PcroomDTO pcroomDTO = new PcroomDTO(phone);
		System.out.println("임시회원번호 : "+pcroomDTO.getNumber());
//		System.out.println(pcroomDTO);
	}
	
//	public void time() {
//		feeDTO fee = new feeDTO();
//		System.out.print("충전하실 금액을 입력해주세요> ");
//		int money = sc.nextInt();
//		fee.setFee(money);
//		long count = fee.getFee() / 1000 * 2;
//		fee.setTime(count);
//		System.out.println("총 " + count + "분 충전되었습니다.");
//		
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask() {
//			@Override
//			public void run() {
//				while(true) {
//					if(fee.getTime() >= 0) {
//						System.out.println("[남은시간 : "+fee.getTime()+"]");
//						
//					}
//				}
//			}
//		};
//		timer.schedule(task, 5000);
//	}

	public void update1() {
		System.out.print("비밀번호 확인> ");
		String password = sc.next();
		if(password.equals(loginPassword)) {
			System.out.print("수정할 이름> ");
			String name = sc.next();
			System.out.print("수정할 전화번호> ");
			String phone = sc.next();
			System.out.print("수정할 비밀번호> ");
			String pw = sc.next();
			if(repository.update1(loginId, loginPassword, name, phone, pw)) {
				loginPassword = pw;
				System.out.println("\n회원정보가 수정되었습니다.");
			}else {
				System.out.println("\n오류가 발생하였습니다.");
			}
		}else {
			System.out.println("\n비밀번호가 일치하지 않습니다.");
		}
	}
	
	public void delete() {
		System.out.print("삭제할 회원의 비밀번호> ");
		String pw = sc.next();
		if(repository.delete(pw)) {
			System.out.println("\n탈퇴가 완료되었습니다. 감사합니다.");
		}else {
			System.out.println("\n오류가 발생하였습니다.");
		}
	}
	public void logout() {
		loginId = null;
		loginPassword = null;
		System.out.println("\n로그아웃 되었습니다.");
	}
	
//	public void Admin() {
//		PcroomDTO pcroomDTO = new PcroomDTO();
//		pcroomDTO.setId("admin");
//		pcroomDTO.setPassword("1234");
//		System.out.print("아이디> ");
//		String id = sc.next();
//		System.out.print("비밀번호> ");
//		String pw = sc.next();
//		
//		if(repository.Admin(id, pw)) {
//			System.out.println("\n관리자모드로 로그인이 되었습니다");
//		}
//		
//	}
	public void useTime() {
		feeDTO fee = new feeDTO();
		PcroomDTO p = new PcroomDTO();
		if(p.isMember() == false) {
			System.out.println("<비회원요금>\n1.[1시간] : 1,200원\n2.[2시간] : 2,400원\n3.[3시간] : 3,500원\n4.[4시간] : 4,500원\n5.[5시간] : 5,500원\n6.[10 시간] : 10,000원\n7.[20 시간] : 20,000원");
		}else if(p.isMember() == true) {
			System.out.println("<회원요금>\n1.[1시간] : 900원\n2.[2시간] : 1,800원\n3.[3시간] : 3,000원\n4.[4시간] : 3,500원\n5.[5시간] : 4,500원\n6.[10 시간] : 8,000원\n7.[20 시간] : 16,000원");
		}
		System.out.println();
		System.out.print("충전하실 금액을 입력해주세요> ");
		int chk = sc.nextInt();
		
		
	}
}
