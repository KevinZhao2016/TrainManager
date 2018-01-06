<%@ page import="java.util.List" %>
<%@ page import="com.entity.QueryResult" %>
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
    <title>查询结果</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-bootstrap-wizard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
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
                            </div>
                            <div class="row">
                                <div id="container">

                                    <table class="zebra" id="tableSort">
                                        <thead>
                                        <tr>
                                            <th>车次</th>
                                            <th  onclick="sortAble(this,'tableSort', 1,'date')" style="cursor: pointer;">出发时间</th>
                                            <th onclick="sortAble(this,'tableSort', 2,'date')" style="cursor: pointer;">到达时间</th>
                                            <th  onclick="sortAble(this,'tableSort', 3,'date')" style="cursor: pointer;">历时</th>
                                            <th>商务座</th>
                                            <th>一等座</th>
                                            <th>二等座</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                             List<QueryResult> queryResultList = (List<QueryResult>)session.getAttribute("queryResultList");
                                          for(int i=0; i< queryResultList.size();i++){
                                            out.print("<tr group="+i+">");
                                        %>
                                            <td>
                                                <%=
                                                    queryResultList.get(i).getTripBeans().get(0).getTname()
                                                %>
                                            </td>
                                            <td>
                                                <%=
                                                queryResultList.get(i).getDepartureTime()
                                                %>
                                            </td>
                                            <td>
                                                <%=
                                                queryResultList.get(i).getArrivalTime()
                                                %>
                                            </td>
                                            <td>
                                                <%=
                                                queryResultList.get(i).getTotalTime()
                                                %>
                                            </td>
                                            <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                            <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                            <td class="ticket_font" onclick="show_price(this)" style="cursor: pointer">有</td>
                                        </tr>
                                        <tr style="display: none" parent=<%=i%>>
                                            <td colspan="4"></td>
                                            <td>
                                                <%="￥"+
                                                queryResultList.get(i).getTripBeans().get(0).getBusinessClassPrice()
                                                %>
                                            </td>
                                            <td>
                                                <%="￥"+
                                                queryResultList.get(i).getTripBeans().get(0).getFirstClassPrice()
                                                %>
                                            </td>
                                            <td>
                                                <%="￥"+
                                                queryResultList.get(i).getTripBeans().get(0).getSecondClassPrice()
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

