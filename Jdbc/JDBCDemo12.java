package Jdbc;


import java.sql.Connection;
import java.sql.Savepoint;
	
	public class JDBCDemo12 {
		public static void main(String[] args) {
			Savepoint sp=null;
			try {
			UserDAO userDAO=new UserDAOImpl();
			
			Connection con=ConnectionUtility.getConnection();
			
			UserDTO userDTO=userDAO.findById(2, con);
					
			System.out.println(userDTO);
			
			userDTO.setUid(3);
			userDTO.setUname("Thaqi");
			userDTO.setUpass("Thaqi123");
			
			userDAO.createUser(userDTO, con);

			sp=con.setSavepoint();
//			
//			userDTO.setUid(8);
//			userDTO.setUname("navya");
//			int i=1/0;

//			userDAO.createUser(userDTO, con);
			
			
			ConnectionUtility.closeConnection(null, null);
			}catch(Exception e) {
				e.printStackTrace();
				ConnectionUtility.closeConnection(e, sp);
			}
		}
	
}
