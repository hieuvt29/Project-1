<%-- 
    Document   : products
    Created on : 05-Oct-2016, 15:35:41
    Author     : admin
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Laptop"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Category"%>
<%@page import="model.Dienthoai"%>
<%@page import="dao.DienthoaiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <script src="js/jquery1.min.js"></script>
        <!-- start menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
        <script type="text/javascript" id="sourcecode">
            $(function ()
            {
                $('.scroll-pane').jScrollPane();
            });
        </script>
    </head>
    <body>


        <jsp:include page="header.jsp"></jsp:include>

            <div class="mens">    
                <div class="main">
                    <div class="wrap">
                        <div class="cont span_3_of_3">
                            <div class="mens-toolbar">
                                <h4>Danh sách sản phẩm</h4>
                                <div class="clear"></div>
                            </div>
                            
                        <%  
                            
                            ArrayList<Product> productList = (ArrayList < Product >) request.getAttribute("productList");
                            request.removeAttribute("productList");
                            if(productList == null){
                                response.sendRedirect("index.jsp");
                            }
                            int numProducts = productList.size();
                          
                            for (int i = 0; i < numProducts; i++) {
                                Product p = productList.get(i);
                                if (i % 3 == 0) {
                        %>
                                <div class="top-box">
                        <%}
                        %>

                            <div class="col_1_of_3 span_1_of_3">                                
                                <a href="SingleServlet?product_id=<%=p.getProduct_id()%>">
                                    <div class="inner_content clearfix">
                                        <div class="product_image">
                                            <%
                                                String img = null;
                                                img = "images/" + p.getProduct_id() + " (1)" + ".jpg";
                                            %>
                                            <img src="<%=img%>" alt=""/>
                                        </div>
                                        <%
                                            if (p.getCategory_id() == 1) {
                                        %>
                                        <div class="sale-box"><span class="on_sale title_shop">New</span></div>
                                        <div class="price">
                                            <div class="cart-left">
                                                <p class="title"><%=p.getProduct_name()%></p>
                                                <div class="price1">
                                                    <span class="actual"><%=new DecimalFormat("###,###,###").format(Math.round(p.getProduct_price() * Math.pow(10, 6)))%><span>₫</span></span>
                                                </div>
                                            </div>
                                            <div class="cart-right"> </div>
                                            <div class="clear"></div>
                                        </div>
                                        <%
                                        } else if (p.getCategory_id() == 2) {
                                        %>
                                        <div class="price">
                                            <div class="cart-left">
                                                <p class="title"><%=p.getProduct_name()%></p>
                                                <div class="price1">
                                                    <span class="actual"><%=new DecimalFormat("###,###,###").format(Math.round(p.getProduct_price() * Math.pow(10, 6)))%><span>₫</span></span>
                                                </div>
                                            </div>
                                            <div class="cart-right"> </div>
                                            <div class="clear"></div>
                                        </div>
                                        <%
                                        } else if (p.getCategory_id() == 3) {
                                        %>
                                        <div class="sale-box1"><span class="on_sale title_shop">Sale</span></div>
                                        <div class="price">
                                            <div class="cart-left">
                                                <p class="title"><%=p.getProduct_name()%></p>
                                                <div class="price1">
                                                    <span class="reducedfrom"><%=new DecimalFormat("###,###,###").format(Math.round(p.getProduct_price() * Math.pow(10, 6)))%><span>₫</span></span>
                                                    <span class="actual"><%=new DecimalFormat("###,###,###").format(Math.round((p.getProduct_price() - (p.getProduct_price() * p.getProduct_discount() / 100)) * Math.pow(10, 6)))%><span>₫</span></span>
                                                </div>
                                            </div>
                                            <div class="cart-right"> </div>
                                            <div class="clear"></div>
                                        </div>
                                        <%
                                            }
                                        %>
                                    </div>
                                </a>
                            </div>

                            <%
                                if (i % 3 == 2 || (i == numProducts -1 && i % 3 == 1) || (i == numProducts - 1 && i % 3 == 0)) {
                            %>
                        </div>
                        <div class="clear"></div>
                        <%
                                }
                            }
                        %>
                        
                    </div>	                            	                           	                           	                        		 						 			    
                </div>		                            			 							 			    
            </div>

            <div class="clear"></div>
        </div>
    <script src="js/jquery.easydropdown.js"></script>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>