package com.order.controller.orderfinish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.model.service.OrderService;

/**
 * Servlet implementation class OrderFinishServlet
 */
@WebServlet("/order/pay")
public class OrderFinishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFinishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oname = request.getParameter("formnameo");
		String id = request.getParameter("formid");
		String pay = request.getParameter("formbank");
		
		String rname = request.getParameter("formnamer");
		String addr = request.getParameter("formaddr");
		String phone = request.getParameter("formphone");
		String zip = request.getParameter("formzip");
		int totalprice = Integer.parseInt(request.getParameter("totalprice"));
		
		String flag = request.getParameter("flag2");
		String payflag  = request.getParameter("payflag");
		
		System.out.println(oname +":"+ id +":"+ pay +":"+rname +":"+ addr +":"+ phone+":"+ zip+":"+flag+":"+payflag);
		
		
		//카트 cart/ 페이지 page
//		System.out.println(oname+":"+id+":"+pay+":"+rname+":"+addr+":"+phone+":"+zip);
		
		int result = new OrderService().insertOrder(oname,rname,addr,phone,id,zip, totalprice);
		String onum = new OrderService().orderNum(oname,rname);
		System.out.println("numbers  "+onum);
		String cartflag = null;
		
		//////////////
		if(flag.equals("cart")) {
			
			cartflag = request.getParameter("cartflag");
		}
		
		System.out.println(flag);
		System.out.println(cartflag);
// detail - 0
//cart - 1		
		
		
		
		String msg = "";
		if(result>0) {
			//user insert
			if(flag.equals("cart")) {
			
							Cookie[] cookiejar  = request.getCookies();
							String temp = "";
								for(Cookie c : cookiejar) {
				//					쿠키로 추가
									
											if(c.getName().equals("cartlist")) {
													temp=c.getValue();
													temp = temp.substring(1, temp.length());
													
													
														if(cartflag.equals("2")) {	
															String[] temp2 = temp.split("#");
															
															System.out.println("cart many");
																	for(String a : temp2) {
																		
																				System.out.println("cartlisti 2 "+a);
																				
																				
																				String[] b = a.split("@");
											//									#7@L@blue@250000@4@c01
											//									#3@230cm@black@250000@3@c04
																				
																				String pid = b[0];
																				String size = b[1];
																				String color =b[2];
																				String price = b[3];
																				String stock = b[4];
																				String cid = b[5];
																				
																				
																				int result2 = new OrderService().insertOrderDetail(onum, pid, cid, size, color, stock);
																						if(result2>0) {
																							msg = "상품 주문이 완료되었습니다.";
																							
																							Cookie q = new Cookie("cartlist","");
																							q.setMaxAge(1);
																							q.setPath(request.getContextPath()+"/");
																							response.addCookie(q);
																						} else {
																							msg = "상품 주문에 실패했습니다..";
																						}
																		
																	}	
																	
																
																
														}	else  {
								//							카트에 하나
															
															String[] b =temp.split("@");
								//									#7@L@blue@250000@4@c01
								//									#3@230cm@black@250000@3@c04
															System.out.println("cart one");
															
															String pid = b[0];
															String size = b[1];
															String color =b[2];
															String price = b[3];
															String stock = b[4];
															String cid = b[5];
															
															
															int result2 = new OrderService().insertOrderDetail(onum, pid, cid, size, color, stock);
																	if(result2>0) {
																		msg = "상품 주문이 완료되었습니다.";
																		
																		Cookie q = new Cookie("cartlist","");
																		q.setMaxAge(1);
																		q.setPath(request.getContextPath()+"/");
																		response.addCookie(q);
																	} else {
																		msg = "상품 주문에 실패했습니다..";
																	}
															
															
														}
														
											}
									
								}
			
			} else if(flag.equals("page")) {
				
				System.out.println("default shop");
				
				String pid = request.getParameter("pid");
				String category = request.getParameter("category");
				String color = request.getParameter("color");
				String price = request.getParameter("price");
				String stock = request.getParameter("stock");
				String size = request.getParameter("size");
				System.out.println(pid+" : "+category+" : "+color+" : "+price+" : "+stock+" : "+size);
				
				System.out.println("------------- 여기가 실행되야만 한다.");
				
				int result2 = new OrderService().insertOrderDetail(onum, pid, category, size, color, stock);
				if(result2>0) {
					msg = "상품 주문이 완료되었습니다.";
					
					
					
				} else {
					msg = "상품 주문에 실패했습니다..";
				}
				
				
				
			}
			
			
			
			
			
			
		} else {
			msg = "상품 주문에 실패했습니다..";
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//		order table insert
		}
		
		
		
			
			request.setAttribute("msg", msg);
//		
			request.setAttribute("pay", pay);
			
			
			
			String location = request.getParameter("location");
			
			
			if(location!=null) {
				request.getRequestDispatcher(location).forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
