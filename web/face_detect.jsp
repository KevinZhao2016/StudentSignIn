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
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/xcConfirm.css">
    <script src="js/jquery.js"></script>
    <script src="js/tracking-min.js"></script>
    <script src="js/face-min.js"></script>
    <script src="js/detect.js"></script>
    <script src="js/xcConfirm.js"></script>
</head>
<body>
<div id="container_fa">
    <div id="container">
        <video id="video" preload autoplay loop muted></video>
        <canvas id="canvas" width="581" height="436"></canvas>
        <%--<img id="img_dete" src="img/detecting.gif" alt="" style="z-index: 2;display: none;">--%>
    </div>
    <div id="container_below">
        <p id="iden_text">
            签到系统
        </p>
    </div>
</div>
<div class="message">
    <canvas id="shortCut" width="290" height="218" ></canvas>
    <div id="checkinMsg"></div>
</div>
</body>
</html>
