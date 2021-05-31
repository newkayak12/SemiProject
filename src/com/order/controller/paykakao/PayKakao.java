package com.order.controller.paykakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/
import com.google.gson.Gson;





/**
 * Servlet implementation class PayKakao
 */


@WebServlet("/pay/kakao")
public class PayKakao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayKakao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* POST /v1/payment/ready HTTP/1.1
		Host: kapi.kakao.com
		Authorization: KakaoAK {"7be18bb35d4598742bb7e4f4c82ab6d0"}
		Content-type: application/x-www-form-urlencoded;charset=utf-8
		
		
		
		
		 */
		 
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready HTTP/1.1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK 7be18bb35d4598742bb7e4f4c82ab6d0");
		conn.setRequestProperty("Accept", "application/json;charset=utf-8");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cid", "TC0INETIME");
		params.put("partner_order_id", "KLIEDUNG");
		params.put("partner_user_id","BS");
		params.put("item_name", "TEST1");
		params.put("item_code", "TEST2");
		params.put("quantity", "1");
		params.put("total_amount", "2000");
		params.put("tax_free_amount", "0");
		params.put("approval_url", request.getContextPath()+"/order/pay/kakao/receive");
		params.put("cancel_url", request.getContextPath()+"/order/pay/kakao/cancel");
		params.put("fail_url", request.getContextPath()+"/order/pay/kakao/fail");
		
		
		
		String string_params = new String();
		for(Map.Entry<String,String> elem : params.entrySet()) {
				string_params += (elem.getKey()+"="+elem.getValue()+"&");
				
				
		}
		
		System.out.println(string_params);
		
		
		conn.getOutputStream().write(string_params.getBytes());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		/* JSONParser parser = new JSONParser(); */
//			try {
////				JSONObject obj = (JSONObject)parser.parse(in);
////				String successUrl = (String)obj.get(request.getContextPath()+"/views/pay/temp.jsp");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("connencted");
		
			
			response.setContentType("application/json;charset=utf-8;");
			Gson gson = new Gson();
			gson.toJson(in,response.getWriter());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
