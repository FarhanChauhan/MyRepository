package in.ineuron.VO;

public class EployeeVO {

	private String eno;
	private String ename;
	private String job;
	private String sal;
	private String deptNo;
	private String mgrNo;
	
	@Override
	public String toString() {
		return "EployeeVO [eno=" + eno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo=" + deptNo
				+ ", mgrNo=" + mgrNo + "]";
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getMgrNo() {
		return mgrNo;
	}
	public void setMgrNo(String mgrNo) {
		this.mgrNo = mgrNo;
	}
}
