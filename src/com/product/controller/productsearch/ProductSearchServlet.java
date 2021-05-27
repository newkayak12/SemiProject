package com.product.controller.productsearch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.service.ProductService;
import com.product.model.vo.Product;


@WebServlet("/product/searchProduct")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductSearchServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String keyword = request.getParameter("keyword");
		
		ProductService service = new ProductService();
		
		List<Product> searchResult = service.searchProduct(keyword);
		
		
		// productlist.jsp 에서 request.getAttribute("result");로 불러오기떄문에 key를 맞춰줘야함
		request.setAttribute("result", searchResult);
		
		
		
		// 페이지바 만드는 과정 있어야함
		// jsp에 검색결과 출력용 페이지바가 따로 필요하기 떄문에
		
		
		
		
		
		
		
		
		
		
		
		
		request.setAttribute("pageBar", keyword);
		
		
	
		// 정렬기준을 안보이게 할 flag
		request.setAttribute("sortFlag", "1");
		
		
		
		// 검색어 유지
		request.setAttribute("keyword", keyword);
		
		

		
		request.getRequestDispatcher("/views/product/productlist.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
