<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../dynamic/header.jspf"%>


        <!-- Page Content-->
        <div class="container-fluid p-0">
            <hr class="m-0" />
            <!-- Education-->
            <section class="resume-section" id="education">
                <div class="resume-section-content">
                    <h2 class="mb-5">Education</h2>
                    <c:forEach items="${educationModel}" var="item">
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                            <h3 class="mb-0">${item.fieldOfStudy}</h3>
                            <div class="subheading mb-3">${item.degree}</div>
                            <div>${item.school}</div>
                        </div>
                        <div class="flex-shrink-0"><span class="text-primary"><fmt:formatDate pattern = "yyyy-MM" value = "${item.startDate}" />
 - <c:if test="${empty item.endDate}">now</c:if><fmt:formatDate pattern = "yyyy-MM" value = "${item.endDate}" /></span></div>
                    </div>

                        <security:authorize access="hasAnyRole('ADMIN')">
                            <!--Delete button-->
                            <form method="post" action="<c:url value="/education/${item.id}"/>">
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
    <form method="post" action='<c:url value="/education"/>'>
    <div class="col-xl-12 col-md-12 mb-12">
        <div class="card shadow mb-4">
            <div class="card-header py-3">


                <div class="form-group row">
                    <label class="col-2 col-form-label">Name of the school</label>
                    <div class="col-10">
                        <input class="form-control" type="text" name="school" placeholder="Enter the name of the school/university">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-2 col-form-label">Degree</label>
                    <div class="col-10">
                        <input class="form-control" type="text" name="degree" placeholder="What degree did you get">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-2 col-form-label">Field of study</label>
                    <div class="col-10">
                        <input class="form-control" type="text" name="fieldOfStudy" placeholder="What was the field of study">
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
    </div>
</div>
</security:authorize>

</form>
<%@include file="../dynamic/footer.jspf"%>
</body>
</html>
