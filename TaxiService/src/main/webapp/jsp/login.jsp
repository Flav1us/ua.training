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

    if( form.login.value == "" ) {
      result += ' -  <fmt:message key="login.insertYourName"/>.\n';
        control = form.login;
        setFocus = false;
    }
    if( form.password.value == "" ) {
        result += ' - <fmt:message key="login.insertYourPass"/>.\n';
        if( setFocus ) {
            control = form.password;
            setFocus = false;
        }
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
</script>
</head>

<body class="bottombody">
<P>
<form action="<c:url value='/login'/>" onSubmit="return validate(this);" method="POST" type="application/x-www-form-urlencoded; charset=utf-8">
	<table cellSpacing="0" cellPadding="0"  width="90%">
   		<c:if test="${!(empty requestScope.errors)}">
      		<tr>
         		<td  align="left">
                    <ul>
                        <c:forEach var="error" items="${requestScope.errors}">
                            <li><span class="error"><fmt:message key="${error}"/></span>
                        </c:forEach>
                        
                    </ul>
                </td>
            </tr>
        </c:if>
        <tr>
            <td align="center">
                      <table cellSpacing="2" cellPadding="0" border="0">
                           <tr>
                                <td vAlign="top" align="left" colSpan="2"> <hr> </td>
                            </tr>
                           <tr>
                                <td>
                                    <font class=text4><fmt:message key="login.YourName"/>:</font>
                                </td>
                                <td>
                                    <input type="text" maxLength="15" style="width:110px" name="login" value='<c:out value="${str}" default="default"/>'>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <font class=text4><fmt:message key="login.YourPass"/>:</font>&nbsp;
                                </td>
                                <td>
                                    <input type="password" maxLength="20" style="width:110px" name="password" alt="blank">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit"  value="<fmt:message key="login.In"/>" style="width:110px">
                                </td>
                            </tr>
                            <tr>
                                <td vAlign="top" align="left" colSpan="2"><hr></td>
                            </tr>
                     </table>
            </td>
        </tr>
 </table>
</form>

<form action="<c:url value='/login'/>" method="POST" type="application/x-www-form-urlencoded; charset=utf-8">
	<input type="hidden" name="countryId" id="countryId" value="ru"/>
	<table cellSpacing="0" cellPadding="0"  width="90%">
        <tr>
            <td align="center">
                      <table cellSpacing="2" cellPadding="0" border="0">
                            <tr>
                                <td vAlign="top" align="left" colSpan="2">
                                <input type="submit"  value="RUS" style="width:35px">
                                <input type="submit" onclick="document.getElementById('countryId').value = 'en';" value="EN" style="width:35px">
                                </td>
                            </tr>
                     </table>
            </td>
        </tr>
 </table>

</form>

</body>
</html>
