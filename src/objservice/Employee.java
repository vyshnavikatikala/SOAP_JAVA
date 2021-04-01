package objservice;

public class Employee{
	private String ename;
	private int esal;
	private String dept;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public String getDept() {
		return dept;
	}
	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", esal=" + esal + ", dept=" + dept + "]";
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
