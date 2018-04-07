package com.Tool;


import java.util.Calendar;  
import java.util.HashMap;  
import java.util.Map;  
  
import com.pingplusplus.exception.PingppException;  
import com.pingplusplus.model.Charge;  
  
/** 
 * @author why 
 * 
 */  
/** 
 *  alipay:支付宝手机支付 
 *  alipay_wap:支付宝手机网页支付 
 *  alipay_qr:支付宝扫码支付 
 *  alipay_pc_direct:支付宝 PC 网页支付 
 *  bfb:百度钱包移动快捷支付 
 *  bfb_wap:百度钱包手机网页支付 
 *  upacp:银联全渠道支付（2015 年 1 月 1 日后的银联新商户使用。若有疑问，请与 Ping++ 或者相关的收单行联系） 
 *  upacp_wap:银联全渠道手机网页支付（2015 年 1 月 1 日后的银联新商户使用。若有疑问，请与 Ping++ 或者相关的收单行联系） 
 *  upacp_pc:银联 PC 网页支付 
 *  cp_b2b:银联企业网银支付 
 *  wx:微信支付 
 *  wx_pub:微信公众号支付 
 *  wx_pub_qr:微信公众号扫码支付 
 *  wx_wap:微信WAP支付 
 *  yeepay_wap:易宝手机网页支付 
 *  jdpay_wap:京东手机网页支付 
 *  cnp_u:应用内快捷支付（银联） 
 *  cnp_f:应用内快捷支付（外卡） 
 *  applepay_upacp:Apple Pay 
 *  fqlpay_wap:分期乐支付 
 *  qgbc_wap:量化派支付 
 *  cmb_wallet:招行一网通 
 */  
public class MyPayUtil  {  
    private String appId;    
    private com.Entity.Charge charge;
    MyPayUtil () {    
     
    }    
    public MyPayUtil(com.Entity.Charge charge) {
		// TODO Auto-generated constructor stub
    	this.charge=charge;
	}
    /** 
     * 支付方法 
     * @param orderNo 
     * @param amount 
     * @param subject 
     * @param body 
     * @param channel 
     * @param clientIP 
     * @return 
     */  
    public String createCharge() {    
        Map<String, Object> chargeMap = new HashMap<String, Object>();    
        chargeMap.put("amount", charge.getAmount());//金额    
        chargeMap.put("currency", charge.getCurrency());    
        chargeMap.put("subject", charge.getSubject());    
        chargeMap.put("body", charge.getBody());    
        chargeMap.put("order_no", charge.getOrder_no()); //订单号   
        chargeMap.put("channel", charge.getChannel());  //支付渠道  
        Calendar cal = Calendar.getInstance();    
        cal.add(Calendar.MINUTE, 15);//15分钟失效    
        long timestamp = cal.getTimeInMillis()/ 1000L;    
        chargeMap.put("time_expire", timestamp); //订单失效时间，用 Unix 时间戳表示。时间范围在订单创建后的 1 分钟到 15 天，默认为 1 天，创建时间以 Ping++ 服务器时间为准。 微信对该参数的有效值限制为 2 小时内；银联对该参数的有效值限制为 1 小时内。   
        chargeMap.put("client_ip", charge.getClient_ip()); // 客户端 ip 地址(ipv4)    
        
        //使用app发起支付
        Map<String, String> app = new HashMap<String, String>();    
        app.put("id", charge.getAppid());//支付使用的 app 对象的 id   
        chargeMap.put("app", app);    
        String chargeString = null;    
        try {    
            //发起交易请求    
            Charge charge = Charge.create(chargeMap);    
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串    
            chargeString = charge.toString();  
        } catch (PingppException e) {    
            e.printStackTrace();    
        }    
        return chargeString;    
    }    
}  