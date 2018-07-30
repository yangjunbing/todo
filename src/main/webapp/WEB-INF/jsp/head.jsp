<%--
   JSP静态包含: <%@include file="common/head.jsp" %>  最终是一个servlet

   JSP动态包含:多个servlet
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
--%>
<%
    String ctx = request.getContextPath();
%>
<script type="text/javascript">
    var ctx = '<%=ctx%>';
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="<%=ctx%>/statics/js/jquery-2.0.3.min.js"></script>
<script src="<%=ctx%>/statics/js/bootstrap.min.js"></script>
<link href="<%=ctx%>/statics/css/bootstrap.min.css" rel="stylesheet">


