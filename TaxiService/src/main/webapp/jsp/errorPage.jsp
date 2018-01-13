
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
	</table>
