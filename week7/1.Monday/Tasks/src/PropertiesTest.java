import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesTest {
	static File file=null;
	static Map<String,String> testMap;
	
	@BeforeClass
	public static void initPropertiesTest(){
		file=new File("properties.txt");
		testMap=new HashMap<>();
		testMap.put("a1", "b1");
		testMap.put("a2", "b2");
		testMap.put("a3", "b3");
		testMap.put("a4", "b4");
		testMap.put("a5", "b6=b7=b8");
		testMap.put("a6", "b9 #comment");
		testMap.put("a7", "=b10");
	}
	@Test
	public void testParseProperties() throws IOException {
		assertEquals(testMap, Properties.parseProperties(file));
	}

}
