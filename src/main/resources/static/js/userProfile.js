
$(document).ready(function() {

    $(".view-profile-container").show()
    $(".your-orders-container").hide()

    $(".view-profile-btn").click(function() {
        $(".view-profile-container").show()
        $(".your-orders-container").hide()
    })

    $(".your-orders-btn").click(function() {
        $(".view-profile-container").hide()
         $(".your-orders-container").show()
    })

    $(".edit-button-view-profile").click(function() {
        event.preventDefault();
        $(".edit-button-view-profile").hide();
        $(".save-button-view-profile").show();
        $(".close-button-view-profile").show();
        $('.form-control-plaintext').prop('disabled',false);
        $('.disabled-input-field').addClass('form-control')
        $('.disabled-input-field').removeClass('form-control-plaintext')
    })

    $(".save-button-view-profile").click(function() {
        event.preventDefault(); 
        $(".edit-button-view-profile").show();
        $(".save-button-view-profile").hide();
        $(".close-button-view-profile").hide();
        $('.form-control-plaintext').prop('disabled',true);
        $('.disabled-input-field').removeClass('form-control')
        $('.disabled-input-field').addClass('form-control-plaintext')
    })

});