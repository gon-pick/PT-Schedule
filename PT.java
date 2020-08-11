
public class PT {
	private String[] pt = new String[4];
	
	public PT() {
		this(" "," "," ", " ");
	};
	
	public PT(String pt1, String pt2, String pt3, String pt4) {
		// TODO Auto-generated constructor stub
		this.pt[0]=pt1;
		this.pt[1]=pt2;
		this.pt[2]=pt3;
		this.pt[3]=pt4;
	}

	@Override
	public String toString() {
		return "PT Member's name: " + this.pt[0] + "\n" + "PT Member's name: " + this.pt[1] + "\n"+  "PT Member's name: " + this.pt[2] 
				+ "\n" + "PT Member's name: " + this.pt[3] + "\n";
	}
	
	public String[] getPt() {
		return pt;
	}
	
	public void setPt(String[] pt) {
		this.pt=pt;
	}
	
	public void setptindex(int i,String name) {
		this.pt[i]=name;
	}	
}
