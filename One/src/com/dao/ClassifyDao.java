package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.entity.Classify;

public class ClassifyDao extends BaseDao{
   
	public static List<Classify> getClassifies()
	{
		return (List<Classify>) BaseDao.getList("Classify");
	}
	
    public static List<Classify> getClassifyById(String cid)
    {
    	List<Classify> list=new ArrayList<Classify>();
    	
    	if(getClassifies().size()>0)
    	{
    		for(Classify i:getClassifies())
        	{
        		if(i.getIntro()!=null&&i.getIntro().equals(cid))
        		{
        			System.out.println("------------------------"+cid+"    "+i.getIntro());
        			list.add(i);
        		}
        	}
    	}
    	return list;
    }
    public static List<Classify> getClassifyByFid(int fid)
    {
    	List<Classify> list=new ArrayList<Classify>();
    	for(Classify i:getClassifies())
    	{
    		if(i.getFid()==(fid))
    		{
    			list.add(i);
    		}
    	}
    	return list;
    }
    
}
