<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="pl">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron" style='text-align:center'>
    <h1 class="display-4">Bank tajnych danych</h1>
    <label for="key">Podaj klucz</label>
    <div class='form-group'>
        <form:form method="post" modelAttribute="keyModel">
            <div style= 'display:inline-block'>
                <form:input path="key" type="text" class="form-control" style="width:200px" />
            </div>
    </div>
           <form:button class="btn btn-primary btn-lg" type="submit">Otworz</form:button>
    </form:form>
    <hr class="my-4">
    <c:choose>
        <c:when test="${isSafeOpened}">
            <h3>Tajna wiadomosc: ${message}</h3>
            <img src='/images/kufer_opened.png'></img>
            <br/>
        </c:when>
        <c:otherwise>
            <img src='/images/kufer.png'></img>
            <br/>
        </c:otherwise>
    </c:choose>
</div>
</body>

</html>
