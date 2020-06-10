$(document).ready(function() {

  var apiRoot = 'http://localhost:8080/v1/';
  var datatableRowTemplate = $('[data-datatable-row-template]').children()[0];
  var usersContainer = $('[data-users-container]');



  // init
  getAllUsers();



  function createElement(data) {
    var element = $(datatableRowTemplate).clone();

    element.attr('data-user-id', data.id);
    element.find('[data-firstName-section] [data-firstName-paragraph]').text(data.firstName);
    element.find('[data-firstName-section] [data-firstName-input]').val(data.firstName);

    element.find('[data-lastName-section] [data-lastName-paragraph]').text(data.lastName);
    element.find('[data-lastName-section] [data-lastName-input]').val(data.lastName);

    element.find('[data-login-section] [data-login-paragraph]').text(data.login);
    element.find('[data-login-section] [data-login-input]').val(data.login);

    element.find('[data-email-section] [data-email-paragraph]').text(data.email);
    element.find('[data-email-section] [data-email-input]').val(data.email);

    element.find('[data-password-section] [data-password-paragraph]').text(data.password);
    element.find('[data-password-section] [data-password-input]').val(data.password);

    return element;
  }


  function handleDatatableRender(data) {
    usersContainer.empty();
    data.forEach(function(user) {
      createElement(user).appendTo(usersContainer);
    });
  }

  function getAllUsers() {
    var requestUrl = apiRoot + 'users';

    $.ajax({
      url: requestUrl,
      method: 'GET',
      success: handleDatatableRender
    });
  }


  function deleteUser() {
    var parentEl = $(this).parents('[data-user-id]');
    var userId = parentEl.attr('data-user-id');
    var requestUrl = apiRoot + 'users';

    $.ajax({
      url: requestUrl + '/' + userId,
      method: 'DELETE',
      success: function() {
        parentEl.slideUp(400, function() { parentEl.remove(); });
      }
    })
  }


  function save(event) {
    event.preventDefault();
    var parentEl = $(this).parent().parent();

    var firstName = parentEl.find('[name = firstName]').val();
    var lastName = parentEl.find('[name = lastName]').val();
    var login = parentEl.find('[name = login]').val();
    var email = parentEl.find('[name = email]').val();
    var password = parentEl.find('[name = password]').val();


    var requestUrl = apiRoot + 'users';

    $.ajax({
      url: requestUrl,
      method: 'POST',
      processData: false,
      contentType: "application/json; charset=utf-8",
      dataType: 'json',
      data: JSON.stringify({

        firstName: firstName,
        lastName: lastName,
        login: login,
        email: email,
        password: password


      }),
      complete: function(data) {
        if(data.status === 200) {
          getAllUsers();
        }
      }
    });
  }

  $('[data-user-add-form]').on('submit', save);
  usersContainer.on('click', '[data-user-delete-button]', deleteUser);


});