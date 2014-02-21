package com.xaxis.bbs.common.util.model;

import java.util.HashMap;
import java.util.Map;

public class TreeGroup extends TreeItem{
	 private Map<String, Object> properties;

     public Object getValue(Object key) {
         return properties.get(key);
     }

     public Object putValue(String key, Object value) {
         return properties.put(key, value);
     }

     public TreeGroup () {
         super();
         properties = new HashMap<String, Object>();
     }
}
