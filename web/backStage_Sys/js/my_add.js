function sign_up_deteciton() {
    var tel_reg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var pwd_reg=/^(\w){6,20}$/;
    var username=document.getElementById("username").value;
    var tel = document.getElementById("tel").value;
    var pwd = document.getElementById("password").value;
    var repwd = document.getElementById("re-password").value;
    if (username.replace(/(^\s*)|(\s*$)/g, "")== ""||tel.replace(/(^s*)|(s*$)/g, "").length ==""
    ||pwd.replace(/(^s*)|(s*$)/g, "").length ==""||repwd.replace(/(^s*)|(s*$)/g, "").length ==""){
        alert("输入不能为空！");
        return false;
    }else if (!tel_reg.exec(tel)){
        alert('请输入有效的手机号码！');
        return false;
    }else if(!pwd_reg.exec(pwd)){
        alert('密码输入6-20个字母、数字、下划线 ！');
        return false;
    }else if(repwd != pwd){
        alert('两次输入密码不一致！');
        return false;
    }else {
        var showdiv = document.getElementById('show_div');
        showdiv.style.display = "block";
        return true;
    }
}
function submit_info() {
    var coursename=document.getElementById('select_CName_2').value;
    var courseNo=document.getElementById('cNo').value;
    var state=document.getElementById('cState').value;
    alert(state);
    $.ajax(
        {
            url:"/action/GetAllClassInfoAction",
            type:"post",
            dataType:"json",
            data:{
                cname:coursename,
                cno:courseNo,
                state:state
            },
            success:function (result) {
                // alert(result);
            }
        }
    );
}

