<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user_updateUser.action">
<input type="hidden" name="id" value="${currentUser.id}"/>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户修改</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="20%">Id</th>
        <th width="20%">账号</th>       
        <th width="20%">密码</th>
        <th width="40%">操作</th>       
      </tr>   
        <tr>
          <td><input type="checkbox" name="id[]" value="1" />
            ${currentUser.id}</td>
          <td><input type="text" name="userName" value="${currentUser.userName}"/></td>
          <td><input type="text" name="passWord" value="${currentUser.passWord}"/></td>
          <td>
          <div class="button-group"> 
           <%-- <a class="button border-green" href="${pageContext.request.contextPath}/user_jumpUserUpdate.action"><span class="icon-trash-o"></span>修改</a>  --%>
          <input type="submit" value="修改"/>
          </div>
          </td>
        </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>