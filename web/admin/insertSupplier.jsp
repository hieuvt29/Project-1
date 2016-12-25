<%-- 
    Document   : dienthoaiManager
    Created on : 17-Dec-2016, 22:35:23
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Supply</title>
        <link href="${root}/WebBanHang/admin/css/bootstrap.min.css" rel="stylesheet">
        <link href="${root}/WebBanHang/admin/css/datepicker3.css" rel="stylesheet">
        <link href="${root}/WebBanHang/admin/css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="${root}/WebBanHang/admin/js/lumino.glyphs.js"></script>

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <%
            String error = null;
            error = (String) request.getAttribute("error");
            String table = null;
            table = request.getParameter("table");
        %>
        <jsp:include page="bars.jsp"></jsp:include>

            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
                <div class="row">
                    <ol class="breadcrumb">
                        <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                        <li class="active">Icons</li>
                    </ol>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Thêm nhà cung cấp</h1>
                    </div>
                </div><!--/.row-->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form role="form" action="${root}/WebBanHang/ManagerSupplierServlet" method="post">
                                <div class="col-md-6">
                                    <%
                                        if (error != null) {
                                            request.removeAttribute("error");
                                    %>
                                    <font color="red"><%=error%></font>
                                    <%}%>
                                    <div class="form-group">
                                        <label>Tên nhà cung cấp</label>
                                        <input class="form-control" placeholder="Name" name="supplier_name">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                                <input type="hidden" name="command" value="insert">
                                <input type="hidden" name="table" value="<%=table%>">
                            </form>
                        </div>
                    </div><!-- /.col-->
                </div><!-- /.row -->

            </div><!--/.main-->


            <script src="${root}/WebBanHang/admin/js/jquery-1.11.1.min.js"></script>
            <script src="${root}/WebBanHang/admin/js/bootstrap.min.js"></script>
            <script src="${root}/WebBanHang/admin/js/chart.min.js"></script>
            <script src="${root}/WebBanHang/admin/js/chart-data.js"></script>
            <script src="${root}/WebBanHang/admin/js/easypiechart.js"></script>
            <script src="${root}/WebBanHang/admin/js/easypiechart-data.js"></script>
            <script src="${root}/WebBanHang/admin/js/bootstrap-datepicker.js"></script>
            <script src="${root}/WebBanHang/admin/js/bootstrap-table.js"></script>
            <script>
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