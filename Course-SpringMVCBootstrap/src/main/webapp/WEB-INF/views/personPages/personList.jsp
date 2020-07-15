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

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Kursanci</h1>
          <p class="mb-4">Wszyscy kursanci biorący udział w szkoleniu- SDA | <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Tabela Kurasntów</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table action-panel table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                  <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>URL GIT</th>
                    <th>Od czego się zaczęło</th>
                    <th>Umiejętności</th>
                    <th>Akcja</th>
                  </tr>
                  </thead>
                  <tfoot>
                  <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>URL GIT</th>
                    <th>Od czego się zaczęło</th>
                    <th>Umiejętności</th>
                    <th>Akcja</th>
                  </tr>
                  </tfoot>
                  <tbody>

                  <c:forEach  items="${persons}" var ="person">
                  <tr>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>
                      <a href="<c:url value = "https://${person.github}"/>" class="btn btn-info btn-circle">
                        <i class="fas fa-info-circle"></i>
                      </a>
                    </td>
                    <td>${person.start}</td>
                    <td>
                      <a data-toggle="modal" data-target="#exampleModal${person.id}" class="btn btn-success btn-circle">
                        <i class="fas fa-check"></i>
                      </a>
                      <!-- Modal -->
                      <div class="modal fade" id="exampleModal${person.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                          <div class="modal-content">
                            <div class="modal-header">
                              <h5 class="modal-title" id="exampleModalLabel">Dominik Maciąg</h5>
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                              </button>
                            </div>
                            <div class="modal-body">

                              <div class="card shadow mb-4">

                                <!-- Project Card Example -->
                                <div class="card shadow mb-4">
                                  <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Umiejętności</h6>
                                  </div>
                                  <div class="card-body">

                                    <h4 class="small font-weight-bold">Java <span class="float-right">${person.java}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar bg-danger" role="progressbar" style="width: ${person.java}%" aria-valuenow="${person.java}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">Wzorce projektowe <span class="float-right">${person.bestpractice}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar bg-warning" role="progressbar" style="width: ${person.bestpractice}%" aria-valuenow="${person.bestpractice}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">TDD <span class="float-right">${person.tdd}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar" role="progressbar" style="width: ${person.tdd}%" aria-valuenow="${person.tdd}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">Bazy danych SQL <span class="float-right">${person.hibernate}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar bg-info" role="progressbar" style="width: ${person.hibernate}%" aria-valuenow="${person.hibernate}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">Hibernate JPA <span class="float-right">${person.hibernate}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar " role="progressbar" style="width: ${person.hibernate}%" aria-valuenow="${person.hibernate}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">HTML, CSS <span class="float-right">${person.html}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar" role="progressbar" style="width: ${person.html}%" aria-valuenow="${person.html}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">JPA <span class="float-right">${person.hibernate}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar " role="progressbar" style="width: ${person.hibernate}%" aria-valuenow="${person.hibernate}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">Thymeleaf <span class="float-right">${person.thymeleaf}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar " role="progressbar" style="width: ${person.thymeleaf}%" aria-valuenow="${person.thymeleaf}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>

                                    <h4 class="small font-weight-bold">GIT <span class="float-right">${person.git}</span></h4>
                                    <div class="progress mb-4">
                                      <div class="progress-bar " role="progressbar" style="width: ${person.git}%" aria-valuenow="${person.git}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-primary">Ok</button>
                            </div>
                          </div>
                        </div>
                      </div>

                    </td>
                    <td>
                      <!-- Button trigger modal -->
                      <a href="<c:url value = "/editperson/${person.id}"/>">
                        <button type="button" class="btn btn-primary"   > Edytuj </button>
                      </a>
                    </td>
                  </tr>
                  </c:forEach>

                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->









        <a href="<c:url value = "/addperson"/>" class="btn btn-info btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-info-circle"></i>
                    </span>
          <span class="text">Dodaj nowego</span>
        </a>


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
