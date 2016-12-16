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
        <title>Header</title>
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
          var js, fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id)) return;
          js = d.createElement(s); js.id = id;
          js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8";
          fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));</script>
    </head>
    <body>
        <%
            SupplierDAO supplierDAO = new SupplierDAO();
            
            User user = null;
            if(session.getAttribute("user") != null){
                user = (User) session.getAttribute("user");
            }
            
        %>

        <div class="header-top">
            <div class="wrap"> 
                <div class="cssmenu">
                    <ul>
                        <li class="active"><a href="login.jsp">Account</a></li> |
                        <li><a href="checkout.jsp">Wishlist</a></li> |
                        <li><a href="checkout.jsp">Checkout</a></li> |
                        <% if (user != null){ 
                        %>
                            <li><a href="profile.jsp"><%=user.getUser_name()%></a></li> |
                            <li><a href="UserControllerServlet?command=logout" >Log out</a></li> |
                    
                        <% }else{

                        %>
                        <li><a href="login.jsp">Log In</a></li> |
                        <li><a href="register.jsp">Sign Up</a></li>
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
                            <li><a class="color4" href="products.jsp?product=Dienthoai&supplier_id=*">Điện thoại</a>
                                <div class="megapanel">
                                    <%
                                        for (Supplier s : supplierDAO.getSupplierList("supplier_dienthoai")) {
                                    %>
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <ul>
                                                    <li><a href="products.jsp?product=Dienthoai&supplier_id=<%=s.getSupplier_id()%>"><h4><%=s.getSupplier_name()%></h4></a></li>
                                                </ul>	
                                            </div>							
                                        </div>                                                                               
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </li>
                                                    <form name='queryform' action='ProductsPageServlet' method='get'>
                                                        <input type='hidden' name='product' value="Laptop">
                                                        <input type='hidden' name='supplier' value="*">
                                                    </form>
                            <li><a class="color5" href="#" onClick="document.queryform.submit()">Laptop</a>
                                <div class="megapanel">
                                    <%
                                        for (Supplier s : supplierDAO.getSupplierList("supplier_laptop")) {
                                    %>
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <ul>
                                                    <li><a href="products.jsp?product=Laptop&supplier_id=<%=s.getSupplier_id()%>"><h4><%=s.getSupplier_name()%></h4></a></li>
                                                </ul>	
                                            </div>							
                                        </div>                                                                               
                                    </div>
                                    <%
                                        }
                                    %>
                                </div>
                            </li>
                            <li><a class="color6" href="products.jsp?product=Mayanh&supplier_id=*">Máy ảnh</a>
                                <div class="megapanel">
                                    <%
                                        for (Supplier s : supplierDAO.getSupplierList("supplier_mayanh")) {
                                    %>
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <ul>
                                                    <li><a href="products.jsp?product=Mayanh&supplier_id=<%=s.getSupplier_id()%>"><h4><%=s.getSupplier_name()%></h4></a></li>
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
                    <div class="search">	  
                        <input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                    this.value = 'Search';
                                }">
                        <input type="submit" value="Subscribe" id="submit" name="submit">
                        <div id="response"> </div>
                    </div>
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
                <div class="clear"></div>
            </div>
        </div>

    </body>
</html>
