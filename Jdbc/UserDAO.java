package Jdbc;

import java.sql.Connection;
import java.util.Set;
public interface UserDAO {
	public UserDTO findById(int uid,Connection con)throws Exception;
	public UserDTO findByName(String uname,Connection con)throws Exception;
	public Set<UserDTO> findAll(Connection con)throws Exception;
	
	public void deleteUserById(int uid,Connection con)throws Exception;
	public void deleteUserByName(String uname,Connection con)throws Exception;
	
	public void createUser(UserDTO userDTO,Connection con)throws Exception;
	public void updateUser(UserDTO userDTO,Connection con)throws Exception;
}