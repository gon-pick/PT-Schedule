import java.util.*;

public class Manager extends User {
	private int profit;
	private static int num;
	Scanner sc = new Scanner(System.in);
	
	public Manager() {};
	
	public Manager(String name,String phoneNo) {
		super(name,phoneNo);
		setNum(getNum() + 1);
	}

	@Override
	public int showPT() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("*매니저님 무엇을 설정하시겠습니까?");
		System.out.println("1.현재 매출 출력 2.PT수정  3.PT조회 4.로그아웃  ");
		int pt = sc.nextInt();
		sc.nextLine();
		if(pt<1 && pt>6) {
			pt=0;
		}
		return pt;
	}
	
	public void profit(int pt) {
		System.out.println("현재 매출액은 " + (pt*50000) + "원 입니다.");
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Manager.num = num;
	}
}
