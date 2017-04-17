<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>PsychSpace</title>
    <%--Google sign in--%>
    <meta name="google-signin-client_id" content="268071146674-5jjt494svk74rt4jb5mu4pik8503qbph.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <%--Google fonts--%>
    <link href='http://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
    <link href='http://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
    <%--jQuery--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <%--Bootstrap--%>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet"/>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <%--Customized--%>
    <link href="${contextPath}/resources/css/admin.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <script src="${contextPath}/resources/js/adminDeleteArticle.js"></script>
</head>
<body>

    <div id="wrapper">

        <%@include file="admin-sidebar.html" %>

        <div id="page-content-wrapper">
            <h1>Delete Article</h1>
            <form:form method="get" action="admin_deleteArticle" modelAttribute="news">
                <table id="delete-article-table" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="selectAll" />
                        </th>
                        <th>Title</th>
                        <th>Date</th>
                        <td><button type="button" class="btn btn-primary" id="btn-delete-article"data-toggle="modal" data-target="deleteArticleModal">
                            Delete
                            </button>
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${newsList}" var="news">
                        <tr>
                            <form:hidden value="${news.newsKey}" path="newsKey"/>
                            <form:hidden value="${news.title}" path="title"/>
                            <form:hidden value="${news.date}" path="date"/>
                            <form:hidden value="${news.content}" path="content"/>
                            <form:hidden value="${news.author}" path="author"/>
                            <form:hidden value="${news.likesCount}" path="likesCount"/>
                            <th>
                                <input type="checkbox" id="${news.newsKey}"/>
                            </th>
                            <td>${news.title}</td>
                            <td>${news.date}</td>
                            <td><div class="button">Delete</div></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form:form>

        </div>
    </div>

    <%--Delete confirmation modal--%>
    <div class="modal fade" id="deleteArticleModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header row">
                    <div class="col-sm-8">
                        <h3 class="modal-title">Delete Confirmation</h3>
                    </div>
                    <div class="col-sm-4">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete <span id="modal-delete-article-span"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" id="btn-delete-article-confirm">Delete</button>
                </div>
            </div>
        </div>
    </div>

    <%--Delete error modal--%>
    <div class="modal fade" id="deleteArticleErrorModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header row">
                    <div class="col-sm-8">
                        <h3 class="modal-title">Oops</h3>
                    </div>
                    <div class="col-sm-4">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </div>
                <div class="modal-body">
                    Something went wrong :/
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
