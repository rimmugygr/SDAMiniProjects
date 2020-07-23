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
        <form name="send" method="post" action="<c:url value="/addtask"/> ">
          <%--  first card      --%>
          <div class="card shadow mb-4">
            <div class="card-body">


              <div class="form-group row">
                <label for="github" class="col-sm-2 col-form-label">URL Git</label>
                <div class="col-sm-10">
                  <select class="custom-select form-control" name="person" id="github">
                    <option selected disabled>Open this select menu</option>

                    <c:forEach  items="${persons}" var ="person">
                      <option value="${person.id}">${person.firstName}  ${person.lastName}</option>
                    </c:forEach>

                  </select>
                </div>
              </div>

              <div class="form-group row">
                <label for="deadline" class="col-sm-2 col-form-label">Deadline</label>
                <div class="col-sm-10">
                  <input type="date" name="deadline" id="deadline" max="3000-12-31"
                         min="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />" class="form-control">
                </div>
              </div>


              <div class="form-group row">
                <label for="content" class="col-sm-2 col-form-label">Treść zadania</label>
                <div class="col-sm-10">
                  <textarea class="form-control" name="content" id="content" rows="10" placeholder=""></textarea>
                </div>
              </div>

            </div>
          </div>
          <%--  second card      --%>
          <div class="card shadow mb-4">
            <div class="card-body">

              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline1" name="level" class="custom-control-input" value="junior">
                <label class="custom-control-label" for="customRadioInline1">
                  <span class="btn btn-success btn-circle btn-sm"></span>
                  <span>Poziom Junior</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline5" name="level" class="custom-control-input" value="juniorPlus">
                <label class="custom-control-label" for="customRadioInline5">
                  <span class="btn btn-info btn-circle btn-sm"></span>
                  <span>Poziom Junior+</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline2" name="level" class="custom-control-input" value="mid">
                <label class="custom-control-label" for="customRadioInline2">
                  <span class="btn btn-secondary btn-circle btn-sm"></span>
                  <span>Poziom Mid</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline3" name="level" class="custom-control-input" value="midPlus">
                <label class="custom-control-label" for="customRadioInline3">
                  <span class="btn btn-primary btn-circle btn-sm"></span>
                  <span>Poziom Mid+</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline4" name="level" class="custom-control-input" value="senior">
                <label class="custom-control-label" for="customRadioInline4">
                  <span class="btn btn-danger btn-circle btn-sm"></span>
                  <span>Senior</span>
                </label>
              </div>
            </div>
          </div>

          <%--  button for submit form          --%>
          <div class="form-group row">
            <div class="col-sm-10">
              <button type="submit" class="btn btn-success">Sign in</button>
            </div>
          </div>


        </form>

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
