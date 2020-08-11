import java.util.*;

public class PtManager {
	List<PT> ptlist = new ArrayList<>();
	Calendar cal = Calendar.getInstance();
	int daynum = cal.getActualMaximum(Calendar.DATE);
	
	public void ScheduleInit() {
			for(int i=0; i<=40; i++) {
				ptlist.add(new PT(" "," "," "," "));
			}
	}
	
	public void modify(int day,PT pt) {
		ptlist.remove(day);
		ptlist.add(day, pt);
	}
	
	
	public void printAll() throws Exception {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayof = cal.get(Calendar.DAY_OF_WEEK);
		int endofweek = 0;
		
		for(int i=0; i<7; i++) {
			if((dayof+i)%7 == 0) {
				endofweek=(day+i);
				break;
			}
		}
		
		System.out.println("PT Schdule 2주");
		System.out.println(year + "년도 " + month + "월 " + week + "주 PT "  );
		System.out.println("일" + "\t" + "월"+ "\t"+ "화"+ "\t"+"수"+ "\t"+"목"+ "\t"+"금"+ "\t"+"토");
		
		for(int i=1;i<dayof;i++) { //시작 날짜
			System.out.print("\t");
		}
		
		for(int i=day; i<=endofweek; i++) { //이번주 날짜 입력
			int n = i%daynum;
			if(n==0) n=daynum;
			System.out.print("*" + n + "*" + "\t");
		}
		System.out.println();
		
		//이번주 피티 입력
		for(int i=0;i<4;i++) { 
			for(int j=1; j<dayof; j++) {
				System.out.print("\t");
			}
			for(int j=day;j<=endofweek; j++) {
				int n= j%daynum;
				System.out.print(ptlist.get(n).getPt()[i] + "\t");
			}
			System.out.println();
		}
		
		//다음주 날짜 입력
		for(int i=(endofweek+1);i<=(endofweek+7);i++ ) {
			int n = i%daynum;
			if(n==0) n=daynum;
			System.out.print("*" + n + "*" + "\t");
		}
		System.out.println();
		
		//다음주 피티 입력
		for(int i=0;i<4;i++) {
			for(int j= (endofweek+1); j<=(endofweek+7); j++) {
				int n = j%daynum;
				if(n==0) n=daynum;
				System.out.print(ptlist.get(n).getPt()[i] + "\t");
			}
			System.out.println();
		}
	}
	
	public List<PT> getPtlist(){
		return ptlist;
	}
	
	public void setptlist(List<PT> ptlist) {
		this.ptlist=ptlist;
	}

}
