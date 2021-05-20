package com.common;

public class PageBar{
	public PageBar() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * table : 쿼리를 보낼 테이블
	 * cPage : 현재 페이지
	 * numPerPage : 페이지 당 데이터의 수
	 * totalData : 전체데이터의 수
	 * url : 페이지바를 보낼 url
	 * keyword : 검색어
	 * searchType : 검색 타입
	 */
	public static String pageBar( int cPage, int numPerPage, int totalData, String url) {
		String html = "";
		
		int pageBarSize =5;
		int totalPage = (int) (Math.ceil((double)totalData/numPerPage));
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		
		
		
				if(pageNo == 1) {
						html+="<span>&nbsp;&nbsp;</span>";
				} else {
						html+= "<a href='"+url+"?cPage="+1+"&numPerPage="+numPerPage+"'> << </a>";
				}
					
		
		
		
				if(pageNo == 1) {
						html+="<span>&nbsp;&nbsp;</span>";
				} else {
						html+= "<a href='"+url+"?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'> < </a>";
				}
				
				while(!(pageNo>pageEnd || pageNo>totalPage)) {
							if( pageNo == cPage) {
								html+="<span>"+pageNo+"</span>";
							} else {
								html+= "<a href='"+url+"?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+ pageNo +" </a>";
							}
							
						pageNo++;
				}
				
				if(pageNo>totalPage) {
					html+="<span>&nbsp;&nbsp;</span>";
				} else {
					html+= "<a href='"+url+"?cPage="+pageNo+"&numPerPage="+numPerPage+"'> > </a>";
				}
				
				
				
				
				if(pageNo>totalPage) {
					html+="<span>&nbsp;&nbsp;</span>";
				} else {
					html+= "<a href='"+url+"?cPage="+totalPage+"&numPerPage="+numPerPage+"'> >> </a>";
				}
		
				
		
		return html;
	}
	
	
	
	
	public static String pageBar( int cPage, int numPerPage, int totalData, String url, String keyword, String searchType) {
		int pageBarSize =5;
		int totalPage = (int) (Math.ceil((double)totalData/numPerPage));
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo+pageBarSize-1;
		String html="";
		
			
						
			
					if(pageNo == 1) {
							html+="<span>&nbsp;&nbsp;</span>";
					} else {
						html+= "<a href='"+url+"?cPage="+1+"&numPerPage="+numPerPage+"&keyword="+keyword+"&searchType="+searchType+"'> << </a>";
					}
							
			
			
					if(pageNo == 1) {
							html+="<span>&nbsp;&nbsp;</span>";
					} else {
							html+= "<a href='"+url+"?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"&keyword="+keyword+"&searchType="+searchType+"'> < </a>";
					}
					
					while(!(pageNo>pageEnd || pageNo>totalPage)) {
								if( pageNo == cPage) {
									html+="<span>"+pageNo+"</span>";
								} else {
									html+= "<a href='"+url+"?cPage="+pageNo+"&numPerPage="+numPerPage+"&keyword="+keyword+"&searchType="+searchType+"'>"+ pageNo +" </a>";
								}
								
							pageNo++;
					}
					
					if(pageNo>totalPage) {
						html+="<span>&nbsp;&nbsp;</span>";
					} else {
						html+= "<a href='"+url+"?cPage="+pageNo+"&numPerPage="+numPerPage+"&keyword="+keyword+"&searchType="+searchType+"'> > </a>";
					}
		
					
					
					if(pageNo>totalPage) {
						html+="<span>&nbsp;&nbsp;</span>";
					} else {
						html+= "<a href='"+url+"?cPage="+totalPage+"&numPerPage="+numPerPage+"&keyword="+keyword+"&searchType="+searchType+"'> >> </a>";
					}

			
		return html;
	}
}
