$().ready(function(){
    var verifyCode = new GVerify("v_container");
    // 在键盘按下并释放及提交后验证提交表单
    var validator=$("#loginForm").validate({
        debug:true,
        rules: {
            username: "required",
            password:"required"
        },
        messages: {
            username:'用户名不能为空',
            password:"密码不能为空"
        }, submitHandler:function(form) {
            console.log(document.getElementById("code_input").value);
                var res = verifyCode.validate(document.getElementById("code_input").value);
                if(res){
                    $(location).attr('href','index.html');
                }else{
                    alert("验证码错误");
                }
        }
    });
    $('#signUp').click(function(){
        validator.resetForm();
    });
});

function verifyRes(){
    var isSuccess=false;
    $('#mpanel').slideVerify({
        type : 1,		//类型
        vOffset : 5,	//误差量，根据需求自行调整
        barSize : {
            width : '80%',
            height : '40px',
        },
        ready : function() {
        },
        success : function() {
            isSuccess=true;
        },
        error : function() {
            isSuccess=false;
        }
    });
    return isSuccess;
}
