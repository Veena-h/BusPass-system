<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   errorPage="error.jsp"%>
    <%@page import="com.connection.connection"%>
<%@page import="com.model.bus_model"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style type="text/css">
@media (min-width: 1025px) {
.h-custom {
height: 100vh !important;
}
}
</style>
</head>
<body>
<section class="h-100 h-custom" style="background-color: #8fc4b7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <img src="img/images/slider-bg1.jpg"
            class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
            alt="Sample photo">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration Info</h3>
			
			 <%
        		   
        		   
        		   int id=Integer.parseInt(request.getParameter("id"));
			 try{
                 bus_model b=new bus_model(connection.getconnection());
                 List<route_entity> al=b.routeby_id(id);
                 for(route_entity s:al) {
                	 byte[] imagedata = s.getPic();
                 	String base64Image =imagedata !=null ? Base64.getEncoder().encodeToString(imagedata): " "; 
                 	
        		 %>	              
			
            <form class="px-md-2" action="pass_servlet"  method="post" enctype="multipart/form-data">
				
        		 
        		  	
        		
        		  <div class="row">
        		
        		 		
        		  <div class="container">
        		 <img src="data:image/*;base64, <%=base64Image%>" alt="" class="img-d img-fluid"    style="height: 120px;width:80px">
        		  <input type="hidden" name="base64Image" value="<%= base64Image %>" />
        		 </div>
        		 
                <div class="col-md-6 mb-4 my-2">
					
                  <div class="form-outline datepicker">
                  <input type="hidden" class="form-control" id="id"  value=<%=s.getId() %>  name="id" readonly="readonly">
                    <input type="text" class="form-control" id="exampleDatepicker1"  value=<%=s.getStop_no() %>  name="stop_no" readonly="readonly">
                    <label for="exampleDatepicker1" class="form-label">Stop-No</label>
                    
                    
                  </div>
				
                </div>
                
        		 
              <div class="form-outline mb-4">
                <input type="text" id="form3Example1q" class="form-control"  value=<%=s.getName() %> name="stud_name"  readonly="readonly">
                <label class="form-label" for="form3Example1q">Name</label>
              
              </div>
              
              <div class="form-outline mb-4">
                <input type="text" id="form3Example1q" class="form-control"  value=<%=s.getAddress() %> name="address"  readonly="readonly">
                <label class="form-label" for="form3Example1q">Address</label>
              
              </div>
              
              <div class="form-outline mb-4">
                <input type="text" id="form3Example1q" class="form-control"  value=<%=s.getPhone() %> name="phone"  readonly="readonly">
                <label class="form-label" for="form3Example1q">Phone</label>
              
              </div>

              
                
                
                <!-- <div class="col-md-6 mb-4">

                  <select class="select">
                    <option value="1" disabled>Gender</option>
                    <option value="2">Female</option>
                    <option value="3">Male</option>
                    <option value="4">Other</option>
                  </select>

                </div> -->
              </div>

              

             
              
              
              
              
              <div class="row">
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                     <input type="text" id="textBox" class="form-control" name="uid" readonly="readonly"  required="required"/>
                    <label class="form-label" for="form3Example1w">Unique-Id</label>
                    </div>
                  </div>
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
						<input type="text" id="dateTextBox"  class="form-control" onclick="displayCurrentDate()" name="date" placeholder="Click to display current date" readonly="readonly">
                      <label class="form-label" for="form3Example1n">Current-date</label>
                    </div>
                  </div>
                </div>
                
				
				
				<div class="row">
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <input type="date" id="form3Example1m" class="form-control form-control-lg"  name="s_date" required="required" />
                      <label class="form-label" for="form3Example1m">Start-date</label>
                    </div>
                  </div>
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <input type="date" id="form3Example1n" class="form-control form-control-lg" name="e_date" required="required" />
                      <label class="form-label" for="form3Example1n">End-date</label>
                    </div>
                  </div>
                </div>
                
                
                <div class="row">
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                        <div class="form-outline">
                    <input type="text" id="textBox" class="form-control" value="Pass-assigned" name="status" readonly="readonly"/>
                    
                  </div>
                    </div>
                  </div>
                  
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                    

                <select class="select"  name="select">
                  <option  name="select" value="1" disabled>PassFee-Paid</option>
                  <option  name="select"  value="Half-paid">Half</option>
                  <option  name="select" value="complete-fee">Complete</option>
                  
                </select>

         
                   
                    </div>
                  </div>
                </div>
                
              
              </div>
                
              <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
			
            </form>
			          
              
                <%
				
                 }}catch(Exception e)
             {
                 	e.printStackTrace();
             }
            %>     
                                   
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


<script>
    function displayCurrentDate() {
        var today = new Date();
        var day = String(today.getDate()).padStart(2, '0');
        var month = String(today.getMonth() + 1).padStart(2, '0'); 
        var year = today.getFullYear();
        
        var currentDate = year + '-' + month + '-' + day; 
        
        document.getElementById('dateTextBox').value = currentDate;
    }
</script>


<script type="text/javascript">
document.getElementById("textBox").addEventListener("click", function() {
    // Generate a random number between 1 and 5
    //const randomNumber = Math.floor(Math.random() * 5) + 1;
    const min = 100000;
const max = 999999;
const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
    
    // Update the value of the text box with the random number
    this.value = randomNumber;
});
</script>
</body>
 

</html>