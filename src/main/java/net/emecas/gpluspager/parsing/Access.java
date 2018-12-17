package net.emecas.gpluspager.parsing;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Access {
	private String kind;
	private String description;
	private ArrayList<?> items;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<?> getItems() {
		return items;
	}
	public void setItems(ArrayList<?> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return String.format("Access [kind=%s, description=%s, items=%s]", kind, description, items);
	}
	
	
}
