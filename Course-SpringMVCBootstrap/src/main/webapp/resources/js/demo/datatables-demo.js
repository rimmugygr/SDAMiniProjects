// // Call the dataTables jQuery plugin
// $(document).ready(function() {
//   $('#dataTable').DataTable();
// });
// Call the dataTables jQuery plugin
//
// $(document).ready(function () {
//     $('table.action-panel').each(function (index, object) {
//         $(object).DataTable({
//             dom: 'Bfrtip',
//             "pageLength": 10,
//             buttons: [
//                 'copy', 'csv', 'excel', 'pdf', 'print'
//             ]
//         });
//     });
//
// });

$(document).ready(function () {
    $('table.action-panel').each(function (index, object) {
        $('#dataTablePersons').DataTable({
            dom: 'Bfrtip',
            "pageLength": 10,
            buttons: [
                'copy', 'csv', 'excel', 'pdf', 'print'
            ]
        });
        $('#dataTableTasks').DataTable({
            "searching": false,
            "columnDefs": [
                { "orderable": false, "targets": 0 }
            ],
            "order": [],
            dom: 'Bfrtip',
            "pageLength": 4,
            buttons: []
        });
    });

});