<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="tags.jsp"%>
<html>
<head>
    <title>工作台 </title>
    <%@ include file="head.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/font-awesome.min.css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace-skins.min.css" />
    <script src="<%=ctx%>/statics/js/ace-extra.min.js"></script>
</head>
<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    TODO后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue">
                    欢迎,${sessionScope.admin.name} &nbsp;&nbsp;
                </li>
                <li class="light-blue">

                    <a href="<%=ctx%>/adminbing/login"><small>退出</small> </a>
                </li>
            </ul>
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>

            <ul class="nav nav-list">
                <c:forEach var="menu" items="${menus}" varStatus="index">
                    <li>
                        <a href="<%=ctx%>${menu.url}" >
                            <i class="icon-list"></i>
                            <span class="menu-text"> ${menu.name} </span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">控制台</a>
                    </li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="space-6"></div>

                            <div class="col-sm-7 infobox-container">
                                <div class="infobox infobox-green  ">
                                    <div class="infobox-icon">
                                        <i class="icon-comments"></i>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-data-number">32</span>
                                        <div class="infobox-content">2个评论</div>
                                    </div>
                                    <div class="stat stat-success">8%</div>
                                </div>

                                <div class="infobox infobox-blue  ">
                                    <div class="infobox-icon">
                                        <i class="icon-twitter"></i>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-data-number">11</span>
                                        <div class="infobox-content">新粉丝</div>
                                    </div>

                                    <div class="badge badge-success">
                                        +32%
                                        <i class="icon-arrow-up"></i>
                                    </div>
                                </div>

                                <div class="infobox infobox-pink  ">
                                    <div class="infobox-icon">
                                        <i class="icon-shopping-cart"></i>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-data-number">8</span>
                                        <div class="infobox-content">新订单</div>
                                    </div>
                                    <div class="stat stat-important">4%</div>
                                </div>

                                <div class="infobox infobox-red  ">
                                    <div class="infobox-icon">
                                        <i class="icon-beaker"></i>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-data-number">7</span>
                                        <div class="infobox-content">调查</div>
                                    </div>
                                </div>

                                <div class="infobox infobox-orange2  ">
                                    <div class="infobox-chart">
                                        <span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"></span>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-data-number">6,251</span>
                                        <div class="infobox-content">页面查看次数</div>
                                    </div>

                                    <div class="badge badge-success">
                                        7.2%
                                        <i class="icon-arrow-up"></i>
                                    </div>
                                </div>

                                <div class="infobox infobox-blue2  ">
                                    <div class="infobox-progress">
                                        <div class="easy-pie-chart percentage" data-percent="42" data-size="46">
                                            <span class="percent">42</span>%
                                        </div>
                                    </div>

                                    <div class="infobox-data">
                                        <span class="infobox-text">交易使用</span>

                                        <div class="infobox-content">
                                            <span class="bigger-110">~</span>
                                            剩余58GB
                                        </div>
                                    </div>
                                </div>

                                <div class="space-6"></div>

                                <div class="infobox infobox-green infobox-small infobox-dark">
                                    <div class="infobox-progress">
                                        <div class="easy-pie-chart percentage" data-percent="61" data-size="39">
                                            <span class="percent">61</span>%
                                        </div>
                                    </div>

                                    <div class="infobox-data">
                                        <div class="infobox-content">任务</div>
                                        <div class="infobox-content">完成</div>
                                    </div>
                                </div>

                                <div class="infobox infobox-blue infobox-small infobox-dark">
                                    <div class="infobox-chart">
                                        <span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
                                    </div>

                                    <div class="infobox-data">
                                        <div class="infobox-content">获得</div>
                                        <div class="infobox-content">$32,000</div>
                                    </div>
                                </div>

                                <div class="infobox infobox-grey infobox-small infobox-dark">
                                    <div class="infobox-icon">
                                        <i class="icon-download-alt"></i>
                                    </div>

                                    <div class="infobox-data">
                                        <div class="infobox-content">下载次数</div>
                                        <div class="infobox-content">1,205</div>
                                    </div>
                                </div>
                            </div>

                            <div class="vspace-sm"></div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div id="piechart-placeholder"></div>

                                    <div class="hr hr8 hr-double"></div>

                                    <div class="clearfix">
                                        <div class="grid3">
															<span class="grey">
																<i class="icon-facebook-sign icon-2x blue"></i>
																&nbsp; likes
															</span>
                                            <h4 class="bigger pull-right">1,255</h4>
                                        </div>

                                        <div class="grid3">
															<span class="grey">
																<i class="icon-twitter-sign icon-2x purple"></i>
																&nbsp; tweets
															</span>
                                            <h4 class="bigger pull-right">941</h4>
                                        </div>

                                        <div class="grid3">
															<span class="grey">
																<i class="icon-pinterest-sign icon-2x red"></i>
																&nbsp; pins
															</span>
                                            <h4 class="bigger pull-right">1,050</h4>
                                        </div>
                                    </div>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
                        </div><!-- /widget-box -->
                    </div><!-- /span -->
                </div><!-- /row -->

                <div class="hr hr32 hr-dotted"></div>

                <div class="row">
                    <div class="col-sm-5">
                        <div class="widget-box transparent">
                            <div class="widget-header widget-header-flat">
                                <h4 class="lighter">
                                    <i class="icon-star orange"></i>
                                    热门域名
                                </h4>

                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="icon-chevron-up"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <table class="table table-bordered table-striped">
                                        <thead class="thin-border-bottom">
                                        <tr>
                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                名称
                                            </th>

                                            <th>
                                                <i class="icon-caret-right blue"></i>
                                                价格
                                            </th>

                                            <th class="hidden-480">
                                                <i class="icon-caret-right blue"></i>
                                                状态
                                            </th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <tr>
                                            <td>internet.com</td>

                                            <td>
                                                <small>
                                                    <s class="red">$29.99</s>
                                                </small>
                                                <b class="green">$19.99</b>
                                            </td>

                                            <td class="hidden-480">
                                                <span class="label label-info arrowed-right arrowed-in">销售中</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>online.com</td>

                                            <td>
                                                <small>
                                                    <s class="red"></s>
                                                </small>
                                                <b class="green">$16.45</b>
                                            </td>

                                            <td class="hidden-480">
                                                <span class="label label-success arrowed-in arrowed-in-right">可用</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>newnet.com</td>

                                            <td>
                                                <small>
                                                    <s class="red"></s>
                                                </small>
                                                <b class="green">$15.00</b>
                                            </td>

                                            <td class="hidden-480">
                                                <span class="label label-danger arrowed">待定</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>web.com</td>

                                            <td>
                                                <small>
                                                    <s class="red">$24.99</s>
                                                </small>
                                                <b class="green">$19.95</b>
                                            </td>

                                            <td class="hidden-480">
																	<span class="label arrowed">
																		<s>无货</s>
																	</span>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>domain.com</td>

                                            <td>
                                                <small>
                                                    <s class="red"></s>
                                                </small>
                                                <b class="green">$12.00</b>
                                            </td>

                                            <td class="hidden-480">
                                                <span class="label label-warning arrowed arrowed-right">售完</span>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
                        </div><!-- /widget-box -->
                    </div>
                </div>
                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>

<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=ctx%>/statics/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='<%=ctx%>/statics/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>

<script src="<%=ctx%>/statics/js/typeahead-bs2.min.js"></script>



<script src="<%=ctx%>/statics/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=ctx%>/statics/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=ctx%>/statics/js/jquery.slimscroll.min.js"></script>
<script src="<%=ctx%>/statics/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=ctx%>/statics/js/jquery.sparkline.min.js"></script>
<script src="<%=ctx%>/statics/js/flot/jquery.flot.min.js"></script>
<script src="<%=ctx%>/statics/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=ctx%>/statics/js/flot/jquery.flot.resize.min.js"></script>
<script src="<%=ctx%>/statics/js/ace-elements.min.js"></script>
<script src="<%=ctx%>/statics/js/ace.min.js"></script>
</body>

</html>
