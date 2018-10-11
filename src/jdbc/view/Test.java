package jdbc.view;

import java.sql.SQLException;

import jdbc.action.GoddessAction;
import jdbc.model.Goddess;

public class Test {

	
	public static void main(String[] args) throws Exception {
		GoddessAction action=new GoddessAction();
		Goddess byAgeAndName = action.getByAgeAndName(16, "п║од");
		System.out.println(byAgeAndName.toString());
	}
	
}
