<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.connection.connection"%>
<%@page import="com.model.bus_model"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus-System</title>
<link href="css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

   
<form action="route_form_servlet" method="post"  enctype="multipart/form-data">
<section class="h-100 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="img/studentregistration.jpg"
                alt="Sample photo" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Student registration form</h3>
				<%
				  try{
					  
					  String stopno=request.getParameter("stopno");
				      bus_model b=new bus_model(connection.getconnection());
				       List<BusAdd_entity> al=b.showbystopno(stopno);
				       for(BusAdd_entity s:al)
				       {
				      
				   
				   %> 
                <div class="row">
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <input type="text" id="form3Example1m" class="form-control form-control-lg"  name="stop_no" value=<%=s.getStop_no() %> readonly="readonly"/>
                      <label class="form-label" for="form3Example1m">Stop-No</label>
                    </div>
                  </div>
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <input type="text" id="form3Example1n" class="form-control form-control-lg" name="stop_name" value=<%=s.getStop_name() %> readonly="readonly"/>
                      <label class="form-label" for="form3Example1n">Stop-Name</label>
                    </div>
                  </div>
                </div>
				
				<div class="form-outline mb-4">
                  <input type="text" id="form3Example8" class="form-control form-control-lg" name="dname" value=<%=s.getBus_fee() %> readonly="readonly"/>
                  <label class="form-label" for="form3Example8">Driver-Name</label>
                </div>
                <%
				break;
       }}catch(Exception e)
   {
       	e.printStackTrace();
   }
  %>   
				<div class="form-outline mb-4">
                  <input type="text" id="form3Example8" class="form-control form-control-lg" name="name" required="required"/>
                  <label class="form-label" for="form3Example8">Name</label>
                </div>
                

                <div class="form-outline mb-4">
                  <input type="number" id="form3Example8" class="form-control form-control-lg" name="phone" required="required" />
                  <label class="form-label" for="form3Example8">Phone-no</label>
                </div>

                
                

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example9" class="form-control form-control-lg"  name="address" required="required"/>
                  <label class="form-label" for="form3Example9">Address</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example90" class="form-control form-control-lg" name="dept" required="required"/>
                  <label class="form-label" for="form3Example90">Department</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example99" class="form-control form-control-lg"  name="course" required="required"/>
                  <label class="form-label" for="form3Example99">Course</label>
                </div>
                
                 <div class="form-outline mb-4">
                  <input type="file" id="form3Example99" class="form-control form-control-lg"  name="pic" required="required"/>
                  <label class="form-label" for="form3Example99">Identity-Photo</label>
                </div>
                 <div class="form-outline mb-4">
                  <input type="file" id="form3Example99" class="form-control form-control-lg"  name="pic1" required="required"/>
                  <label class="form-label" for="form3Example99">Bus Payment-recipient</label>
                </div>
                

              
                

                <div class="d-flex justify-content-end pt-3">
                
                 <button type="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</form>



</body>
</html>