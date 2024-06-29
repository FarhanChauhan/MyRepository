package in.ineuron.bo;

import java.io.Serializable;
import java.time.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Integer cid;
	private String cname;
	private String caddresss;
	private LocalDateTime dob;
	private LocalDate doj;
	private LocalTime dom;
	
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddresss=" + caddresss + ", dob=" + dob + ", doj="
				+ doj + ", dom=" + dom + "]";
	}
	public Customer(String cname, String caddresss, LocalDateTime dob, LocalTime dom, LocalDate doj) {
		this.cname = cname;
		this.caddresss = caddresss;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddresss() {
		return caddresss;
	}
	public void setCaddresss(String caddresss) {
		this.caddresss = caddresss;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalTime getDom() {
		return dom;
	}
	public void setDom(LocalTime dom) {
		this.dom = dom;
	}
	
}
