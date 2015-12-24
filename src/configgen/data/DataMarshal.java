package configgen.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import configgen.Main;


public final class DataMarshal {
	private final List<String> line = new ArrayList<>();
	
	private DataMarshal put(String x) {
		line.add(x);
		return this;
	}
	
	public DataMarshal putBool(boolean x) {
		return put(x ? "true" : "false");
	}
	
	public DataMarshal putInt(int x) {
		return put(Integer.toString(x));
	}
	
	public DataMarshal putLong(long x) {
		return put(Long.toString(x));
	}
	
	public DataMarshal putFloat(double x) {
		return put(Double.toString(x));
	}
	
	public DataMarshal putString(String x) {
		return put(x.replace("\n", Main.magicStringForNewLine));
	}
	
	public String toData() {
		final ArrayList<String> newLines = new ArrayList<String>(line);
		newLines.add("");
		return newLines.stream().collect(Collectors.joining("\n"));
	}
}
