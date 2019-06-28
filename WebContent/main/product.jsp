<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	/* 购买时，点击添加进入订单项 传入一个bookid */
	function addCart(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/cart/addBook.do?id="+id+"&time="+new Date().getTime());
		setTimeout("t1('"+id+"')",10);
		setTimeout("t2('"+id+"')",1000);
		setTimeout("t3('"+id+"')",1500);
	}
	/*0秒   从点击购买小图标           1秒  到反应小图标          1.5秒 到购买成功的对勾小图标*/
	function t1(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/load.gif");
	}
	function t2(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/label3.gif");
	}
	function t3(id) {
		$("#buy"+id).prop("src","${pageContext.request.contextPath}/images/buttom_goumai.gif");
	}
	</script>
</head>
<body>
<c:forEach var='c1' items="${requestScope.product }">
	<div style="width: 60%;margin:20px auto;">
		<div style="width:100%;float: left;">
			<h1>
				${c1.ddProductName }
			</h1>
			<div>
				<div style="float: left;width:20%;">
					<img
						src="${pageContext.request.contextPath}/productImages/${c1.ddProductImg }"
						border=0 />
				</div>
				<div style="float: left;width:80%">
					<ul class="info">
						<li>作&nbsp;者：${c1.ddProductAuthor }</li>
						<li>出版社：${c1.ddProductPress }</li>
						<li style="float:left;width:50%;">
							出版时间：${c1.ddProductPresstime }
						</li>
						<li style="float:left;width:50%;">
							字数：${c1.ddProductWordcount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							版本号：${c1.ddProductEdition }
						</li>
						<li style="float:left;width:50%;">
							页数：${c1.ddProductPagecount }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印刷时间：${c1.ddProductPrinttime }
						</li>
						<li style="float:left;width:50%;">
							页面规格：${c1.ddProductFormat }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							印次：${c1.ddProductPrintcount }
						</li>
						<li style="float:left;width:50%;">
							纸张：${c1.ddProductPaper }
						</li>
						<li style="float:clear;"></li>
						<li style="float:left;width:50%;">
							ISBN：${c1.ddProductIsbn }
						</li>
						<li style="float:left;width:50%;">
							包装：${c1.ddProductPack }
						</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='../main/main.jsp'>当当图书</a> &gt;&gt; 
								<font style='color: #cc3300'> 
									<strong> 图书展示
									</strong>
								</font>
							</div>
						</li>
						<li>定价：￥${c1.ddProductPrice }&nbsp;&nbsp;
							当当价：￥${c1.ddProductDdprice }&nbsp;&nbsp; 
							节省：￥${c1.ddProductPrice -  c1.ddProductDdprice}</li>
						<li><a href="javascript:void(0)"> <img
								src='../images/buttom_goumai.gif' class="abc"
								id="buy${c1.ddProductId }"
								onclick="addCart('${c1.ddProductId }')" />
								
						</a></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>

		<div style="width:100%;float: left;">
			<hr width="" size="1">
				<div>
					<h2>编辑推荐</h2>
					${c1.ddProductRecommend }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>内容简介</h2>
					${c1.ddProductBrief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>作者简介</h2>
					${c1.ddProductAuthorbrief }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>目录</h2>
					${c1.ddProductDirectory }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>媒体评论</h2>
					${c1.ddProductMediacomment }
				</div>
			</hr>
			<hr width="" size="1">
				<div>
					<h2>书摘插图</h2>
					${c1.ddProductExcerpt }
				</div>
			</hr>
			<div>
				<div style="float: clear"></div>
				<p>&nbsp;</p>
			</div>
		</div>
	</div>
	</c:forEach>
	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>