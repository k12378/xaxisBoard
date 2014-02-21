package com.xaxis.bbs.common.util.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class TreeItem implements Iterable<TreeItem>{
	private Map<String, TreeItem> children;     
    private String name;

    public TreeItem() {
        children = new HashMap<String, TreeItem>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(String key, TreeItem data) 
    {           
        children.put(key, data);
    }

    public TreeItem getChild(String key) 
    {           
        return children.get(key);
    }

    public boolean hasChild(String key) 
    {           
        return children.containsKey(key);
    }

    @Override
    public Iterator<TreeItem> iterator() {          
        return children.values().iterator();
    }
}

