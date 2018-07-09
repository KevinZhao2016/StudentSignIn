<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/7/9
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <meta charset="UTF-8">
    <title>人脸检测</title>
    <script src="js/jquery.js"></script>
    <script src="js/tracking-min.js"></script>
    <script src="js/face-min.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .container {
            position: relative;
            width: 581px;
            height: 436px;
            float:left;
        }
        .message{
            float:left;
        }
        video, #canvas {
            position: absolute;
            width: 581px;
            height: 436px;
        }
    </style>
    <script>
        $(function () {
            var video = document.getElementById('video');
            var canvas = document.getElementById('canvas');
            var context = canvas.getContext('2d');
            var shortCut = document.getElementById('shortCut');
            var scContext = shortCut.getContext('2d');
            var time =5000;//向后台发照片的冷却时间

            var tracker = new tracking.ObjectTracker('face');
            tracker.setInitialScale(4);
            tracker.setStepSize(2);
            tracker.setEdgesDensity(0.1);
            tracking.track('#video', tracker, {camera: true});
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
                        flag=false;
                        setTimeout(function(){flag=true;},time);
                    }else{
                        //console.log("冷却中");
                    }
                }
            });
            function getPhoto() {
                scContext.drawImage(video,0,0,290,218);
                var imgStr = shortCut.toDataURL("image/png");
                //将拍照的图片数据发送到后台
                $.ajax({
                    url:"identifyUser",
                    type:"post",
                    dataType:"json",
                    data:{
                        imgStr:imgStr.substring(imgStr.indexOf(",")+1)
                    },
                    success:function(result){
                        if(result.result == "true"){
                            if(result.user != "404"){
                                send("user_info:"+result.user);
                            }
                        }

                    }
                });

            }
        });
    </script>
</head>
<body>
<div class="container">
    <video id="video" preload autoplay loop muted></video>
    <canvas id="canvas" width="581" height="436"></canvas>
</div>
<div class="message">
    <canvas id="shortCut" width="290" height="218" ></canvas>
    <div id="checkinMsg"></div>
</div>
</body>
</body>
</html>
