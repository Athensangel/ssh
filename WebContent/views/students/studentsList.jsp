<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
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
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 学生管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <a class="button border-main" href="${pageContext.request.contextPath}/students_jumpStudentsAdd.action"><span class="icon-edit"></span> 新增</a>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       	<th width="4%">序号</th>
        <th width="10%">Id</th>
        <th width="10%">姓名</th>
        <th width="10%">年龄</th>       
        <th width="10%">电话号码</th>
         <th width="10%">电子邮箱</th>
        <th width="20%">操作</th>       
      </tr>   
      <c:forEach items="${studentsList }" var="students" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td><input type="checkbox" name="id[]" value="1" />
            ${students.id}</td>
          <td>${students.name}</td>
          <td>${students.age}</td>
          <td>${students.telPhone}</td>
          <td>${students.eMail}</td>
          <td>
          <div class="button-group"> 
           <a class="button border-main" href="${pageContext.request.contextPath}/students_jumpStudnetsUpdate.action?id=${students.id}"><span class="icon-edit"></span>修改</a> 
           <a class="button border-red" href="${pageContext.request.contextPath}/students_deleteStudents.action?id=${students.id}"><span class="icon-trash-o"></span>删除</a> 
          </div>
          </td>
        </tr>
       </c:forEach>   
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
</html>