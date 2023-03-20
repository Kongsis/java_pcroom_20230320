package java_project;

import java.util.*;

public class PcroomMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PcroomService service = PcroomService.getInstance();
		boolean loginOk = false;
		
		while(true) {
			System.out.println("===========일보PC방===========");
			if(loginOk) {
				System.out.println("1.시간충전 2.음식주문 3.회원정보수정 4.상품권구매 5.자리이동 6.회원탈퇴 7.로그아웃 0.종료");
			}else {
				System.out.println("1.회원가입 2.로그인 3.아이디/비밀번호 찾기 4.비회원로그인 5.시간충전 0.종료");
			}
			System.out.print("선택> ");
			int menu = sc.nextInt();
				
			if(menu == 1) {
				if(loginOk) {
						
				}else {
						
				}
			}else if(menu == 2) {
				if(loginOk) {
					
				}else {
						
				}
			}else if(menu == 3) {
				if(loginOk) {
					
				}else {
						
				}
			}else if(menu == 4) {
				if(loginOk) {
					
				}else {
					
				}
			}else if(menu == 5) {
				if(loginOk) {
					
				}else {
					
				}
			}else if(menu == 6 && loginOk) {
				
			}else if(menu == 7 && loginOk) {
				
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
