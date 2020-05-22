<html>
<head >
    <title>Welcome to E-Services</title>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/signUpForm.css">
    <style><%@include file="/WEB-INF/css/signUpForm.css"%></style>
<%--    <script type="text/javascript" src="js/jquery.js"></script>--%>
<%--    <script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>--%>
<%--    <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>--%>
    <script>
        $(document).on('submit','form#form',function(e){
            e.preventDefault();
            debugger;
            var userData = {};
            userData["name"] = $("#name").val();
            userData["password"] = $("#pass").val();
            userData["email"] = $("#mail").val();
            $.ajax({
                type:'POST',
                url :"postData",
                contentType : "application/json",
                dataType : "json",
                data : JSON.stringify(userData),
                success: function(data) {
                    console.log('success',data);
                },
                error:function(exception){alert('Exeption:'+exception);}
            });

        });
    </script>
</head>
<body>
<%--<form action="" id="form">--%>
<%--    <label >User Name</label>--%>
<%--    <input type="text" name="name" id="name">--%>
<%--    <label>Password</label>--%>
<%--    <input type="password" name="password" id="pass">--%>
<%--    <input type="submit" value="Submit" id="btn1"/>--%>
<%--</form>--%>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1>WELCOME TO E-SERVICES</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form id="form">
                <input class="text" type="text" name="name" id="name" placeholder="Username" required="">
                <input class="text email" type="email" name="email" id="mail" placeholder="Email" required="">
                <input class="text" type="password" name="password" id="pass" placeholder="Password" required="">
                <input class="text w3lpass" type="password" name="password" placeholder="Confirm Password" required="">
                <div class="wthree-text">
                    <label class="anim">
                        <input type="checkbox" class="checkbox" required="">
                        <span>I Agree To The Terms & Conditions</span>
                    </label>
                    <div class="clear"> </div>
                </div>
                <input type="submit" value="SIGNUP">
            </form>
            <p>Already have an Account? <a href="#"> Login Now!</a></p>
        </div>
    </div>
    <ul class="colorlib-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<!-- //main -->
</body>
</html>