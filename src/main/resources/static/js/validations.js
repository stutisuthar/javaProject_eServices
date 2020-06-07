function validateLoginForm() {
  validateEmail("login", "email", "asdas");
  validatePassword("login", "password", "asfas");
}


function validateEmail(formDOMName, inputDOMName) {

  var email = document.forms[formDOMName][inputDOMName];
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  if (email.value == "") {
    event.preventDefault();
    if(email.classList.contains('is-valid')) {
      email.classList.remove('is-valid');
    }
    email.classList.add('is-invalid');
    feedback = document.getElementById('invalid-email');
    feedback.innerHTML = "Please provide an email"   
  }
  
  if(email.value.match(mailformat)) {
    
    if(email.classList.contains('is-invalid')) {
      email.classList.remove('is-invalid');
    }
    email.classList.add('is-valid');
    feedback = document.getElementById('valid-email');
    feedback.innerHTML = "Legit" 
  }
}

function validatePassword(formDOMName, inputDOMName) {
  
  var password = document.forms[formDOMName][inputDOMName];
  if (password.value == "") {
    event.preventDefault();
    if(password.classList.contains('is-valid')) {
      password.classList.remove('is-valid');
    }
    password.classList.add('is-invalid');
    feedback = document.getElementById('invalid-password');
    feedback.innerHTML = "Please provide a password"
    return false;
  }

  else {
    if(password.classList.contains('is-invalid')) {
      password.classList.remove('is-invalid');
    }
    password.classList.add('is-valid');
    feedback = document.getElementById('invalid-password');
    feedback.innerHTML = "Please provide a password"
  }

}

//verify

function verifyEmail(formDOMName, inputDOMName) {

  var email = document.forms[formDOMName][inputDOMName];
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  if (email.value == "") {
    event.preventDefault();
    email.classList.add('is-invalid');
    feedback = document.getElementById('invalid-email');
    feedback.innerHTML = "Please provide an email"   
  }  
}