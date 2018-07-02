package org.uc.exercise.tvd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.uc.exercise.tvd.connector.Connector;
import org.uc.exercise.tvd.dao.UserDAO;
import org.uc.exercise.tvd.vo.UserVO;

public class UserDAOImpl implements UserDAO{
	private Connector cn = new Connector();
	
	public boolean tableExist(){
		boolean exists = false;
		Connection con = cn.getConnection();
		StringBuilder sb = new StringBuilder().
		append("select id_user from personal_data");
		System.out.println(sb.toString());
		try{
			PreparedStatement ps = con.prepareStatement(sb.toString());			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				exists = true;
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(SQLException err){
			exists = false;
			System.out.println(err.getMessage());
		}finally{
			con = null;
		}
		return exists;
	}
	
	public UserVO validateUser(String user, String pwd){
		UserVO vo = null;
		Connection con = cn.getConnection();
		StringBuilder sb = new StringBuilder().
				
		append("select id_user,nombre,paterno,materno,username,password,rol,email").
		append("  from personal_data").
		append(" where username=? ").
		append("   and password=?");
		System.out.println(sb.toString());
		try{
			PreparedStatement ps = con.prepareStatement(sb.toString());		
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				vo = new UserVO();
				vo.setIdUser(rs.getInt("id_user"));
				vo.setNombre(rs.getString("nombre"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setUsername(rs.getString("username"));
				vo.setPassword(rs.getString("password"));
				vo.setRol(rs.getString("rol"));
				vo.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(SQLException err){			
			System.out.println(err.getMessage());
		}finally{
			con = null;
		}
		return vo;
	}
	
	public List<UserVO> getUsers(){
		List<UserVO> vos = new ArrayList<UserVO>();
		Connection con = cn.getConnection();
		StringBuilder sb = new StringBuilder().
				
		append("select id_user,nombre,paterno,materno,username,password,rol,email").
		append("  from personal_data");
		System.out.println(sb.toString());
		try{
			PreparedStatement ps = con.prepareStatement(sb.toString());		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				UserVO vo = new UserVO();
				vo.setIdUser(rs.getInt("id_user"));
				vo.setNombre(rs.getString("nombre"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setUsername(rs.getString("username"));
				vo.setPassword(rs.getString("password"));
				vo.setRol(rs.getString("rol"));
				vo.setEmail(rs.getString("email"));
				vos.add(vo);
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(SQLException err){			
			System.out.println(err.getMessage());
		}finally{
			con = null;
		}
		return vos;
	}
	
	public byte[] getImage(Integer id){
		byte[] img = null;
		Connection con = cn.getConnection();
		StringBuilder sb = new StringBuilder().
				
		append("select foto").
		append("  from personal_data").
		append(" where id_user = ?");
		System.out.println(sb.toString());
		try{
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				img = rs.getBytes("foto");
				
			}
			rs.close();
			ps.close();
			con.close();
			
		}catch(SQLException err){			
			System.out.println(err.getMessage());
		}finally{
			con = null;
		}
		return img;
	}
	
	public int createTable(String qry){
		int r = 0;
		Connection con = cn.getConnection();
		
		System.out.println(qry);
		try{
			PreparedStatement ps = con.prepareStatement(qry);
			r = ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(SQLException err){
			System.out.println(err.getMessage());
		}finally{
			con = null;
		}
		return r;
	}
	
	public String insert(UserVO user){
		String msg = "";
		Connection con = cn.getConnection();
		StringBuilder sb = new StringBuilder().
				
		append("INSERT INTO personal_data").
		append("(nombre,paterno,materno,username,password,rol,email,foto) ").
		append("VALUES(?,?,?,?,?,?,?,?)");
		System.out.println(sb.toString());
		try{
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getPaterno());
			ps.setString(3, user.getMaterno());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getRol());
			ps.setString(7, user.getEmail());
			ps.setBytes(8, user.getFoto());
			ps.executeUpdate();
			ps.close();
			con.close();
			msg = "Datos guardados";
		}catch(SQLException err){
			msg = err.getMessage();
		}finally{
			con = null;
		}
		return msg;
	}
}
