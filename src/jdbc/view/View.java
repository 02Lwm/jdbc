package jdbc.view;

import java.util.List;
import java.util.Scanner;

import jdbc.action.GoddessAction;
import jdbc.model.Goddess;

public class View {
	
	private static final String CONTEXT="欢迎来到禁区：\n"+
	                                     "下面是禁区的功能表：\n"+
			                             "[MAIN/M]：主菜单\n"+
	                                     "[QUERY/Q]：查看全部女生的信息\n"+
			                             "[GET/G]：查看某位女生的详细信息\n"+
			                             "[ADD/A]：添加女生信息\n"+
			                             "[DELETE/D]：删除女生信息\n"+
			                             "[SEARCH/S]：查询女生信息(根据姓名、手机号来查询)\n"+
                                         "[EXIT/E]：退出女生禁区\n"+
                                         "[BREAK/B]：退出当前功能,返回主菜单\n"+
                                         "[UPDATEGODDESS/U]：修改女生信息\n";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	private static final String OPERATION_UPDATEGODDESS="UPDATEGODDESS";	
	
	private String  name;
	private Integer age;
	
	
	




	public static void main(String[] args) throws Exception {
		
		System.out.println(CONTEXT);
		//怎么保存程序一直运行
		
		Scanner scanner=new Scanner(System.in);
		Goddess goddess=new Goddess();
		GoddessAction action=new GoddessAction();
		//String prenious=null;
		
		boolean flag = true;
		while(flag) {
			String in=scanner.next();
			if(OPERATION_EXIT.equals( in.toUpperCase() ) || OPERATION_EXIT.substring(0, 1).equals( in.toUpperCase() ) ) {
				System.out.println("您已成功退出女生禁区！");
				flag = false;
				break;
			}  
			    //查询女生
				else if(OPERATION_QUERY.equals( in.toUpperCase() ) || OPERATION_QUERY.substring(0, 1).equals( in.toUpperCase() ) ) {
				try{
					List<Goddess> list=action.query();
					for(Goddess goddess2 : list) {
						System.out.println(goddess2.getId()+",姓名："+goddess2.getName()+",年龄："+goddess2.getAge());
					}
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				
			}
				//新增女生
				else if(OPERATION_ADD.equals(in.toUpperCase())  || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase()) ){
				
					System.out.println("请输入女生的 [姓名] ");
					String name = scanner.next();
					goddess.setName(name);
					System.out.println("请输入女生的 [年龄] ");
					int age = scanner.nextInt();
					System.out.println("新增女生成功!");
					goddess.setAge(age);
					action.add(goddess);
				
				}
				
				//返回菜单
				else if(OPERATION_BREAK.equals( in.toUpperCase() ) || OPERATION_BREAK.substring(0, 1).equals( in.toUpperCase() ) ) {
					
					
					System.out.println(CONTEXT);
					continue ;
				}  
			
			    //删除女生
				else if(OPERATION_UPDATEGODDESS.equals( in.toUpperCase() ) || OPERATION_UPDATEGODDESS.substring(0, 1).equals( in.toUpperCase() ) ) {
					
					System.out.println("请输入要删除的女生 [姓名] ");
					String name = scanner.next();
					action.del(name);
					System.out.println("您已成功删除该女生！");
					
				}  
			
			    //修改女生
				else if(OPERATION_UPDATEGODDESS.equals( in.toUpperCase() ) || OPERATION_UPDATEGODDESS.substring(0, 1).equals( in.toUpperCase() ) ) {
					System.out.println("请输入要修改信息的女生 [姓名] ");
					String name = scanner.next();	
				    action.edit(goddess);
					System.out.println("您已成功修改女生！");
				
			}  
				 
			}
			
			
		}
		
}
