<%-- 
    Document   : header
    Created on : 05-Oct-2016, 15:34:41
    Author     : admin
--%>

<%@page import="model.User"%>
<%@page import="model.Supplier"%>
<%@page import="dao.SupplierDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Header</title>
    <div id="fb-root"></div>
    <script>(function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id))
                return;
            js = d.createElement(s);
            js.id = id;
            js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>

</head>
<body>
    <%
        SupplierDAO supplierDAO = new SupplierDAO();
        User user = null;
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
        }
    %>

    <div class="header-top">
        <div class="wrap"> 
            <div class="cssmenu">
                <ul>
                    <% if (user != null) {
                    %>
                    <li><a href="checkout.jsp">WISHLIST</a></li> |
                    <li><a href="checkout.jsp">CHECKOUT</a></li> |
                    <li><a href="profile.jsp"><%=user.getUser_name()%> - (<%=user.getUser_email()%>)</a></li> |
                    <li><a href="UserControllerServlet?command=logout" >LOG OUT</a></li>
                        <% } else {
                        %>
                    <li><a href="login.jsp">LOG IN</a></li> |
                    <li><a href="register.jsp">SIGN UP</a></li>
                        <% }
                        %>

                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="wrap">
            <div class="header-bottom-left">
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo.png" alt=""/></a>
                </div>
                <div class="menu">
                    <ul class="megamenu skyblue">
                        <li class="active grid"><a href="index.jsp">Home</a></li>
                        <li><a class="color4" href="ProductsPageServlet?product=Dienthoai&supplier=%" >Điện thoại</a>
                            <div class="megapanel">
                                <%
                                    for (Supplier s : supplierDAO.getSupplierList("supplier_dienthoai")) {
                                %>
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <li><a href="ProductsPageServlet?product=Dienthoai&supplier=<%=s.getSupplier_id()%>" ><h4><%=s.getSupplier_name()%></h4></a></li>
                                            </ul>	
                                        </div>							
                                    </div>                                                                               
                                </div>
                                <%
                                    }
                                %>
                            </div>
                        </li>

                        <li><a class="color5" href="ProductsPageServlet?product=Laptop&supplier=%" >Laptop</a>
                            <div class="megapanel">
                                <%
                                    for (Supplier s : supplierDAO.getSupplierList("supplier_laptop")) {
                                %>
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <li><a href="ProductsPageServlet?product=Laptop&supplier=<%=s.getSupplier_id()%>"><h4><%=s.getSupplier_name()%></h4></a></li>
                                            </ul>	
                                        </div>							
                                    </div>                                                                               
                                </div>
                                <%
                                    }
                                %>
                            </div>
                        </li>
                        <li><a class="color6" href="ProductsPageServlet?product=Mayanh&supplier=%" >Máy ảnh</a>
                            <div class="megapanel">
                                <%
                                    for (Supplier s : supplierDAO.getSupplierList("supplier_mayanh")) {
                                %>
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <ul>
                                                <li><a href="ProductsPageServlet?product=Mayanh&supplier=<%=s.getSupplier_id()%>"><h4><%=s.getSupplier_name()%></h4></a></li>
                                            </ul>	
                                        </div>							
                                    </div>                                                                               
                                </div>
                                <%
                                    }
                                %>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="header-bottom-right">
                <div class="row">
                    <div class="col-md-4">
                        <div class="search" >
                            <form action="CustomSearchServlet" method="Get">
                                <input class="form-control" type="text" name="product_name" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                            this.value = 'Search';
                                        }">
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <select class="form-control" id="price" name="price" style="width: 150px">
                            <option value="0">Select Price (vnđ) </option>
                            <option value="1">dưới 8 triệu</option>
                            <option value="2">từ 8 triệu - 10 triệu</option>
                            <option value="3">từ 10 triệu - 12 triệu</option>
                            <option value="4">trên 12 triệu</option>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <div class="tag-list">
                            <ul class="icon1 sub-icon1 profile_img">
                                <li><a class="active-icon c1" href="#"> </a>
                                    <ul class="sub-icon1 list">
                                        <li><h3>sed diam nonummy</h3><a href=""></a></li>
                                        <li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="icon1 sub-icon1 profile_img">
                                <li><a class="active-icon c2" href="#"> </a>
                                    <ul class="sub-icon1 list">
                                        <li><h3>No Products</h3><a href=""></a></li>
                                        <li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="last"><li><a href="#">Cart(0)</a></li></ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <script> //for header fixed
        $(window).scroll(function () {
            var sticky = $('.header-bottom'),
                    scroll = $(window).scrollTop();

            if (scroll >= 100)
                sticky.addClass('fixed');
            else
                sticky.removeClass('fixed');
        });
    </script>

</body>
</html>
