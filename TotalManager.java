import java.util.*;

public class TotalManager {
	List<User> userlist = new ArrayList<>();
	Calendar cal = Calendar.getInstance();
	PtManager pm = new PtManager();
	private User current;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int daynum = cal.getActualMaximum(Calendar.DATE);
	int ptnum;
	int buypt;
	String ManagerName="pt123";
	String Managerphone="12345";
	Scanner sc = new Scanner(System.in);
	
	public void InitSchedule() {
		pm.ScheduleInit();
	}

	public void join(){
		int plag=-1;
		System.out.println("1.PT회원   "+"\t"+ "2.관리자 [관리자도 등록 후 사용가능]: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		if(n==1){
			System.out.print("PT Member's Name: ");
			String name = sc.nextLine();
			System.out.print("PT Member's PhoneNumber [Except -]: ");
			String phone = sc.nextLine();
			
			for(int i=0;i<userlist.size();i++) {
				if(userlist.get(i).getPhoneNo().contentEquals(phone)) {
					plag=1;
				}
			}
			if(plag==1 || Managerphone.equals(phone)) {
				System.out.println("휴대폰 번호가 이미 등록되어 있습니다.");
			}else {
				userlist.add(new Customer(name,phone,0));
			}
		}else if(n==2) {
			
			if(new Manager().getNum()>0) {
				System.out.println("관리자 계정이 등록됬습니다.");
				plag=1;
			}
			if(plag==-1) {
				System.out.print("Manager's Name [사전 공지]: ");
				String name = sc.nextLine();
				System.out.print("Manager's PhoneNumber [사전 공지]: ");
				String phone = sc.nextLine();
				
				if(ManagerName.equals(name)) {
					userlist.add(new Manager(name,phone));	
				}else {
					System.out.println("관리자 이름을 정확히 입력하세요!");
				}	
			}
		}else {
			System.out.println("1 or 2 만 입력해야 합니다.");
		}
	}
	
	public int login() {
		System.out.println("Phonenum: ");
		String phone = sc.nextLine();
		int plag=-1;
		
		for(int i=0; i<userlist.size();i++) {
			if(userlist.get(i).getPhoneNo().contentEquals(phone)) {
				plag=i;
			}
		}
		
		if(plag==-1) {
			System.out.println("해당 번호가 틀렸습니다!");
		}
		else {
			current = userlist.get(plag);
		}
		
		return plag;
	}
	
	public int showPT() {
		int key = current.showPT();
		return key;
	}
	
	public void buy() {
		if(current instanceof Customer) {
			System.out.println("PT 몇 회를 구매하시겠어요? ");
			int n= sc.nextInt();
			sc.nextLine();
			buypt+=n;
			ptnum = ((Customer) current).ptBuy(n);
			
		}
	}
	
	public void Information() {
		if(current instanceof Customer) {
			System.out.println(current.toString());
		}
	}
	
	public void printProfit() {
		if(current instanceof Manager) {
			((Manager) current).profit(buypt);
		}
	}
	
	public void Infomodify() {
		if(current instanceof Customer) {
			System.out.println("1.이름변경  2.전화번호 변경");
			int n = sc.nextInt();
			String postName;
			sc.nextLine();
			
			if(n==1) {
				System.out.println("이름 변경 하세요: ");
				postName= current.getName();
				current.setName(sc.nextLine());
				
				//정보가 수정 됬으면 pt의 이름도 변경 되도록 수정.
				for(int i=day;i<daynum;i++) {
					for(int j=0;j<4;j++) {
						if(pm.ptlist.get(i).getPt()[j].contentEquals(postName)) {
							PT pt = pm.ptlist.get(i);
							pt.setptindex(j, ((Customer) current).getName());
							pm.modify(i, pt);
						}
					}
				}
			}else if(n==2) {
				System.out.println("폰 번호 변경 하세요: ");
				((Customer) current).setPhoneNo(sc.nextLine());
			}
		}
	}
	
	//해당 pt날 보기
	public void CustomerPtRegister() {
		int month = cal.get(Calendar.MONTH)+1;
		System.out.println(month+"월 "+day+"부터 " +month+"월 " +daynum +"까지 예약이 가능합니다.");
		System.out.println("pt받고 싶은 날 입력하세요 : ");
		int cusday = sc.nextInt();
		int plag=-1;
		int plag2=-1;
		
		System.out.println(cusday+ " 일에 pt 신청하시겠습니까? [1.네 2.아니오]");
		int answer = sc.nextInt();
		sc.nextLine();
		
		if(cusday<day) {
			answer=3;
		}
		
		if(answer==1) {
			if(current instanceof Customer) {
				if(((Customer) current).getptMod()==0) {
					System.out.println("PT를 구매하고 오세요.");
					plag2=1;
				}
				if(plag2==-1) {
					for(int i=0;i<4;i++) {
						if(pm.ptlist.get(cusday).getPt()[i].contentEquals(" ")) {
							ptnum=((Customer) current).ptUse(cusday);
							PT pt = pm.ptlist.get(cusday);
							pt.setptindex(i, ((Customer) current).getName()); 
							pm.modify(cusday, pt);
							System.out.println("해당 날에 PT등록이 되었습니다.");
							plag=1;
							break;
						}
					}
					if(plag==-1) {
						System.out.println("해당 날은 인원이 다 찾습니다.");
					}
					
				}	
			}		
		}else if(answer==3) {
			System.out.println("지난 날은 예약이 불가능 합니다." + day+"부터 " +daynum +"까지 예약이 가능합니다.");
		}
	}
	
	//전체 pt날 보기
	public void printAll() {
		try {
			pm.printAll();
		} catch(Exception e) {
			System.out.println("신청한 PT가 0명입니다.");
		}
	}
	
	public void ManagerPtModify() {
		int plag=-1;
		System.out.println("어느 날을 변경하시겠습니까?");
		int cusday = sc.nextInt();
		sc.nextLine();
		System.out.println("어느 회원을 변경하시겠습니까? [추가를 원하시면 spaceBar + Enter]");
		String name = sc.nextLine();
		System.out.println("어떤 회원을 추가하겠습니까? [삭제를 원하시면 spaceBar + Enter 입력]");
		String changeName = sc.nextLine() ;
		
		if(current instanceof Manager) {
			for(int i=0;i<4;i++) {
				if(pm.ptlist.get(cusday).getPt()[i].contentEquals(name)) {
					PT pt = pm.ptlist.get(cusday);
					pt.setptindex(i, changeName);
					System.out.println("변경이 완료되었습니다.");
					plag=1;
					break;
				}
			}
			if(plag==-1) {
				System.out.println("해당 회원은 존재하지 않습니다.");
			}
		}
	}
	
	public User getCureent() {
		return current;
	}
	
	public void setCurrent(User current) {
		this.current=current;
	}
	

}
