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
</head>
<body style="padding: 20px">

<!-- 加载编辑器的容器 -->
<script id="container" name="content" type="text/plain">
</script>


<form id="article_form" class="form-horizontal" style="border:thin solid #e5e5e5; border-radius: 3px">
    <input type="hidden" name="themeid" id="themeid" class="form-control" value="${theme.id}" >
    <input type="hidden" name="themeName" id= "themeName" class="form-control" value="${theme.name}" >
    <input type="hidden" name="id" id="id"  value="${article.id}" />
    <input type="hidden" name="favorateNum" id="favorateNum"  value="${article.favorateNum}" />
    <input type="hidden" name="commentNum" id="commentNum"  value="${article.commentNum}" />
    <input type="hidden" name="readNum" id="readNum"  value="${article.readNum}" />
    <input type="hidden" name="finishNum" id="finishNum"  value="${article.finishNum}" />
    <input type="hidden" name="temp1" id="temp1"  value="${article.temp1}" />
    <input type="hidden" name="temp2" id="temp2"  value="${article.temp2}" />
    <input type="hidden" name="temp3" id="temp3"  value="${article.temp3}" />
    <input type="hidden" name="temp4" id="temp4"  value="${article.temp4}" />
    <input type="hidden" name="temp5" id="temp5"  value="${article.temp5}" />

    <div class="form-group">
        <div class="space-6"></div>
        <label  class="col-sm-2 control-label">标题</label>
        <div class="col-sm-9">
            <input type="text" name="title" class="form-control" id="title" placeholder="请输入标题" value="${article.title}">
            <input type="hidden" name="content" class="form-control" id="content" value="${article.content}" >
        </div>
    </div>
    <div class="form-group">
        <div class="space-6"></div>
        <label  class="col-sm-2 control-label">作者</label>
        <div class="col-sm-9">
            <input type="text" name="author" class="form-control" id="author" placeholder="作者" value="${article.author}">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">排序</label>
        <div class="col-sm-9">
            <input type="text" name="position" class="form-control" id="priority" placeholder="请输入排序号" value="${article.position}">
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-2 control-label">图片</label>
        <div class ="col-md-9">
            <button type="button" onclick="choosePicture()" class="btn btn-white" >添加图片</button>
            <input type="hidden" name="imgsrc"  id="imgsrc"  value="${article.imgsrc}"/>
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-2 control-label"> </label>
        <div class ="col-md-9">
            <img src="" class="imgbox" id="imgbox" width="313px">
        </div>
    </div>

    <div class="alert alert-warning alert-dismissible" id="info"  hidden="true">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span></button>
    </div>
    <button type="button"  onclick="addOrEdit(this.form)" class="btn btn-success btn-lg btn-block" id="btn_add">submit</button>
    <div class="space-6"></div>
</form>







<!-- 配置文件 -->
<script type="text/javascript" src="<%=ctx%>/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="<%=ctx%>/ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('container');
    var result = ue.loadServerConfig();
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
<div style="display: none">
    <input  name="picture" id="fileInput" type="file" onchange="uploadPicture()">
</div>
</body>
<script>
    $(function () {
        $('#imgbox').attr('src',"<%=ctx%>/picture/getPicture?path=${article.imgsrc}"  );
        var ue = UE.getEditor('container');
        ue.ready(function() {
            ue.setContent('${article.content}');
        });
    })

    //提交新增或修改
    function addOrEdit(form){
        var content = UE.getEditor('container').getContent();

        $("#content").val(content);
        if(form.title.value == ""){
            $('#info').text = ("请输入标题↖(^ω^)↗'");
            $('#info').show();
            return;
        }
        if(form.author.value == ""){
            $('#info').text("请输入作者↖(^ω^)↗'");
            $('#info').show();
            return;
        }
        $.ajax({
            url:   "<%=ctx%>/article/addOrEdit",
            data:  $('#article_form').serialize(),
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

    }


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
</script>


</html>
