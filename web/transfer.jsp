<%@ page import="java.util.List" %>
<%@ page import="com.model.QueryResult" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lipen
  Date: 2018/1/5
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>接续换乘</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/demo.css" rel="stylesheet" />
    <link href="css/style_2.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/my_add.js"></script>
</head>

<body>

<div class="image-container set-full-height" style="background-image: url('images/paper-2.jpeg')">
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
                <s:property value="#session.userName"/>
            </div>
        </div>
    </a>
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" >
                        <!--        You can switch " data-color="green" "  with one of the next bright colors: "blue", "azure", "orange", "red"       -->
                        <div class="wizard-header">
                            <h3 class="wizard-title">查询结果</h3>
                            <p class="category">Query result</p>
                            <div class="choose_sort selectpicker">
                            <select name="country" class="form-control" onchange="sortBySelecter(this)">
                                <option  selected="" value="0">按出发时间排序</option>
                                <option value="1"> 按总历时排序 </option>
                                <option value="2"> 按价格排序 </option>
                            </select>
                            </div>
                        </div>
                        <div class="row">
                            <div id="container">
                                <table class="zebra zebra_2" id="tableSort">
                                    <thead>
                                    <tr>
                                        <th>车次</th>
                                        <th>出发站</th>
                                        <th >出发时间</th>
                                        <th>到达站</th>
                                        <th >到达时间</th>
                                        <th>历时</th>
                                        <th>商务座</th>
                                        <th>一等座</th>
                                        <th>二等座</th>
                                        <th style="display: none"></th>
                                        <th style="display: none"></th>
                                        <th style="display: none"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<QueryResult> queryResultList = (List<QueryResult>)session.getAttribute("queryResultList");
                                        for(int i=0; i< queryResultList.size();i++){
                                    %>
                                    <tr style="border: none" class="ticket_title" group=<%=i%>>
                                        <td colspan="9">
                                            <i class="fa fa-clock-o"></i>
                                            出发时间：
                                            <%--<%= queryResultList.get(i).getDepartureTime()%>--%>
                                            <%= queryResultList.get(i).getTripBeans().get(0).getDepartureTime()%>
                                            &nbsp;
                                            <i class="fa fa-train"></i>
                                            <%=queryResultList.get(i).getDepartureStation()%>
                                            <i class="fa fa-long-arrow-right"></i>
                                            <%=queryResultList.get(i).getTransferStation()%>
                                            <i class="fa fa-long-arrow-right"></i>
                                            <%=queryResultList.get(i).getArrivalStation()%>&nbsp;&nbsp;
                                            <i class="fa fa-clock-o"></i>
                                            总历时：<%=queryResultList.get(i).getTotalTime()%>&nbsp;&nbsp;
                                            <i class="fa fa-jpy"></i>
                                            总价格：<%=queryResultList.get(i).getTotalSecondClassPrice()%>元起
                                        </td>
                                        <td style="display: none">
                                            <%=
                                            queryResultList.get(i).getTripBeans().get(0).getDepartureTime()
                                            %>
                                        </td>
                                        <td style="display: none">
                                            queryResultList.get(i).getTotalTime()
                                        </td>
                                        <td style="display: none">
                                            <%=
                                                queryResultList.get(i).getTotalSecondClassPrice()
                                            %>

                                        </td>
                                    </tr>
                                    <%
                                        for(int j=0; j<2;j++){
                                    %>
                                    <tr parent=<%=i%>>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getTname()
                                        %>
                                    </td>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getDepartureStation()
                                        %>
                                    </td>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getDepartureTime()
                                        %>
                                    </td>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getArrivalStation()
                                        %>
                                    </td>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getArrivalTime()
                                        %>
                                    </td>
                                    <td>
                                        <%=
                                        queryResultList.get(i).getTripBeans().get(j).getTripTime()
                                        %>
                                    </td>
                                    <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                    <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                    <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                    </tr>
                                    <tr style="display: none" parent=<%=i%>>
                                        <td colspan="6"></td>
                                        <td>
                                            <%="￥"+
                                                    queryResultList.get(i).getTripBeans().get(j).getBusinessClassPrice()
                                            %>
                                        </td>
                                        <td>
                                            <%="￥"+
                                                    queryResultList.get(i).getTripBeans().get(j).getFirstClassPrice()
                                            %>
                                        </td>
                                        <td>
                                            <%="￥"+
                                                    queryResultList.get(i).getTripBeans().get(j).getSecondClassPrice()
                                            %>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
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
            <p><small>&copy; All Rights Reserved.</small></p>
        </div>
    </div>
</div>

</body>
</html>
