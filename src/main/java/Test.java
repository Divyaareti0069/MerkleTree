import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		Map<String, Integer> collect = new LinkedHashMap<>();
         
		collect.put("1", Integer.valueOf(1));
		collect.put("2", Integer.valueOf(2));
		collect.put("3", Integer.valueOf(3));
		collect.put("4", Integer.valueOf(4));

        collect.forEach((k, v) -> System.out.println(k + ":" + v));


	}

}
