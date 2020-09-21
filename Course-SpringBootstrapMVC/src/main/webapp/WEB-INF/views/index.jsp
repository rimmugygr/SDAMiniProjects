<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="dynamic/head.jspf"%>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

<%@include file="dynamic/menuLeft.jspf"%>

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <%@include file="dynamic/menuTop.jspf"%>

    <!-- Begin Page Content -->
    <div class="container-fluid">
      <!-- Content Row -->
      <div class="row">
        <!-- ILOŚĆ (KURSANCI) Card  -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">ILOŚĆ (KURSANCI)</div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">12</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-users fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- ILOŚĆ H (KURSU) Card-->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-success shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-success text-uppercase mb-1">ILOŚĆ H (KURSU)</div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">360</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-laptop fa-2x  text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks</div>
                  <div class="row no-gutters align-items-center">
                    <div class="col-auto">
                      <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">80%</div>
                    </div>
                    <div class="col">
                      <div class="progress progress-sm mr-2">
                        <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Pending Requests Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-warning shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Technologie</div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">12</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-cogs fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Content Row -->
      <!-- Approach -->
      <div class="jumbotron">
        <h1 class="display-4">Projekt zajeciowy</h1>
        <p class="lead">Bootstrap + ASP + Spring Boot + MySQL</p>
        <p class="lead"> ${userhello} Dzisiaj jest : <fmt:formatDate value="${now}" pattern="MM.dd.yyyy" /></p>
      </div>
    </div>
    <!-- End of Main Content -->

    <%@include file="dynamic/foot.jspf"%>
  </div>
  <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<%@include file="dynamic/script.jspf"%>
</body>
</html>