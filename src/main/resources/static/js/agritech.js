$(document).ready(function() {

    $(".submit_search").bind("click", function() {
        submitSearch($(this).attr('data-id'));
    });

     var objDiv = $("#messageContainer");
     objDiv.scrollTop = objDiv.scrollHeight;
});

function loadCodedValues() {
    $.ajax({
        type : "Get",
        contentType : "application/json",
        url : "getAttributeData?attributeSetName=${item.codedValueSetId}",
        success : function(data) {
            let str = data.substring(1, data.length - 1);
            let str_array = str.split(',');
            for (let i = 0; i < str_array.length; i++) {
                str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
                $('#${item.name}').append('<option>' + str_array[i] + '</option>');
            }
        },
        error : function(data) {
            alert('error');
        }
    });
}

function submitSearch(id) {
    var form = document.createElement("form");
    var element1 = document.createElement("input"); 
    var element2 = document.createElement("input");
    var element3 = document.createElement("input");

    form.method = "GET";
    form.action = "searchResultsGrid";

    element1.value=$('#state').val();
    element1.name="state";
    form.appendChild(element1);

    element2.value=$('#pincode').val();
    element2.name="pincode";
    form.appendChild(element2);
    
    element3.value=id;
    element3.name="specificationId";
    form.appendChild(element3);

    document.body.appendChild(form);
    form.submit();
}

function options() {
    toastr.options = {
        "closeButton" : true,
        "debug" : false,
        "newestOnTop" : false,
        "progressBar" : false,
        "positionClass" : "toast-top-right",
        "preventDuplicates" : true,
        "onclick" : null,
        "showDuration" : "30000",
        "hideDuration" : "100000",
        "timeOut" : "200000",
        "extendedTimeOut" : "500000",
        "showEasing" : "swing",
        "hideEasing" : "linear",
        "showMethod" : "fadeIn",
        "hideMethod" : "fadeOut",
        "closeMethod" : "fadeOut",
        "closeDuration" : "10",
    }
}

function showMessage(type, msg, title) {
    options();
    if (type === 'error') {
        toastr.error(msg, title);
    } else if (type === 'info') {
        toastr.info(msg, title);
    } else if (type === 'success') {
        toastr.success(msg, title);
    } else {
        toastr.warning(msg, title);
    }
}