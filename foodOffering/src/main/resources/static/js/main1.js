$(document).ready(function () {

    $("#ngo-form").submit(function (event) {


        //stop submit the form, we will post it manually.
        event.preventDefault();

        register();

    });

});

function register() {

    var user = {}

	
    user["type"] = $("input[name='type]:checked").val();
    
    user["name"] = $("#name").val();
    user["address"] = $("#address").val();
    user["owner"] = $("#owner").val();
    user["mobile"] = $("#contact").val();
    user["email"] = $("#email").val();

    $("#submit").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/res_register",
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#response').html(json);

            console.log("SUCCESS : ", data);
            $("#submit").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#response').html(json);

            console.log("ERROR : ", e);
            $("#submit").prop("disabled", false);

        }
    });

}
