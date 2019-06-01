$(function () {
    'use strict';
    /* Validate commect form */
    $("#comment_form").validate({
        rules: {
            name: {
                required: true
            },
            message: {
                required: true
            },
            email: {
                required: true,
                email: true
            }
        },
        success: "valid",
        submitHandler: function () {
        }
    });

    /* Validate contact form */
    $("#cform").validate({
        rules: {
            name: {
                required: true
            },
            message: {
                required: true
            },
            email: {
                required: true,
                email: true
            }
        },
        success: "valid",
        submitHandler: function() {  // TODO: Rewrite to json "Database" OR Delete validator from project
            $.ajax({
                url: 'mailer/feedback.php',
                type: 'post',
                dataType: 'json',
                data: 'name='
                    + $("#cform").find('input[name="name"]').val()
                    + '&email='
                    + $("#cform").find('input[name="email"]').val()
                    + '&message='
                    + $("#cform").find('textarea[name="message"]').val(),
                beforeSend: function() {

                },
                complete: function() {

                },
                success: function(data) {
                    $('#cform').fadeOut();
                    $('.alert-success').delay(1000).fadeIn();
                }
            });
        }
    });
});