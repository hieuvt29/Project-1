<%-- 
    Document   : products
    Created on : 05-Oct-2016, 15:35:41
    Author     : admin
--%>

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
            String  product = null,
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
                        <div class="cont span_2_of_3">
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
                            <div class="top-box">  
                            <%  
                                for (Product p : productDAO.getProducts(supplier)) {
                            %>
                            <div class="col_1_of_3 span_1_of_3">                                
                                <a href="single.jsp?product_id=<%=p.getProduct_id()%>">
                                    <div class="inner_content clearfix">
                                        <div class="product_image">
                                            <%
                                                String img = null;
                                                if(product.equals("Laptop")){
                                                    img = "images/" + p.getProduct_name().split("/")[0] +" (1)" + ".jpg";
                                                }else{
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
                                                <p class="title"><%=p.getProduct_name()%></p>
                                                <div class="price1">
                                                    <span class="actual"><%=p.getProduct_price()%><span>0.000₫</span></span>
                                                </div>
                                            </div>
                                            <div class="cart-right"> </div>
                                            <div class="clear"></div>
                                        </div>
                                        <%
                                            }else if(p.getCategory_id() == 2) {
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
                                            }else if(p.getCategory_id() == 3) {
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
                                }
                            %>
                            <div class="clear"></div>
                        </div>	                            	                           	                           	                        		 						 			    
                    </div>		                            			 							 			    
                </div>
                <div class="rsingle span_1_of_single">
                    <h5 class="m_1">DANH MỤC</h5>
                    <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                        <option value="1">ĐIỆN THOẠI</option>                               
                    </select>
                    <select class="dropdown" tabindex="8" data-settings='{"wrapperClass":"metro"}'>
                        <option value="1">LAPTOP</option>
                    </select>
                    <ul class="kids">
                        <li><a href="#">MÁY ẢNH</a></li>
                    </ul>
                    <section  class="sky-form">
                        <h4>GIÁ</h4>
                        <div class="row row1 scroll-pane">
                            <div class="col col-4">
                                <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Rs 500 - Rs 700</label>
                            </div>
                            <div class="col col-4">
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 700 - Rs 1000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 1000 - Rs 1500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 1500 - Rs 2000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 2000 - Rs 2500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>Rs 2500 - Rs 3000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 3500 - Rs 4000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 4000 - Rs 4500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 4500 - Rs 5000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 5000 - Rs 5500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 5500 - Rs 6000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 6000 - Rs 6500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 6500 - Rs 7000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 7000 - Rs 7500</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 7500 - Rs 8000</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Rs 8000 - Rs 8500</label>	
                            </div>
                        </div>
                    </section>
                    <section  class="sky-form">
                        <h4>Brand Name</h4>
                        <div class="row row1 scroll-pane">
                            <div class="col col-4">
                                <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>John Jacobs</label>
                            </div>
                            <div class="col col-4">
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Tag Heuer</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Lee Cooper</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Mikli</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>S Oliver</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>Hackett</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Killer</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>IDEE</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Vogue</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Gunnar</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Accu Reader</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>CAT</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Excellent</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Feelgood</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Odysey</label>
                                <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Animal</label>	
                            </div>
                        </div>
                    </section>

                    <section  class="sky-form">
                        <h4>MÀU SẮC</h4>
                        <ul class="color-list">
                            <li><a href="#"> <span class="color1"> </span><p class="red">Red</p></a></li>
                            <li><a href="#"> <span class="color2"> </span><p class="red">Green</p></a></li>
                            <li><a href="#"> <span class="color3"> </span><p class="red">Blue</p></a></li>
                            <li><a href="#"> <span class="color4"> </span><p class="red">Yellow</p></a></li>
                            <li><a href="#"> <span class="color5"> </span><p class="red">Violet</p></a></li>
                            <li><a href="#"> <span class="color6"> </span><p class="red">Orange</p></a></li>
                            <li><a href="#"> <span class="color7"> </span><p class="red">Gray</p></a></li>
                        </ul>
                    </section>
                    <script src="js/jquery.easydropdown.js"></script>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <script src="js/jquery.easydropdown.js"></script>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
