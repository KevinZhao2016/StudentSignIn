<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/7/10
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>学生注册</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />
    <link href="css/themify-icons.css" rel="stylesheet">
    <script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="js/tracking-min.js"></script>
    <script src="js/face-min.js"></script>
    <script src="js/face_show.js"></script>
</head>
<body>
<div class="image-container set-full-height" style="background-image: url('img/paper-1.jpeg')">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="orange" id="wizardProfile">
                        <form id="register_form" method="post" action="/action/studentRegist" onsubmit="return check_sub()">
                            <!--  You can switch " data-color="orange" "  with one of the next bright colors: "blue", "green", "orange", "red", "azure"          -->
                            <div class="wizard-header text-center">
                                <h3 class="wizard-title">创建学生信息</h3>
                            </div>
                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#about" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-user"></i>
                                            </div>
                                            基本信息
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#address" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-map"></i>
                                            </div>
                                            人脸录入
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="about">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text"> 输入你的信息 </h5>
                                        </div>
                                        <div class="col-sm-3 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>姓名</label>
                                                <input type="text" class="form-control" placeholder="..." name="sName" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-4 ">
                                            <div class="form-group">
                                                <label>学号</label>
                                                <input type="text" class="form-control" placeholder="..." name="sno" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>年龄</label>
                                                <input type="number" class="form-control" placeholder="..." name="sAge" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>专业</label>
                                                <select name="sMajor"  class="form-control" required>
                                                    <option value ="计算机">计算机</option>
                                                    <option value ="软件工程">软件工程</option>
                                                    <option value="物联网">物联网</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>性别</label><br>
                                                <select name="sSex"  class="form-control" required>
                                                    <option value ="男">男</option>
                                                    <option value ="女">女</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="address">
                                    <h5 class="info-text"> 人脸录入 </h5>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-1">
                                            <video id="video" preload autoplay loop muted></video>
                                            <canvas id="canvas" style="display: none" width="580" height="436"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <textarea name="face" id="face" cols="30" rows="10" style="display: none"></textarea>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-next btn-fill btn-warning btn-wd' name='next' value='Next' />
                                    <input type='button' class='btn btn-finish btn-fill btn-warning btn-wd' id='take_photo' value='拍照' />
                                </div>
                                <div class="pull-left">
                                    <!--<input type='button' class='btn btn-previous btn-default btn-wd' id="previous" value='上一步' />-->
                                    <input type='submit' class='btn btn-default btn-wd' id="clear" value='上传' style="display: none"/>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div><!-- end row -->
    </div> <!--  big container -->
</div>

</body>
<!--   Core JS Files   -->
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
<!--  Plugin for the Wizard -->
<script src="js/paper-bootstrap-wizard.js" type="text/javascript"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
</html>
