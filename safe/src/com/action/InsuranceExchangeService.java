package com.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import com.action.BaseAction;
import com.dao.InsuranceExchangeDao;
import com.entity.InsuranceExchange;
import com.tool.Tool;

import net.sf.json.JSONArray;

public class InsuranceExchangeService extends BaseAction {

	/**
	 * 
	 */
	   private static final long serialVersionUID = 1L;
	   private InsuranceExchange insuranceExchange;
	 
	
		public InsuranceExchange getInsuranceExchange() {
		return insuranceExchange;
	    }
	public void setInsuranceExchange(InsuranceExchange insuranceExchange) {
		this.insuranceExchange = insuranceExchange;
	}
	 /*添加信息*/
		public String add()
		{
			
			baseEntity=insuranceExchange;
			
			return super.add();
		}
		/*修改*/
		public String update()
		{
			baseEntity=insuranceExchange;
			Tool.createExcel(insuranceExchange,false);
			return super.update();
		}
	    /*删除*/
		public String delete()
		{
			baseEntity=insuranceExchange;
			Tool.deleteExcel(insuranceExchange);
			return super.delete();
		}
//		获取信息 通过员工号
		public String getInsuranceExchangeInfo()
		{
			List<InsuranceExchange> list=InsuranceExchangeDao.getInsuranceExchangeList(insuranceExchange.getUseNumber());
			JSONArray jsonArray=JSONArray.fromObject(list);
			try {
				response.getOutputStream().write(jsonArray.toString().getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return NONE;
		}
}
