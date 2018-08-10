<%--
  Created by IntelliJ IDEA.
  User: ff
  Date: 2018/8/6
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="tags.jsp"%>
<%@ include file="head.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=ctx%>/statics/css/font-awesome.min.css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=ctx%>/statics/css/ace-skins.min.css" />
    <script src="<%=ctx%>/statics/js/ace-extra.min.js"></script>

    <style>
        .media-object{
            width: 120px;
            margin: 2px;
        }
        .media-left{
            width: 125px;
            float: left;
        }
        .media-body{
            position: relative
        }
        .search-actions{
            position: absolute;
            bottom: 0px;
            right: 0px;
        }

    </style>
</head>
<body style="padding: 20px">

<h1>标题<a class="btn btn-success" href="javascript:void(0)"  onclick="edit('${theme.id}','')"><i class="ace-icon fa fa-pencil align-top bigger-125"></i>新增</a>
</h1>

<div class="row">
    <div class="col-xs-8">
        <div class="media search-media">
            <div class="media-left">
                <img class="media-object" src="" />
            </div>

            <div class="media-body">
                <div>
                    <h2 class="media-heading">
                        <a href="#" class="blue">Media heading</a>
                    </h2>
                </div>
                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis...</p>

                <div class="search-actions text-center">
                    <div class="action-buttons bigger-125">
                        <a href="#">
                            阅读（9999）
                        </a>

                        <a href="#">
                            点赞（9999）
                        </a>

                        <a href="#">
                            评论（9999）
                        </a>

                        <a href="#">
                            完成（9999）
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="media search-media">
            <div class="media-left">
                <img class="media-object" src="" />
            </div>

            <div class="media-body">
                <div>
                    <h2 class="media-heading">
                        <a href="#" class="blue">Media heading</a>
                    </h2>
                </div>
                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis...</p>

                <div class="search-actions text-center">
                    <div class="action-buttons bigger-125">
                        <a href="#">
                            阅读（9999）
                        </a>

                        <a href="#">
                            点赞（9999）
                        </a>

                        <a href="#">
                            评论（9999）
                        </a>

                        <a href="#">
                            完成（9999）
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>





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
<script >
    function  edit(themeid,id) {
        window.open("<%=ctx%>/article/edit?themeid="+themeid + "&id="+ id, "_blank");
    }
</script>
</body>



</html>
