<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/12
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style_2.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
<h1>后台管理</h1>
<h2></h2>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>功能描述</th>
                    <th class="text-right">进入</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>教师管理</td>
                    <td class="text-right">
                        <form action="/action/Listroute" method="post">
                            <button type="submit" class="btn btn-info">
                                <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>学生管理</td>
                    <td class="text-right">
                        <form action="/action/Liststation" method="post">
                            <button type="submit" class="btn btn-info">
                                <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>课程管理</td>
                    <td class="text-right">
                        <form action="/action/ListTrip" method="post">
                            <button type="submit" class="btn btn-info">
                                <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>签到管理</td>
                    <td class="text-right">
                        <form action="/action/ListUser" method="post">
                            <button type="submit" class="btn btn-info">
                                <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
