<%-- 
    Document   : about
    Created on : 05-Oct-2016, 15:32:22
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About</title>
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

        <jsp:include page="header.jsp"></jsp:include>
            <!--About-->
            <div class="login">
                <div class="wrap">
                    <ul class="breadcrumb breadcrumb__t"><a class="home" href="index.jsp">Home</a>  / About</ul>
                    <div class="section group">
                        <div class="labout span_1_of_about">
                            <h3>Testimonials</h3>                            
                            <div class="testimonials ">
                                <div class="testi-item">
                                    <blockquote class="testi-item_blockquote">
                                        <a href="#">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </a>
                                        <div class="clear"></div>
                                    </blockquote>
                                    <small class="testi-meta"><span class="user">Lorem ipsum dolor</span>,
                                        <span class="info">sit amet</span><br><a href="#">http://demolink.org</a></small></div>
                            </div>
                        </div>
                        <div class="cont span_2_of_about">
                            <h3>Our Mission</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>                                                      
                            <!-- Add fancyBox main JS and CSS files -->
                            <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
                            <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
                            <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });
            });
                            </script>
                        </div>
                        <div class="clear"></div>	
                    </div>
                </div>	
            </div>  
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
