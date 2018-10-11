package jdbc.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.jar.Attributes.Name;

import jdbc.*;
import jdbc.model.*;


public class GoddessDao {

	public void addGoddess(Goddess g) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="insert into test" + "(name,age) values(?,?)";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getName());
		ptmt.setInt(2, g.getAge());

		ptmt.execute();
	}
	
	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="update test set age=?,name=? where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, g.getAge());
		ptmt.setString(2, g.getName());
		ptmt.setInt(3, g.getId());
		
		ptmt.execute();
		
	}
	
	public void delGoddess(String name) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="delete from test where name? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
	
		ptmt.setString(1, name);
		ptmt.execute();
		
	}
	 
			
	public List<Goddess> query()throws Exception{
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select id,name,age from test");
		  
        List<Goddess> list=new ArrayList<Goddess>();
        Goddess g;
	    while(rs.next()) {
	    	  g=new Goddess();
	    	  g.setId(rs.getInt("id"));
	    	  g.setName(rs.getString("name"));
	    	  g.setAge(rs.getInt("age"));
	    	  
	    	  list.add(g);
	      }
		return list;
	}
	
	public Goddess get(Integer id) throws SQLException {
		Goddess g=null;
		Connection conn=DBUtil.getConnection();
		String sql=""+"select * from test where id=?";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		
		ResultSet rs=ptmt.executeQuery();
		
		while(rs.next()) {
			g=new Goddess();
			g.setId(rs.getInt("id"));
			g.setName(rs.getString("Name"));
			g.setAge(rs.getInt("age"));
			
		}
		return g;
	}
	
	public Goddess getByAgeAndName(int age,String name ) throws SQLException {
		Goddess g=null;
		Connection conn=DBUtil.getConnection();
		String sql=""+"select * from test where age=? and name=?";
		
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, age);
		ptmt.setString(2, name);
		
		ResultSet rs=ptmt.executeQuery();
		
		while(rs.next()) {
			g=new Goddess();
			g.setId(rs.getInt("id"));
			g.setName(rs.getString("Name"));
			g.setAge(rs.getInt("age"));
			
		}
		return g;
	}
	
	
}
