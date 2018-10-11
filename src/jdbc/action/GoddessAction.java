package jdbc.action;

import java.awt.Graphics2D;
import java.sql.SQLException;
import java.util.*;

import jdbc.dao.GoddessDao;
import jdbc.model.Goddess;


public class GoddessAction {
	
   public void add(Goddess goddess) throws Exception {
	   GoddessDao dao=new GoddessDao();
	   dao.addGoddess(goddess);
   }
	
   public void edit(Goddess goddess) throws Exception {
	   GoddessDao dao=new GoddessDao();
	   dao.updateGoddess(goddess); 
   }
   
   public void del(String name) throws SQLException {
	   GoddessDao dao=new GoddessDao();
	   dao.delGoddess(name); 
   }
   
   public List<Goddess> query() throws Exception {
	   GoddessDao dao=new GoddessDao();
	   return dao.query();
   }
   
   public Goddess get(Integer id) throws SQLException {
	   GoddessDao dao=new GoddessDao();
	   return dao.get(id);
   }
   
   public Goddess getByAgeAndName(int age,String name ) throws SQLException {
	   GoddessDao dao=new GoddessDao();
	   Goddess goddess = dao.getByAgeAndName(age,name);
	   return goddess;
   }
   
   
   
   
   
   
   
   
   
/*
   public static void main(String[] args)throws Exception {
	
	   GoddessDao g=new GoddessDao();
	   
	   Goddess g1=new Goddess();

	   g1.setId(12);
	   g1.setAge(16);
	   int id;
	   g.delGoddess(12);
	   
	   g.updateGoddess(g1);
	   
	   
	   List<Goddess> list = g.query();
	   
	   for(int i=0;i<list.size();i++) {
		   Goddess goddess = list.get(i);
		   String name = goddess.getName();
		   System.out.println(name);
	   }
	  // g.addGoddess(g1);
	   System.out.println("=======================");
	   
	   Goddess goddess = g.get(15);
	   String name = goddess.getName();
	   Integer age = goddess.getAge();
	   
	   System.out.println(name+"===="+age);
	   /*
	   List<Goddess> gs=g.query();
	   
	   for (Goddess goddess : gs) {
		   System.out.println(goddess.getName()+","+goddess.getAge());
	   }
	  */
	   
}

