package jdbc.view;

import java.util.List;
import java.util.Scanner;

import jdbc.action.GoddessAction;
import jdbc.model.Goddess;

public class View {
	
	private static final String CONTEXT="��ӭ����������\n"+
	                                     "�����ǽ����Ĺ��ܱ�\n"+
			                             "[MAIN/M]�����˵�\n"+
	                                     "[QUERY/Q]���鿴ȫ��Ů������Ϣ\n"+
			                             "[GET/G]���鿴ĳλŮ������ϸ��Ϣ\n"+
			                             "[ADD/A]�����Ů����Ϣ\n"+
			                             "[DELETE/D]��ɾ��Ů����Ϣ\n"+
			                             "[SEARCH/S]����ѯŮ����Ϣ(�����������ֻ�������ѯ)\n"+
                                         "[EXIT/E]���˳�Ů������\n"+
                                         "[BREAK/B]���˳���ǰ����,�������˵�\n"+
                                         "[UPDATEGODDESS/U]���޸�Ů����Ϣ\n";
	
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
		//��ô�������һֱ����
		
		Scanner scanner=new Scanner(System.in);
		Goddess goddess=new Goddess();
		GoddessAction action=new GoddessAction();
		//String prenious=null;
		
		boolean flag = true;
		while(flag) {
			String in=scanner.next();
			if(OPERATION_EXIT.equals( in.toUpperCase() ) || OPERATION_EXIT.substring(0, 1).equals( in.toUpperCase() ) ) {
				System.out.println("���ѳɹ��˳�Ů��������");
				flag = false;
				break;
			}  
			    //��ѯŮ��
				else if(OPERATION_QUERY.equals( in.toUpperCase() ) || OPERATION_QUERY.substring(0, 1).equals( in.toUpperCase() ) ) {
				try{
					List<Goddess> list=action.query();
					for(Goddess goddess2 : list) {
						System.out.println(goddess2.getId()+",������"+goddess2.getName()+",���䣺"+goddess2.getAge());
					}
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				
			}
				//����Ů��
				else if(OPERATION_ADD.equals(in.toUpperCase())  || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase()) ){
				
					System.out.println("������Ů���� [����] ");
					String name = scanner.next();
					goddess.setName(name);
					System.out.println("������Ů���� [����] ");
					int age = scanner.nextInt();
					System.out.println("����Ů���ɹ�!");
					goddess.setAge(age);
					action.add(goddess);
				
				}
				
				//���ز˵�
				else if(OPERATION_BREAK.equals( in.toUpperCase() ) || OPERATION_BREAK.substring(0, 1).equals( in.toUpperCase() ) ) {
					
					
					System.out.println(CONTEXT);
					continue ;
				}  
			
			    //ɾ��Ů��
				else if(OPERATION_UPDATEGODDESS.equals( in.toUpperCase() ) || OPERATION_UPDATEGODDESS.substring(0, 1).equals( in.toUpperCase() ) ) {
					
					System.out.println("������Ҫɾ����Ů�� [����] ");
					String name = scanner.next();
					action.del(name);
					System.out.println("���ѳɹ�ɾ����Ů����");
					
				}  
			
			    //�޸�Ů��
				else if(OPERATION_UPDATEGODDESS.equals( in.toUpperCase() ) || OPERATION_UPDATEGODDESS.substring(0, 1).equals( in.toUpperCase() ) ) {
					System.out.println("������Ҫ�޸���Ϣ��Ů�� [����] ");
					String name = scanner.next();	
				    action.edit(goddess);
					System.out.println("���ѳɹ��޸�Ů����");
				
			}  
				 
			}
			
			
		}
		
}
