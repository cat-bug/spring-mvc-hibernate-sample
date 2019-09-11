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
                <th>Diseases</th>
                <th>Action</th>

            </tr>
            <c:forEach var="animal" items="${animals}">
                <c:url var="updateLink" value="/animals/showFormForUpdate">
                    <c:param name="animalId" value="${animal.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/animals/deleteAnimal">
                    <c:param name="animalId" value="${animal.id}"/>
                </c:url>
                <tr>
                    <td>${animal.name}</td>
                    <td>${animal.kind}</td>
                    <td>${animal.age}</td>
                    <td> <c:forEach var="disease" items="${animal.diseases}"><div>${disease.name}</div></c:forEach></td>
                    <td><a href="${updateLink}">Update</a>
                        | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a> </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
