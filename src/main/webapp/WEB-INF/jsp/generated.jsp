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
                    <jsp:param name="header_title" value="Report"/>
                    <jsp:param name="breadcump_parent" value="Home"/>
                    <jsp:param name="breadcump_child" value="Report"/>
                </jsp:include>
                <!-- /.CONTENT HEADER -->

                <!-- MAIN CONTENT -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card card-secondary">
                                    <div class="card-header">
                                        <h3 class="card-title">
                                            <i class="fas fa-exclamation-triangle"></i>

                                        </h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body">
                                        <div class="alert alert-success alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h5><i class="icon fas fa-check"></i> Alert!</h5>
                                            Pdf Has been Generated
                                        </div>
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