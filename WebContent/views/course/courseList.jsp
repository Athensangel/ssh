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
        <th width="10%">课程代码</th>
        <th width="10%">课程名称</th>
        <th width="10%">选修课程</th>       
        <th width="10%">学分</th>
        <th width="20%">操作</th>       
      </tr>   
      <c:forEach items="${pageBean.list }" var="course" varStatus="status">
        <tr>
          <td>${status.index + 1}</td>
          <td><input type="checkbox" name="cno[]" value="1" />
            ${course.cno}</td>
          <td>${course.cname}</td>
          <td>${course.cpno}</td>
          <td>${course.credit}</td>
          <td>
          <div class="button-group"> 
           <a class="button border-main" href="${pageContext.request.contextPath}/course_jumpStudnetsUpdate.action?cno=${course.cno}"><span class="icon-edit"></span>修改</a> 
           <a class="button border-red" href="${pageContext.request.contextPath}/course_deleteStudents.action?cno=${course.cno}"><span class="icon-trash-o"></span>删除</a> 
          </div>
          </td>
        </tr>
       </c:forEach>   
       <tr>
                     <td width="13%" class="tocenter">
                         共
                         <s:property value="pageBean.totalPage" />
                         页
                     </td>
                     <td width="17%" class="tocenter">
                         共
                         <s:property value="pageBean.allRow" />
                         条记录
                     </td>
                     <td width="15%" class="tocenter">
                         当前第
                         <s:property value="pageBean.currentPage" />
                         页
                     </td>
                     <td colspan="4" width="55%" class="tocenter">
                         <s:if test="%{pageBean.currentPage == 1}">第一页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
                         <s:else>
                             <a href="${pageContext.request.contextPath}/course_getCoursePageList.action?page=1">第一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
                             <a href="${pageContext.request.contextPath}/course_getCoursePageList.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
                         </s:else>
                         <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
                             <a href="${pageContext.request.contextPath}/course_getCoursePageList.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
                             <a href="${pageContext.request.contextPath}/course_getCoursePageList.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
                         </s:if>
                         <s:else>下一页&nbsp;&nbsp;&nbsp;&nbsp; 尾页</s:else>
                     </td>
                 </tr>
                 
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