<%@ page import="projects.bing.entity.AdminUser" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2017/2/19
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="<%=ctx%>/statics/css/picCut.css">
<style>
    .imgbox{
        width: 100px;
        height: auto;
    }
</style>
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
                    TODO Management System
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue">
                   <% HttpSession s = request.getSession();
                    AdminUser a = (AdminUser) s.getAttribute("admin");
                    %>
                    欢迎,<%=a.getName() %> &nbsp;&nbsp;
                </li>
                <li class="light-blue">
                    <a href="<%=ctx%>/admin/login"><small>退出</small> </a>
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
                <c:forEach var="menu" items="${list}">
                    <li>
                        <a href="<%=ctx%>${menu.url}" >
                            <i class="icon-list"></i>
                            <span class="menu-text"> ${menu.name} </span>
                        </a>
                    </li>
                </c:forEach>
            </ul><!-- /.nav-list -->

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
                            菜单管理
                    </li>
                </ul><!-- .breadcrumb -->
            </div>


            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="space-6"></div>
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="center">
                                        <label>
                                            <input type="checkbox" class="ace" />
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>名称</th>
                                    <th>链接地址</th>
                                    <th>排序</th>
                                    <th style="align-content: center">操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${list}" var="menu">
                                <tr id="tr_${menu.id}">
                                    <td class="center">
                                        <label>
                                            <input type="checkbox" class="ace" value="${menu.id}"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </td>

                                    <td>${menu.name}</td>
                                    <td>${menu.url}</td>
                                    <td>${menu.position}</td>
<%--
                                    <td  class="testLi" > <img src=<%=ctx%>/picture/getPicture?path=${menu.imgsrc}  class="img imgbox" hidden="true"> </td>
--%>
                                    <td>
                                        <button class="btn btn-xs btn-info" onclick="edit('${menu.id}')">
                                        <i class="icon-edit bigger-120"></i>
                                            </button>

                                        <button class="btn btn-xs btn-danger" onclick="del('${menu.id}')">
                                            <i class="icon-trash bigger-120"></i>
                                        </button>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div><!-- /.table-responsive -->
                    </div>

                    <div class ="col-md-4">
                    <form id="menuform" class="form-horizontal" style="border:thin solid #e5e5e5; border-radius: 3px">
                        <input type="hidden" name="id" id="id"  />
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-9">
                                <input type="text" name="name" class="form-control" id="name" placeholder="请输入名称">
                            </div>
                        </div>


                        <div class="form-group">
                            <label  class="col-sm-2 control-label">链接地址</label>
                            <div class="col-sm-9">
                                <input type="text" name="url" class="form-control" id="url" placeholder="请输入链接">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">排序</label>
                            <div class="col-sm-9">
                                <input type="text" name="position" class="form-control" id="position" placeholder="请输入排序">
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label  class="col-sm-2 control-label">图片</label>
                            <div class ="col-md-9">
                                <button type="button" onclick="choosePicture()" class="btn btn-white" >添加图片</button>
                                <input type="hidden" name="imgsrc"  id="imgsrc" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-2 control-label"> </label>
                            <div class ="col-md-9">
                                <img src="" class="imgbox" id="imgbox">
                            </div>
                        </div>--%>

                        <div class="alert alert-warning alert-dismissible" id="info"  hidden="true">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                        </div>

                        <button type="button"  onclick="addOrEdit(this.form)" class="btn btn-success btn-lg btn-block" id="btn_add">新增</button>
                        <div class="space-6"></div>
                    </form>
                    </div>
                </div>
            </div>
        </div><!-- /.main-content -->
    </div>
    <div style="display: none">
        <input  name="picture" id="fileInput" type="file" onchange="uploadPicture()">
    </div>
</div>
</body>
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="icon-double-angle-up icon-only bigger-110"></i>
</a>
<script type="application/javascript">
    function  choosePicture(){   //点击普通按钮触发文件选择
        $('#fileInput').click();
    }
    //选择文件后上传
    function uploadPicture(){
        var formData = new FormData();
        formData.append("imgFile", document.getElementById("fileInput").files[0]);
        $.ajax({
            url: "<%=ctx%>/picture/upload",
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                if (result.flag) {
                    $('#imgsrc').val(result.data);
                    $('#imgbox').attr('src',"<%=ctx%>/picture/getPicture?path=" + result.data);
                }else{
                    $('#info').text = (result.data);
                    console.log(result.data);
                    $('#info').show();
                }

            }
        });

    }

    //提交新增或修改
    function addOrEdit(form){
        if(form.name.value == ""){
            $('#info').text = ("请输入名称!");
            $('#info').show();
            return;
        }
        if(form.url.value == ""){
            $('#info').text("请输入链接!");
            $('#info').show();
            return;
        }
        if(form.position.value == ""){
            $('#info').text("请输入排序!");
            $('#info').show();
            return;
        }
        $.ajax({
            url:   "<%=ctx%>/menu/saveOrUpdate",
            data:  $('#menuform').serialize(),
            async: false,
            type:  "POST",
            success:function(result){
                if(result.flag==true){
                    $('#info').removeClass('alert-warning');
                    $('#info').addClass('alert-success');
                    $('#info').text(result.data);
                    $('#info').show();
                }
            }
        });
        setTimeout("self.location.reload()",3000);
    }
    //点击edit按钮
    function edit(id){
        $('#menuid').val(id);
        $.ajax({
            url:'<%=ctx%>/menu/getOne?id='+id,
            type:'POST',
            async:false,
            success:function(result){
                if(result.flag){
                    var obj = result.data;
                    $('#id').val(obj.id);
                    $('#name').val(obj.name);
                    $('#url').val(obj.url);
                    $('#position').val(obj.position);
                    $('#btn_add').text('修改');

                }
            }
        });
    }

    //删除
    function  del(id) {
        var trid = 'tr_'+id;
        var result = confirm("确定删除？");
        if(result){
            $.ajax({
                url:'<%=ctx%>/menu/delete?id='+id,
                type:'POST',
                async:false,
                success:function(result){
                    if(result.flag){
                        var tr = document.getElementById(trid);
                        tr.style.display="none";
                    }else{
                        alert('删除失败，请稍后重试！');
                    }
                }

            });
        }
    }
    function upload() {
        $("#uploading1").show();
        var formData = new FormData();
        formData.append("imgFile", document.getElementById("fileInput").files[0]);
        $.ajax({
            url: "/picture/upload",
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                if (result.flag) {
                    $('#imgsrc').val(result.data);
                    console.log(result['data']);
                }else{
                    alert('上传失败');
                }
            }
        });
    }
    $('.testLi').on('mouseenter', function() {
        $('.img').stop().fadeIn();
    }).on('mouseleave', function() {
        $('.img').stop().fadeOut();
    })
</script>
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
<script src="<%=ctx%>/statics/js/ace-extra.min.js"/>

</html>
