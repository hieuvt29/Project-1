<%-- 
    Document   : register
    Created on : 05-Oct-2016, 15:35:58
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery1.min.js"></script>
        <!-- start menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <script src="js/jquery.easydropdown.js"></script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <!--register-->
            <div class="register_account">
                <div class="wrap">
                    <h4 class="title">Nhập thông tin người dùng</h4>
                    <form class="form-inline" action="UserControllerServlet" method="post" onsubmit="return submitController();">
                        <div class="col_3_of_3 span_3_of_3">
                            <div><label>Tên tài khoản* :</label>
                                <input class="form-control" type="text" id="user_name" name="user_name" placeholder="anguyenvan1996">

                                <span id="check-username-result"></span>
                            </div>
                            <div><label>Email* :</label>
                                <input class="form-control" type="text" id="user_email" name="user_email" placeholder="nguyenvana@gmail.com">

                                <span id="check-useremail-result"></span>
                            </div>
                            <div><label>Mật khẩu* :</label>
                                <input class="form-control" type="password" id="user_pass" name="user_pass">

                                <span id="check-userpass-result"></span>
                            </div>
                            <div><label>Số điện thoại* :</label>
                                <input class="form-control" type="text" name="user_phonenumber" placeholder="0918273645"></div>
                            <input type="hidden" name="command" value="register"/>
                            <br>
                            <div>
                                <input type="submit" value="ĐĂNG KÝ" />
                                <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>
                            </div>
                        </div>

                        <div class="col_1_of_2 span_1_of_2">
                            <div id="testing"></div>
                            <div></div>
                            <div></div>
                        </div>
                        <div class="clear"></div>

                    </form>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">
//            var error = true;
//            var submitBtn = $('input[type="submit"]');
//            submitBtn.attr('disabled', true);

            var check_email_timer, check_username_timer, check_pass_timer,
                    email_ok, username_ok, pass_ok;

            function submitController() {
                
                if (email_ok && username_ok && pass_ok && $('input[name="user_phonenumber"').val() != "") {
                    return true;
                } else {
                    alert("Correct the form before submit!");
                    return false;
                }
            }
            $(document).ready(function () {

                $("#user_name").keyup(function (e) {
                    clearTimeout(check_username_timer);
                    var username = $(this).val();
                    $("#check-username-result").html('<img src="img/ajax-loader.gif" />');
                    check_username_timer = setTimeout(function () {
                        check_username_ajax(username);
                    }, 1000);
                });
                function check_username_ajax(username) {
                    $.post('CheckUsernameServlet', {'username': username}, function (data) {
                        $("#check-username-result").html(data.message);
                        if (data.error) {
                            username_ok = false;
                        } else {
                            username_ok = true;
                        }
                    });
                }
                ;
                $("#user_email").keyup(function (e) {
                    clearTimeout(check_email_timer);
                    var email = $(this).val();
                    $("#check-useremail-result").html('<img src="img/ajax-loader.gif" />');
                    check_email_timer = setTimeout(function () {
                        check_email_ajax(email);
                    }, 1000);
                });
                function check_email_ajax(email) {
                    $.post('CheckEmailServlet', {'email': email}, function (data) {
                        $("#check-useremail-result").html(data.message);
                        if (data.error) {
                            email_ok = false;
                        } else {
                            email_ok = true;
                        }
                    });
                }
                ;

                $("#user_pass").keyup(function (e) {
                    clearTimeout(check_pass_timer);
                    var pass = $(this).val();
                    $("#check-userpass-result").html('<img src="img/ajax-loader.gif" />');
                    check_pass_timer = setTimeout(function () {
                        check_pass_ajax(pass);
                    }, 1000);
                });
                function check_pass_ajax(pass) {
                    $.post('CheckUserpassServlet', {'password': pass}, function (data) {
                        $("#check-userpass-result").html(data.message);
                        if (data.error) {
                            pass_ok = false;
                        } else {
                            pass_ok = true;
                        }
                    });
                }
            });
        </script>
    </body>
</html>
