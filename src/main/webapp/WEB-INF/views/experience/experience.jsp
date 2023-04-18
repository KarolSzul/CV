<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../dynamic/header.jspf"%>

        <!-- Page Content-->
        <div class="container-fluid p-0">
           <!-- Experience-->
            <section class="resume-section" id="experience">
                <div class="resume-section-content">
                    <h2 class="mb-5">Experience</h2>
                    <c:forEach items="${experienceModel}" var="item">
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                            <h3 class="mb-0">${item.position}</h3>
                            <div class="subheading mb-3">${item.company}</div>
                            <p>${item.responsibilities}</p>
                        </div>
                        <div class="flex-shrink-0"><span class="text-primary"><fmt:formatDate pattern = "yyyy-MM" value = "${item.startDate}" />
 - <c:if test="${empty item.endDate}">now</c:if> <fmt:formatDate pattern = "yyyy-MM" value = "${item.endDate}" /></span></div>
                    </div>
                        <security:authorize access="hasAnyRole('ADMIN')">
                            <!--Delete button-->
                            <form method="post" action="<c:url value="/experience/${item.id}"/>">
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
        <form method="post" action='<c:url value="/experience"/>'>
            <div class="col-xl-12 col-md-12 mb-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">


                        <div class="form-group row">
                            <label class="col-2 col-form-label">Position</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="position" placeholder="Enter position">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-2 col-form-label">Company</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="company" placeholder="Enter company">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-2 col-form-label">Responsibilities</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="responsibilities" placeholder="Describe shortly your responsibilities">
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-2 col-form-label">Date of start</label>
                            <div class="col-10">
                                <input class="form-control" type="date" name="startDate"  placeholder="">
                            </div>
                        </div>


                        <div class="form-group row">
                            <label class="col-2 col-form-label">Date of end</label>
                            <div class="col-10">
                                <input class="form-control" type="date" name="endDate"  placeholder="">
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
