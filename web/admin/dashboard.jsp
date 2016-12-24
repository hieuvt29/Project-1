<%-- 
    Document   : index
    Created on : Oct 16, 2016, 1:43:26 PM
    Author     : LOREMSUM
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lumino - Dashboard</title>

        <link href="${root}/WebBanHang/admin/css/bootstrap.min.css" rel="stylesheet">
        <link href="${root}/WebBanHang/admin/css/datepicker3.css" rel="stylesheet">
        <link href="${root}/WebBanHang/admin/css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="${root}/WebBanHang/admin/js/lumino.glyphs.js"></script>

        <!--[if lt IE 9]>
        <script src="${root}/WebBanHang/admin/js/html5shiv.js"></script>
        <script src="${root}/WebBanHang/admin/js/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <jsp:include page="bars.jsp" ></jsp:include>

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="${root}/WebBanHang/admin/dashboard.jsp""><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active"><a href="${root}/WebBanHang/admin/dashboard.jsp"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Bảng điều khiển</a></li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Bảng điều khiển</h1>
                </div>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Thống kê</div>
                        <div class="panel-body">
                            <div class="canvas-wrapper">
                                <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.row-->


            <!-- extra panel-->
            <div class="row">
                <div class="col-md-12">

                    <!--Calendar-->
                    <div class="panel panel-red">
                        <div class="panel-heading dark-overlay"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg>Calendar</div>
                        <div class="panel-body">
                            <div id="calendar"></div>
                        </div>
                    </div>
                </div><!--/.col-->

            </div><!--/.row-->
        </div>	<!--/.main-->

        <script src="${root}/WebBanHang/admin/js/jquery-1.11.1.min.js"></script>
        <script src="${root}/WebBanHang/admin/js/bootstrap.min.js"></script>
        <script src="${root}/WebBanHang/admin/js/chart.min.js"></script>
        <script src="${root}/WebBanHang/admin/js/chart-data.js"></script>
        <script src="${root}/WebBanHang/admin/js/easypiechart.js"></script>
        <script src="${root}/WebBanHang/admin/js/easypiechart-data.js"></script>
        <script src="${root}/WebBanHang/admin/js/bootstrap-datepicker.js"></script>
        <script src="${root}/WebBanHang/admin/js/bootstrap-table.js"></script>
        <script>
            $("#calendar").datepicker({
            });
            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>
    </body>
</html>
