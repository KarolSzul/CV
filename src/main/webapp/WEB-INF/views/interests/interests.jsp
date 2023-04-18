<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../dynamic/header.jspf"%>

        <!-- Page Content-->
        <div class="container-fluid p-0">
            <!-- Interests-->
            <section class="resume-section" id="interests">
                <div class="resume-section-content">
                    <h2 class="mb-5">Interests</h2>
                    <c:forEach items="${interestsModel}" var="item">
                    <p>${item.description}</p>

                        <security:authorize access="hasAnyRole('ADMIN')">
                            <!--Delete button-->
                            <form method="post" action="<c:url value="/interests/${item.id}"/>">
                                <input type="submit" class="btn btn-danger" value="Delete">
                            </form>
                        </security:authorize>


                    </c:forEach>
                </div>
            </section>
            <hr class="m-0" />
        </div>

<security:authorize access="hasAnyRole('ADMIN')">
    <!-- Edit content-->
    <div class="row">
        <form method="post" action='<c:url value="/interests"/>'>
            <div class="col-xl-12 col-md-12 mb-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">


                        <div class="form-group row">
                            <label class="col-2 col-form-label">Description</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="description" placeholder="Enter description">
                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-10">
                                <input class="btn btn-success pull-left" type="submit" value="Wyślij" id="searchButton"></input>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </form>
    </div>
</security:authorize>


<%@include file="../dynamic/footer.jspf"%>
    </body>
</html>
