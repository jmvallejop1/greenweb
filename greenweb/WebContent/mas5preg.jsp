<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
import="com.greenweb.pregunta.*,java.util.List,com.greenweb.pregunta.data.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			$.post('mas5preg.jsp', {
				num: 1
			}, function(responseText) {
				$('.container').html(responseText);
			});
		});
	});
	</script>
<script>
var cambio;
	$(document).ready(function(){
    	$(".bot").click(function(){
    		var array = []
    		$("input[type=checkbox]:checked").each(function(){
    			array.push($(this).val())
    		});
    		alert(array);
        	var id = $(this).parent().parent().parent().parent().attr("id");
        	cambio = $(this).parent().parent().parent().parent().parent();
        	$.ajax({
                type: "POST",
                url: 'Contestar',
                data: ({ idc: id , resp: array }),
                success: function(data) {
                    comprobar(data);    
                },
                error: function() {
                    alert('Error occured 23');
                }
            });
        	
   	 });
	});
</script>

<script>
	function comprobar(valor){
		if(valor == -1){
			$(cambio).addClass("incorrecta");
			window.alert("-1");
		}else if(valor == 0){
			window.alert("0");
		}else if(valor>0){
			window.alert(">0");
		}
	}
</script>
</head>
<body>
	<%
	
	session = request.getSession(false);
	int hasta = 0;
	if(session!=null) {
		 hasta =  (int)session.getAttribute("hasta");
	}
	hasta+=2;
	//int tipo = Integer.parseInt(request.getParameter("num"));
		PreguntasManager man=new PreguntasManager();
		List<PreguntaDO> result=man.obtenerTodasPreguntas();
		if(result.size()<10){
			hasta  = result.size();
		}
		
		for(int i = 0;i<hasta;i++){ %>
		<div>
		  <div id="<%out.println(result.get(i).getId());%>"> 
			<div class="PreguntaAdicional">
			    <form>
			      <h3><%out.println(result.get(i).getPreg());%></h3>
			      <i class="fas fa-info-circle"></i>
			      <div class="respuestas">
			        <ul>
			          <li><input type="checkbox" name="resp" value="1" />
			          <label><%out.println(result.get(i).getR1());%></label></li>
			          <li><input type="checkbox" name="resp" value="2" />
			          <label><%out.println(result.get(i).getR2());%></label></li>
			          <li><input type="checkbox" name="resp" value="3" />
			          <label><%out.println(result.get(i).getR3());%></label></li>
			          <li><input type="checkbox" name="resp" value="4" />
			          <label><%out.println(result.get(i).getR4());%></label></li>
			        </ul>
			        <input type="button" class="bot" name="contestar" value="Contestar!">
			        </div>
		   	 </form>
		  	</div>
		  </div>
		  </div>
		  <%} session.setAttribute("hasta",hasta);%>

	  	</table>	
</body>
</html>