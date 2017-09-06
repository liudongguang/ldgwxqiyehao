<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<button class="btn btn-outline-info float-right margin-bottom10">新增部门</button>
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
                <button class="btn btn-outline-success table_bt_cz" ${obj.id} ><div class="table_btspan_cz">修改</div></button>
                <button class="btn btn-outline-danger table_bt_cz" ${obj.id} ><div class="table_btspan_cz">删除</div></button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>

