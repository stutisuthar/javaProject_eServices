function validateForm() {
    var x = document.forms["login"]["email"].value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  if (x == "" ) {
    alert("Email is one of the essentials");
    return false;
  }

  
if(x.match(mailformat))
{
console.log("hello");
return true;
}
else
{
alert("You have entered an invalid email address!");

console.log("hello");
return false;
}
    
}