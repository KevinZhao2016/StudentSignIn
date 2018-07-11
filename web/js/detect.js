/**
 * Created by lipen on 2018/7/9.
 */
$(function () {
    var video = document.getElementById('video');
    var shortCut = document.getElementById('shortCut');
    var scContext = shortCut.getContext('2d');
    var time =6000;//向后台发照片的冷却时间
    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);
    tracking.track('#video', tracker, {camera: true});
    var flag=true;
    tracker.on('track', func2=function (event) {
        if (event.data.length === 0) {
            // context.clearRect(0, 0, canvas.width, canvas.height);
        }else{
            // context.clearRect(0, 0, canvas.width, canvas.height);
            if(flag){
                getPhoto();
                flag=false;
                setTimeout(function(){flag=true;},time);
            }else{
                //console.log("冷却中");
            }
        }
    }
    );
    function getPhoto() {
        scContext.drawImage(video,0,0,290,218);
        var imgStr = shortCut.toDataURL("image/png");
//                console.log(imgStr);
        //将拍照的图片数据发送到后台
        // video.style.display="none";
        $.ajax({
            url:"/action/signin",
            type:"post",
            dataType:"json",
            data:{
                face:imgStr.substring(imgStr.indexOf(",")+1)
            },
            success:function(result){
                    if (result.studentEntity!=null){
                            var stu=result.studentEntity;
                            var stu_info=document.getElementsByClassName('text3');
                            stu_info[0].innerHTML=stu.sMajor;
                            stu_info[1].innerHTML=result.CName;
                            stu_info[2].innerHTML=stu.sSex;
                            stu_info[3].innerHTML=stu.sAge;
                            stu_info[4].innerHTML=stu.sName;
                            stu_info[5].innerHTML=stu.sno;
                            setTimeout("clear_text()",3000);

                    }else {
                            var txt=  "签到失败，请重新录入";
                            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    }

            },
            error:function () {
                var txt=  "签到失败，请重新录入";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
            }

        });
    }
});
function clear_text() {
    var stu_info=document.getElementsByClassName('text3');
    for(var i=0;i<6;i++){
        stu_info[i].innerHTML="";
        var shortCut = document.getElementById('shortCut');
        var scContext = shortCut.getContext('2d');
        scContext.clearRect(0,0,shortCut.width,shortCut.height);
    }

}
// function getPhoto() {
//     scContext.drawImage(video,0,0,290,218);
//     var imgStr = shortCut.toDataURL("image/png");
// //                console.log(imgStr);
//     //将拍照的图片数据发送到后台
//     text.innerHTML="正在识别，请稍后...";
//     $.ajax({
//         url:"/action/signin",
//         type:"post",
//         dataType:"json",
//         data:{
//             face:imgStr.substring(imgStr.indexOf(",")+1)
//         },
//         success:function(result){
//             if(result!=null){
//                 alert(result.studentEntity.sName);
//             }
//             else {
//                 alert("签到失败");
//             }
//         }
//
//     });
//     // flag=false;
//     // setTimeout(function(){flag=true;},time);
// }