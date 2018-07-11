/**
 * Created by lipen on 2018/7/9.
 */
$(function () {
    var video = document.getElementById('video');
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');
    var shortCut = document.getElementById('shortCut');
    var scContext = shortCut.getContext('2d');
    var time =5000;//向后台发照片的冷却时间
    var text= document.getElementById('iden_text');
    var con = document.getElementById('container');
    var img_dtc = document.getElementById('img_dete');
    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);
    tracking.track('#video', tracker, {camera: true});
    var flag=true;
    tracker.on('track', func2=function (event) {
        if (event.data.length === 0) {
            context.clearRect(0, 0, canvas.width, canvas.height);
        }else{
            context.clearRect(0, 0, canvas.width, canvas.height);
            event.data.forEach(function (rect) {
                context.strokeStyle = '#ff0000';
                context.strokeRect(rect.x, rect.y, rect.width, rect.height);
                context.fillStyle = "#ff0000";
                //console.log(rect.x, rect.width, rect.y, rect.height);
            });
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
        $.ajax({
            url:"/action/signin",
            type:"post",
            dataType:"json",
            data:{
                face:imgStr.substring(imgStr.indexOf(",")+1)
            },
            success:function(result){
                if(result!=null){
                    if (result.studentEntity.sName!=null){
                            var name=result.studentEntity.sName;
                            var txt=  name+"签到成功";
                            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                    }else {
                            var txt=  "签到失败，请重新录入";
                            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    }
                }
                else {
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
function detect_face() {
    var video = document.getElementById('video');
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');
    var shortCut = document.getElementById('shortCut');
    var scContext = shortCut.getContext('2d');
    var time =1000;//向后台发照片的冷却时间
    var text= document.getElementById('iden_text');
    text.innerHTML="签到系统";
    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);
    var tracktask=tracking.track('#video', tracker, {camera: true});
    var flag=true;
    tracker.on('track', function (event) {
        if (event.data.length === 0) {
            context.clearRect(0, 0, canvas.width, canvas.height);
        }else{
            context.clearRect(0, 0, canvas.width, canvas.height);
            event.data.forEach(function (rect) {
                context.strokeStyle = '#ff0000';
                context.strokeRect(rect.x, rect.y, rect.width, rect.height);
                context.fillStyle = "#ff0000";
                //console.log(rect.x, rect.width, rect.y, rect.height);
            });
            if(flag){
                console.log("拍照");
                getPhoto();
            }else{
                //console.log("冷却中");
            }
        }
    })
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