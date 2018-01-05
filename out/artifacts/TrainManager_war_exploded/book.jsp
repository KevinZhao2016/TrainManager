<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2017/12/25
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>查询结果</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="css/demo.css" rel="stylesheet" />
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('img/paper-2.jpeg')">
    <!--   Creative Tim Branding   -->
    <a href="#">
        <div class="logo-container">
            <div class="logo">
                <img src="img/new_logo.png">
            </div>
            <div class="brand">
                Jason
            </div>
        </div>
    </a>
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card">
                        <form action="/action/query.action" method="post">
                            <div class="wizard-header">
                                <h3 class="wizard-title">车票查询</h3>
                                <p class="category">Query ticket</p>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <h5 class="info-text"> 请选择具体信息</h5>
                                </div>
                                <div class="col-sm-5 col-sm-offset-1">
                                    <div class="form-group">
                                        <label>出发地</label><br>
                                        <select name="DepartureStation" class="form-control" required>
                                            <option disabled="" selected="">- 城市 -</option>
                                            <option value="hangzhoudong"> 杭州东 </option>
                                            <option value="dezhoudong"> 德州东 </option>
                                            <option value="shanghaihongqiao"> 上海虹桥 </option>
                                            <option value="beijingnan"> 北京南 </option>
                                            <option value="ningbo"> 宁波 </option>
                                            <option value="nanjingnan"> 南京南 </option>
                                            <option value="jinan"> 济南 </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-5">
                                    <div class="form-group">
                                        <label>目的地</label><br>
                                        <select name="ArrivalStation" class="form-control" required>
                                            <option disabled="" selected="">- 城市 -</option>
                                            <option value="hangzhoudong"> 杭州东 </option>
                                            <option value="dezhoudong"> 德州东 </option>
                                            <option value="shanghaihongqiao"> 上海虹桥 </option>
                                            <option value="beijingnan"> 北京南 </option>
                                            <option value="ningbo"> 宁波 </option>
                                            <option value="nanjingnan"> 南京南 </option>
                                            <option value="jinan"> 济南 </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-5 col-sm-offset-1">
                                    <div class="form-group">
                                        <label>乘车人数</label>
                                        <select class="form-control">
                                            <option disabled="" selected="">- 人数 -</option>
                                            <option>1 Person</option>
                                            <option>2 Persons </option>
                                            <option>3 Persons</option>
                                            <option>4 Persons</option>
                                            <option>5 Persons</option>
                                            <option>6+ Persons</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-5">
                                    <div class="form-group">
                                        <label>乘车日期</label>
                                        <input type="date" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='submit' class='btn btn-finish btn-fill btn-success btn-wd' name='finish' value='查询' />
                                </div>

                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->

    <div class="footer">
        <div class="container text-center">
            <p><small>&copy; All Rights Reserved.</small></p>
        </div>
    </div>
</div>

</body>
</html>

