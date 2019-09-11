<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Update an animal</h2>
    </div>
</div>
<div id="container">
    <h3>Add new animal</h3>
    <div id="content">
        <form:form action="updateAnimal" modelAttribute="animal" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>Kind</label></td>
                    <td><form:input path="kind"/></td>
                </tr>

                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <td><label>Age</label></td>
                    <td><form:input path="age"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Update" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <p>
            <a href="${pageContext.request.contextPath}/animals/list">Back to list</a>
        </p>
    </div>
</div>
</body>
</html>
