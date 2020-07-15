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

      <form name="send" method="post" action="<c:url value="/editperson/${person.id}"/> ">

        <div class="card shadow mb-4">
          <div class="card-body">

            <div class="form-group row">
              <label for="firstName" class="col-sm-2 col-form-label">Imię</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" name="firstName" id="firstName" value="${person.firstName}">
              </div>
            </div>
            <div class="form-group row">
              <label for="lastName" class="col-sm-2 col-form-label">Nazwisko</label>
              <div class="col-sm-10">
                <input  type="text" class="form-control" name="lastName" id="lastName" value="${person.lastName}">
              </div>
            </div>
            <div class="form-group row">
              <label for="github" class="col-sm-2 col-form-label">URL Git</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" name="github" id="github" value="${person.github}">
              </div>
            </div>
            <div class="form-group row">
              <label for="start" class="col-sm-2 col-form-label">Od czego się zaczeło</label>
              <div class="col-sm-10">
                <textarea class="form-control" id="start" name="start" rows="5" >${person.start}</textarea>
              </div>
            </div>
<%--     check box       --%>
            <fieldset class="form-group" >
              <div class="row">
                <legend class="col-form-label col-sm-2 pt-0">Czy kursant opanował jakieś technologie</legend>
                <div class="col-sm-10">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="checkBox" id="gridRadios1" value="1"
                           <c:if test = "${person.checkBox==1}"> checked </c:if>
                           data-toggle="collapse" aria-expanded="false"
                           aria-controls="collapseExample" data-target=".collapseOne:not(.show)">
                    <label class="form-check-label" for="gridRadios1">
                      Tak
                    </label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="checkBox" id="gridRadios2" value="2"
                           <c:if test = "${person.checkBox==2}"> checked </c:if>
                           data-toggle="collapse"  aria-expanded="false"
                           aria-controls="collapseExample" data-target=".collapseOne.show">
                    <label class="form-check-label" for="gridRadios2">
                      Nie
                    </label>
                  </div>
                </div>
              </div>
            </fieldset>

          </div>
        </div>

<%--   collpase menu by chacebox--%>
        <div class="collapse collapseOne <c:if test = "${person.checkBox==1}">  show </c:if> "  aria-expanded="true">
          <div class="card shadow mb-4" >

              <div class="card-body" >

          <div class="row">
            <div class="col">
              <div class="form-group">
                <label for="inputJava" >Java</label>
                <input type="text" class="form-control" name="java" value="${person.java}" id="inputJava">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputWzorce" >Wzorce Projktowe</label>
                <input type="text" class="form-control" name="bestpractice" value="${person.bestpractice}" id="inputWzorce">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputTDD" >TDD</label>
                <input type="text" class="form-control" name="tdd" value="${person.tdd}" id="inputTDD">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputBazy" >Bazy danych SQL</label>
                <input type="text" class="form-control" name="hibernate" value="${person.hibernate}" id="inputBazy">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputHibernate" >Hibernate JPA</label>
                <input type="text" class="form-control" value="${person.hibernate}" id="inputHibernate">
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col">
              <div class="form-group">
                <label for="inputHTML" >HTML, CSS</label>
                <input type="text" class="form-control" name="html" value="${person.html}" id="inputHTML">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputJSP" >JSP</label>
                <input type="text" class="form-control" name="jsp" value="${person.jsp}" id="inputJSP">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputThymeleaf" >Thymeleaf</label>
                <input type="text" class="form-control" name="thymeleaf" value="${person.thymeleaf}" id="inputThymeleaf">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputGIT" >GIT</label>
                <input type="text" class="form-control" name="git" value="${person.git}" id="inputGIT">
              </div>
            </div>
            <div class="col">
              <div class="form-group">
                <label for="inputHidden" ></label>
                <input type="text" class="form-control" placeholder="50" id="inputHidden" hidden>
              </div>
            </div>
          </div>

        </div>

    </div>
  </div>

  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-success">Sign in</button>
      <!-- Button trigger modal for delete -->
      <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
        Usuń
      </button>



    </div>
  </div>

  </form>

  <!-- Modal for deleting-->
  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
          <form name="delete" method="post" action="<c:url value = "/deleteperson/${person.id}"/>">
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
