<%@ page import="java.util.List" %>
<%@ page import="com.model.RouteEntity" %><%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/12
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>路线管理</title>
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
            <form action="/action/Addroute" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    出发站：
                    <input type="text" class="form-control form-control-2" id="StationA" name="StationA"
                           autocomplete="off" required>

                </div>
                <div class="form-group form-group-2">
                    到达站：
                    <input type="text" class="form-control form-control-2" id="StationB" name="StationB"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    距&nbsp;&nbsp;&nbsp;&nbsp;离：
                    <input type="text" class="form-control form-control-2" id="distance" name="distance"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    历&nbsp;&nbsp;&nbsp;&nbsp;时：
                    <input type="text" class="form-control form-control-2" id="time" name="time" autocomplete="off"
                           required>
                </div>
                <div class="form-group form-group-2">
                    商务座：
                    <input type="text" class="form-control form-control-2" id="businessClass" name="businessClass"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    一等座：
                    <input type="text" class="form-control form-control-2" id="firstClass" name="firstClass"
                           autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    二等座：
                    <input type="text" class="form-control form-control-2" id="secondClass" name="secondClass"
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
            <form action="/action/Updateroute" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    路线号：
                    <input type="text" class="form-control form-control-2" name="rid" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    出发站：
                    <input type="text" class="form-control form-control-2" name="StationA" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    到达站：
                    <input type="text" class="form-control form-control-2" name="StationB" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    距&nbsp;&nbsp;&nbsp;&nbsp;离：
                    <input type="text" class="form-control form-control-2" name="distance" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    历&nbsp;&nbsp;&nbsp;&nbsp;时：
                    <input type="text" class="form-control form-control-2" name="time" autocomplete="off" required>
                </div>
                <div class="form-group form-group-2">
                    商务座：
                    <input type="text" class="form-control form-control-2" name="businessClass" autocomplete="off"
                           required>
                </div>
                <div class="form-group form-group-2">
                    一等座：
                    <input type="text" class="form-control form-control-2" name="firstClass" autocomplete="off"
                           required>
                </div>
                <div class="form-group form-group-2">
                    二等座：
                    <input type="text" class="form-control form-control-2" name="secondClass" autocomplete="off"
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
<div class="md-modal md-effect-5" id="modal-3">
    <div class="md-content">
        <h3>输入信息</h3>
        <div>
            <form action="/action/Deleteroute" class="sign_in_form" method="post">
                <div class="form-group form-group-2">
                    路线号：
                    <input type="text" class="form-control form-control-2" name="rid" autocomplete="off" required>
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
                            <th>路线号</th>
                            <th>出发站</th>
                            <th>到达站</th>
                            <th>距离</th>
                            <th>历时</th>
                            <th>商务座</th>
                            <th>一等座</th>
                            <th>二等座</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<RouteEntity> RouteList = (List<RouteEntity>) session.getAttribute("RouteList");
                            for (int i = 0; i < RouteList.size(); i++) {
                        %>
                        <tr>
                            <td>
                                <%=
                                RouteList.get(i).getRid()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getStationA()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getStationB()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getDistance()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getTime()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getBusinessClass()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getFirstClass()
                                %>
                            </td>
                            <td>
                                <%=
                                RouteList.get(i).getSecondClass()
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
