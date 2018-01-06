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
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">


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
                Jason
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
                                <div id="center">
                                    <div id="center_left">
                                        <i class="fa fa-spinner fa-spin fa-5x"></i>
                                    </div>
                                    <div id="center_right">
                                        很抱歉，按您的查询条件，当前未找到符合条件的列车。
                                        您可以使用<a href="transfer.jsp">接续换乘</a>功能，查询途中换乘一次的部分列车余票情况。
                                    </div>
                                </div>
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
