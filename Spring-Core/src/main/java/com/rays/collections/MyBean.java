package com.rays.collections;

import java.util.List;
import java.util.Map;

public class MyBean {
	
	private List<String> list;
	private Map<String, Object> map;
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void diplayData() {
		System.out.println("List element :"+list);
		System.out.println("Map entities :"+map);
	}

}
