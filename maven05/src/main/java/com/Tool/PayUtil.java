package com.Tool;

import java.util.HashMap;
import java.util.Map;

import com.pingplusplus.Pingpp;
import com.pingplusplus.exception.APIConnectionException;
import com.pingplusplus.exception.APIException;
import com.pingplusplus.exception.AuthenticationException;
import com.pingplusplus.exception.InvalidRequestException;
import com.pingplusplus.model.Charge;

/*支付工具*/
public class PayUtil {
 public static void charge()
 {
	 Charge charge=null;
	 
	 Pingpp.apiKey="test";
	 Map<String, Object>param=new HashMap<String, Object>();
	 param.put("order_no","1234");
	 param.put("amount", 0.01);
	 
	 
	 Map<String, String> app=new HashMap<String, String>();
	 
	 app.put("app", "app");
	 param.put("app", app);
	 param.put("channel","支付方式");
	 param.put("currency","cny");
	 param.put("client_ip", "127.0.0.1");
	 param.put("subject","标题");
	 param.put("body", "");
	 try {
		charge=Charge.create(param);
	} catch (AuthenticationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidRequestException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (APIConnectionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (APIException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
}
