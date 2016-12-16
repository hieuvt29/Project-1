<%-- 
    Document   : login
    Created on : 05-Oct-2016, 15:35:11
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery1.min.js"></script>
        <!-- start menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <!-- dropdown -->
        <script src="js/jquery.easydropdown.js"></script>
    </head>
    <body>
        <% String error = null;
            error = (String) request.getAttribute("error");

        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="login">
                <div class="wrap">
                    <div class="col_1_of_login span_1_of_login">
                        <h4 class="title">New Customers</h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan</p>
                        <div class="button1">
                            <a href="register.jsp"><input type="submit" name="Submit" value="Create an Account"></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="col_1_of_login span_1_of_login">
                        <div class="login-title">
                            <h4 class="title">Registered Customers</h4>
                            <div id="loginbox" class="loginbox">
                            <% if (error != null) {
                                    request.removeAttribute("error");
                            %>
                            <font color="red"><%=error%></font>
                            <% }
                            %>
                            <form action="UserControllerServlet" method="post">
                                <fieldset class="input">
                                    <p id="login-form-username">
                                        <label for="modlgn_username">Email</label>
                                        <input id="modlgn_username" type="text" name="user_email" class="inputbox" size="18" autocomplete="off">
                                    </p>
                                    <p id="login-form-password">
                                        <label for="modlgn_passwd">Password</label>
                                        <input id="modlgn_passwd" type="password" name="user_pass" class="inputbox" size="18" autocomplete="off">
                                    </p>
                                    <div class="remember">
                                        <p id="login-form-remember">
                                            <label for="modlgn_remember"><a href="#">Forget Your Password ? </a></label>
                                        </p>
                                        <input type="hidden" value="login" name="command" />
                                        <input type="submit" name="Submit" class="button" value="Login"><div class="clear"></div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
