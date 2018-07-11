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
function sign_in_detection() {
    var tel_reg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var tel = document.getElementById("telNum").value;
    var pwd = document.getElementById("password").value;
    var pwd_reg=/^(\w){6,20}$/;
    if(tel.replace(/(^s*)|(s*$)/g, "").length ==""
        ||pwd.replace(/(^s*)|(s*$)/g, "").length ==""){
        alert("输入不能为空！");
        return false;
    }else if (!tel_reg.exec(tel)){
        alert('请输入有效的手机号码！');
        return false;
    }else if(!pwd_reg.exec(pwd)){
        alert('密码不正确！');
        return false;
    }else {
        return true;
    }
}
function book_detection() {
    var depar = document.getElementsByName('DepartureStation');
    var arriv = document.getElementsByName('ArrivalStation');
    if (depar.value == 1 || arriv.value == 1) {
        alert("请选择车站！");
        return false;
    } else {
        return true;
    }
}
function show_price(event) {
    var tr1 = event.parentNode;
    rowIndex = tr1.rowIndex;
    var table = document.getElementById("tableSort");
    var row = table.getElementsByTagName("tr")[rowIndex+1];
    // alert(child.rowIndex)
    if (row != null) {
        if (row.style.display == (document.all ? "block" : "table-row")) {
            row.style.display = "none";
        }
        else {
            row.style.display = (document.all ? "block" : "table-row");
        }
    }
}
function sortAble(th, tableId, iCol, dataType) {
//排序 tableId: 表的id,iCol:第几列 ；dataType：iCol对应的列显示数据的数据类型
    var ascChar = "▲";
    var descChar = "▼";
    var table = document.getElementById(tableId);
    var tbody = table.tBodies[0];
    var colRows = tbody.rows;
    var aTrs = new Array;
    //将得到的行放入数组，备用
    for (var i = 0; i < colRows.length; i++) {
        if ($(colRows[i]).attr("group") != undefined) {
            aTrs.push(colRows[i]);
        }
    }
    //判断上一次排列的列和现在需要排列的是否同一个。
    var thCol = $(table.tHead.rows[0].cells[iCol]);
    if (table.sortCol == iCol) {
        aTrs.reverse();
    } else {
        //如果不是同一列，使用数组的sort方法，传进排序函数
        aTrs.sort(compareEle(iCol, dataType));
    }
    var oFragment = document.createDocumentFragment();
    for (var i = 0; i < aTrs.length; i++) {
        oFragment.appendChild(aTrs[i]);
    }
    tbody.appendChild(oFragment);

    //记录最后一次排序的列索引
    table.sortCol = iCol;

    //给排序标题加“升序、降序” 小图标显示
    var th = $(table.tHead.rows[0].cells[iCol]);
    if (th.html().indexOf(ascChar) == -1 && th.html().indexOf(descChar) == -1) {
        th.html(th.html() + ascChar);
    }
    else if (th.html().indexOf(ascChar) != -1) {
        th.html(th.html().replace(ascChar, descChar));
    }
    else if (th.html().indexOf(descChar) != -1) {
        th.html(th.html().replace(descChar, ascChar));
    }

    //重新整理分组
    var subRows = $("#" + tableId + " tr[parent]");
    for (var t = subRows.length - 1; t >= 0 ; t--) {
        var parent = $("#" + tableId + " tr[group='" + $(subRows[t]).attr("parent") + "']");
        parent.after($(subRows[t]));
    }
}

//将列的类型转化成相应的可以排列的数据类型
function convert(sValue, dataType) {
    switch (dataType) {
        case "int":
            return parseInt(sValue, 10);
        case "float":
            return parseFloat(sValue);
        case "date":
            return new Date(Date.parse(sValue));
        case "string":
        default:
            return sValue.toString();
    }
}

//排序函数，iCol表示列索引，dataType表示该列的数据类型
function compareEle(iCol, dataType) {
    return function (oTR1, oTR2) {

        // var vValue1 = convert(removeHtmlTag($(oTR1.cells[iCol]).html()), dataType);
        // var vValue2 = convert(removeHtmlTag($(oTR2.cells[iCol]).html()), dataType);
        var vValue1 = convert($(oTR1.cells[iCol]).html(), dataType);
        var vValue2 = convert($(oTR2.cells[iCol]).html(), dataType);
        if (vValue1 < vValue2) {
            return -1;
        }
        else {
            return 1;
        }

    };
}

// 去掉html标签
// function removeHtmlTag(html) {
//     return html.replace(/<[^>]+>/g, "");
// }

function my_sort(th, tableId, iCol, dataType) {
    var tbody = table.tBodies[0];
    var colRows = tbody.rows;
    var aTrs = new Array;
    //将得到的行放入数组，备用
    for (var i = 0; i < colRows.length; i++) {
        aTrs.push(colRows[i]);
    }
    //判断上一次排列的列和现在需要排列的是否同一个。
    var thCol = $(table.tHead.rows[0].cells[iCol]);
    if (table.sortCol == iCol) {
        return;
        aTrs.reverse();
    } else {
        //如果不是同一列，使用数组的sort方法，传进排序函数
        aTrs.sort(compareEle(iCol, dataType));
    }
}
function sortBySelecter(event) {
    // alert(event.value);
    if (event.value ==0){
        sortAble(this,'tableSort', 9,'date');
    }else if (event.value==1){
        sortAble(this,'tableSort', 10,'date');
    } else {
        sortAble(this,'tableSort', 11,'float');
    }
}
