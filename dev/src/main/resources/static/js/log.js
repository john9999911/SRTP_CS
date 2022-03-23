
    //onblur失去焦点事件，用户离开输入框时执行 JavaScript 代码：
    //身份证号格式
//    function validate_idcard(idcard) {
//        var idcardReg = /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
//
//        if (idcard != "" && idcard.search(idcardReg) != -1) {
//            document.getElementById("test_idcard").innerHTML = "<font color='green' size='3px'>√身份证号格式正确</font>";
//        }else {
//            document.getElementById("test_idcard").innerHTML = "<font color='red' size='3px'>身份证号不能为空</font>";
//        }
//
//    }
//修改为验证邮箱格式，但名字未作修改
    function validate_idcard(idcard) {
        var idcardReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;

        if (idcard != "" && idcard.search(idcardReg) != -1) {
            document.getElementById("test_idcard").innerHTML = "<font color='green' size='3px'>√邮箱格式正确</font>";
        }else {
            document.getElementById("test_idcard").innerHTML = "<font color='red' size='3px'>邮箱不能为空</font>";
        }

    }

//    function checkEmail(){undefined
//    　　var myforms=document.forms;
//    　　var myemail=myforms[0].email.value;
//    　　var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
//
//    　　if(myReg.test(myemail)){undefined
//    　　　　return true;
//    　　}else{undefined
//    　　　　myspan.innerText="邮箱格式不对!";
//    　　　　return false;
//    }

    //函数1：验证用户名格式
    function validate_username(username) {

        if (username != "") {
            document.getElementById("test_user").innerHTML = "<font color='green' size='3px'>√用户名正确</font>";
        } else {
            document.getElementById("test_user").innerHTML = "<font color='red' size='3px'>用户名错误</font>";
        }
    }

    //函数2：验证密码是否符合要求
    function validate_password(password) {
        //^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6-10}$
        var passwordReg = /^[a-zA-Z]\w{5,17}$/;
        if (password != "" && password.search(passwordReg) != -1) {
            document.getElementById("test_pw").innerHTML = "<font color='green' size='3px'>√密码格式正确</font>";
        } else {
            document.getElementById("test_pw").innerHTML = "<font color='red' size='3px'>亲，您输入的密码格式有误哦</font>";
            // alert("密码由数字和字母组成!");
        }
    }

    //函数3：验证两次输入的密码是否一样
    function validate_password2(password2) {
        var password = document.getElementById("password").value;
        //测试：console.log(password);
        //测试：console.log(password2);
        if (password == "") {
            document.getElementById("is_test_pw").innerHTML = "<font color='red' size='3px'>密码不为空</font>";
        } else if (password == password2) {
            document.getElementById("is_test_pw").innerHTML = "<font color='green' size='3px'>√两次输入的密码相同</font>";
        } else {
            document.getElementById("is_test_pw").innerHTML = "<font color='red' size='3px'>两次输入的密码不相同</font>";
            // console.log("密码由数字和字母组成!");
        }
    }

