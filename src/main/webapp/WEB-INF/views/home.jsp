<%--
  Created by IntelliJ IDEA.
  User: APuzikov
  Date: 6/27/2016
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <h2>A global community of friends and strangers spitting out their
        inner-most personal thoughts on web for everyone else to see.</h2>
    <h3>Look at what these people are spitting write now....</h3>

    <ol class="spittle-list">
        <c:forEach var="spittle" items="${spittles}">
            <s:url value="/spitters/{spittleName}" var="spittle_url">
                <s:param name="spitterName" value="${spittle.spitter.name}"/>
            </s:url>

            <li>
            <span class="spittle-list-image">
                <img src="/WEB-INF/img/spitter.jpg"/>
            </span>
            <span class="spittle-list-text">
                <a href="${spitter_url}">
                    <c:out value="${spittle.spitter.name}"/></a>
                <c:out value="${spittle.text}"/><br>
                    <small>
                        <fmt:formatDate value="${spittle.when}" pattern="hh:mma MMM d, yyyy"/>
                    </small>

            </span>
            </li>

        </c:forEach>
    </ol>
</div>