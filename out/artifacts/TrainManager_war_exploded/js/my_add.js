function sign_up_deteciton() {
    var name = document.getElementById("username");
    var tel = document.getElementById('tel');
    var pass = document.getElementById('password');
    var rpass = document.getElementById('re-password');
    var nameval = name.value.replace(/(^\s*)|(\s*$)/g, '');
    var telval = tel.value.replace(/(^\s*)|(\s*$)/g, '');
    var passval = pass.value.replace(/(^\s*)|(\s*$)/g, '');
    var repassval = rpass.value.replace(/(^\s*)|(\s*$)/g, '');
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(nameval.length==0||telval.length==0||passval==0){
        alert("输入不能为空！");
        return false;
    }else if(!myreg.test(telval)){
        alert("请输入正确的手机号码！");
    }
    else if (passval.length<4 || passval.length>16){
        alert("密码的长度必须在4-16个字符");
        pass.select();
        return false;
    }else if(passval!=repassval){
        alert("两次密码输入不一致");
        rpass.select();
        return false;
    } else {
        return true;
    }
}