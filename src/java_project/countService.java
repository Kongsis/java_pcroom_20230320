package java_project;

import java.util.*;

public class countService {
	private static countService countsv = new countService(); // 싱글톤(접근제한)
	private countService() {}
	public static countService getInstance() {
		return countsv;
	}
	private PcroomRepository repository = PcroomRepository.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	
	public void countOk() {
		
		while(true) {
			System.out.println("===========================일보PC방===========================");
			System.out.println("1.회원리스트 2.상품추가 3.재고관리 4.자리이동 5.메신저 6.돌아가기 0.종료");
			System.out.print("선택> ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
					List<PcroomDTO> clist = repository.findAll();
					System.out.println("회원번호\t이름\t아이디\t비밀번호\t전화번호\t회원여부");
					System.out.println("-------------------------------------------------------");
					for(PcroomDTO p : clist) {
						System.out.println(p.toString());
					}
			}else if(menu == 2) {
				
			}else if(menu == 3) {
				
			}else if(menu == 4) {
				
			}else if(menu == 5) {
				
			}else if(menu == 6) {
				
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
