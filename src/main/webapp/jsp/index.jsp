<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="Ko">
<head>
	<meta charset="utf8">
	<title>Hello Ext</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<!-- 	
	<link rel="stylesheet" type="text/css" href="css/ext-all.css" />
	<script type="text/javascript" src="extjs/ext-debug.js"></script>
	<script type="text/javascript" src="app/app.js"></script>
 -->
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
 *  @RequestParam(value="subject", required=true) String subject,
	@RequestParam(value="message", required=true) String message,
	@RequestParam(value="userId", required=true) String userID,
	@RequestParam(value="nickName", required=true) String nickName,
	@RequestParam(value="parentMessageCode", required=true) int parentMessageCode,
	@RequestParam(value="parentMessageLevel", required=true) int parentMessageLevel,
	@RequestParam(value="secretCode", required=true) String secretCode,
	@RequestParam(value="topFlag", required=true) int topFlag,
	@RequestParam(value="tags", required=true) String tags
 */
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
</script>
</body>
</html>