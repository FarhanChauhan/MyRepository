package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="company")
public class Company {

	private String name;
	private Integer size;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + ", location=" + location + "]";
	}
	
}
