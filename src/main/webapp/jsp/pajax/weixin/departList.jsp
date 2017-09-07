<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty  requestScope.rsInfo}">
    <div class="alert alert-primary" role="alert">
            ${requestScope.rsInfo.errmsg}
    </div>
</c:if>
<button class="btn btn-outline-info float-right margin-bottom10" pajax-data href="jsp/pajax/weixin/adddepart.jsp">新增部门
</button>
<table class="table table-hover">
    <thead>
    <tr>
        <th>部门名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.department}" var="obj">
        <tr>
            <td>${obj.name}</td>
            <th scope="row">
                <button class="btn btn-outline-success table_bt_cz" pajax-data href="jsp/pajax/weixin/adddepart.jsp?name=${obj.name}&id=${obj.id}&parentid=${obj.parentid}">
                    <div class="table_btspan_cz">修改</div>
                </button>
                <button class="btn btn-outline-danger table_bt_cz" pajax-data del="del"
                        href="pajaxwx/delDepart?id=${obj.id}">
                    <div class="table_btspan_cz">删除</div>
                </button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script language="javascript" type="text/javascript">
    jQuery.ajax({
        url: "assets/js/jsp/pajax/weixin/departList.js",
        dataType: "script",
        cache: true
    })
</script>

