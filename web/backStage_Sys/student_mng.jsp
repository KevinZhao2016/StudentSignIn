<%@ page import="java.util.List" %>
<%@ page import="com.model.RouteEntity" %>
<%@ page import="com.model.StationEntity" %><%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/12
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车站管理</title>
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
            <form action="/action/AddStation" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    中文名：
                    <input type="text" class="form-control form-control-2" id="name" name="name" autocomplete="off"
                           required>
                </div>
                <div class="form-group form-group-2">
                    拼音名：
                    <input type="text" class="form-control form-control-2" id="pinyin" name="pinyin" autocomplete="off"
                           required>
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
            <form action="/action/UpdateStation" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    站点号：
                    <input type="text" class="form-control form-control-2" name="id" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    中文名：
                    <input type="text" class="form-control form-control-2" name="name" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    拼音名：
                    <input type="text" class="form-control form-control-2" name="pinyin" autocomplete="off" required>
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
            <form action="/action/DeleteStation" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    站点号：
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
            <button class="md-trigger btn btn-info" data-modal="modal-1">增加</button>
            <button class="md-trigger btn btn-info" data-modal="modal-2">修改</button>
            <button class="md-trigger btn btn-info" data-modal="modal-3">删除</button>
            <div class="row">
                <div id="container">
                    <table class="zebra" id="tableSort">
                        <thead>
                        <tr>
                            <th>站点号</th>
                            <th>中文名</th>
                            <th>拼音名</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<StationEntity> StationList = (List<StationEntity>) session.getAttribute("StationList");
                            out.print(StationList.size());
                            for (int i = 0; i < StationList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                StationList.get(i).getId()
                                %>
                            </td>
                            <td>
                                <%=
                                StationList.get(i).getName()
                                %>
                            </td>
                            <td>
                                <%=
                                StationList.get(i).getPinyin()
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
