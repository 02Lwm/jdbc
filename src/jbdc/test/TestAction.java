package jbdc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.action.GoddessAction;
import jdbc.model.Goddess;

public class TestAction {

	public static void main(String[] args) throws Exception {
		GoddessAction action=new GoddessAction();
		//*查询
		
		//新增
		Goddess g=new Goddess();
		
		g.setName("小琴");
		g.setAge(18);
		g.setId(9);
		
//		action.add(g);
		
//		action.edit(g);
		
//		action.del(9);
		
		
		List<Goddess> result=action.query();
		
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).getId()+"==="+result.get(i).getName());
		}
		
		

	}
}
