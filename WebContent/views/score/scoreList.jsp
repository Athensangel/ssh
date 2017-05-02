<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
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
    <div class="panel-head"><strong class="icon-reorder"> 分数管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <a class="button border-main" href="${pageContext.request.contextPath}/score_jumpScoreAdd.action"><span class="icon-edit"></span> 新增</a>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
       	<th width="4%">序号</th>
       	<th width="4%">id</th>
        <th width="10%">分数</th>
        <th width="10%">课程Id</th>
        <th width="10%">学生Id</th>       
        <th width="20%">操作</th>       
      </tr>   
      <c:forEach items="${scoresList}" var="score" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td>
            ${score.id}</td>
          <td>${score.score}</td>
          <td>${score.courseId}</td>
          <td>${score.stuId}</td>
          <td>
          <div class="button-group"> 
           <a class="button border-main" href="${pageContext.request.contextPath}/score_jumpScoreUpdate.action?id=${score.id}"><span class="icon-edit"></span>修改</a> 
           <a class="button border-red" href="${pageContext.request.contextPath}/score_deleteScore.action?id=${score.id}"><span class="icon-trash-o"></span>删除</a> 
          </div>
          </td>
        </tr>
       </c:forEach>   
   <%--    <tr>
        <td colspan="8">
          <div class="pagelist"> 
        <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> 
          </div>
        </td>
      </tr> --%>
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