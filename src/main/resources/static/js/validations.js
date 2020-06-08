function validateLoginForm() {
  validateEmail("login", "email");
  validatePassword("login", "password");
}

function validateRegistrationForm() {
  validateEmail("registration", "email");
  validatePassword("registration", "password");
  validateName("registration","name")
}

function validateUpdatedUserForm() {
  // validateEmail("update-profile", "email");
  // validatePassword("update-profile", "password");
  // validateName("update-profile","name")
}


function validateEmail(formDOMName, inputDOMName) {

  var email = document.forms[formDOMName][inputDOMName];
  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

  email.classList.remove('is-valid');
  email.classList.remove('is-invalid');
  
  if(email.value.match(mailformat)) {

    email.classList.add('is-valid');
    feedback = document.getElementById('valid-email');
    feedback.innerHTML = "Legit" 
  }

  else{
    event.preventDefault();
    email.classList.add('is-invalid');
    feedback = document.getElementById('invalid-email');
    feedback.innerHTML = "Please provide an email"   
  }
}

function validatePassword(formDOMName, inputDOMName) {
  
  var password = document.forms[formDOMName][inputDOMName];
  password.classList.remove('is-valid');
  password.classList.remove('is-invalid');
  
  if (password.value == "") {
    event.preventDefault();
    password.classList.add('is-invalid');
    feedback = document.getElementById('invalid-password');
    feedback.innerHTML = "Please provide a password"
    return false;
  }

  else {
    password.classList.add('is-valid');
    feedback = document.getElementById('valid-password');
    feedback.innerHTML = "Legit"
  }

}

function validateName(formDOMName, inputDOMName) {

  var name = document.forms[formDOMName][inputDOMName];

  name.classList.remove('is-valid');
  name.classList.remove('is-invalid');
  
  if (name.value == "") {
    event.preventDefault();
    name.classList.add('is-invalid');
    feedback = document.getElementById('invalid-name');
    feedback.innerHTML = "Please provide a name"
    return false;
  }

  else {
    name.classList.add('is-valid');
    feedback = document.getElementById('valid-name');
    feedback.innerHTML = "Legit"
  }

}


//verify

function verifyEmailAndPassword(formDOMName, inputEmailDOMName, inputPasswordDOMName) {
  var email = document.forms[formDOMName][inputEmailDOMName].value.trim();
  var password = document.forms[formDOMName][inputPasswordDOMName].value.trim();

  console.log(email,password);

}
