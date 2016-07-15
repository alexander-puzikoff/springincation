<%--
  Created by IntelliJ IDEA.
  User: APuzikov
  Date: 7/15/2016
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <h2>
        Spittles for ${spitter.name}
    </h2>

    <table cellspacing="15">
        <c:forEach items="${spittleList}" var="spittle">
            <tr>
                <td>
                    <img src="/WEB-INF/img/spitter_avatar.jpg"/>
                </td>
                <td>
                    <a href="<s:url value="/spitters/${spittle.spitter.name}"/>">${spittle.spitter.name}</a>
                    <c:out value="${spittle.text}"/><br>
                    <c:out value="${spittle.when}"/><br>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>