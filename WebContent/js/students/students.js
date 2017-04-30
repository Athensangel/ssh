$(function(){
	
	// 手机号码验证 
	jQuery.validator.addMethod("isMobile", function(value, element) { 
	  var length = value.length; 
	  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
	  return this.optional(element) || (length == 11 && mobile.test(value)); 
	}, "请正确填写您的手机号码"); 
	
	var validate = $("#studentsForm").validate({
        debug: true, //调试模式取消submit的默认提交功能   
        //errorClass: "label.error", //默认为错误的样式类为：error   
        focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
        onkeyup: false,   
        submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
            form.submit();   //提交表单   
        },   
        
        rules:{
        	name:{
                
            },
            age:{
                required:true,
                number:true
            },
            telPhone:{
                required:true,
                rangelength:[3,11],
                isMobile : true
            },
            eMail:{
            	required:true,
            	email:true
            }                    
        },
        messages:{
        	name:{
                required:"必填"
            },
            age:{
                required:"必填",
                number:"必须输入合法的数字"
                
            },
            telPhone:{
                required: "不能为空"
            },
            eMail:{
            	required: "不能为空",
            	email:"E-Mail格式不正确"
            }                                    
        }
                  
    });    
});