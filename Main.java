import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalManager totmanager = new TotalManager();
		Scanner sc = new Scanner(System.in);
		totmanager.InitSchedule();
		
		while(true) {
			System.out.println("1.회원가입   "+"\t"+"2.로그인   "+"\t"+ "3.종료: ");
			int n = sc.nextInt();
			sc.nextLine();
			
			switch(n) {
			case 1:
				try {
					totmanager.join();
					break;
				} catch(Exception e) {
					System.out.println("이미 등록된 번호가 있으니 바꿔주세요.");
				}
				break;
				
			case 2:
				int plag=totmanager.login();		
				if(plag==-1) break;
				int Managerplag=-1;
				for(;;) {
					int key = totmanager.showPT();
					//Customer: 1.PT구매 2.PT사용 3.PT조회  4.회원 정보 조회 5.회원 정보 수정 6.로그아웃  
					//Manager: 1.현재 매출 출력 2.PT수정  3.PT조회 4.로그아웃  
					
					switch(key) {
					case 1:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.buy();
						}else {
							totmanager.printProfit();
						}
						break;
					case 2:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.CustomerPtRegister();
						}else {
							totmanager.ManagerPtModify();
						}
						break;
					case 3:
						totmanager.printAll();
						break;
					case 4:
						if(totmanager.getCureent() instanceof Customer) {
							totmanager.Information();
						}else {
							System.out.println("Log out");
							Managerplag=1;
						}
						break;
					case 5:
						totmanager.Infomodify();
						break;
					case 6:
						System.out.println("Log out");
						break;
					default:
						break;
					}
					
					if(key<1 || key>5 || Managerplag==1) {
						break;
					}
				}
				break;
				
			case 3: System.exit(0);
			default:
				System.out.println("1,2,3만 누르세요.");
			}
		}
	}
}
	


