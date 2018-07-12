<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/7/11
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Paper Bootstrap Wizard by Creative Tim</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/xcConfirm.css">
    <!-- Fonts and Icons -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="css/themify-icons.css" rel="stylesheet">
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('img/paper-3.jpeg')">
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="azure" id="wizard">
                        <form >
                            <!--        You can switch " data-color="azure" "  with one of the next bright colors: "blue", "green", "orange", "red"           -->
                            <div class="wizard-header">
                                <h3 class="wizard-title">教师登录</h3>
                                <!--<p class="category">Book from thousands of unique work and meeting spaces.</p>-->
                            </div>
                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="2" style="width: 21%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#details" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-list"></i>
                                            </div>
                                            账号信息
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#captain" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-briefcase"></i>
                                            </div>
                                            课程信息
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="details">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text"> 请填写下列信息</h5>
                                        </div>
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="form-group">
                                                <label>教师名</label>
                                                <input type="text" class="form-control"  placeholder="..." name="TuserName" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input type="password" class="form-control" name="TpassWord" placeholder="..." required>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="captain">
                                    <h5 class="info-text">确认本次课程信息</h5>
                                    <div class="row" id="course_info" style="display: none">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="form-group" >
                                                <label>课程名</label>
                                                <select name="CName" class="form-control">

                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <div class="form-group">
                                                <label>课程次数</label>
                                                <select name="Cno" class="form-control">
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-else  btn-fill btn-primary btn-wd' id="sub_tech_1" value='下一步' />
                                    <input type='button' class='btn btn-next btn-fill btn-primary btn-wd' name='next' value='下一步' id="sub_tech_2" style="display: none"/>
                                    <input type='button' class='btn btn-finish btn-fill btn-primary btn-wd' name='finish' id="sub_tech_final" value='确认' />
                                </div>
                                <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='上一步' />
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->
</div>
</body>

<!--   Core JS Files   -->
<script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
<!--  Plugin for the Wizard -->
<script src="js/jq_bs_wiza_2.js" type="text/javascript"></script>
<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<%--<script src="js/jquery.js"></script>--%>
<script src="js/xcConfirm.js" type="text/javascript"></script>
<script src="js/submit_teacher.js" type="text/javascript"></script>

</html>
