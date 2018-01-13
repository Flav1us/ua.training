<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="resources.Messages" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" scope="page"/>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value='${contextPath}'/>/resources/coolmenus.css">
<title>ProjectFirst</title>
<script language="JavaScript">

function validate( form ) {
    var result = "";
    var control;
    var setFocus = true;

    if( form.streetFrom.value == "" ) {
      result += ' -  <fmt:message key="order.streetFrom"/>.\n';
        control = form.streetFrom;
        setFocus = false;
    }
    if( form.streetTo.value == "" ) {
        result += ' -  <fmt:message key="order.streetTo"/>.\n';
          control = form.streetTo;
          setFocus = false;
    }
    if( form.hhArrive.value == "" || form.mmArrive.value == "" ) {
        result += ' -  <fmt:message key="order.timeArrive"/>.\n';
          control = form.hhArrive;
          setFocus = false;
    }
    if( result == "" ) {
        return true;
    } else {
        result = ' <fmt:message key="login.needToFillOutAllFields"/>.\n' +
                 ' <fmt:message key="login.pleaseFillOutTheFollowing"/>: \n' +
                 result;
        alert( result );
        control.focus();
        return false;
    }
}

function goToOrderHistory(){
	document.getElementById("orderHistoryForm").submit();
} 
</script>

</head>
<body class="bottombody">
<form action="<c:url value='/order'/>" onSubmit="return validate(this);" method="POST" type="application/x-www-form-urlencoded; charset=utf-8">
<input type="hidden" name="actionId" value="calculate"/>
	<%@include file="./errorPage.jsp"%>

	<table cellSpacing="0" cellPadding="0"  width="90%" style="margin-top:50px">
        <tr>
            <td align="center">
                      <table cellSpacing="2" cellPadding="0" border="0">
                           <tr>
                                <td>
                                    <font class=text4><fmt:message key="order.streetFrom"/>:</font>
                                </td>
                                <td>
                                    <input type="text" maxLength="200" style="width:500px" name="streetFrom" value='<c:out value="${streetFrom}" escapeXml="false"/>'>
                                </td>
                            </tr>
                           <tr>
                                <td>
                                    <font class=text4><fmt:message key="order.streetTo"/>:</font>
                                </td>
                                <td>
                                    <input type="text" maxLength="200" style="width:500px" name="streetTo" value='<c:out value="${streetTo}" escapeXml="false"/>'>
                                </td>
                            </tr>
                           <tr>
                                <td>
                                    <font class=text4><fmt:message key="order.timeArrive"/>:</font>
                                </td>
                                <td>
                                    <input type="text" maxLength="2" style="width:20px" name="hhArrive" value='<c:out value="${hhArrive}" escapeXml="false"/>'>:
                                    <input type="text" maxLength="2" style="width:20px" name="mmArrive" value='<c:out value="${mmArrive}" escapeXml="false"/>'>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font class=text4><fmt:message key="order.carType"/>:</font>&nbsp;
                                </td>
                                <td>
                                	<select name="carType" style="width:110px">
                        <c:forEach var="type" items="${requestScope.carTypes}">
                        			<option value="<c:out value="${type.code}"/>" <c:if test="${type.code==carType}">selected='true'</c:if> ><c:out value="${type.type}"/>
                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit"  value="<fmt:message key="order.calc"/>" style="width:110px">&#160;
                                    <input type="button" onclick='goToOrderHistory()' value="<fmt:message key="order.history"/>" style="width:110px">
                                    
                                </td>
                            </tr>
                     </table>
            </td>
        </tr>    
            
 </table>
 
</form>
<form action="<c:url value='/orderHistory'/>" id='orderHistoryForm'  method="POST" type="application/x-www-form-urlencoded; charset=utf-8">
</form>

</body>
</html>