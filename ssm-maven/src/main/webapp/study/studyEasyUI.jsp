<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Panel - jQuery EasyUI Demo1</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
</head>

<script type = "text/javascript">
function openorclose(){
	var openStr = document.getElementById("open").style.display;
	var closeStr = document.getElementById("close").style.display;
	if(openStr == 'none'){
		document.getElementById("close").style.display='none';
		document.getElementById("open").style.display='block';
	}else{
		document.getElementById("close").style.display='block';
		document.getElementById("open").style.display='none';
	}
	
	
	
	
}
function expandorcollapse(){
	
}

</script>

<body>
	<h2>Basic Panel</h2>
	<p>The panel is a container for other components or elements.</p>
	<div style="margin:20px 0 10px 0;">
	<span>
		<a href="#" class="easyui-linkbutton"  id ="open" style = "display:none" onclick="openorclose()">显示</a>
		<a href="#" class="easyui-linkbutton" id = "close"  onclick="openorclose()">关闭</a>
		<a href="#" class="easyui-linkbutton" id = "expand" style = "display:none" onclick="expandorcollapse()">展开</a>
		<a href="#" class="easyui-linkbutton" id = "collapse"  onclick="expandorcollapse()">折叠</a>
	</span>
	</div>
	<div id="p" class="easyui-panel" title="Basic Panel" style="width:700px;height:200px;padding:10px;">
		<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
		<ul>
			<li>${pageContext.request.contextPath}</li>
			<li>主要掌握$("id").panel('open')</li>
			<li>主要掌握$("id").panel('close')</li>
			<li>隐藏开关</li>
			<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
			<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
			<li>complete framework for HTML5 web page.</li>
			<li>easyui save your time and scales while developing your products.</li>
			<li>easyui is very easy but powerful.</li>
		</ul>
	</div>
</body>

<script type="text/javascript">
function EI1(){
	alert(1);
}

</script>
</html>