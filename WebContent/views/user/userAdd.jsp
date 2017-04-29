<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
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
<%-- <form method="post" action="${pageContext.request.contextPath}/user_saveUser.action">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户新增</strong></div>
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
            </td>
          <td><input type="text" name="userName"/></td>
          <td><input type="text" name="passWord"/></td>
          <td>
          <div class="button-group"> 
           <a class="button border-green" href="${pageContext.request.contextPath}/user_jumpUserAdd.action"><span class="icon-trash-o"></span>新增</a> 
        <input type="submit" value="新增"/>
          </div>
          </td>
        </tr>
    </table>
  </div>
</form> --%>

 <%-- <form method="post" class="form-x" action="${pageContext.request.contextPath}/user_saveUser.action" enctype="multipart/form-data">
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="userName" style="width: 470px;"/>
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="passWord" style="width: 470px;"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户头像：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="myFile" class="input tips" style="width:25%; float:left;" value="" data-toggle="hover" data-place="right" data-image=""  />
          <input type="file" class="button bg-blue margin-left" id="image1" value="+ 浏览上传" >
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">提交</button>
          <button class="button bg-main icon-check-square-o" >返回</button>
        </div>
      </div>
    </form>  --%>
   <s:form action="user_saveUser.action" enctype="multipart/form-data" method="post">
	    <s:textfield  name="userName"></s:textfield >
	    <s:password name="passWord"></s:password>
	    <s:file name="myFile" label="选择文件"/><br/>
	    <s:submit name="submit" value="上传文件"></s:submit>
    </s:form>
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