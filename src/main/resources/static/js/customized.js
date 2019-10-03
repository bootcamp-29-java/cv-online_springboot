$(document).ready(function () {
    $('.modal').modal();
    $('.sidenav').sidenav();
    $('select').formSelect();
    $(".datepicker").datepicker({
        format: 'yyyy/mm/dd',
        autoclose: true,
        todayHighlight: true
    });
    $('textarea').characterCounter();
    $('.tooltipped').tooltip();
//    $('#listEmployees').DataTable();
});

$(document).ready(function() {
    var t = $('#listEmployees').DataTable( {
        "columnDefs": [ {
            "searchable": false,
            "orderable": false,
            "targets": 0
        } ],
        "order": [[ 1, 'asc' ]]
    } );
 
    t.on( 'order.dt search.dt', function () {
        t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
} );

//$(document).ready(function () {
//    //call function when page is loaded
//    getContent();
//
//    //set on change listener
//    $('#categorySelector').change(getContent);
//
//    function getContent() {
//
//        //create url to request fragment
//        var url = /staffpage/cv-skill;
//        if ($('#categorySelector').val() === "PL") {
//            url = url + "skillPRG";
//        } else if ($('#categorySelector').val() === "OS") {
//            url = url + "skillPOS";
//        } else if ($('#categorySelector').val() === "AP") {
//            url = url + "SkillAPP";
//        } else if ($('#categorySelector').val() === "DP") {
//            url = url + "skillDEV";
//        }
//
//        //load fragment and replace content
//        $('#replace_div').load(url);
//    }
//})

$('#photo').on('change', function () {
    //get the file name
    var fileName = $(this).val();
    //replace the "Choose a file" label
    $(this).next('.hidden-file-path').html(fileName);
    document.getElementById("hiddenPathPhoto").value = fileName;
    console.log(fleName);
});

$("input.datepicker").keypress(function (e) {
    var chr = String.fromCharCode(e.which);
    if ("1234567890/".indexOf(chr) < 0)
        return false;
});

$(function () {
    $('.skill').hide();
    $('#categorySelector').change(function () {
        if ($('#categorySelector').val() == 'PL') {
            $('.skill').hide();
            $('#skillPRG').show();
        } else if ($('#categorySelector').val() == 'OS') {
            $('.skill').hide();
            $('#skillPOS').show();
        } else if ($('#categorySelector').val() == 'AP') {
            $('.skill').hide();
            $('#skillAPP').show();
        } else if ($('#categorySelector').val() == 'DP') {
            $('.skill').hide();
            $('#skillDEV').show();
        } else {
            $('.skill').hide();
        }
    });
    
    $('.certificates').hide();
    $('#instituteSelector').change(function () {
        if ($('#instituteSelector').val() == '1') {
            $('.certificates').hide();
            $('#certificateOracle').show();
        } else if ($('#instituteSelector').val() == '2') {
            $('.certificates').hide();
            $('#certificateMicrosoft').show();
        } else if ($('#instituteSelector').val() == '3') {
            $('.certificates').hide();
            $('#certificateCisco').show();
        } else {
            $('.certificates').hide();
        }
    });
});

function deleteEducation(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-educationhistory?id=" + id;
        }
    })
}
;

function deleteEmployeeLanguage(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-employeelanguage?id=" + id;
        }
    })
}
;

function deleteEmployeeSkill(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-employeeskill?id=" + id;
        }
    })
}
;

function deleteWorkAssignment(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-workassignment?id=" + id;
        }
    })
}
;

function deleteProject(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-project?id=" + id;
        }
    })
}
;

function deleteCertification(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-certification?id=" + id;
        }
    })
}
;

function deleteTraining(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-training?id=" + id;
        }
    })
}
;

function deleteOrganization(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-organization?id=" + id;
        }
    })
}
;

function deleteExperience(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-experience?id=" + id;
        }
    })
}
;

function deleteAward(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You will delete this from your CV!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            window.location.href = "/delete-award?id=" + id;
        }
    })
}
;