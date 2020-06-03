// $(document).ready(function() {
//     $("#navbar-frame").load("adminNavbar")
// });


// $(document).ready(function() {
//     $("#navbar-user-frame").load("navbar");
// });
$(document).ready(function() {
    $(".edit-profile-container").show()
    $(".your-orders-container").hide()
})


$(document).ready(function() {
    $(".edit-profile-btn").click(function() {
        $(".edit-profile-container").show()
        $(".your-orders-container").hide()
    })
});

$(document).ready(function() {
    $(".your-orders-btn").click(function() {
        $(".edit-profile-container").hide()
         $(".your-orders-container").show()
    })
});