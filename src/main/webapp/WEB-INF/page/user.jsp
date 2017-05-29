<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/5/28
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()
            +":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
    </script>
    <title>用户信息列表</title>
</head>
<body>

<c:if test="${!empty userList}">
    <c:forEach var="user" items="${userList}">
        姓名：${user.name} &nbsp;&nbsp;手机号：${user.age} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
</body>
</html>
<script type="text/javascript">

    function loginSubmit1(){
            var code=$("#code").val();
            var type=$("#type").val();
            $.ajax({

                cache: false,

            type: "POST",

            // url:"http://localhost:8080/loanRepaymentPay/toBaofuRecharge", //把表单数据发送到ajax.jsp
            url:  "<%=basePath%>loanRepaymentPay/toBaofuRecharge",

            data:$('#ajaxFrm').serialize(), //要发送的是ajaxFrm表单中的数据

            async: false,

            error: function(request) {

                alert("发送请求失败！");

            },
            success: function(data) {
                var dataObj=eval("("+data+")");
                // window.open(data)
                //$("#ajaxDiv").html(data); //将返回的结果显示到ajaxDiv中
                if(dataObj.respStatus == 'SUCCESS'){
                    console.log("成功了")

                    window.open("<%=basePath%>loanRepaymentPay/toBaofuPayWeb");
                }else{
                    alert(data);
                }


            }

        });

    }
</script>