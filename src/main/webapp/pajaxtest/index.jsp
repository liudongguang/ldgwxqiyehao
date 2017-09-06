<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <title>Title</title>
    <link rel="stylesheet" href="assets/bootstrap4.0.0-beta/css/bootstrap.css"/>
    <link rel="stylesheet" href="assets/menu/css/menu.css"/>
    <link rel="stylesheet" href="assets/menu/css/public.css"/>
    <link rel="stylesheet" href="assets/nprogress-0.2.0/nprogress.css"/>
    <link rel="stylesheet" href="assets/css/index_fix.css"/>
</head>
<body>
<input type="hidden" value="${param.isRedirect}" id="isRedirect"/>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Settings</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Help</a>
            </li>
        </ul>
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <div class="row" style="margin-top: 56px;">
        <div class="col-md-2">
            <div class="middle">
                <!-- 隐藏菜单 -->
                <div class="hidLeftMenu">
                    <img class="openMenu" src="assets/menu/img/open.png"/>
                    <p class="hidTitle">各地名吃菜单</p>
                </div>
                <!-- 隐藏菜单结束 -->
                <!-- 菜单-开始 -->
                <div class="leftMenu">
                    <div class="topMenu">
                        <img class="banshi" src="assets/menu/img/banshidating.png"/>
                        <p class="menuTitle">各地名吃菜单</p>
                        <img class="changeMenu" src="assets/menu/img/shouqicaidan.png" id="hidIcon"/>
                    </div>
                    <div class="menu_list">
                        <ul>
                            <li class="lis">
                                <p id="defaultDisplay" class="fuMenu">武汉名吃</p>
                                <img class="xiala" src="assets/menu/img/xiala.png"/>
                                <div class="div1">
                                    <p class="zcd" id="zcd1" href="pajaxtest/a.jsp">老通城的三鲜豆皮</p>
                                    <p class="zcd" id="zcd2" href="pajaxtest/b.jsp">四季美的汤包</p>
                                    <p class="zcd" id="zcd3">蔡林记的热干面</p>
                                    <p class="zcd" id="zcd4">顺香居的烧麦</p>
                                    <p class="zcd" id="zcd5">福庆和的牛肉豆丝</p>
                                    <p class="zcd" id="zcd6">小桃园的煨汤</p>
                                    <p class="zcd" id="zcd7">田启恒的糊汤粉</p>
                                    <p class="zcd" id="zcd8">谢荣德的面窝</p>
                                </div>
                            </li>
                            <li class="lis">
                                <p class="fuMenu">山东名吃</p>
                                <img class="xiala" src="assets/menu/img/xiala.png"/>
                                <div class="div1">
                                    <p class="zcd" id="zcd9">威海鲅鱼煎包</p>
                                    <p class="zcd" id="zcd10">济南拔丝山药</p>
                                    <p class="zcd" id="zcd11">枣庄菜煎饼</p>
                                    <p class="zcd" id="zcd12">青岛大包</p>
                                    <p class="zcd" id="zcd13">潍坊肉火烧</p>
                                    <p class="zcd" id="zcd14">济宁甏肉干饭</p>
                                    <p class="zcd" id="zcd15">沂蒙光棍鸡</p>
                                    <p class="zcd" id="zcd16">莱芜烧饼</p>
                                    <p class="zcd" id="zcd17">平原签子馒头</p>
                                    <p class="zcd" id="zcd18">魏集驴肉</p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- 菜单-结束 -->
            </div>
        </div>
        <div class="col-md-10" id="pajaxMainContainer" style="padding: 100px"></div>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery3.2.1.js"></script>
<script language="javascript" type="text/javascript" src="assets/menu/js/menu.js"></script>
<script language="javascript" type="text/javascript" src="assets/bootstrap4.0.0-beta/popper.js"></script>
<script language="javascript" type="text/javascript" src="assets/bootstrap4.0.0-beta/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajax/jquery.pjax.js"></script>
<script language="javascript" type="text/javascript" src="assets/nprogress-0.2.0/nprogress.js"></script>
<script language="javascript" type="text/javascript" src="assets/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajaxtest/index.js"></script>
</body>
</html>
