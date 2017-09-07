<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="pajaxwx/<c:if test="${empty param.id}">addDepart</c:if><c:if test="${not empty param.id}">updateDepart</c:if>" method="post" pajax-form >
    <div class="form-group row">
        <label for="ksmc" class="col-sm-1 col-form-label">部门名称</label>
        <div class="col-sm-7">
            <input type="hidden" name="id"  value="${param.id}" >
            <input type="hidden" name="parentid"  value="${param.parentid}" >
            <input type="text" name="name"  class="form-control" id="ksmc" value="${param.name}" >
        </div>
    </div>
    <div class="form-group row">
        <label  class="col-sm-7 col-form-label"></label>
        <div class="col-sm-1">
            <button class="btn btn-outline-info float-right ">提交</button>
        </div>
    </div>
</form>
<script language="javascript" type="text/javascript">
    jQuery.ajax({
        url: "assets/js/jsp/pajax/weixin/adddepart.js",
        dataType: "script",
        cache: true
    })
</script>