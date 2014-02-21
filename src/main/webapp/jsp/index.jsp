<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String rootContext = request.getContextPath();
	String boardCode = request.getParameter("boardCode");
	String searchField = request.getParameter("searchField");
	String searchValue = request.getParameter("searchvalue");
 %>
<!DOCTYPE html>
<html lang="Ko">
<head>
	<meta charset="utf8">
	<title>Hello Ext</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=rootContext%>/css/ext-all.css" />
	<script type="text/javascript" src="<%=rootContext%>/extjs/ext-all.js"></script>
	<script type="text/javascript" src="<%=rootContext%>/app/admin/app.js"></script>
	<script type="text/javascript">
		var contextRoot = "<%=rootContext%>";
		var boardCode = "<%=boardCode%>";
		var searchField = "<%=searchField%>";
		var searchValue = "<%=searchValue%>";
		
	</script>
</head>
<body>
<script type="text/javascript">
/*
$(document).ready(function(){
	$.ajax({
		url : "/xaxisBoard/category/item/update/000000001/",
		type : "post",
		data : {"categoryName" : encodeURIComponent("카테고리11")},
		dataType: "json",
		error : function(jqXHR, textStatus, errorThrown){
			alert(textStatus);
		},
		success : function(responseData){
			alert( responseData["responseData"]["result"] );	
		}
	});
});
*/
/*
$(document).ready(function(){
	$.ajax({
		url : "/xaxisBoard/board/add/",
		type : "post",
		data : {
					"boardCode" : encodeURIComponent("InsertTestBoard"),
					"categoryCode" : encodeURIComponent("1"),
					"typeCode" : encodeURIComponent("bbs"),
					"adminFlag" : encodeURIComponent("1"),
					"replyFlag" : encodeURIComponent("1"),
					"commentFlag" : encodeURIComponent("1"),
					"attchementFlag" : encodeURIComponent("1"),
					"secretFlag" : encodeURIComponent("1"),
					"recommendateFlag" : encodeURIComponent("1"),
					"userId" : encodeURIComponent("rmkdev")
			   },
		dataType: "json",
		error : function(jqXHR, textStatus, errorThrown){
			alert(textStatus);
		},
		success : function(responseData){
			alert( responseData["responseData"]["result"] );	
		}
	});
});
*/

/*
 $(document).ready(function(){
		$.ajax({
			url : "/xaxisBoard/board/InsertTestBoard/item/add/",
			type : "post",
			data : {
						"subject" : encodeURIComponent("TestSubject"),
						"message" : encodeURIComponent("Test Message From Xaxis"),
						"userId" : encodeURIComponent("rmkdev"),
						"nickName" : encodeURIComponent("관리자"),
						"parentMessageCode" : encodeURIComponent("0"),
						"parentMessageLevel" : encodeURIComponent("0"),
						"secretCode" : encodeURIComponent("qlalf"),
						"topFlag" : encodeURIComponent("0"),
						"tags" : encodeURIComponent("tag1,tag2")						
				   },
			dataType: "json",
			error : function(jqXHR, textStatus, errorThrown){
				alert(textStatus);
			},
			success : function(responseData){
				alert( responseData["responseData"]["result"] );	
			}
		});
	});
*/
/*	
	$(document).ready(function(){
		$.ajax({
			url : "/xaxisBoard/board/InsertTestBoard/item/4/update/",
			type : "post",
			data : {
						"subject" : encodeURIComponent("updateTestSubject"),
						"message" : encodeURIComponent("Test Message From Xaxis Board update"),
						"messageContentId" : encodeURIComponent("23"),
						"userId" : encodeURIComponent("rmkdev"),
						"nickName" : encodeURIComponent("관리자"),
						"parentMessageCode" : encodeURIComponent("0"),
						"parentMessageLevel" : encodeURIComponent("0"),
						"secretCode" : encodeURIComponent("qlalf"),
						"topFlag" : encodeURIComponent("0"),
						"tags" : encodeURIComponent("tag1,tag2")						
				   },
			dataType: "json",
			error : function(jqXHR, textStatus, errorThrown){
				alert(textStatus);
			},
			success : function(responseData){
				alert( responseData["responseData"]["result"] );
			}
		});
	});
*/

/*
$(document).ready(function(){
	$.ajax({
		url : "/xaxisBoard/board/InsertTestBoard/item/4/delete/",
		type : "post",
		data : {
					"userId" : encodeURIComponent(""),
					"secretCode" : encodeURIComponent("qlalf")
			   },
		dataType: "json",
		error : function(jqXHR, textStatus, errorThrown){
			alert(textStatus);
		},
		success : function(responseData){
			alert( responseData["responseData"]["result"] );
		}
	});
});
*/

</script>
</body>
</html>