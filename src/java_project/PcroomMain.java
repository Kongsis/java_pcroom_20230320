package java_project;

import java.util.*;

public class PcroomMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PcroomService service = PcroomService.getInstance();
		countService countsv = countService.getInstance();
		boolean loginOk = false;
//		boolean count = false;
		
		while(true) {
			System.out.println("===일보PC방===");
			System.out.println("1.관리자 2.회원");
			System.out.print("선택> ");
			int chk = sc.nextInt();
			if(chk == 1) {
				if(loginOk) {
					countsv.countOk();
				}else {
					loginOk = service.loginCheck(1);
				}
			}else if(chk == 2) {
				while(true) {
					System.out.println("=========================일보PC방=========================");
					if(loginOk) {
						System.out.println("1.시간충전 2.음식주문 3.회원정보수정 4.메신저 5.회원탈퇴 6.로그아웃 0.종료");
					}else {
						System.out.println("1.회원가입 2.로그인 3.아이디/비밀번호 찾기 4.비회원로그인 0.종료");
					}
					System.out.print("선택> ");
					int menu = sc.nextInt();
						
					if(menu == 1) {
						if(loginOk) {
							service.useTime();
						}else {
							service.save();
						}
					}else if(menu == 2) {
						if(loginOk) {
							
						}else {
							loginOk = service.loginCheck(2);
						}
					}else if(menu == 3) {
						if(loginOk) {
							service.update1();
						}else {
							service.findByIdPw();
						}
					}else if(menu == 4) {
						if(loginOk) {
							
						}else {
							service.bLoginCheck();
							loginOk = true;
						}
					}else if(menu == 5 && loginOk) {
						service.delete();
					}else if(menu == 6 && loginOk) {
						service.logout();
						loginOk = false;
					}else if(menu == 0) {
						break;
					}else {
						System.out.println("\n다시 입력해주세요.");
					}
					System.out.println();
				}
				System.out.println("\n시스템을 종료합니다.");

			}
		}

	}

}
