<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="layouts/header.jsp"/>
    </head>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <!-- NAVBAR -->
            <jsp:include page="layouts/navbar.jsp"/>
            <!-- /.NAVBAR -->

            <!-- MAIN SIDEBAR CONTAINER -->
            <jsp:include page="layouts/sidebar.jsp"/>
            <!-- MAIN SIDEBAR CONTAINER END-->


            <!-- CONTENT WRAPPER -->
            <div class="content-wrapper">

                <!-- CONTENT HEADER (PAGE HEADER) -->
                <jsp:include page="layouts/content-header.jsp">
                    <jsp:param name="header_title" value="Home"/>
                    <jsp:param name="breadcump_parent" value="Home"/>
                    <jsp:param name="breadcump_child" value=""/>
                </jsp:include>
                <!-- /.CONTENT HEADER -->

                <!-- MAIN CONTENT -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">








                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header border-0">
                                    <h3 class="card-title">Books</h3>
                                    <div class="card-tools">
                                        <a href="<c:url value="/book/report"/>">Generate Report</a>
                                    </div>
                                </div>
                                <div class="card-body table-responsive p-0">
                                    <table class="table table-striped table-valign-middle">
                                        <thead>
                                        <tr>
                                            <th>Book</th>
                                            <th>ISBN</th>
                                            <th>Author</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${books}" var="book">
                                            <tr>
                                                <td>
                                                    <img src="<c:url value="/dist/img/prod-3.jpg"/>" alt="Product 1" class="img-circle img-size-32 mr-2">
                                                    Book: ${book.name}
                                                    <!--span class="badge bg-danger">NEW</span-->
                                                </td>
                                                <td>${book.isbn}</td>
                                                <td>
                                                    <small class="text-success mr-1">
                                                        <i class="fas fa-arrow-up"></i>

                                                    </small>
                                                        ${book.author}
                                                </td>
                                                <td>
                                                    <!--a href="#" class="text-muted">
                                                        <i class="fas fa-search"></i>
                                                    </a-->
                                                    <c:url var="action" value="/book/delete/${book.isbn}"/>
                                                    <form action="${action}" method="POST">
                                                        <input class="btn btn-outline-info" type="submit" name="submit" value="Delete" />
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>












                        </div>
                    </div>
                </div>
                <!-- MAIN CONTENT -->

            </div>
            <!-- CONTENT WRAPPER -->



            <!-- MAIN FOOTER -->
            <jsp:include page="layouts/footer.jsp"/>
            <!-- MAIN FOOTER -->

        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED SCRIPTS -->
        <jsp:include page="layouts/js-scripts.jsp"/>

    </body>
</html>
