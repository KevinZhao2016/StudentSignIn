<%@ page import="java.util.List" %>
<%@ page import="com.model.CourseEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
    <link rel="stylesheet" href="css/pop_up.css">
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/demo.css" rel="stylesheet"/>
    <link href="css/style_2.css" rel="stylesheet">
</head>
<body>
<div class="md-modal md-effect-5" id="modal-1">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/AddCourse" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    课程：
                    <input type="text" class="form-control form-control-2" name="CName" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    教师姓名：
                    <input type="text" class="form-control form-control-2" name="TUserName" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    开始时间：
                    <input type="text" class="form-control form-control-2" name="CStart" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    结束时间：
                    <input type="text" class="form-control form-control-2" name="CEnd" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    上课次数：
                    <input type="text" class="form-control form-control-2" name="Cno" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    <input type="submit" value="提交" class="btn btn-primary">
                </div>
            </form>
            <button class="md-close btn btn-default">Close me!</button>
        </div>
    </div>
</div>
<div class="md-modal md-effect-5" id="modal-2">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/UpdateCourse" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    课程号：
                    <input type="text" class="form-control form-control-2" name="Cid" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    课程：
                    <input type="text" class="form-control form-control-2" name="CName" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    教师姓名：
                    <input type="text" class="form-control form-control-2" name="TUserName" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    开始时间：
                    <input type="text" class="form-control form-control-2" name="CStart" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    结束时间：
                    <input type="text" class="form-control form-control-2" name="CEnd" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    上课次数：
                    <input type="text" class="form-control form-control-2" name="Cno" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    <input type="submit" value="提交" class="btn btn-primary">
                </div>
            </form>
            <button class="md-close btn btn-default">Close me!</button>
        </div>
    </div>
</div>
<div class="md-modal md-effect-5" id="modal-3">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/DeleteCourse" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    课程号：
                    <input type="text" class="form-control form-control-2" name="Cid" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    <input type="submit" value="提交" class="btn btn-primary">
                </div>
            </form>
            <button class="md-close btn btn-default">Close me!</button>
        </div>
    </div>
</div>
<div class="container list_info">
    <div class="row">
        <div class="col-sm-12">
            <!--      Wizard container        -->
            <button class="md-trigger btn btn-info" data-modal="modal-1">增加</button>
            <button class="md-trigger btn btn-info" data-modal="modal-2">修改</button>
            <button class="md-trigger btn btn-info" data-modal="modal-3">删除</button>
            <div class="row">
                <div id="container">
                    <table class="zebra" id="tableSort">
                        <thead>
                        <tr>
                            <th>课程号</th>
                            <th>课程</th>
                            <th>教师姓名</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>上课次数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<CourseEntity> CourseList= (List<CourseEntity>) session.getAttribute("CourseList");

                            for (int i = 0; i < CourseList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                CourseList.get(i).getCid()
                                %>
                            </td>
                            <td>
                                <%=
                                CourseList.get(i).getcName()
                                %>
                            </td>
                            <td>
                                <%=
                                CourseList.get(i).gettUserName()
                                %>
                            </td>
                            <td>
                                <%=
                                CourseList.get(i).getcStart()
                                %>
                            </td>
                            <td>
                                <%=
                                CourseList.get(i).getcEnd()
                                %>
                            </td>
                            <td>
                                <%=
                                CourseList.get(i).getCno()
                                %>
                            </td>

                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div> <!-- row -->
</div> <!--  big container -->


<script src="js/pop_up.js"></script>
</body>
</html>
