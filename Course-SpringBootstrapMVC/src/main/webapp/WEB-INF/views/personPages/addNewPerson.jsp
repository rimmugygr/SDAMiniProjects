<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="../dynamic/head.jspf"%>
<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <%@include file="../dynamic/menuLeft.jspf"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <%@include file="../dynamic/menuTop.jspf"%>

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <div class="card shadow mb-4">
          <div class="card-body">
            <form name="send" method="post" action="<c:url value="/addperson"/> ">
              <div class="form-group row">
                <label for="firstName" class="col-sm-2 col-form-label">Imię</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" name="firstName" id="firstName" placeholder="uzupełnij imie">
                </div>
              </div>
              <div class="form-group row">
                <label for="lastName" class="col-sm-2 col-form-label">Nazwisko</label>
                <div class="col-sm-10">
                  <input  type="text" class="form-control" name="lastName" id="lastName" placeholder="uzupełnij nazwisko">
                </div>
              </div>
              <div class="form-group row">
                <label for="github" class="col-sm-2 col-form-label">URL Git</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" name="github" id="github" placeholder="uzupełnij url do gita">
                </div>
              </div>
              <div class="form-group row">
                <label for="start" class="col-sm-2 col-form-label">Od czego się zaczeło</label>
                <div class="col-sm-10">
                  <textarea class="form-control" name="start" id="start" rows="10" placeholder="napisz kilka słow co cię zmotywowało"></textarea>
                </div>
              </div>
              <div class="form-group row">
                <div class="col-sm-10">
                  <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
              </div>
            </form>
          </div>
      </div>


    </div>
    <!-- End of Main Content -->
    <%@include file="../dynamic/foot.jspf"%>
  </div>
  <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<%@include file="../dynamic/script.jspf"%>
</body>
</html>
