package com.product.controller.productlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.PageBar;
import com.product.model.service.ProductService;
import com.product.model.vo.Product;
import static com.common.PageBar.pageBar;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// sort pop/ high/ low
		// category c01/ c02 /c03 /c04 
		// cPage 1
		// numperpage 5
		// keyword
		//
		String sort = request.getParameter("sort");
		 
		
		if(sort == null) {
			sort  = "p_view_count";
		} 
		
		request.setAttribute("sort", sort);
		
		String category = request.getParameter("category");
		
		if(category == null) {
			
			category = "all";
		}
		
		request.setAttribute("category", category);
		
		
		int cPage;
		
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}
		
		
		int numPerPage;
		
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 9;
		}
		
		
		
		List<Product> result = new ProductService().selectAllProduct(cPage, numPerPage,sort,category);
		
		int count = new ProductService().countAllProduct(sort, category);
		
		request.setAttribute("result", result);
		
		String url = request.getContextPath()+"/product/list";
		
		PageBar pb = new PageBar();
		
		String pageBar = pb.pageBar(cPage, numPerPage, count, url, category, sort, null);
		
		request.setAttribute("pageBar", pageBar);
		
//		request.setAttribute("pageBar", pageBar(cPage, numPerPage, count, url , category, sort, null));
		
		
		
		// 정렬기준을 보이게 할 flag
		request.setAttribute("sortFlag", "0");
		
		
		request.getRequestDispatcher("/views/product/productlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
