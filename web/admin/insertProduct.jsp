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
        <title>Insert Product</title>
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
            String product = null;
            product = request.getParameter("product");
            String error = null;
            error = (String) request.getAttribute("error");
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
                        <h1 class="page-header">Add Product</h1>
                    </div>
                </div><!--/.row-->            
                <div class="row">
                    <div class="col-lg-12">                   
                        <div class="panel panel-default">
                            <div class="panel-body">                            
                                <form role="form" action="${root}/WebBanHang/ManagerProductServlet" method="post">
                                <% if (product.equals("mobile")) { %>
                                <div class="col-md-6">
                                    <%
                                        if (error != null) {
                                            request.removeAttribute("error");
                                    %>
                                    <font color="red"><%=error%></font>
                                    <%}%>
                                    <div class="form-group">
                                        <label>Product Id</label>
                                        <input class="form-control" name="product_id">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Category Id</label>
                                        <input class="form-control" name="category_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Supply Id</label>
                                        <input class="form-control" name="supply_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Name</label>
                                        <input class="form-control" name="name">
                                    </div>

                                    <div class="form-group">
                                        <label>Price</label>
                                        <input class="form-control" name="price">
                                    </div>

                                    <div class="form-group">
                                        <label>Resolution</label>
                                        <input class="form-control" name="resolution">
                                    </div>

                                    <div class="form-group">
                                        <label>Opera System</label>
                                        <input class="form-control" name="operaSystem">
                                    </div>

                                    <div class="form-group">
                                        <label>Camera After</label>
                                        <input class="form-control" name="cameraAfter">
                                    </div>
                                    <div class="form-group">
                                        <label>Camera Front</label>
                                        <input class="form-control" name="cameraFront">
                                    </div>
                                    <div class="form-group">
                                        <label>CPU</label>
                                        <input class="form-control" name="cpu">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>RAM</label>
                                            <input class="form-control" name="ram">
                                        </div>

                                        <div class="form-group">
                                            <label>Memory</label>
                                            <input class="form-control" name="memory">
                                        </div>

                                        <div class="form-group">
                                            <label>Memory Card</label>
                                            <input class="form-control"name="memoryCard">
                                        </div>

                                        <div class="form-group">
                                            <label>SIM Card</label>
                                            <input class="form-control" name="simCard">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Connection</label>
                                            <input class="form-control" name="connection">
                                        </div>

                                        <div class="form-group">
                                            <label>Battery</label>
                                            <input class="form-control" name="battery">
                                        </div>

                                        <div class="form-group">
                                            <label>Design</label>
                                            <input class="form-control" name="design">
                                        </div>

                                        <div class="form-group">
                                            <label>Extra Information</label>
                                            <input class="form-control" name="extraInfo">
                                        </div>

                                        <div class="form-group">
                                            <label>Discount</label>
                                            <input class="form-control" name="discount">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit Button</button>
                                </div>                           
                                <input type="hidden" name="command" value="insert">
                                <input type="hidden" name="product" value="mobile">
                                <% } else if (product.equals("laptop")) { %>                                    
                                <div class="col-md-6">
                                    <%
                                        if (error != null) {
                                            request.removeAttribute("error");
                                    %>
                                    <font color="red"><%=error%></font>
                                    <%}%>
                                    <div class="form-group">
                                        <label>Product Id</label>
                                        <input class="form-control" name="product_id">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Category Id</label>
                                        <input class="form-control" name="category_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Supply Id</label>
                                        <input class="form-control" name="supply_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Name</label>
                                        <input class="form-control" name="name">
                                    </div>

                                    <div class="form-group">
                                        <label>Price</label>
                                        <input class="form-control" name="price">
                                    </div>

                                    <div class="form-group">
                                        <label>CPU</label>
                                        <input class="form-control" name="cpu">
                                    </div>

                                    <div class="form-group">
                                        <label>RAM</label>
                                        <input class="form-control" name="ram">
                                    </div>

                                    <div class="form-group">
                                        <label>Hard Disk</label>
                                        <input class="form-control" name="hardDisk">
                                    </div>
                                    <div class="form-group">
                                        <label>Screen</label>
                                        <input class="form-control" name="screen">
                                    </div>
                                    <div class="form-group">
                                        <label>Touch</label>
                                        <input class="form-control" name="touch">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Graphic</label>
                                            <input class="form-control" name="graphic">
                                        </div>

                                        <div class="form-group">
                                            <label>Optical Disk</label>
                                            <input class="form-control" name="opticalDisk">
                                        </div>

                                        <div class="form-group">
                                            <label>Webcam</label>
                                            <input class="form-control"name="webcam">
                                        </div>

                                        <div class="form-group">
                                            <label>Material</label>
                                            <input class="form-control" name="material">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Gates</label>
                                            <input class="form-control" name="gates">
                                        </div>

                                        <div class="form-group">
                                            <label>Connection</label>
                                            <input class="form-control" name="connection">
                                        </div>

                                        <div class="form-group">
                                            <label>Battery</label>
                                            <input class="form-control" name="battery">
                                        </div>

                                        <div class="form-group">
                                            <label>Weight</label>
                                            <input class="form-control" name="weight">
                                        </div>

                                        <div class="form-group">
                                            <label>Discount</label>
                                            <input class="form-control" name="discount">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit Button</button>
                                </div>                                                          
                                <input type="hidden" name="command" value="insert">
                                <input type="hidden" name="product" value="laptop">
                                <% } else if (product.equals("camera")) { %>                                   
                                <div class="col-md-6">
                                    <%
                                        if (error != null) {
                                            request.removeAttribute("error");
                                    %>
                                    <font color="red"><%=error%></font>
                                    <%}%>
                                    <div class="form-group">
                                        <label>Category Id</label>
                                        <input class="form-control" name="category_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Supply Id</label>
                                        <input class="form-control" name="supply_id">
                                    </div>

                                    <div class="form-group">
                                        <label>Name</label>
                                        <input class="form-control" name="name">
                                    </div>

                                    <div class="form-group">
                                        <label>Categorize</label>
                                        <input class="form-control" name="categorize">
                                    </div>

                                    <div class="form-group">
                                        <label>Sensor</label>
                                        <input class="form-control" name="sensor">
                                    </div>

                                    <div class="form-group">
                                        <label>Image Processor</label>
                                        <input class="form-control" name="imageProcessor">
                                    </div>

                                    <div class="form-group">
                                        <label>Lens</label>
                                        <input class="form-control" name="lens">
                                    </div>
                                    <div class="form-group">
                                        <label>Film</label>
                                        <input class="form-control" name="film">
                                    </div>
                                    <div class="form-group">
                                        <label>Shutter Speed</label>
                                        <input class="form-control" name="shutterSpeed">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Connection</label>
                                            <input class="form-control" name="connection">
                                        </div>

                                        <div class="form-group">
                                            <label>Screen</label>
                                            <input class="form-control" name="screen">
                                        </div>

                                        <div class="form-group">
                                            <label>Battery</label>
                                            <input class="form-control"name="battery">
                                        </div>

                                        <div class="form-group">
                                            <label>Memory Card</label>
                                            <input class="form-control" name="memoryCard">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="form-group">
                                            <label>Made in</label>
                                            <input class="form-control" name="madeIn">
                                        </div>

                                        <div class="form-group">
                                            <label>Warranty</label>
                                            <input class="form-control" name="warranty">
                                        </div>

                                        <div class="form-group">
                                            <label>Weight</label>
                                            <input class="form-control" name="weight">
                                        </div>

                                        <div class="form-group">
                                            <label>Price</label>
                                            <input class="form-control" name="price">
                                        </div>

                                        <div class="form-group">
                                            <label>Discount</label>
                                            <input class="form-control" name="discount">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Submit Button</button>
                                </div>                                                                                     
                                <input type="hidden" name="command" value="insert">
                                <input type="hidden" name="product" value="camera">
                                <% }%>
                            </form>                            
                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

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
