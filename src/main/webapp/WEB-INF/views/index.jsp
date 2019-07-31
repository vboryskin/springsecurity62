<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        table {
            color: #333;
            font-family: Helvetica, Arial, sans-serif;
            width: 640px;
            /* Table reset stuff */
            border-collapse: collapse; border-spacing: 0;
        }

        td, th {  border: 0 none; height: 30px; }

        th {
            /* Gradient Background */
            background: linear-gradient(#333 0%,#444 100%);
            color: #FFF; font-weight: bold;
            height: 40px;
        }

        td { background: #FAFAFA; text-align: center; }

        /* Zebra Stripe Rows */

        tr:nth-child(even) td { background: #EEE; }
        tr:nth-child(odd) td { background: #FDFDFD; }

        /* First-child blank cells! */
        tr td:first-child, tr th:first-child {
            background: none;
            font-style: italic;
            font-weight: bold;
            font-size: 14px;
            text-align: right;
            padding-right: 10px;
            width: 80px;
        }

        /* Add border-radius to specific cells! */
        tr:first-child th:nth-child(2) {
            border-radius: 5px 0 0 0;
        }

        tr:first-child th:last-child {
            border-radius: 0 5px 0 0;
        }
    </style>
</head>
<body>
<h1>Welcome to index</h1>
<sec:authorize access="isAnonymous()">
    <div>
        <a href="/login">Login</a>
    </div>
    <div>
        <a href="/registration">First time, huh?</a>
    </div>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div>
        <a href="/profile">Profile</a>
    </div>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th><a href="/index?page=${param.get("page")}&sort=name">Name</a></th>
            <th><a href="/index?page=${param.get("page")}&sort=price">Price</a></th>
            <th><a href="/index?page=${param.get("page")}&sort=amount">Amount</a></th>
            <th><a href="/index?page=${param.get("page")}&sort=manufacturer">Manufactorer</a></th>
            <th><a href="/index?page=${param.get("page")}&sort=description">Description</a></th>
            <th><a href="/index?page=${param.get("page")}&sort=productPicture">Picture</a></th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.amount}</td>
                <td>${p.manufacturer}</td>
                <td>${p.description}</td>
                <td>${p.productPicture}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <a href="/index?page=1&sort=${param.get("sort")}">1</a>
        <a href="/index?page=2&sort=${param.get("sort")}">2</a>
        <a href="/index?page=3&sort=${param.get("sort")}">3</a>
        <a href="/index?page=4&sort=${param.get("sort")}">4</a>
        <a href="/index?page=5&sort=${param.get("sort")}">5</a>
    </div>
</sec:authorize>
</body>
</html>
