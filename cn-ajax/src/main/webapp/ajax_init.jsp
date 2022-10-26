<!DOCTYPE html>
<html lang="en">
<head>
<title>SO question 4112686</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
	<button onclick="init();">press here</button>
	<div id="form_signup_text"></div>

<script>
function init(){
	var numero = 5
		$.ajax({
			url : 'ServletAjax',
			type : 'get',
			data: { num:numero},
			cache : false,
			success : sumar,
			error : function() {
				alert('Error');
			}
		});
	};
	function sumar (data){
		var num = parseInt(eval(data))
var num2 = (num+10)
		console.log ("El numero es:" + num2)
	}
</script>
</body>




</html>