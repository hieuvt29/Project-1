<%-- 
    Document   : single
    Created on : 05-Oct-2016, 15:36:19
    Author     : admin
--%>

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
        
        <jsp:include page="header.jsp"></jsp:include>
            <!--main-->
            <div class="mens">    
                <div class="main">
                    <div class="wrap">
                        <ul class="breadcrumb breadcrumb__t"><a class="home" href="index.jsp">Home</a> / <a href="single.jsp">Single</a></ul>
                        <div class="cont span_2_of_3">
                            <div class="grid images_3_of_2">
                                <ul id="etalage">
                                    <li>
                                        <a href="optionallink.html">
                                            <img class="etalage_thumb_image" src="images/SE.jpg" class="img-responsive" />
                                            <img class="etalage_source_image" src="images/SECopy.png" class="img-responsive" title="" />
                                        </a>
                                    </li>                                    
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="desc1 span_3_of_2">
                                <h3 class="m_3">Lorem ipsum dolor sit amet</h3>
                                <p class="m_5">Rs. 888 <span class="reducedfrom">Rs. 999</span> <a href="#">click for offer</a></p>
                                <div class="btn_form">
                                    <form>
                                        <input type="submit" value="buy" title="">
                                    </form>
                                </div>
                                <span class="m_link"><a href="#">login to save in wishlist</a> </span>
                                <p class="m_text2">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit </p>
                            </div>
                            <div class="clear"></div>	
                            <div class="clients">
                                <h3 class="m_3">Thêm hình ảnh về sản phẩm</h3>
                                <ul id="flexiselDemo3">
                                    <li><img src="images/s5.jpg" /><a href="#">Category</a><p>Rs 600</p></li>
                                    <li><img src="images/s6.jpg" /><a href="#">Category</a><p>Rs 850</p></li>
                                    <li><img src="images/s7.jpg" /><a href="#">Category</a><p>Rs 900</p></li>
                                    <li><img src="images/s8.jpg" /><a href="#">Category</a><p>Rs 550</p></li>
                                    <li><img src="images/s9.jpg" /><a href="#">Category</a><p>Rs 750</p></li>
                                </ul>
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
                            </div>
                            <div class="toogle">
                                <h3 class="m_3">Product Details</h3>
                                <p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
                            </div>
                            <div class="toogle">
                                <h3 class="m_3">More Information</h3>
                                <p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.</p>
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
                    <div class="clear"></div>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
</html>
