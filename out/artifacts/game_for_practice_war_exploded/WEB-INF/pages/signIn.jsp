<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/singIn.css">
</head>
<tags:master pageTitle="Game">
    <div id="login">
        <form method="get">
            <fieldset>
                <p><span class="fontawesome-user"></span><input type="text" name="login" value="Логин" onBlur="if(this.value == '') this.value = 'Логин'" onFocus="if(this.value == 'Логин') this.value = ''" required></p>
                <p><span class="fontawesome-lock"></span><input type="password" name="password" value="Пароль" onBlur="if(this.value == '') this.value = 'Пароль'" onFocus="if(this.value == 'Пароль') this.value = ''" required></p>
                <p><input type="submit" value="Войти"/></p>
                <c:if test="${not empty error}">
                    <p class="error">${error}</p>
                </c:if>
            </fieldset>
        </form>
        <p>Нет аккаунта? &nbsp;&nbsp;<a href="${pageContext.servletContext.contextPath}/logIn">Регистрация</a><span class="fontawesome-arrow-right"></span></p>
    </div>
</tags:master>