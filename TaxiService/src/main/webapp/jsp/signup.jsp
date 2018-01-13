<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="resources.Messages" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/signup'/>" method="post">
<table cellSpacing="0" cellPadding="0"  width="90%">
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
                                <td>
                                    <font class=text4><fmt:message key="login.YourPhone"/>:</font>&nbsp;
                                </td>
                                <td>
                                    <input type="text" maxLength="20" style="width:110px" name="phone" alt="blank">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit"  value="<fmt:message key="signup.up"/>" style="width:110px">
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
</body>
</html>