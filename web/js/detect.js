/**
 * Created by lipen on 2018/7/9.
 */
var flag = 1;
$(function () {
    var video = document.getElementById('video');
    var shortCut = document.getElementById('shortCut');
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');
    var scContext = shortCut.getContext('2d');
    // var time =6000;//向后台发照片的冷却时间
    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);
    tracking.track('#video', tracker, {camera: true});
    tracker.on('track', func2 = function (event) {
            if (event.data.length === 0) {
                context.clearRect(0, 0, canvas.width, canvas.height);
            } else {
                context.clearRect(0, 0, canvas.width, canvas.height);
                event.data.forEach(function (rect) {
                    context.strokeStyle = '#ff0000';
                    context.strokeRect(rect.x, rect.y, rect.width, rect.height);
                    context.fillStyle = "#ff0000";
                    //console.log(rect.x, rect.width, rect.y, rect.height);
                });
                if (flag == 1 && (event.data[0].width > 160)) {
                    flag = 0;
                    getPhoto();
                    // setTimeout(function(){flag=true;},time);
                } else {
                    //console.log("冷却中");
                }
            }
        }
    );

    function getPhoto() {
        flag = 0;
        scContext.drawImage(video, 0, 0, 290, 218);
        var imgStr = shortCut.toDataURL("image/png");
//                console.log(imgStr);
        //将拍照的图片数据发送到后台
        // video.style.display="none";
        $.ajax({
            url: "/action/signin",
            type: "post",
            dataType: "json",
            data: {
                face: imgStr.substring(imgStr.indexOf(",") + 1)
            },
            success: function (result) {
                if (result.studentEntity != null) {
                    var stu = result.studentEntity;
                    var stu_info = document.getElementsByClassName('text3');
                    stu_info[0].innerHTML = stu.sMajor;
                    stu_info[1].innerHTML = result.CName;
                    stu_info[2].innerHTML = stu.sSex;
                    stu_info[3].innerHTML = stu.sAge;
                    stu_info[4].innerHTML = stu.sName;
                    stu_info[5].innerHTML = stu.sno;
                    setTimeout("clear_text()", 3000);


                } else {
                    var txt = "签到失败，请重新录入";
                    window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    setTimeout("clear_pop()", 3000);

                }
            },
            error: function () {
                var txt = "签到失败，请重新录入";
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                setTimeout("clear_pop()", 3000);

            }

        });
    }
});

function clear_text() {
    var stu_info = document.getElementsByClassName('text3');
    for (var i = 0; i < 6; i++) {
        stu_info[i].innerHTML = "";
        var shortCut = document.getElementById('shortCut');
        var scContext = shortCut.getContext('2d');
        scContext.clearRect(0, 0, shortCut.width, shortCut.height);
    }
    flag = 1;

}

function clear_pop() {
    var pop = document.getElementsByClassName('xcConfirm');
    for (var i = 0; i < pop.length; i++) {
        pop[i].parentNode.removeChild(pop[i]);
    }
    clear_text();
    flag = 1;
}
