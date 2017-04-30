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
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <a class="button border-main" href="${pageContext.request.contextPath}/teacher_jumpTeacherAdd.action"><span class="icon-edit"></span> 新增</a>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
          <a class="button border-main" href="${pageContext.request.contextPath}/user_exportUserExcel.action"><span class="icon-edit"></span>导出</a>
          <a class="button border-main" href="${pageContext.request.contextPath}/user_exportUserExcel2.action"><span class="icon-edit"></span>导出2</a>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       	<th width="4%">序号</th>
        <th width="10%">Id</th>
        <th width="10%">密碼</th>
        <th width="10%">账号</th>       
        <th width="10%">性別</th>
        <th width="10%">生日</th>
        <th width="10%">学院编号</th>
        <th width="10%">工号</th>
        <th width="10%">所在省份</th>
        <th width="10%">所在城市</th>
        <th width="10%">联系方式</th>
        <th width="10%">职称</th>
        <th width="20%">操作</th>       
      </tr>   
      <c:forEach items="${teacherList }" var="teacher" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td><input type="checkbox" name="id[]" value="1" />
            ${teacher.id}</td>
          <td>${teacher.password}</td>
          <td>${teacher.name}</td>
          <td>${teacher.sex}</td>
          <td>${teacher.brithday}</td>
          <td>${teacher.collegeid}</td>
          <td>${teacher.post}</td>
          <td>${teacher.province}</td>
          <td>${teacher.city}</td>
          <td>${teacher.phone}</td>
          <td>${teacher.title}</td>
          <td>
          <div class="button-group"> 
           <a class="button border-main" href="${pageContext.request.contextPath}/teacher_jumpTeacherUpdate.action?id=${teacher.id}"><span class="icon-edit"></span>修改</a> 
           <a class="button border-red" href="${pageContext.request.contextPath}/teacher_deleteTeacher.action?id=${teacher.id}"><span class="icon-trash-o"></span>删除</a> 
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
</body></html>