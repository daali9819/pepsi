<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'nav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="common.jsp" %>

  </head>
  
  <body>
  	<script type="text/javascript" src="sys/js/nav.js"></script>
    	<div id = "dede" class="easyui-accordion"  data-options="fit:true">
    		<c:forEach items="${sessionScope.login_user.role.rolesysrights }" var="roleRight">
    			<c:if test="${roleRight.sysright.parent == null }">
		    		<div title="${roleRight.sysright.text }" data-options="iconCls:'${roleRight.sysright.iconCls }'">
		    			<ul class="easyui-tree  tree">
		    				<c:forEach items="${sessionScope.login_user.role.rolesysrights }" var="roleRight2">
		    					<c:if test="${roleRight2.sysright.parent != null  && roleRight2.sysright.parent.sysrightId == roleRight.sysright.sysrightId}">
			    					<li data-options="iconCls:'${roleRight2.sysright.iconCls }',attributes:{url:'${ roleRight2.sysright.url}'}"><span>${roleRight2.sysright.text }</span></li>
			    				</c:if>
		    				</c:forEach>
		    			</ul>
		    		</div>
    		</c:if>
    		</c:forEach>
    	</div>
  </body>
</html>























