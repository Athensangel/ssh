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
<%-- <form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <a class="button border-main" href="${pageContext.request.contextPath}/user_jumpUserAdd.action"><span class="icon-edit"></span> 新增</a>
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
        <tr>
          <td><input name="password" value="${teacher.password}"/></td>
          <td><input name="name" value="${teacher.name}"/></td>
          <td><input name="sex" value="${teacher.sex}"/></td>
          <td><input name="brithday" value="${teacher.brithday}"/></td>
          <td><input name="collegeid" value="${teacher.collegeid}"/></td>
          <td><input name="post" value="${teacher.post}"/></td>
          <td><input name="province" value="${teacher.province}"/></td>
          <td><input name="city" value="${teacher.city}"/></td>
          <td><input name="phone" value="${teacher.phone}"/></td>
          <td><input name="title" value="${teacher.title}"/></td>
          <td>
          <div class="button-group"> 
           <a class="button border-red" href="${pageContext.request.contextPath}/teacher_jumpTeacherAdd.action?id=${teacher.id}"><span class="icon-trash-o"></span>新增</a> 
          </div>
          </td>
        </tr>
    </table>
  </div>
</form> --%>
<div class="panel admin-panel margin-top">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/teacher_updateTeacher.action">   
     <input type="hidden" name="id" value="${currentTeacher.id }"/>
      <div class="form-group">
        <div class="label">
          <label>密碼：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="password" value="${currentTeacher.password}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="name" value="${currentTeacher.name}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>性別：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="sex" value="${currentTeacher.sex}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>生日：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="brithday" value="${currentTeacher.brithday}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>学院编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="collegeid" value="${currentTeacher.collegeid}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>工号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="post" value="${currentTeacher.post}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>所在省份：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="province" value="${currentTeacher.province}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>所在城市：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="city" value="${currentTeacher.city}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>联系方式：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="phone" value="${currentTeacher.phone}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
       <div class="form-group">
        <div class="label">
          <label>职称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="title" value="${currentTeacher.title}" data-validate="required:请输入标题" />         
          <div class="tips"></div>
        </div>
      </div> 
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
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