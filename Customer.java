import java.util.*;

public class Customer extends User {
	private int ptMod;
	Scanner sc = new Scanner(System.in);
	
	public Customer() {};
	
	public Customer(String name,String phoneNo,int ptMod) {
		super(name,phoneNo);
		this.ptMod=ptMod;
	}
	
	@Override
	public int showPT() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("* 헬스 클럽에 오신것을 환영합니다. "+super.getName() +"님의 남은 PT 횟수는: "  + ptMod + "입니다. *");
		System.out.println("1.PT구매   2.PT사용   3.PT조회   4.회원 정보 조회   5.회원 정보 수정   6.로그아웃   : ");
		int pt = sc.nextInt();
		sc.nextLine();
		if(pt<1 && pt>6) {
			pt=0;
		}
		return pt;
	}
	
	@Override
	public String toString() {
		return "Customer *Name: " + super.getName() + "     *PhoneNumber: " + super.getPhoneNo();
	}
	
	public int ptBuy(int n) {
		System.out.println("PT 이용권을 " + n + "개를 구매하였습니다.");
		System.out.println("남은 PT횟수는 " + (getptMod()+n) + "개 입니다");
		setptMod(ptMod+n);
		return ptMod;
	}

	public int ptUse(int cusday) {
		// TODO Auto-generated method stub
		if(ptMod>0) {
			System.out.println(cusday+"일에 "+"PT 이용권을 사용하였습니다.");
			System.out.println("남은 PT횟수는 " + (getptMod()-1) + "개 입니다");
			setptMod(ptMod-1);	
		}else {
			System.out.println("PT 수가 0개 입니다. PT를 구매하세요.");
		}
		
		return ptMod;
	}

	public void setptMod(int ptMod) {
		this.ptMod=ptMod;
	}
	
	public int getptMod() {
		return this.ptMod;
	}
}
