package com.xaxis.bbs.common.util;

import java.util.Arrays;
import java.util.List;

import com.xaxis.bbs.common.util.model.TreeGroup;
import com.xaxis.bbs.common.util.model.TreeItem;

public class TreeManager extends TreeItem
{       
    /**
     * Will add an Item to the tree at the specified path with the value
     * equal to the last item in the path, unless that Item already exists 
     */
    public void addData(List<String> path)
    {
        addData(this, path);
    }

    private void addData(TreeItem parent, List<String> path)
    {
        // if we're at the end of the path - create a node
        String data = path.get(0);
        if(path.size() == 1)
        {
            // unless there is already a node with this name
            if(!parent.hasChild(data))
            {
                TreeGroup group = new TreeGroup();
                group.setName(data);
                parent.addChild(data, group);
            }
        }
        else
        {
            // pass the tail of this path down to the next level in the hierarchy
            addData(parent.getChild(data), path.subList(1, path.size()));
        }
    }

    public TreeGroup getData(String[] path)
    {
        return (TreeGroup) getData(this, Arrays.asList(path));
    }

    public TreeGroup getData(List<String> path)
    {
        return (TreeGroup) getData(this, path);
    }

    private TreeItem getData(TreeItem parent, List<String> path)
    {
        if(parent == null || path.size() == 0)
        {
            throw new IllegalArgumentException("Invalid path specified in getData, remainder: " 
                    + Arrays.toString(path.toArray()));
        }
        String data = path.get(0);
        if(path.size() == 1)
        {
            return parent.getChild(data);
        }
        else
        {
            // pass the tail of this path down to the next level in the hierarchy
            return getData(parent.getChild(data), path.subList(1, path.size()));
        }
    }
}