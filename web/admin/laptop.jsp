<%-- 
    Document   : product_admin
    Created on : Oct 24, 2016, 9:45:00 AM
    Author     : LOREMSUM
--%>

<%@page import="model.Product"%>
<%@page import="dao.LaptopDAO"%>
<%@page import="model.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SupplierDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Laptop Manager</title>
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
            SupplierDAO supplierDAO = new SupplierDAO();
            ArrayList<Supplier> listSupplier = supplierDAO.getSupplierList("supplier_laptop");
            
            LaptopDAO laptopDAO = new LaptopDAO();
            ArrayList<Product> listLaptop = laptopDAO.getProducts("%", "%", 50);
        %>

        <jsp:include page="bars.jsp"></jsp:include>
            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
                <div class="row">
                    <ol class="breadcrumb">
                        <li><a href="${root}/WebBanHang/admin/dashboard.jsp""><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                        <li class="active"><a href="${root}/WebBanHang/admin/laptop.jsp"><svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>Laptop</a></li>
                    </ol>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Nhà cung cấp Laptop</h1>
                    </div>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a href="${root}/WebBanHang/admin/insertSupplier.jsp?table=supplier_laptop">Thêm nhà cung cấp</a>
                            </div>
                            <div class="panel-body">
                                <table class="table" border="1" bordercolor="gray" width="900">
                                    <thead>
                                        <tr>
                                            <th><center>Mã NCC</center></th>
                                            <th><center>Tên NCC</center></th>
                                        </tr>
                                    <%
                                        for (Supplier s : listSupplier) {
                                    %>
                                    <tr>
                                        <td align="center"><%=s.getSupplier_id()%></td>
                                        <td align="center"><%=s.getSupplier_name()%></td>
                                    </tr>
                                    <%}%>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>

            </div><!--/.row-->	

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Laptop</h1>
                </div>
            </div><!--/.row-->

            <div class="row">
                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="${root}/WebBanHang/admin/insertProduct.jsp?product=laptop">Thêm sản phẩm</a>
                        </div>
                        <div class="panel-body">
                            <table class="table" border="1" bordercolor="gray" width="880">
                                <thead>
                                    <tr>
                                        <th><center>Mã sản phẩm</center></th>                                       
                                        <th><center>Tên sản phẩm</center></th>
                                        <th><center>Giá sản phẩm</center></th>                                       
                                        <th><center>Giảm giá (%)</center></th>
                                        <th><center>Thao tác</center></th>
                                    </tr>
                                    <%
                                        for(Product laptop : listLaptop) {
                                    %>
                                    <tr>
                                        <td align="center"><%=laptop.getProduct_id()%></td>                                        
                                        <td align="center"><%=laptop.getProduct_name()%></td>
                                        <td align="center"><%=laptop.getProduct_price()%><span>0.000₫</span></td>                                       
                                        <td align="center"><%=laptop.getProduct_discount()%></td>
                                        <td width="150">
                                            <center>
                                                <a href="${root}/WebBanHang/admin/updateProduct.jsp?product=laptop&product_id=<%=laptop.getProduct_id()%>">Cập nhật</a>&nbsp; | &nbsp;
                                                <a href="${root}/WebBanHang/ManagerProductServlet?command=remove&product=laptop&product_id=<%=laptop.getProduct_id()%>">Xóa</a>
                                            </center>
                                        </td>
                                    </tr>
                                    <%}%>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>

            </div><!--/.row-->	

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