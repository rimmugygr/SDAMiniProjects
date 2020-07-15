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
        <form name="send" method="post" action="<c:url value="/edittask/${task.id}"/> ">
          <%--  first card      --%>
          <div class="card shadow mb-4">
            <div class="card-body">

              <div class="form-group row">
                <label for="github" class="col-sm-2 col-form-label">URL Git</label>
                <div class="col-sm-10">
                  <select class="custom-select form-control" name="person" id="github">
                    <option selected value="${task.person.id}" >${task.person.firstName} ${task.person.lastName}</option>
                    <c:forEach  items="${persons}" var ="person">
                      <option value="${person.id}">${person.firstName}  ${person.lastName}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="form-group row">
                <label for="deadline" class="col-sm-2 col-form-label">Deadline</label>
                <div class="col-sm-10">
                  <input type="date" name="deadline" id="deadline" value="${task.deadline}" max="3000-12-31"
                         min="1000-01-01" class="form-control">
                </div>
              </div>

              <div class="form-group row">
                <label for="createDate" class="col-sm-2 col-form-label">Create Date</label>
                <div class="col-sm-10">
                  <input type="date" readonly name="createDate" id="createDate" value="${task.createDate}" max="3000-12-31"
                         min="1000-01-01" class="form-control">
                </div>
              </div>

              <div class="form-group row">
                <label for="content" class="col-sm-2 col-form-label">Treść zadania</label>
                <div class="col-sm-10">
                  <textarea class="form-control" name="content" id="content" rows="10" placeholder="">${task.content}</textarea>
                </div>
              </div>

            </div>
          </div>
          <%--  second card      --%>
          <div class="card shadow mb-4">
            <div class="card-body">

              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline1" name="level" class="custom-control-input" value="junior"
                       <c:if test="${task.level eq 'junior'}"> checked</c:if> >
                <label class="custom-control-label" for="customRadioInline1">
                  <span class="btn btn-success btn-circle btn-sm"></span>
                  <span>Poziom Junior</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline5" name="level" class="custom-control-input" value="juniorPlus"
                <c:if test="${task.level eq 'juniorPlus'}"> checked</c:if> >
                <label class="custom-control-label" for="customRadioInline5">
                  <span class="btn btn-info btn-circle btn-sm"></span>
                  <span>Poziom Junior+</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline2" name="level" class="custom-control-input" value="mid"
                <c:if test="${task.level eq 'mid'}"> checked</c:if> >
                <label class="custom-control-label" for="customRadioInline2">
                  <span class="btn btn-secondary btn-circle btn-sm"></span>
                  <span>Poziom Mid</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline3" name="level" class="custom-control-input" value="midPlus"
                <c:if test="${task.level eq 'midPlus'}"> checked</c:if> >
                <label class="custom-control-label" for="customRadioInline3">
                  <span class="btn btn-primary btn-circle btn-sm"></span>
                  <span>Poziom Mid+</span>
                </label>
              </div>
              <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline4" name="level" class="custom-control-input" value="senior"
                <c:if test="${task.level eq 'senior'}"> checked</c:if> >
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
              <button type="submit" class="btn btn-success">Save Change</button>
              <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                Delete Task
              </button>
            </div>
          </div>
        </form>

        <!-- Modal for deleting-->
        <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Are u sure</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form name="delete" method="post" action="<c:url value = "/deletetask/${task.id}"/>">
                  <button type="submit" class="btn btn-danger">Confirm delete</button>
                </form>
              </div>
            </div>
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
