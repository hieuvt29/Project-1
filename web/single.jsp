<%-- 
    Document   : single
    Created on : 05-Oct-2016, 15:36:19
    Author     : admin
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Mayanh"%>
<%@page import="dao.MayanhDAO"%>
<%@page import="model.Laptop"%>
<%@page import="dao.LaptopDAO"%>
<%@page import="model.Dienthoai"%>
<%@page import="dao.DienthoaiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Single</title>
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
        <!-- start details -->
        <script src="js/slides.min.jquery.js"></script>
        <script>
            $(function () {
                $('#products').slides({
                    preload: true,
                    preloadImage: 'img/loading.gif',
                    effect: 'slide, fade',
                    crossfade: true,
                    slideSpeed: 350,
                    fadeSpeed: 500,
                    generateNextPrev: true,
                    generatePagination: false
                });
            });
        </script>
        <link rel="stylesheet" href="css/etalage.css">
        <script src="js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 360,
                    thumb_image_height: 360,
                    source_image_width: 900,
                    source_image_height: 900,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
    </head>
    <body>
        <%
            String product_id = request.getParameter("product_id");
            double d = 0;
            Dienthoai dt = null;
            Laptop lt = null;
            Mayanh ma = null;
            Product pd = (Product) request.getAttribute("product");
            ArrayList<Product> listManyProduct = (ArrayList<Product>) request.getAttribute("listManyProduct");

            if (pd instanceof Dienthoai) {
                dt = (Dienthoai) pd;
            } else if (pd instanceof Laptop) {
                lt = (Laptop) pd;
            } else if (pd instanceof Mayanh) {
                ma = (Mayanh) pd;
            }

        %>

        <jsp:include page="header.jsp"></jsp:include>
            <!--main-->
            <div class="mens">    
                <div class="main">
                    <div class="wrap">
                        <ul class="breadcrumb breadcrumb__t"><a class="home" href="index.jsp">Home</a>/<a href="single.jsp">Single</a></ul>
                        <div class="cont span_2_of_3">
                        <%                            if (dt != null) {
                        %>
                        <div class="grid images_3_of_2">
                            <ul id="etalage">
                                <%
                                    for (int i = 2; i < 6; i++) {
                                %>
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image" src="<%="images/" + dt.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" />
                                        <img class="etalage_source_image" src="<%="images/" + dt.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" title="" />
                                    </a>
                                </li>  
                                <%
                                    }
                                %>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="desc1 span_3_of_2">
                            <h3 class="m_3"><%=dt.getProduct_name()%></h3>
                            <%
                                if (dt.getCategory_id() == 3) {
                                    d = dt.getProduct_price() - (dt.getProduct_price() * dt.getProduct_discount() / 100);
                            %>
                            <p class="m_5"><font color="red"><%=(double) Math.round((d * 1000) / 1000)%><span>0.000₫ </span></font><span class="reducedfrom"><%=dt.getProduct_price()%><span>0.000₫</span></span> <a href="#">click for offer</a></p>
                                <%
                                } else {
                                %>
                            <p class="m_5"><%=dt.getProduct_price()%><span>0.000₫</span><a href="#"> click for offer</a></p>
                            <%
                                }
                            %>
                            <div class="btn_form">
                                <form>
                                    <input type="submit" value="buy" title="">
                                </form>
                            </div>
                            <span class="m_link"><a href="#">login to save in wishlist</a></span>
                            <p class="m_text2">
                            <p>Màn hình: <%=dt.getProduct_resolution()%><p><br>
                            <p>Hệ điều hành: <%=dt.getProduct_os()%></p><br>
                            <p>Camera sau: <%=dt.getProduct_camera_after()%> MP</p><br>
                            <p>Camera trước: <%=dt.getProduct_camera_front()%> MP</p><br>
                            <p>CPU: <%=dt.getProduct_cpu()%></p><br>
                            <p>RAM: <%=dt.getProduct_ram()%> GB</p><br>
                            <p>Bộ nhớ trong: <%=dt.getProduct_memory()%> GB</p><br>
                            <p>Hỗ trợ thẻ nhớ: <%=dt.getProduct_mem_card()%></p><br>
                            <p>Thẻ SIM: <%=dt.getProduct_sim_card()%></p><br>
                            <p>Kết nối: <%=dt.getProduct_connection()%></p><br>
                            <p>Dung lượng pin: <%=dt.getProduct_battery()%> mAh</p><br>
                            <p>Thiết kế: <%=dt.getProduct_design()%></p><br>
                            <p>Chức năng đặc biệt: <%=dt.getProduct_extra_info()%></p>
                        </div>
                        <div class="clear"></div>	
                        <div class="clients">
                            <h3 class="m_3">Các sản phẩm khác cùng loại</h3>
                            <ul id="flexiselDemo3">
                                <%
                                    for (int i = 0; i < listManyProduct.size(); i++) {
                                        if (listManyProduct.get(i).getCategory_id() == 1) {
                                %>
                                <li><img src="<%="images/" + listManyProduct.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=listManyProduct.get(i).getProduct_id()%>"><%=listManyProduct.get(i).getProduct_name()%></a></li>
                                    <%
                                    } else if (listManyProduct.get(i).getCategory_id() == 2) {
                                    %>
                                <li><img src="<%="images/" + listManyProduct.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=listManyProduct.get(i).getProduct_id()%>"><%=listManyProduct.get(i).getProduct_name()%></a></li>
                                    <%
                                    } else if (listManyProduct.get(i).getCategory_id() == 3) {
                                    %>
                                <li><img src="<%="images/" + listManyProduct.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=listManyProduct.get(i).getProduct_id()%>"><%=listManyProduct.get(i).getProduct_name()%></a></li>
                                    <%
                                            }
                                        }
                                    %>
                            </ul>
                        </div>
                        <%
                        } else if (lt != null) {
                        %>
                        <div class="grid images_3_of_2">
                            <ul id="etalage">
                                <%
                                    for (int i = 2; i < 6; i++) {
                                %>
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image" src="<%="images/" + lt.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" />
                                        <img class="etalage_source_image" src="<%="images/" + lt.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" title="" />
                                    </a>
                                </li>  
                                <%
                                    }
                                %>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="desc1 span_3_of_2">
                            <h3 class="m_3"><%=lt.getProduct_name()%></h3>
                            <%
                                if (lt.getCategory_id() == 3) {
                                    d = lt.getProduct_price() - (lt.getProduct_price() * lt.getProduct_discount() / 100);
                            %>
                            <p class="m_5"><font color="red"><%=(double) Math.round((d * 1000) / 1000)%><span>0.000₫ </span></font><span class="reducedfrom"><%=lt.getProduct_price()%><span>0.000₫</span></span> <a href="#">click for offer</a></p>
                                <%
                                } else {
                                %>
                            <p class="m_5"><%=lt.getProduct_price()%><span>0.000₫</span><a href="#"> click for offer</a></p>
                            <%
                                }
                            %>
                            <div class="btn_form">
                                <form>
                                    <input type="submit" value="buy" title="">
                                </form>
                            </div>
                            <span class="m_link"><a href="#">login to save in wishlist</a></span>
                            <p class="m_text2">
                            <p>CPU: <%=lt.getProduct_CPU()%><p><br>
                            <p>RAM: <%=lt.getProduct_RAM()%></p><br>
                            <p>Đĩa cứng: <%=lt.getProduct_hard_disk()%></p><br>
                            <p>Màn hình rộng: <%=lt.getProduct_screen()%></p><br>
                            <p>Cảm ứng: <%=lt.getProduct_touch()%></p><br>
                            <p>Đồ họa: <%=lt.getProduct_graphic()%></p><br>
                            <p>Đĩa quang: <%=lt.getProduct_optical_disk()%></p><br>
                            <p>Webcam: <%=lt.getProduct_webcam()%></p> MP<br>
                            <p>Chất liệu vỏ: <%=lt.getProduct_material()%></p><br>
                            <p>Cổng giao tiếp: <%=lt.getProduct_gates()%></p><br>
                            <p>Kết nối: <%=lt.getProduct_connection()%></p><br>
                            <p>Pin: <%=lt.getProduct_battery()%></p><br>
                            <p>Trọng lượng: <%=lt.getProduct_weight()%> Kg</p>
                        </div>
                        <div class="clear"></div>	
                        <div class="clients">
                            <h3 class="m_3">Các sản phẩm khác cùng loại</h3>
                            <ul id="flexiselDemo3">
                                <%
                                    ArrayList<Laptop> laptopList = (ArrayList<Laptop>) request.getAttribute("listManyProduct");
                                    for (int i = 0; i < laptopList.size(); i++) {
                                        if (laptopList.get(i).getCategory_id() == 1) {
                                %>
                                <li><img src="<%="images/" + laptopList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=laptopList.get(i).getProduct_id()%>"><%=laptopList.get(i).getProduct_name().substring(0,15)+"..."%></a></li>
                                    <%
                                    } else if (laptopList.get(i).getCategory_id() == 2) {
                                    %>
                                <li><img src="<%="images/" + laptopList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=laptopList.get(i).getProduct_id()%>"><%=laptopList.get(i).getProduct_name().substring(0,15)+"..."%></a></li>
                                    <%
                                    } else if (laptopList.get(i).getCategory_id() == 3) {
                                    %>
                                <li><img src="<%="images/" + laptopList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=laptopList.get(i).getProduct_id()%>"><%=laptopList.get(i).getProduct_name().substring(0,15)+"..."%></a></li>
                                    <%
                                            }
                                        }
                                    %>
                            </ul>
                        </div>
                        <%
                        } else if (ma != null) {
                        %>
                        <div class="grid images_3_of_2">
                            <ul id="etalage">
                                <%
                                    for (int i = 2; i < 6; i++) {
                                %>
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image" src="<%="images/" + ma.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" />
                                        <img class="etalage_source_image" src="<%="images/" + ma.getProduct_id() + " (" + i + ")" + ".jpg"%>" class="img-responsive" title="" />
                                    </a>
                                </li>  
                                <%
                                    }
                                %>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="desc1 span_3_of_2">
                            <h3 class="m_3"><%=ma.getProduct_name()%></h3>
                            <%
                                if (ma.getCategory_id() == 3) {
                                    d = ma.getProduct_price() - (ma.getProduct_price() * ma.getProduct_discount() / 100);
                            %>
                            <p class="m_5"><font color="red"><%=(double) Math.round((d * 1000) / 1000)%><span>0.000₫ </span></font><span class="reducedfrom"><%=ma.getProduct_price()%><span>0.000₫</span></span> <a href="#">click for offer</a></p>
                                <%
                                } else {
                                %>
                            <p class="m_5"><%=ma.getProduct_price()%><span>0.000₫</span><a href="#"> click for offer</a></p>
                            <%
                                }
                            %>
                            <div class="btn_form">
                                <form>
                                    <input type="submit" value="buy" title="">
                                </form>
                            </div>
                            <span class="m_link"><a href="#">login to save in wishlist</a></span>
                            <p class="m_text2">
                            <p>Loại máy ảnh: <%=ma.getProduct_categorize()%><p><br>
                            <p>Cảm biến: <%=ma.getProduct_sensor()%></p><br>
                            <p>Bộ xử lý hình ảnh: <%=ma.getProduct_image_processor()%></p><br>
                            <p>Loại ống kính: <%=ma.getProduct_lens()%></p><br>
                            <p>Chế độ quay phim: <%=ma.getProduct_film()%></p><br>
                            <p>Tốc độ chụp hình: <%=ma.getProduct_shutter_speed()%></p><br>
                            <p>Kết nối: <%=ma.getProduct_connection()%></p><br>
                            <p>Loại màn hình: <%=ma.getProduct_screen()%></p><br>
                            <p>Pin: <%=ma.getProduct_battery()%></p><br>
                            <p>Thẻ nhớ: <%=ma.getProduct_mem_card()%></p><br>
                            <p>Nơi sản xuất: <%=ma.getProduct_made_in()%></p><br>
                            <p>Bảo hành: <%=ma.getProduct_warranty()%></p><br>
                            <p>Trọng lượng: <%=ma.getProduct_weight()%> Kg</p>
                        </div>
                        <div class="clear"></div>	
                        <div class="clients">
                            <h3 class="m_3">Các sản phẩm khác cùng loại</h3>
                            <ul id="flexiselDemo3">
                                <%
                                    ArrayList<Mayanh> mayanhList = (ArrayList<Mayanh>) request.getAttribute("listManyProduct");
                                    for (int i = 0; i < mayanhList.size(); i++) {
                                        if (mayanhList.get(i).getCategory_id() == 1) {
                                %>
                                <li><img src="<%="images/" + mayanhList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=mayanhList.get(i).getProduct_id()%>"><%=mayanhList.get(i).getProduct_name()%></a></li>
                                    <%
                                    } else if (mayanhList.get(i).getCategory_id() == 2) {
                                    %>
                                <li><img src="<%="images/" + mayanhList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=mayanhList.get(i).getProduct_id()%>"><%=mayanhList.get(i).getProduct_name()%></a></li>
                                    <%
                                    } else if (mayanhList.get(i).getCategory_id() == 3) {
                                    %>
                                <li><img src="<%="images/" + mayanhList.get(i).getProduct_id() + " (1)" + ".jpg"%>" /><a href="SingleServlet?product_id=<%=mayanhList.get(i).getProduct_id()%>"><%=mayanhList.get(i).getProduct_name()%></a></li>
                                    <%
                                            }
                                        }
                                    %>
                            </ul>
                        </div>   
                        <% }
                        %>
                        <script type="text/javascript">
                            $(window).load(function () {
                                $("#flexiselDemo1").flexisel();
                                $("#flexiselDemo2").flexisel({
                                    enableResponsiveBreakpoints: true,
                                    responsiveBreakpoints: {
                                        portrait: {
                                            changePoint: 480,
                                            visibleItems: 1
                                        },
                                        landscape: {
                                            changePoint: 640,
                                            visibleItems: 2
                                        },
                                        tablet: {
                                            changePoint: 768,
                                            visibleItems: 3
                                        }
                                    }
                                });

                                $("#flexiselDemo3").flexisel({
                                    visibleItems: 5,
                                    animationSpeed: 1000,
                                    autoPlay: false,
                                    autoPlaySpeed: 3000,
                                    pauseOnHover: true,
                                    enableResponsiveBreakpoints: true,
                                    responsiveBreakpoints: {
                                        portrait: {
                                            changePoint: 480,
                                            visibleItems: 1
                                        },
                                        landscape: {
                                            changePoint: 640,
                                            visibleItems: 2
                                        },
                                        tablet: {
                                            changePoint: 768,
                                            visibleItems: 3
                                        }
                                    }
                                });

                            });
                        </script>
                        <script type="text/javascript" src="js/jquery.flexisel.js"></script>

                        <div>
                            <div class="fb-comments" data-href="http://localhost:8084/ProjectCopy1/single.jsp?product_id=<%=product_id%>" data-width="850" data-numposts="5"></div>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div class="clear"></div>
                </div>

                <div class="clear"></div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
