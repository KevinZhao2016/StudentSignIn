/**
 * Created by lipen on 2018/7/11.
 */
$('#sub_tech_1').click(function () {
    var teach_name = document.getElementsByName('TuserName')[0].value;
    var teach_passwd = document.getElementsByName('TpassWord')[0].value;
    var select = document.getElementsByName('Cname')[0];
    $('#course_info').css("display","block");
    $.ajax({
        url:"/action/TeacherLogin",
        type:"post",
        dataType:"json",
        data:{
            username:teach_name,
            password:teach_passwd
        },
        success:function (result) {
                if(result.flag){
                    $('#sub_tech_2').trigger("click");
                    var select = document.getElementsByName("CName")[0];
                    for (var i=0; i<result.courseList.length;i++){
                        var course_name=result.courseList[i];
                        var item = new Option(course_name,course_name);
                        select.options.add(item);
                    }
                }else {
                    var txt=  "用户名或密码错误，请重新输入";
                    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                }
        }
    });
});
$('#sub_tech_final').click(function () {
    var course_name=document.getElementsByName('CName')[0].value;
    var course_no = document.getElementsByName('Cno')[0].value;
    $.ajax({
        url:"/action/SelectCourse",
        type:"post",
        dataType:"json",
        data:{
            CName:course_name,
            Cno:course_no
        },
        success:function (result) {
            if(result.flag){
                window.location.href="face_detect.jsp";
            }else {
                var txt=  "选课失败，请重新选择";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
            }
        }
    });
});