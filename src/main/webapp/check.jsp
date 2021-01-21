<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${cnt == 1}">{"res" : "1" }</c:when>
	<c:otherwise>{"res" : "0" }</c:otherwise>
</c:choose>