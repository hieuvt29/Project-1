<%-- 
    Document   : products
    Created on : 05-Oct-2016, 15:35:41
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.LaptopDAO"%>
<%@page import="dao.MayanhDAO"%>
<%@page import="dao.ProductDAO"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
        <%
            String product = null,
                    supplier = null;
            ProductDAO productDAO = null;

            product = request.getParameter("product");
            supplier = request.getParameter("supplier_id");

            if (product.equals("Dienthoai")) {
                productDAO = new DienthoaiDAO();
            } else if (product.equals("Laptop")) {
                productDAO = new LaptopDAO();
            } else if (product.equals("Mayanh")) {
                productDAO = new MayanhDAO();
            } else {
                //redirect response
            }

        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="mens">    
                <div class="main">
                    <div class="wrap">
                        <div class="cont span_3_of_3">
                            <div class="mens-toolbar">
                                <div class="sort">
                                    <div class="sort-by">
                                        <label>Sort By</label>
                                        <select>
                                            <option value="">
                                                Vị trí                </option>
                                            <option value="">
                                                Tên                </option>
                                            <option value="">
                                                Giá                </option>
                                        </select>
                                        <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
                                    </div>
                                </div>
                                <div class="pager">   
                                    <div class="limiter visible-desktop">
                                        <label>Show</label>
                                        <select>
                                            <option value="" selected="selected">
                                                9                </option>
                                            <option value="">
                                                15                </option>
                                            <option value="">
                                                30                </option>
                                        </select> per page        
                                    </div>
                                    <ul class="dc_pagination dc_paginationA dc_paginationA06">
                                        <li><a href="#" class="previous">Pages</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                    </ul>
                                    <div class="clear"></div>
                                </div>
                                <div class="clear"></div>
                            </div>

                        <%                            
                            ArrayList<Product> productList = productDAO.getProducts(supplier);
                            int numProducts = productList.size();
                            for (int i = 0; i < numProducts; i++) {
                                Product p = productList.get(i);
                                if (i % 3 == 0) {
                        %>
                                <div class="top-box">
                        <%}
                        %>

                            <div class="col_1_of_3 span_1_of_3">                                
                                <a href="single.jsp?product_id=<%=p.getProduct_id()%>">
                                    <div class="inner_content clearfix">
                                        <div class="product_image">
                                            <%
                                                String img = null;
                                                if (product.equals("Laptop")) {
                                                    img = "images/" + p.getProduct_name().split("/")[0] + " (1)" + ".jpg";
                                                } else {
                                                    img = "images/" + p.getProduct_name() + " (1)" + ".jpg";
                                                }
                                            %>
                                            <img src="<%=img%>" alt=""/>
                                        </div>
                                        <%
                                            if (p.getCategory_id() == 1) {
                                        %>
                                        <div class="sale-box"><span class="on_sale title_shop">New</span></div>
                                        <div class="price">
                                            <div class="cart-left">
                                                <p class="title"><%=p.getProduct_name().length() > 20 ? p.getProduct_name().substring(0, 30) + "... " : p.getProduct_name()%></p>
                                                <div class="price1">
                                                    <span class="actual"><%=p.getProduct_price()%><span>0.000₫</span></span>
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
                                                    <span class="actual"><%=p.getProduct_price()%><span>0.000₫</span></span>
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
                                                    <span class="reducedfrom"><%=p.getProduct_price()%><span>0.000₫</span></span>
                                                    <span class="actual"><%=p.getProduct_price() - (p.getProduct_price() * p.getProduct_discount() / 100)%><span>0.000₫</span></span>
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
    </div>
    <script src="js/jquery.easydropdown.js"></script>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
