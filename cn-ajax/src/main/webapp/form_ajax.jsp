<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
//this is the id of the form
$(document).ready(function () {
  $("form").submit(function (event) {
    var formData = {
      name: $("#name").val(),
      surname: $("#apellido").val(),
      dni: $("#dni").val(),
      email: $("#email").val(),
    };
    console.log(formData)

    $.ajax({
      type: "POST",
      url: "POC_Form_Ajax",
      data: formData,
      dataType: "json",
      encode: true,
    }).done(function (data) {
      alert(data)
    });

    event.preventDefault();
  });
});
</script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="form" method="post" action="POC_Form_Ajax">
<input type="text" id="name" />
<input type="text" id="apellido" />
<input type="text" id="dni" />
<input type="text" id="email" />
<button type="submit">Pulsa aqui</button>
</form>
</body>
</html>