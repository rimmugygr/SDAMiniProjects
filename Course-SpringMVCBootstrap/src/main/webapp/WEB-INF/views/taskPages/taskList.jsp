<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="../dynamic/head.jspf"%>
<body id="page-top">


<div id="wrapper"><!-- Page Wrapper -->

<%@include file="../dynamic/menuLeft.jspf"%>


  <div id="content-wrapper" class="d-flex flex-column">  <!-- Content Wrapper -->

    <%@include file="../dynamic/menuTop.jspf"%>

    <!-- Begin Page Content -->
    <div class="container-fluid">
      <!-- Content Row -->

      <%--  button row   --%>
      <div class="row shadow mb-4">
        <div class="col-lg-12">
          <a href="<c:url value="/addtask"/>" class="btn btn-warning btn-block">
            <i class="fas fa-exclamation-triangle"></i>
            <span class="text"> Dodaj taska</span>
          </a>
        </div>
      </div>

      <%--  card row    --%>
      <div class="row">

        <%--   left column with level    --%>
        <div class="col-lg-2">

          <div class="card bg-success text-white shadow">
            <div class="card-body">
              <div class="col">
                <span class="row h5" >Nowicjusz</span>
                <span class="small row">Poziom Junior</span>
                <a class="stretched-link" href=" <c:url value="/task/junior"/> "></a>
              </div>
            </div>
          </div>

          <div class="card bg-info text-white shadow">
            <div class="card-body">
              <div class="col">
                <span class="row h5" >Dojrzewający</span>
                <span class="small row">Poziom Junior+</span>
                <a class="stretched-link" href=" <c:url value="/task/juniorPlus"/> "></a>
              </div>
            </div>
          </div>
          <div class="card bg-secondary text-white shadow">
            <div class="card-body">
              <div class="col">
                <span class="row h5" >Wie co robi</span>
                <span class="small row">Poziom Mid</span>
                <a class="stretched-link" href=" <c:url value="/task/mid"/> "></a>
              </div>
            </div>
          </div>
          <div class="card bg-primary text-white shadow">
            <div class="card-body">
              <div class="col">
                <span class="row h5" >Doświadczony</span>
                <span class="small row">Poziom Mid+</span>
                <a class="stretched-link" href=" <c:url value="/task/midPlus"/> "></a>
              </div>
            </div>
          </div>
          <div class="card bg-danger text-white shadow">
            <div class="card-body">
              <div class="col">
                <span class="row h5" >Wyjadacz</span>
                <span class="small row">Senior</span>
                <a class="stretched-link" href=" <c:url value="/task/senior"/> "></a>
              </div>
            </div>
          </div>
        </div>
        <%--  end left column with level    --%>

        <%--   right column with task       --%>
        <div class="col-lg-10">

          <c:forEach  items="${tasks}" var ="task">
            <div class="row">
              <div class="col">
                <div class="card  shadow mb-4
                      <c:choose>
                          <c:when test="${task.level eq 'junior'}">border-left-success text-success</c:when>
                          <c:when test="${task.level eq 'juniorPlus'}">border-left-info text-info</c:when>
                          <c:when test="${task.level eq 'mid'}">border-left-secondary text-secondary</c:when>
                          <c:when test="${task.level eq 'midPlus'}">border-left-primary text-primary</c:when>
                          <c:when test="${task.level eq 'senior'}">border-left-danger text-danger</c:when>
                      </c:choose> ">
                  <div class="card-body">
                    <div class="row  small">
                        ${task.person.firstName} ${task.person.lastName}
                      | <strong> Dodano: </strong> ${task.createDate}
                      | <strong> Deadline: </strong> ${task.deadline}
                    </div>
                    <div class="row text-dark">
                        <pre>${task.content}</pre>
                    </div>
                  </div>
                  <a class="stretched-link" href="<c:url value="/edittask/${task.id}"/>" ></a>
                </div>
              </div>
            </div>
          </c:forEach>

        </div>
          <%--   end right column with task       --%>

      </div>
      <%-- end card row  --%>

    </div>
    <!-- End of Main Content -->

    <%@include file="../dynamic/foot.jspf"%>
  </div>  <!-- End of Content Wrapper -->

</div><!-- End of Page Wrapper -->

<%@include file="../dynamic/script.jspf"%>
</body>
</html>