<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <base href="${pageContext.request.contextPath }/" />
  <meta charset="utf-8">
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title>jssdk开发-自定义会话</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<input type="hidden" id="appId" value="${sign.appId}"/>
<input type="hidden" id="nonceStr" value="${sign.nonceStr}"/>
<input type="hidden" id="timestamp" value="${sign.timestamp}"/>
<input type="hidden" id="signature" value="${sign.signature}"/>
<button id="danweiID">单位</button>
</body>
<script language="javascript" type="text/javascript" src="assets/js/jquery3.2.1.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jweixin-1.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jssdktest/test2.js"></script>
</html>