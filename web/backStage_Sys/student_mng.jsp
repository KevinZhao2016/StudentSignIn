<%@ page import="java.util.List" %>
<%@ page import="com.model.StudentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>学生管理</title>
    <link rel="stylesheet" href="css/pop_up.css">
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/demo.css" rel="stylesheet"/>
    <link href="css/style_2.css" rel="stylesheet">
</head>
<body>
<div class="md-modal md-effect-5" id="modal-2">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/UpdateStudent" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    学生姓名：
                    <input type="text" class="form-control form-control-2" name="sName"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    学号：
                    <input type="text" class="form-control form-control-2" name="sno"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    年龄：
                    <input type="text" class="form-control form-control-2" name="sAge"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    性别：
                    <input type="text" class="form-control form-control-2" name="sSex"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    专业：
                    <input type="text" class="form-control form-control-2" name="sMajor"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    token：
                    <input type="text" class="form-control form-control-2" name="token"
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

<div class="md-modal md-effect-5" id="modal-3">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/DeleteStudent" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    学号：
                    <input type="text" class="form-control form-control-2" name="sno" autocomplete="off" required>
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
            <button class="md-trigger btn btn-info" data-modal="modal-2">修改</button>
            <button class="md-trigger btn btn-info" data-modal="modal-3">删除</button>
            <div class="row">
                <div id="container">
                    <table class="zebra" id="tableSort">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>学生姓名</th>
                            <th>学号</th>
                            <th>年龄</th>
                            <th>性别</th>
                            <th>专业</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<StudentEntity> TeacherList = (List<StudentEntity>) session.getAttribute("StudentList");
                            for (int i= 0; i < TeacherList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                TeacherList.get(i).getSid()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getsName()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getSno()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getsAge()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getsSex()
                                %>
                            </td>
                            <td>
                                <%=
                                TeacherList.get(i).getsMajor()
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