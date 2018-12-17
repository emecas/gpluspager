package net.emecas.gpluspager.parsing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import net.emecas.gpluspager.parsing.Item;
import net.emecas.gpluspager.parsing.PlusDataParserImpl;

public class PlusDataParserTest {
	private static final Logger logger = LoggerFactory.getLogger(PlusDataParserTest.class);
	private PlusDataParserImpl target =  new PlusDataParserImpl();

	private String json_a_string;
	private String json_b_string;
	private String json_c_string;
	private String json_d_string;

	@BeforeEach
	public void setUp() throws Exception {
		json_a_string = getFile("emecas-public-a.json");
		json_b_string = getFile("emecas-public-b.json");
		json_c_string = getFile("emecas-public-c.json");
		json_d_string = getFile("emecas-public-d.json");
	}

	@Test
	public void testParse() throws JsonParseException, JsonMappingException, IOException {
		Map<String,?> map = target.parse(json_a_string);
		assertNotNull(map);
		logger.info(" map.keySet() -> "+map.keySet());
		logger.info(" 1***********************************");
		//logger.info(" list -> "+map);
		logger.info(" list.size() -> "+map.size());
		logger.info(" 2***********************************");
		LinkedHashMap<String,?> lhm = (LinkedHashMap<String, ?>)((ArrayList<?>)map.get("items")).get(0);
		logger.info(" 3*********************************** ");
		Set<String> keys = lhm.keySet();
		logger.info(" 4*********************************** ");
		keys.stream().forEach(  key -> logger.info("=>"+ key +" "+ lhm.get(key) + " " +lhm.get(key).getClass() ));
		logger.info(" 5*********************************** ");
		keys.stream().filter( key -> lhm.get(key) instanceof Map ).forEach(  key -> logger.info("--> "+ key +" "+ ((LinkedHashMap)lhm.get(key)).keySet() + " " +lhm.get(key).getClass() ));
		logger.info(" 6*********************************** ");
	}
	
	
	@Test
	public void testParseItems() throws JsonParseException, JsonMappingException, IOException {
		List<Item> list = target.parseItems(json_a_string);
		assertNotNull(list);
		assertEquals(100,list.size());
		assertEquals("#ocaml",list.get(0).getTitle());
		assertEquals("z13gzrvghrfqevk1123mxx54clywfjbak04",list.get(0).getId());
		assertEquals("\"jb1Xzanox6i8Zyse4DcYD8sZqy0/Jr8P4fHNrKcxOQEWoBI5Vua4bwg\"",list.get(0).getEtag());
		assertEquals("2018-07-25T22:30:28.761Z",list.get(0).getPublished());
		logger.info(" list.get(0) -> "+list.get(0));
		
		list = target.parseItems(json_b_string);
		assertNotNull(list);
		assertEquals(100,list.size());
		logger.info(" list.get(0) -> "+list.get(0));
		assertEquals("",list.get(0).getTitle());
		assertEquals("z131vdl5plnlizsta23mxx54clywfjbak04",list.get(0).getId());
		assertEquals("\"jb1Xzanox6i8Zyse4DcYD8sZqy0/w1cr1WxReGwj8OGz9E229pJKHtc\"",list.get(0).getEtag());
		assertEquals("2016-08-20T19:18:03.462Z",list.get(0).getPublished());
		
		list = target.parseItems(json_c_string);
		assertNotNull(list);
		assertEquals(98,list.size());
		logger.info(" list.get(0) -> "+list.get(0));
		assertEquals("",list.get(0).getTitle());
		assertEquals("z12iidba1lq2j3buo23mxx54clywfjbak04",list.get(0).getId());
		assertEquals("\"jb1Xzanox6i8Zyse4DcYD8sZqy0/m8zMWen4hsV0trunCuVk-V6V-wQ\"",list.get(0).getEtag());
		assertEquals("2015-10-21T21:19:37.809Z",list.get(0).getPublished());
		
		list = target.parseItems(json_d_string);
		assertNotNull(list);
		assertEquals(53,list.size());
		logger.info(" list.get(0) -> "+list.get(0));
		assertEquals("",list.get(0).getTitle());
		assertEquals("z13jfnwpgrvvurbwr04cifrool2bvlhwwu00k",list.get(0).getId());
		assertEquals("\"jb1Xzanox6i8Zyse4DcYD8sZqy0/rtoYlb0Ia-ckAGuVOYJ36TfzbF8\"",list.get(0).getEtag());
		assertEquals("2015-03-24T12:44:07.869Z",list.get(0).getPublished());
	}

	private String getFile(String fileName){
		String result = "";
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
