package Jdbc;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Cloneable,Comparable<UserDTO>,Serializable{
	private int uid,flag;
	private String uname,upass;
	public final int getUid() {
		return uid;
	}
	public final void setUid(int uid) {
		this.uid = uid;
	}
	public final int getFlag() {
		return flag;
	}
	public final void setFlag(int flag) {
		this.flag = flag;
	}
	public final String getUname() {
		return uname;
	}
	public final void setUname(String uname) {
		this.uname = uname;
	}
	public final String getUpass() {
		return upass;
	}
	public final void setUpass(String upass) {
		this.upass = upass;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return this.uname.compareTo(o.uname);
	}
	private UserDTO() {
		// TODO Auto-generated constructor stub
	}
	private static UserDTO userDTO;
	synchronized public static UserDTO createInstance() {
		if(userDTO==null) {
			userDTO=new UserDTO();
			return userDTO;
		}
		else {
			return userDTO.createClone();
		}
	}
	synchronized public static UserDTO createInstanceWithParams(int uid,String uname,String upass,int flag) {
		if(userDTO==null) {
			userDTO=new UserDTO();
		}
		else {
			userDTO=userDTO.createClone();
		}
		userDTO.setUid(uid);userDTO.setUname(uname);userDTO.setUpass(upass);userDTO.setFlag(flag);
		return userDTO;
	}
	synchronized public  UserDTO createClone() {
		try {
			return (UserDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(flag, uid, uname, upass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return flag == other.flag && uid == other.uid && Objects.equals(uname, other.uname)
				&& Objects.equals(upass, other.upass);
	}
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", flag=" + flag + ", uname=" + uname + ", upass=" + upass + "]";
	}
	
}