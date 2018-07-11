<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/7/9
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.js"></script>
<script src="js/tracking-min.js"></script>
<script src="js/face-min.js"></script>
<script src="js/detect.js"></script>
<script src="js/xcConfirm.js"></script>
</head>
<body>
<div id="container_fa">
    <div class="container">
        <video id="video" preload autoplay loop muted></video>
        <%--<canvas id="canvas" ></canvas>--%>
    </div>
    <div id="container_below">
        <p id="iden_text">
            签到系统
        </p>
    </div>
</div>
<div id="container_ra">
    <div id="">
        <p id="text">
            学生信息--杭州电子科技大学
        </p>
    </div>
    <div id="container_image">
        <div id="container_info">
            <ul style="list-style-type: none">
                <li class="text2">专业:<span class="text3"> </span></li>
                <li class="text2">课程:<span class="text3"> </span></li>
                <li class="text2">性别:<span class="text3"> </span></li>
                <li class="text2">年龄:<span class="text3"> </span></li>
            </ul>
        </div>
        <div id="iden_image" >
            <canvas id="shortCut" width="290" height="218" ></canvas>
        </div>

    </div>
    <div id="container_stu">
        <ul style="list-style-type: none">
            <li class="text2">姓名:<span class="text3"></span></li>
            <li class="text2">学号:<span class="text3"></span></li>
        </ul>
    </div>

</div>
</body>
</html>
