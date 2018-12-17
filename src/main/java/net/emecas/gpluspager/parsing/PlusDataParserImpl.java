package net.emecas.gpluspager.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PlusDataParserImpl {
	private static final Logger logger = LoggerFactory.getLogger(PlusDataParserImpl.class);

	
	Map<String,?> parse(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,?> map = objectMapper.readValue(json,  Map.class);
		return map;
	}
	
	List<Item> parseItems(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(json);
        JsonNode itemsNode = rootNode.path("items");
        Iterator<JsonNode> ite = itemsNode.elements();
        List<Item> list = new ArrayList<Item>();
        ite.forEachRemaining(item -> {
			try {
				list.add(objectMapper.treeToValue(item, Item.class));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});
        return list;
	}

}
