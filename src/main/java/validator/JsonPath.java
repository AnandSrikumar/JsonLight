package validator;

import java.util.ArrayList;
import java.util.List;

import types.JsonArrayIndex;
import types.JsonString;

public class JsonPath {
	
	private List<Object> path;
	
	public JsonPath() {
		path = new ArrayList<>();
	}
	
	public JsonPath add(JsonString key) {
		path.add(key);
		return this;
	}
	
	public JsonPath add(JsonArrayIndex index) {
		path.add(index);
		return this;
	}
	
	public JsonPath add(JsonPath leader) {
		path.addAll(leader.path);
		return this;
	}
	
	public String toString() {
		int sz = path.size();
		StringBuffer sb = new StringBuffer();
		for (Object o: path) {
			sb.append(o.toString());
			sb.append((--sz > 0)? "/": "");
		}
		return sb.toString();
	}

}
