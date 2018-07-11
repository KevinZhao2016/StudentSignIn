<%@ page import="java.util.List" %>
<%@ page import="com.model.RouteEntity" %>
<%@ page import="com.model.StationEntity" %>
<%@ page import="com.model.TripsEntity" %>
<%@ page import="com.model.UsersEntity" %><%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/12
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
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
            <form action="/action/UpdateUser" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    用户ID：
                    <input type="text" class="form-control form-control-2" name="id" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    用户名：
                    <input type="text" class="form-control form-control-2" name="name" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    密码：
                    <input type="text" class="form-control form-control-2" name="passwd" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    手机号：
                    <input type="text" class="form-control form-control-2" name="telNum" autocomplete="off" required>
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
            <form action="/action/DeleteUser" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    用户ID：
                    <input type="text" class="form-control form-control-2" name="id" autocomplete="off" required>
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
                            <th>用户ID</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>手机号</th>
                            <th>联系人</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<UsersEntity> UsersList = (List<UsersEntity>) session.getAttribute("UsersList");
                            out.print(UsersList.size());
                            for (int i = 0; i < UsersList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                UsersList.get(i).getId()
                                %>
                            </td>
                            <td>
                                <%=
                                UsersList.get(i).getName()
                                %>
                            </td>
                            <td>
                                <%=
                                UsersList.get(i).getPasswd()
                                %>
                            </td>
                            <td>
                                <%=
                                UsersList.get(i).getTelNum()
                                %>
                            </td>
                            <td>
                                <%=
                                UsersList.get(i).getContact()
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
