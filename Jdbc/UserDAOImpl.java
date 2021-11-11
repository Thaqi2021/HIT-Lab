package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Set;
import java.util.TreeSet;
public class UserDAOImpl implements UserDAO{
	@Override
	public UserDTO findById(int uid, Connection con)throws Exception {
		Savepoint sp=null;
			PreparedStatement ps=con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				UserDTO userDTO=UserDTO.createInstance();
				userDTO.setUid(rs.getInt(1));
				userDTO.setUname(rs.getString(2));
				userDTO.setUpass(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));				
				return userDTO;
			}
			else {
				return null;
			}			
	}
	@Override
	public UserDTO findByName(String uname, Connection con) throws Exception{
		Savepoint sp=null;
			PreparedStatement ps=con.prepareStatement("select * from users where uname=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				UserDTO userDTO=UserDTO.createInstance();
				userDTO.setUid(rs.getInt(1));
				userDTO.setUname(rs.getString(2));
				userDTO.setUpass(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));				
				return userDTO;
			}
			else {
				return null;
			}			
	}
	@Override
	public Set<UserDTO> findAll(Connection con)throws Exception {
		Savepoint sp=null;
			PreparedStatement ps=con.prepareStatement("select * from users");
			Set<UserDTO> set=new TreeSet<>();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserDTO userDTO=UserDTO.createInstance();
				userDTO.setUid(rs.getInt(1));
				userDTO.setUname(rs.getString(2));
				userDTO.setUpass(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));
				set.add(userDTO);				
			}
			return set;		
	}
	@Override
	public void deleteUserById(int uid, Connection con) throws Exception{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteUserByName(String uname, Connection con)throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createUser(UserDTO userDTO, Connection con) throws Exception{
		Savepoint sp=null;
			PreparedStatement ps=con.prepareStatement("insert into users values (?,?,?,?)");
			ps.setInt(1, userDTO.getUid());
			ps.setString(2, userDTO.getUname());
			ps.setString(3, userDTO.getUpass());
			ps.setInt(4, userDTO.getFlag());
			ps.executeUpdate();					
	}
	@Override
	public void updateUser(UserDTO userDTO, Connection con)throws Exception {
		// TODO Auto-generated method stub
		
	}
}