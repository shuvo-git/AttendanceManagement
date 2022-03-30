<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <jsp:param name="header_title" value="Add Book"/>
                    <jsp:param name="breadcump_parent" value="Home"/>
                    <jsp:param name="breadcump_child" value="Add Book"/>
                </jsp:include>
                <!-- /.CONTENT HEADER -->

                <!-- MAIN CONTENT -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card card-warning">
                                    <c:if test="${addBookSuccess}">
                                        <div class="card-header">
                                            Successfully added Book with ISBN: ${savedBook.isbn}
                                        </div>
                                    </c:if>

                                    <div class="card-body">
                                        <c:url var="add_book_url" value="/book/addBook"/>
                                        <form:form action="${add_book_url}" method="post" modelAttribute="book">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <!-- text input -->
                                                    <div class="form-group">
                                                        <form:label path="isbn">ISBN</form:label>
                                                        <form:input path="isbn" type="text" class="form-control" placeholder="Enter ..."/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="form-group">
                                                        <form:label path="name">Book Name</form:label>
                                                        <form:input path="name" type="text" class="form-control" placeholder="Enter ..." />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <!-- text input -->
                                                    <div class="form-group">
                                                        <form:label path="author">Author Name</form:label>
                                                        <form:input path="author" type="text" class="form-control" placeholder="Enter ..."/>
                                                    </div>
                                                </div>

                                            </div>


                                            <input class="btn btn-info" type="submit" value="submit"/>
                                        </form:form>

                                    </div>
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->
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

        <!-- JQUERY -->
        <script src="<c:url value="/plugins/jquery/jquery.min.js"/>"></script>
        <!-- BOOTSTRAP -->
        <script src="<c:url value="/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <!-- ADMIN LTE -->
        <script src="<c:url value="/dist/js/adminlte.js"/>"></script>

        <!-- OPTIONAL SCRIPTS -->
        <script src="<c:url value="/plugins/chart.js/Chart.min.js"/>"></script>
        <!-- ADMINLTE FOR DEMO PURPOSES -->
        <script src="<c:url value="/dist/js/demo.js"/>"></script>
        <!-- ADMINLTE DASHBOARD DEMO (THIS IS ONLY FOR DEMO PURPOSES) -->
        <script src="<c:url value="/dist/js/pages/dashboard3.js"/>"></script>
    </body>
</html>