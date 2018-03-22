package com.action;

import java.io.IOException;
import java.util.List;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassifyDao;
import com.entity.Classify;
import com.opensymphony.xwork2.ActionSupport;

import antlr.build.Tool;
import net.sf.json.JSONArray;

public class ClassifyAction extends BaseAction{
	private List<Classify> list;
    /**
	 * @return the list
	 */
	public List<Classify> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Classify> list) {
		this.list = list;
	}

	private Classify classify;
	/**
	 * @return the classify
	 */
	public Classify getClassify() {
		return classify;
	}

	/**
	 * @param classify the classify to set
	 */
	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public String show()
	{
		list=ClassifyDao.getClassifyById("1");//初次加载产险
		return "list";
	}
	
	public void getClassifyInfo()
	{
		if((Object)classify.getFid()!=null)
		{
			list=ClassifyDao.getClassifyByFid(classify.getFid());
		}
		if(classify.getIntro()!=null)
		{
			list=ClassifyDao.getClassifyById(classify.getIntro());
		}
		JSONArray jsonArray=JSONArray.fromObject(list);
		HttpServletResponse  response=com.tool.Tool.getHttpServletResponse();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonArray.toString());;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String add() {
		if((Object)classify.getId()!=null&&(Object)classify.getFid()==null)
		{
			return "add";
		}
		
     	return show();
	}
}
