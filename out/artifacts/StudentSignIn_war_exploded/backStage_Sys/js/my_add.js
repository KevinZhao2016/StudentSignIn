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
    var thead0=document.getElementById('tableSort');
    var thead1=document.getElementById('tableSort_2');
    var tbody0=document.getElementById('tbody0');
    var tbody1=document.getElementById('tbody1');
    if(courseNo=="0"){
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
                    thead0.style.display="none";
                    thead1.style.display="table";
                    tbody0.innerHTML="";
                    tbody1.innerHTML="";
                    if (result.list!=null){
                        var list_info = result.list;
                        for(var i=0;i<list_info.length;i++){
                            var row=getDataRow(list_info[i].studentEntity);
                            var cnameCell = document.createElement('td');//创建第三列major
                            cnameCell.innerHTML = coursename;
                            row.appendChild(cnameCell);
                            var coutCell=document.createElement('td');
                            coutCell.innerHTML=list_info[i].count;
                            row.appendChild(coutCell);
                            tbody1.appendChild(row);
                        }
                    }
                }
            }
        );
    }else {
        if(state=="2"){
            $.ajax(
                {
                    url:"/action/GetSingleClassInfo",
                    type:"post",
                    dataType:"json",
                    data:{
                        cname:coursename,
                        cno:courseNo,
                        state:state
                    },
                    success:function (result) {
                        thead1.style.display="none";
                        thead0.style.display="table";
                        tbody0.innerHTML="";
                        tbody1.innerHTML="";
                        if (result.list!=null){
                            var list_info = result.list;
                            for(var i=0;i<list_info.length;i++){
                                var row=getDataRow(list_info[i].student);
                                var cnameCell = document.createElement('td');//创建第三列major
                                cnameCell.innerHTML = coursename;
                                row.appendChild(cnameCell);
                                var cnoCell = document.createElement('td');//创建第三列major
                                cnoCell.innerHTML = courseNo;
                                row.appendChild(cnoCell);
                                var timeCell=document.createElement('td');
                                timeCell.innerHTML=list_info[i].time;
                                row.appendChild(timeCell);
                                var stateCell=document.createElement('td');
                                if(list_info[i].state=="0"){
                                    stateCell.innerHTML="正常";
                                }else{
                                    stateCell.innerHTML="迟到";
                                }
                                row.appendChild(stateCell);
                                tbody0.appendChild(row);
                            }
                        }
                    }
                }
            );
        }
        else {
            $.ajax(
                {
                    url:"/action/GetSingleClassInfoWithState",
                    type:"post",
                    dataType:"json",
                    data:{
                        cname:coursename,
                        cno:courseNo,
                        state:state
                    },
                    success:function (result) {
                        thead1.style.display="none";
                        thead0.style.display="table";
                        tbody0.innerHTML="";
                        tbody1.innerHTML="";
                        if (result.list!=null){
                            var list_info = result.list;
                            for(var i=0;i<list_info.length;i++){
                                var row=getDataRow(list_info[i].student);
                                var cnameCell = document.createElement('td');//创建第三列major
                                cnameCell.innerHTML = coursename;
                                row.appendChild(cnameCell);
                                var cnoCell = document.createElement('td');//创建第三列major
                                cnoCell.innerHTML = courseNo;
                                row.appendChild(cnoCell);
                                var timeCell=document.createElement('td');
                                timeCell.innerHTML=list_info[i].time.substring(0,10)+" "+list_info[i].time.substring(11);
                                row.appendChild(timeCell);
                                var stateCell=document.createElement('td');
                                if(list_info[i].state=="0"){
                                    stateCell.innerHTML="正常";
                                }else{
                                    stateCell.innerHTML="迟到";
                                }
                                row.appendChild(stateCell);
                                tbody0.appendChild(row);
                            }
                        }
                    }
                }
            );

        }
    }
}
function getDataRow(h) {
        var row = document.createElement('tr'); //创建行
       var idCell = document.createElement('td'); //创建第一列id
       idCell.innerHTML = h.sno; //填充数据
       row.appendChild(idCell); //加入行 ，下面类似
       var nameCell = document.createElement('td');//创建第二列name
       nameCell.innerHTML = h.sName;
       row.appendChild(nameCell);
       var majorCell = document.createElement('td');//创建第三列major
       majorCell.innerHTML = h.sMajor;
       row.appendChild(majorCell);
       var sexCell = document.createElement('td');
       sexCell.innerHTML = h.sSex;
       row.appendChild(sexCell);
       return row;
}

