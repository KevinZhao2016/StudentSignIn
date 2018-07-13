<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/7/12
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>签到管理</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>
    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/demo.css" rel="stylesheet"/>
    <link href="css/style_2.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/my_add.js"></script>
    <%--<script type="text/javascript" src="../js/submit_teacher.js"></script>--%>
</head>
<body>
<div class="image-container set-full-height" style="background-image: url('../img/back2.jpg')">
    <!--   Creative Tim Branding   -->
    <a href="#">
        <div class="logo-container">
            <div class="logo">
                <img src="images/new_logo.png">
            </div>
            <div class="brand">
                <%
                    request.setCharacterEncoding("UTF-8");
                %>
                <s:property value="#session.TName"></s:property>
            </div>
        </div>
    </a>
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card">
                        <!--        You can switch " data-color="green" "  with one of the next bright colors: "blue", "azure", "orange", "red"       -->
                        <div class="wizard-header">
                            <h3 class="wizard-title">查询结果</h3>
                            <div class="choose_sort selectpicker">
                                <lable>
                                    <span class="category">课程名：</span><select class="form-control"
                                                                              id="select_CName_2">
                                    <%
                                        List<String> courseList = (List<String>) session.getAttribute("CourseList");
                                        for (int i = 0; i < courseList.size(); i++) {
                                    %>
                                    <option value=<%=courseList.get(i)%>>
                                        <%=courseList.get(i)%>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                                </lable>
                            </div>
                            <div class="choose_sort selectpicker">
                                <span class="category">课程次序：</span>
                                <select id="cNo" class="form-control">
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
                                    <option value="0">全部</option>
                                </select>
                            </div>
                            <div class="choose_sort selectpicker">
                                <span class="category">签到状态：</span>
                                <select id="cState" class="form-control">
                                    <option value="0">正常</option>
                                    <option value="1">迟到</option>
                                    <option value="2">全部</option>
                                </select>
                            </div>
                            <div class="choose_sort selectpicker">
                                <input type='button' class='btn btn-fill btn-primary' value='查询' id="bt_sub" onclick="submit_info()"/>
                            </div>
                        </div>
                        <div class="row">
                            <div id="container">
                                <table class="zebra zebra_2" id="tableSort" style="display: none;table-layout:fixed">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>学生姓名</th>
                                    <th>专业</th>
                                    <th>性别</th>
                                    <th>课程名</th>
                                    <th>课程序号</th>
                                    <th>签到时间</th>
                                    <th>签到状态</th>
                                </tr>
                                </thead>
                                <tbody id="tbody0">

                                </tbody>
                            </table>
                                <table class="zebra zebra_2" id="tableSort_2" style="table-layout:fixed;display: table">
                                    <thead>
                                    <tr>
                                        <th>学号</th>
                                        <th>学生姓名</th>
                                        <th>专业</th>
                                        <th>性别</th>
                                        <th>课程名</th>
                                        <th>签到次数</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbody1">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->

    <div class="footer">
        <div class="container text-center">
            <p>
                <small>&copy; All Rights Reserved.</small>
            </p>
        </div>
    </div>
</div>

</body>
</html>
