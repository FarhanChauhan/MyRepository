package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="info")
public class ItemsInfo {

	@Value("${item.price.dosa}")
	public float dosaPrice;
	@Value("${item.price.idli}")
	public float idliPrice;
	@Value("${item.price.vada}")
	public float vadaPrice;
	@Override
	public String toString() {
		return "ItemsInfo [dosaPrice=" + dosaPrice + ", idliPrice=" + idliPrice + ", vadaPrice=" + vadaPrice + "]";
	}
	
	
}
