package com.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.connection;
import com.entity.BusAdd_entity;
import com.entity.pass_entity;
import com.entity.route_entity;
import com.entity.studentRegistration_rentity;

public class bus_model 
{

	Connection conn;
	public bus_model(Connection conn) 
	{
		super();
		this.conn=conn;
		
	}
	public boolean insert_studentDetails(studentRegistration_rentity f) throws SQLException 
	{
		boolean b=false;
		String sql="insert into stud_registartion (fname,lname,address,phone,gender,dob,dept,course,email) values(?,?,?,?,?,?,?,?,?,)";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setString(1, f.getFirst_name());
		p.setString(2, f.getLast_name());
		p.setString(3, f.getAddress());
		p.setString(4, f.getPhone());
		p.setString(5, f.getGender());
		p.setString(6, f.getDOB());
		p.setString(7, f.getDept());
		p.setString(8, f.getCourse());
		p.setString(9, f.getEmail());
		/*
		 * p.setString(10, f.getPassword());
		 */	
		
		int i=p.executeUpdate();
		if(i==1)
		{
			System.out.println("inserted");
			b=true;
			
		}
		
		
		
			
		return b;

	}
	public String student_login(String email, String password) throws SQLException 
	{
		studentRegistration_rentity r=null;
		String s=null;
		String sql="select * from stud_registartion where email=? and password=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		 
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			r=new studentRegistration_rentity();
			r.setFirst_name(rs.getString("fname"));
			r.setEmail(rs.getString("email"));;
			r.setPassword(rs.getString("password"));
			
			if(email.equals(r.getEmail()) && password.equals(r.getPassword()))
			{
				s=r.getFirst_name();
				break;
				
			}
		}
		
	
      		
		return s;

	}

	
	
	
	public List<studentRegistration_rentity> select() throws SQLException
	{
	     List<studentRegistration_rentity> al=new ArrayList<>();
	     studentRegistration_rentity e=null;
	     String sql="select * from stud_registartion ";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new studentRegistration_rentity(); 
		  e.setId(rs.getInt(1));
		  e.setFirst_name(rs.getString(2));
		  e.setLast_name(rs.getString(3));
		  e.setAddress(rs.getString(4));
		  e.setPhone(rs.getString(5));
		  e.setGender(rs.getString(6));
		  e.setDOB(rs.getString(7));
		  e.setDept(rs.getString(8));
		  e.setCourse(rs.getString(9));
		  e.setEmail(rs.getString(10));
			/*
			 * e.setPassword(rs.getString(11));
			 */		  
          //Display values
         al.add(e);
		  
	  }
	return al;

	
	}
	public boolean insert_busdetails(BusAdd_entity f) throws SQLException 
	{
		boolean b=false;
		String sql="insert into bus_details(stop_no,stop_name,morning_time,evening_time,bus_fee,driver_name) values(?,?,?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);

		p.setString(1, f.getStop_no());
		p.setString(2, f.getStop_name());
		p.setString(3, f.getMorning_time());
		p.setString(4, f.getEvening_time());
		p.setString(5, f.getBus_fee());
		p.setString(6, f.getDriver_name());
		
	
		
		int i=p.executeUpdate();
		if(i==1)
		{
			System.out.println("inserted");
			b=true;
			
		}
		
		
		
			
		return b;
	}

	
	public List<BusAdd_entity> selectBusdetails() throws SQLException
	{
	     List<BusAdd_entity> al=new ArrayList<>();
	     BusAdd_entity e=null;
	     String sql="select * from bus_details";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new BusAdd_entity(); 
		  e.setId(rs.getInt(1));
		  e.setStop_no(rs.getString(2));
		  e.setStop_name(rs.getString(3));
		  e.setDriver_name(rs.getString(4));
		  e.setMorning_time(rs.getString(5));
		  e.setEvening_time(rs.getString(6));
		  e.setBus_fee(rs.getString(7));
		  
		  
          //Display values
         al.add(e);
		  
	  }
	return al;

	
	}
	
	
	public List<BusAdd_entity> showbystopno(String stopno) throws SQLException
	{
		List<BusAdd_entity> al=new ArrayList<>();
		BusAdd_entity e=null;
		String sql = "select * from bus_details where stop_no=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stopno);   
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
				e = new BusAdd_entity(); 
			 
				e.setId(rs.getInt(1));
				 e.setId(rs.getInt(1));
				  e.setStop_no(rs.getString(2));
				  e.setStop_name(rs.getString(3));
				  e.setDriver_name(rs.getString(4));
				  e.setMorning_time(rs.getString(5));
				  e.setEvening_time(rs.getString(6));
				  e.setBus_fee(rs.getString(7));
			
			al.add(e);
		}
		
		return al;
	}
	
	
	public List<BusAdd_entity> showbyid(int id) throws SQLException
	{
		List<BusAdd_entity> al=new ArrayList<>();
		BusAdd_entity e=null;
		String sql = "select * from bus_details where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);   
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
				e = new BusAdd_entity(); 
			 
				e.setId(rs.getInt(1));
				 e.setId(rs.getInt(1));
				  e.setStop_no(rs.getString(2));
				  e.setStop_name(rs.getString(3));
				  e.setDriver_name(rs.getString(4));
				  e.setMorning_time(rs.getString(5));
				  e.setEvening_time(rs.getString(6));
				  e.setBus_fee(rs.getString(7));
			
			al.add(e);
		}
		
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int insert_routedetails(route_entity f,InputStream file,InputStream file1) throws SQLException 
	{
		int b=0;
		
	String sql="insert into stud_route(stop_no,stop_name,driver_name,name,address,phone,dept,course,pic,pic1) values(?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement p=conn.prepareStatement(sql);
	
	p.setString(1, f.getStop_no());
	p.setString(2, f.getStop_name());
	p.setString(3, f.getDriver_name());
	p.setString(4, f.getName());
	p.setString(5, f.getAddress());
	p.setString(6, f.getPhone());
	p.setString(7, f.getDept());
	p.setString(8, f.getCourse());
	if(file!=null)
	{	
		p.setBlob(9,file);
	}
	
	if(file1!=null)
	{
		
		p.setBlob(10, file1);
	}


	
	
	int i=p.executeUpdate();
	
	if(i==1)
	{
		System.out.println("inserted");
		
		
	}
	
	
	
		
	return b;
	}

	
	public List<route_entity> routeform() throws SQLException
	{
	     List<route_entity> al=new ArrayList<>();
	     route_entity e=null;
	     String sql="select * from stud_route";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new route_entity(); 
		  e.setId(rs.getInt(1));
		  e.setStop_no(rs.getString(2));
		  e.setStop_name(rs.getString(3));
		  e.setDriver_name(rs.getString(4));
		  e.setName(rs.getString(5));
		  e.setAddress(rs.getString(6));
		  e.setPhone(rs.getString(7));
		  e.setDept(rs.getString(8));
		  e.setCourse(rs.getString(9));
		    
		  
		  java.sql.Blob blob=rs.getBlob(10);
			 if(blob!=null)
			 {
				 byte[] img=blob.getBytes(1,(int)blob.length());
				 e.setPic(img);
			 }
			 
			 java.sql.Blob blob1=rs.getBlob(11);
			 if(blob1!=null)
			 {
				 byte[] img=blob1.getBytes(1,(int)blob1.length());
				 e.setPic1(img);
			 }
		  
		 
		  
          //Display values
         al.add(e);
		  
	  }
	return al;
	   
		
	}
	
	
	
	public List<route_entity> routeby_id(int id) throws SQLException
	{
	     List<route_entity> al=new ArrayList<>();
	     route_entity e=null;
	     String sql="select * from stud_route where id=?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, id);    
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new route_entity(); 
		  e.setId(rs.getInt(1));
		  e.setStop_no(rs.getString(2));
		  e.setStop_name(rs.getString(3));
		  e.setDriver_name(rs.getString(4));
		  e.setName(rs.getString(5));
		  e.setAddress(rs.getString(6));
		  e.setPhone(rs.getString(7));
		  e.setDept(rs.getString(8));
		  e.setCourse(rs.getString(9));
		    
		  
		  java.sql.Blob blob=rs.getBlob(10);
			 if(blob!=null)
			 {
				 byte[] img=blob.getBytes(1,(int)blob.length());
				 e.setPic(img);
			 }
			 
			 java.sql.Blob blob1=rs.getBlob(11);
			 if(blob1!=null)
			 {
				 byte[] img=blob1.getBytes(1,(int)blob1.length());
				 e.setPic1(img);
			 }
		  
		 
		  
          //Display values
         al.add(e);
		  
	  }
	return al;
	   
		
	}
	
	
	
	
	public boolean insert_pass(pass_entity f,byte[] img) throws SQLException
	{
		boolean b=false;
		
		String sql="insert into pass(stop_no,stud_name,u_id,start_date,end_date,status,select1,date,address,phone,pic) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p=conn.prepareStatement(sql);
		
		p.setString(1, f.getStop_no());
		p.setString(2, f.getStud_name());
		p.setString(3, f.getU_id());
		p.setString(4, f.getStart_date());
		p.setString(5, f.getEnd_date());
		p.setString(6, f.getStatus());
		
		p.setString(7, f.getSelect());
		p.setString(8, f.getDate());
		p.setString(9, f.getAddress());
		p.setString(10, f.getPhone());
		
		p.setBytes(11, img);
		
		int i=p.executeUpdate();
		
		if(i>0)
		{
			System.out.println("inserted");
			b=true;
			
		}
		
		
		
			
		return b;
	}

	public List<pass_entity> pass_response() throws SQLException
	{
	     List<pass_entity> al=new ArrayList<>();
	     pass_entity e=null;
	     String sql="select * from pass";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new pass_entity(); 
		  e.setId(rs.getInt(1));
		  e.setStop_no(rs.getString(2));
		  e.setStud_name(rs.getString(3));
		  e.setU_id(rs.getString(4));
		  e.setStart_date(rs.getString(5));
		  e.setEnd_date(rs.getString(6));
		  e.setStatus(rs.getString(7));
		  e.setSelect(rs.getString(8));
		  e.setDate(rs.getString(9));
		  e.setAddress(rs.getString(10));
		  e.setPhone(rs.getString(11));
		  e.setPic(rs.getBytes(12));
		 
		  
		 
		  
          //Display values
         al.add(e);
		  
	  }
	return al;
	   
		
	}
	public boolean delet_pass(int id) throws SQLException 
	{
		boolean b=false;
		String sql="delete from pass where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		int i=ps.executeUpdate();
		if(i==1)
		{
			System.out.println("deleted");
			b=true;
		}
		return b;

	}
	
	
	
	
	public List<pass_entity> pass_id(int id) throws SQLException
	{
	     List<pass_entity> al=new ArrayList<>();
	     pass_entity e=null;
	     String sql="select * from pass where id=?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, id);    
	  
	  ResultSet rs=stmt.executeQuery();
	  
	  while(rs.next())
	  {
		  e = new pass_entity(); 
		  e.setId(rs.getInt(1));
		  e.setStop_no(rs.getString(2));
		  e.setStud_name(rs.getString(3));
		  e.setU_id(rs.getString(4));
		  e.setStart_date(rs.getString(5));
		  e.setEnd_date(rs.getString(6));
		  e.setStatus(rs.getString(7));
		  e.setSelect(rs.getString(8));
		  e.setDate(rs.getString(9));
		  e.setAddress(rs.getString(10));
		  e.setPhone(rs.getString(11));
		  e.setPic(rs.getBytes(12));
		    
		  
		 
		 
		  
          //Display values
         al.add(e);
		  
	  }
	return al;
	   
		
	}
	public boolean delete_busdetails(int id) throws SQLException 
	{
		boolean b=false;
		
		String sql="delete from bus_details where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
	
		int i=ps.executeUpdate();
		if(i==1)
		{
			System.out.println("deleted successfully");
			b=true;
		}
		return b;
	}
	public boolean update_busdetails(BusAdd_entity f) throws SQLException 
	{
		boolean b=false;
		String sql="update bus_details set stop_no=? , stop_name=? , morning_time=?,evening_time=?,bus_fee=? ,driver_name=? where id=?";
		PreparedStatement p=conn.prepareStatement(sql);
//		ResultSet rs=p.executeQuery();
		p.setString(1, f.getStop_no());  
		p.setString(2, f.getStop_name());
		
		p.setString(3, f.getMorning_time());
		p.setString(4, f.getEvening_time());
		p.setString(5, f.getBus_fee());
		p.setString(6, f.getDriver_name());
		p.setInt(7, f.getId());
		
		int i=p.executeUpdate();
		if(i==1)
		{
			System.out.println("updated");
			b=true;
			
		}
		
		
		
			
		return b;

	}
	
	
	
	
	
	
	
}
