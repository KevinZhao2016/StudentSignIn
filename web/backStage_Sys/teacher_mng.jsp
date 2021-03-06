<%@ page import="java.util.List" %>
<%@ page import="com.model.TeacherEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>教师管理</title>
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
            <form action="/action/AddTeacher" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    教师姓名：
                    <input type="text" class="form-control form-control-2" id="tName" name="tName"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    用户名：
                    <input type="text" class="form-control form-control-2" id="tUsername" name="tUsername"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    密码：
                    <input type="text" class="form-control form-control-2" id="tPassword" name="tPassword"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    电话号：
                    <input type="text" class="form-control form-control-2" id="tTell" name="tTell"
                           autocomplete="off" required>
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
            <form action="/action/UpdateTeacher" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    教师号：
                    <input type="text" class="form-control form-control-2" name="tid" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    教师姓名：
                    <input type="text" class="form-control form-control-2" name="tName" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    电话号：
                    <input type="text" class="form-control form-control-2" name="tTell" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    用户名：
                    <input type="text" class="form-control form-control-2" name="tUsername" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    密码：
                    <input type="text" class="form-control form-control-2" name="tPassword" autocomplete="off" required>
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
            <form action="/action/DeleteTeacher" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    教师号：
                    <input type="text" class="form-control form-control-2" name="tid" autocomplete="off" required>
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
                            <th>编号</th>
                            <th>教师号</th>
                            <th>教师姓名</th>
                            <th>电话</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<TeacherEntity> TeacherList = (List<TeacherEntity>) session.getAttribute("TeacherList");
                            for (int i= 0; i < TeacherList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                TeacherList.get(i).getTid()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).gettUserName()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).gettName()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getTtell()
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