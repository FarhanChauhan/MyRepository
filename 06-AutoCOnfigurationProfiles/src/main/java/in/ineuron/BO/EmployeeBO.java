package in.ineuron.BO;

public class EmployeeBO {

	private Integer eno;
	private String ename;
	private String job;
	private Integer sal;
	private Integer deptNo;
	private Integer mgrNo;
	
	@Override
	public String toString() {
		return "EmployeeBO [eno=" + eno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", deptNo=" + deptNo
				+ ", mgrNo=" + mgrNo + "]";
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
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
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getMgrNo() {
		return mgrNo;
	}
	public void setMgrNo(Integer mgrNo) {
		this.mgrNo = mgrNo;
	}
	
	
	
}
