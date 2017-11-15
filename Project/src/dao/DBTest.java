package dao;



public class DBTest {
	public static void main(String[] args) {
		DB dao = DB.getInstance();
		if( dao != null )
			System.out.println("객체 생성ㅇㅋ");
		
		System.out.println(dao.selectOneBoardByNum(2));
//			System.out.println("selectAll ㅇㅋ");
//		if(dao.isExist(3)==true)
//			System.out.println("흠");
		
	}
}
