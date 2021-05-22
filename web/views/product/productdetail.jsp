<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp" %>


<main>
	<div id="choice-container">
	<div id="item-img">
		<img src="<%=request.getContextPath() %>/images/pants1.jpg" style='width : 100%; height : 100%;'>
	</div>
	
	<div id="item-comment">
		<table id="comment-table">
			<tr>
				<td class="text-style">상품명</td>
			</tr>
			<tr>
				<td class="item-price">가격</td>
			</tr>
			<tr>
				<td>
					<span>color</span>
					<form>
						<select>
							<option value="none">  -[필수] 옵션을 선택하세요.  </option>
							<option value="free"> - free</option>
						</select>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<span>size</span>
					<form>
						<select>
							<option value="none">  -[필수] 옵션을 선택하세요.  </option>
							<option value="free"> - free</option>
						</select>
					</form>
				</td>
			</tr>
		</table>
		<div id ="total">
				total quantity + total price
		</div>
		<div id="btn">
				a태그로 버튼 형태 만들어주기 (add to cart / buy it now)	
		</div>
		</div>
	</div>

	<div id="info-container">
		<ul class="info-bar">
			<li>DETAILS</li>
			<li>NOTICE</li>
			<li>REVIEW</li>
			<li>Q&A</li>
		</ul>
	</div>
</main>

</body>
</html>