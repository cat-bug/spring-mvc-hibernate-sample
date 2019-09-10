<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Animals</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add animal" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">
        <table>
            <tr>
                <th>Name</th>
                <th>Kind</th>
                <th>Age</th>

            </tr>
            <c:forEach var="animal" items="${animals}">
                <tr>
                    <td>${animal.name}</td>
                    <td>${animal.kind}</td>
                    <td>${animal.age}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
