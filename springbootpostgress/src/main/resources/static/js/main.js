$(document).ready(function () {

    $("#register-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        register();

    });

});

function register() {

    var user = {}
    user["firstName"] = $("#firstName").val();
    user["lastName"] = $("#lastName").val();

    $("#register").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/register",
        data: JSON.stringify(user),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#response').html(json);

            console.log("SUCCESS : ", data);
            $("#register").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#response').html(json);

            console.log("ERROR : ", e);
            $("#register").prop("disabled", false);

        }
    });

}