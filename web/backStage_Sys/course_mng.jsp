<%@ page import="java.util.List" %>
<%@ page import="com.model.RouteEntity" %>
<%@ page import="com.model.StationEntity" %>
<%@ page import="com.model.TripsEntity" %><%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/12
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车次管理</title>
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
            <form action="/action/AddTrip" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    车次名：
                    <input type="text" class="form-control form-control-2" name="tname" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    途经站：
                    <input type="text" class="form-control form-control-2" name="passby" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    出发时间：
                    <input type="text" class="form-control form-control-2" name="departure" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    车次类型：
                    <input type="text" class="form-control form-control-2" name="ttype" autocomplete="off" required>
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
            <form action="/action/UpdateTrip" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    车次号：
                    <input type="text" class="form-control form-control-2" name="tid" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    车次名：
                    <input type="text" class="form-control form-control-2" name="tname" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    途经站：
                    <input type="text" class="form-control form-control-2" name="passby" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    出发时间：
                    <input type="text" class="form-control form-control-2" name="departure" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    车次类型：
                    <input type="text" class="form-control form-control-2" name="ttype" autocomplete="off" required>
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
            <form action="/action/DeleteTrip" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    车次号：
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
                            <th>车次号</th>
                            <th>车次名</th>
                            <th>路经站</th>
                            <th>出发时间</th>
                            <th>车次类型</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<TripsEntity> TripList = (List<TripsEntity>) session.getAttribute("TripList");
                            out.print(TripList.size());
                            for (int i = 0; i < TripList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                TripList.get(i).getTid()
                                %>
                            </td>
                            <td>
                                <%=
                                TripList.get(i).getTname()
                                %>
                            </td>
                            <td>
                                <%=
                                TripList.get(i).getPassby()
                                %>
                            </td>
                            <td>
                                <%=
                                TripList.get(i).getDeparture().getHours() + ":" + TripList.get(i).getDeparture().getMinutes() + ":" + TripList.get(i).getDeparture().getSeconds()
                                %>
                            </td>
                            <td>
                                <%=
                                TripList.get(i).getTtype()
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
