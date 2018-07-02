package org.uc.exercise.tvd.managedbean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.uc.exercise.tvd.constantes.Constantes;
import org.uc.exercise.tvd.service.UserService;
import org.uc.exercise.tvd.service.impl.UserServiceImpl;
import org.uc.exercise.tvd.vo.UserVO;

@ManagedBean(name = "userView")
@ViewScoped
public class UserView implements View {
	private String nombre;
	private String paterno;
	private String materno;
	private String username;
	private String password;
	private String rol;
	private String email;
	private byte[] foto;
	private String kr;
	private String mr;
	private String qr;
	private String pr;
	private String ar;
	private Boolean config;
	
	@PostConstruct
	void initialiseSession() {
		FacesContext context = FacesContext.getCurrentInstance();		
		context.getExternalContext().getSession(true);   
		
        String cc = (String)context.getExternalContext().getSessionMap().get(Constantes.CONF);
        if(cc != null && cc.equals("admin")){        	
        	config = Boolean.TRUE;
        }else {
        	config = Boolean.FALSE;
        }
	    
	}
	
	/**
	 * @return the qr
	 */
	public String getQr() {
		return qr;
	}

	/**
	 * @param qr the qr to set
	 */
	public void setQr(String qr) {
		this.qr = qr;
	}

	@PostConstruct
    public void init() {	
		dispatcher();    	 	
    }
	
	private void dispatcher(){
		this.setQr(Constantes.LBL1);
		this.setPr(Constantes.LBL2);
		this.setAr(Constantes.LBL3);
		this.setKr(Constantes.LBL4);
		this.setMr(Constantes.LBL5);		
	}
	
	@SuppressWarnings("unchecked")
	public void handler(FileUploadEvent event) {
		System.out.println("handler");
		StringBuilder msg = new StringBuilder();    	
		String temp = "";
		foto = null;
    	int[] r = null;
        synchronized(this){
        	UploadedFile uploadedFile = event.getFile();
        	try{
        		
        		temp = new String(uploadedFile.getFileName().getBytes("ISO-8859-1"),"UTF-8");
        		System.out.println("handler " + temp);
        		foto = uploadedFile.getContents();    
        		int i = foto == null?0:foto.length;
        		System.out.println("handler " + i);
        	}catch(UnsupportedEncodingException err){
        		err.getStackTrace();
        	}
            
        }       
        
    }
	
    public void save() {
    	UserService serv = new UserServiceImpl();
    	UserVO user = new UserVO();
    	user.setNombre(this.getNombre());
    	user.setPaterno(this.getPaterno());
    	user.setMaterno(this.getMaterno());
    	user.setUsername(this.getUsername());
    	user.setPassword(this.getPassword());
    	user.setRol(this.getRol());
    	user.setEmail(this.getEmail());
    	user.setFoto(foto);
    	
    	int i = foto == null?0:foto.length;
    	System.out.println(user + " " + i );
    	
    	String msg = serv.insert(user);
    	if(msg.contains("personal_data.username")){
    		msg = "Nombre de usuario ya existe!!!";
    		addMessage(msg, FacesMessage.SEVERITY_ERROR);
    	} else {    	
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    	}
    }
     
    public void addMessage(String summary, Severity severidad) {
        FacesMessage message = new FacesMessage(severidad, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void resetFail() {
    	nombre   = null;
    	paterno  = null;
    	materno  = null;
    	username = null;
    	password = null;
    	rol      = null;
    	email    = null;
    	foto     = null;
    }

    public void regresar() {
    	System.out.println("Regresar");
    	String uri = "login.xhtml";
    	try{
    		FacesContext.getCurrentInstance().getExternalContext().redirect(uri);
    	}catch(IOException err){}
    
    }
    
    public void crearBD() {
    	UserService serv = new UserServiceImpl();
    	StringBuilder sb = new StringBuilder().
        append("CREATE TABLE personal_data (").
        append("id_user  INTEGER     PRIMARY KEY AUTOINCREMENT,").
        append("nombre   STRING (30) NOT NULL,").
        append("paterno  STRING (30) NOT NULL,").
        append("materno  STRING (30) NOT NULL,").
        append("username STRING (30) UNIQUE,").
        append("password STRING (30) NOT NULL,").
        append("rol      STRING (50) NOT NULL,").
        append("email    STRING (50) NOT NULL,").
        append("foto     BLOB);");
        		
        System.out.println("Execute... " + sb.toString());
        serv.createTable(sb.toString());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se creó la base de datos de usuario"));
    }
    
    public void borrarBD() {
    	UserService serv = new UserServiceImpl();
    	StringBuilder sb = new StringBuilder().
    	append("DROP TABLE personal_data;");
        
    	System.out.println("Execute... " + sb.toString());
        serv.createTable(sb.toString());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró la base de datos de usuario"));
    }
    
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the paterno
	 */
	public String getPaterno() {
		return paterno;
	}

	/**
	 * @param paterno the paterno to set
	 */
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	/**
	 * @return the materno
	 */
	public String getMaterno() {
		return materno;
	}

	/**
	 * @param materno the materno to set
	 */
	public void setMaterno(String materno) {
		this.materno = materno;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	/**
	 * @return the kr
	 */
	public String getKr() {
		return kr;
	}

	/**
	 * @param kr the kr to set
	 */
	public void setKr(String kr) {
		this.kr = kr;
	}

	/**
	 * @return the mr
	 */
	public String getMr() {
		return mr;
	}

	/**
	 * @param mr the mr to set
	 */
	public void setMr(String mr) {
		this.mr = mr;
	}

	/**
	 * @return the pr
	 */
	public String getPr() {
		return pr;
	}

	/**
	 * @param pr the pr to set
	 */
	public void setPr(String pr) {
		this.pr = pr;
	}

	/**
	 * @return the ar
	 */
	public String getAr() {
		return ar;
	}

	/**
	 * @param ar the ar to set
	 */
	public void setAr(String ar) {
		this.ar = ar;
	}

	public Boolean getConfig() {
		return config;
	}

	public void setConfig(Boolean config) {
		this.config = config;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
     
   
}
