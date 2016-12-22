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
        <title>Supply Laptop Manager</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>

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
                        <li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                        <li class="active">Icons</li>
                    </ol>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Supply Laptop</h1>
                    </div>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a href="insertSupply.jsp?table=supplier_laptop">Add Supply</a>
                            </div>
                            <div class="panel-body">
                                <table border="1" bordercolor="gray" width="900">
                                    <thead>
                                        <tr>
                                            <th>Supply ID</th>
                                            <th>Supply Name</th>
                                        </tr>
                                    <%
                                        for (Supplier s : listSupplier) {
                                    %>
                                    <tr>
                                        <td><%=s.getSupplier_id()%></td>
                                        <td><%=s.getSupplier_name()%></td>
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
                            <a href="insertProduct.jsp?product=laptop">Add Item</a>
                        </div>
                        <div class="panel-body">
                            <table border="1" bordercolor="gray" width="880">
                                <thead>
                                    <tr>
                                        <th><center>Item ID</center></th>                                       
                                        <th><center>Item Name</center></th>
                                        <th><center>Item Price</center></th>                                       
                                        <th><center>Item Sale (%)</center></th>
                                        <th><center>Option</center></th>
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
                                                <a href="updateProduct.jsp?product=laptop&product_id=<%=laptop.getProduct_id()%>">Update</a>&nbsp; | &nbsp;
                                                <a href="ManagerProductServlet?product=laptop&product_id=<%=laptop.getProduct_id()%>">Remove</a>
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


        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/bootstrap-table.js"></script>
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