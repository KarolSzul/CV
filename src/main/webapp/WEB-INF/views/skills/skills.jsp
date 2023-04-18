<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../dynamic/header.jspf"%>


        <!-- Page Content-->
        <div class="container-fluid p-0">
            <!-- Skills-->
            <section class="resume-section" id="skills">
                <div class="resume-section-content">
                    <h2 class="mb-5">Skills</h2>
                    <div class="subheading mb-3">Programming Languages & Tools</div>
                    <ul class="list-inline dev-icons">
                        <li class="list-inline-item"><i class="devicon-java-plain-wordmark colored"></i></li>
                        <li class="list-inline-item"><i class="devicon-intellij-plain-wordmark colored"></i></li>
                        <li class="list-inline-item"> <i class="devicon-mysql-plain-wordmark colored"></i></li>
                        <li class="list-inline-item"><i class="devicon-git-plain-wordmark colored"></i></li>
                        <li class="list-inline-item"> <i class="devicon-github-original-wordmark colored"></i></li>
                        <li class="list-inline-item"> <i class="devicon-spring-plain-wordmark colored"></i></li>
                        <li class="list-inline-item">  <i class="devicon-html5-plain-wordmark colored"></i></li>
                        <li class="list-inline-item">  <i class="devicon-css3-plain-wordmark colored"></i></li>

                    </ul>
                    <div class="subheading mb-3">Workflow</div>
                    <ul class="fa-ul mb-0">
                        <c:forEach items="${skillsModel}" var="item">
                        <li>
                            <span class="fa-li"><i class="fas fa-check"></i></span>
                            ${item.skillDescription}

                            <security:authorize access="hasAnyRole('ADMIN')">
                                <!--Delete button-->
                                <form method="post" action="<c:url value="/skills/${item.id}"/>">
                                    <input type="submit" class="btn btn-danger" value="Delete">
                                </form>
                            </security:authorize>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
            <hr class="m-0" />
        </div>

<security:authorize access="hasAnyRole('ADMIN')">
    <!-- Edit content-->
    <div class="row">
        <form method="post" action='<c:url value="/skills"/>'>
            <div class="col-xl-12 col-md-12 mb-12">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">


                        <div class="form-group row">
                            <label class="col-2 col-form-label">Description</label>
                            <div class="col-10">
                                <input class="form-control" type="text" name="skillDescription" placeholder="Enter a skill">
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
