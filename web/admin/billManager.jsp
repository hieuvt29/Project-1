<%-- 
    Document   : product_admin
    Created on : Oct 24, 2016, 9:45:00 AM
    Author     : LOREMSUM
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Bill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill Manager</title>
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
        <jsp:include page="bars.jsp"></jsp:include>
            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
                <div class="row">
                    <ol class="breadcrumb">
                        <li><a href="${root}/WebBanHang/admin/dashboard.jsp""><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                        <li class="active"><a href="${root}/WebBanHang/ManagerBillServlet"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Hóa đơn </a></li>                
                    </ol>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Hóa đơn</h1>
                    </div>
                </div><!--/.row-->

                <div class="row">
                    <div class="col-md-10">
                        <div class="panel panel-default">
                            <div class="panel-body">
                            <%
                                ArrayList<Bill> userBills = (ArrayList<Bill>) request.getAttribute("bills");

                            %>
                            <div class="top-box">
                                <table class="table" border="1" bordercolor="gray" width="880">
                                    <thead>
                                        <tr>
                                            <th><center>Stt</center></th>                                       
                                    <th><center>Mã đơn hàng</center></th>
                                    <th><center>Giá trị</center></th>                                       
                                    <th><center>Phương thức thanh toán</center></th>
                                    <th><center>Địa chỉ</center></th>
                                    <th><center>Ngày đặt hàng</center></th>
                                    <th><center>Ngày thanh toán</center></th>
                                    <th><center>Thao tác</center></th>
                                    </tr>
                                    <%                                        Bill bill = null;
                                        for (int i = 0; i < userBills.size(); i++) {
                                            bill = userBills.get(i);
                                    %>
                                    <tr>
                                        <td align="center"><%=i + 1%></td>                                        
                                        <td align="center"><%=bill.getBill_id()%></td>
                                        <td align="center"><%=new DecimalFormat("###,###,###").format(bill.getBill_total() * Math.pow(10, 6))%><span>₫</span></td>                                       
                                        <td align="center"><%=bill.getBill_payment()%></td>
                                        <td align="center"><%=bill.getBill_address()%></td>
                                        <td align="center"><%=bill.getBill_order_date()%></td>
                                        <td align="center"><%=bill.getBill_receipt_date()%></td>
                                        <td width="150">
                                    <center>
                                        <%
                                            if(bill.getBill_receipt_date() == null){
                                        %>
                                        <a href="${root}/WebBanHang/ManagerBillServlet?command=process&bill_id=<%=bill.getBill_id()%>">Process</a>&nbsp; | &nbsp;
                                        <a href="${root}/WebBanHang/ManagerBillServlet?command=cancel&bill_id=<%=bill.getBill_id()%>">Cancel</a>
                                        <%}else if(bill.getBill_receipt_date().compareTo(new Date(0)) <= 0){%>
                                        <span style="color: red">Đã hủy</span>
                                        <%}else{%>
                                        <span style="color: green">Thành công</span>
                                        <%}%>
                                    </center>
                                    </td>
                                    </tr>
                                    <%}%>
                                    </thead>
                                </table>
                                <div class="clear"></div>

                            </div>
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
