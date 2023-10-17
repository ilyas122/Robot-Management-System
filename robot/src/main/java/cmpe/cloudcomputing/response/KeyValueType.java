package cmpe.cloudcomputing.response;

import java.util.Collection;
import java.util.Set;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class KeyValueType {
	Set<String> keys;
	Collection<Integer> values;
	
	public KeyValueType(Set<String> keys, Collection<Integer> values) {
		this.keys = keys;
		this.values = values;
	}
	public Collection<Integer> getValues() {
		return values;
	}
	public void setValues(Collection<Integer> values) {
		this.values = values;
	}
	public Set<String> getKeys() {
		return keys;
	}
	public void setKeys(Set<String> keys) {
		this.keys = keys;
	}
	

}
