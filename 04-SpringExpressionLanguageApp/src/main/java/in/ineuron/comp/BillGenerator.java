package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="bill")
public class BillGenerator {

	@Value("#{info.dosaPrice+info.idliPrice+info.vadaPrice}")
	private float bilAmount;
	
	@Value("A2B")
	private String hotelName;

	@Autowired
	private ItemsInfo info;

	@Override
	public String toString() {
		return "BillGenerator [bilAmount=" + bilAmount + ", hotelName=" + hotelName + ", info=" + info + "]";
	}
	

	
}
