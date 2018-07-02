package org.uc.exercise.tvd.managedbean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.uc.exercise.tvd.service.UserService;
import org.uc.exercise.tvd.service.impl.UserServiceImpl;
import org.uc.exercise.tvd.vo.UserVO;




@ManagedBean(name="loginView", eager=true)
@ViewScoped
public class LoginView implements View {
	
	private String failUser;
	private String failPwd;
	private String usuario;
	private String pwd;
	private String footer;
	private String json_charge;
	private String cveProject;
	private String version;
	
    @PostConstruct
    public void init() {
    	
    	footer = FOOTER;
    	try{
    		footer = new String(FOOTER.getBytes(), "ISO-8859-1");
    	}catch(UnsupportedEncodingException err){}
    	cveProject = "Taller de Visualizacion de Datos";
    	try{
    		cveProject = new String(cveProject.getBytes(), "ISO-8859-1");
    	}catch(UnsupportedEncodingException err){}
    	failUser = "";
    	failPwd  = "";
    	json_charge = JSON_CHARGE;   	
    	setVersion("Proyecto final");
    	FacesContext context = FacesContext.getCurrentInstance();		
    	context.getExternalContext().getSession(true);
    	context.getExternalContext().getSessionMap().remove("config");
    }

    
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("-->" + usuario + " " + pwd, FacesMessage.SEVERITY_INFO);
       
    }
    
    public void buttonAction2() {
    	System.out.println("buttonAction2");
    	
    	UserService serv = new UserServiceImpl();
    	if(usuario.length() > 0 && pwd.length() > 0){
    		
	        UserVO user = null;
	        try{
	        	user = serv.validateUser(usuario, pwd);	
	        }catch(Exception err){
	        	addMessage(err.getMessage(), FacesMessage.SEVERITY_FATAL);
	        }
	        if(user != null){
	        	FacesContext context = FacesContext.getCurrentInstance();
	       
		        context.getExternalContext().getSessionMap().put("usuario", user);
		        
		        try{
		    		FacesContext.getCurrentInstance().getExternalContext().redirect("content.xhtml");
		    	}catch(IOException err){}
	        	
	        } else {
	        	addMessage("Usuario-Password no coincide", FacesMessage.SEVERITY_ERROR);
	        }
        } else if(usuario.length() > 0 && usuario.equals("invitado")){
    		
        	UserVO user = new UserVO();
        	user.setNombre("Invitado");
        	user.setPaterno(new String());
        	user.setMaterno(new String());
        	user.setRol("Visitante");
        	FacesContext context = FacesContext.getCurrentInstance();
 	       
	        context.getExternalContext().getSessionMap().put("usuario", user);
	        
	        try{
		    	FacesContext.getCurrentInstance().getExternalContext().redirect("content.xhtml");
		    }catch(IOException err){}
	        	
	        
        } else {
        	String msg = "";
        	if(usuario.length() == 0){
        		msg = "El usuario es requerido.";
        		failUser = "border-color: crimson;"; //"\u25CF";
        	}
        	if(pwd.length() == 0){
        		msg += " El password es requerido.";
        		failPwd  = "border-color: crimson;"; //"\u25CF";
        	}
        	addMessage(msg, FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public String buttonAction3() {
    	System.out.println("------->" + usuario);
    	if(usuario.equals("admin")){
    		FacesContext context = FacesContext.getCurrentInstance(); 	       
	        context.getExternalContext().getSessionMap().put("config", usuario);
    	}
    	return SUCCESS;
    }
   
    
    public void addMessage(String summary, Severity severidad) {
        FacesMessage message = new FacesMessage(severidad, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @param service the service to set
	 
	public void setService(LoginService service) {
		this.service = service;
	}*/

	/**
	 * @return the failUser
	 */
	public String getFailUser() {
		return failUser;
	}

	/**
	 * @param failUser the failUser to set
	 */
	public void setFailUser(String failUser) {
		this.failUser = failUser;
	}

	/**
	 * @return the failPwd
	 */
	public String getFailPwd() {
		return failPwd;
	}

	/**
	 * @param failPwd the failPwd to set
	 */
	public void setFailPwd(String failPwd) {
		this.failPwd = failPwd;
	}

	/**
	 * @return the footer
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * @param footer the footer to set
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}



	/**
	 * @return the json_charge
	 */
	public String getJson_charge() {
		return json_charge;
	}



	/**
	 * @param json_charge the json_charge to set
	 */
	public void setJson_charge(String json_charge) {
		this.json_charge = json_charge;
	}

	/**
	 * @param ser the ser to set
	 
	public void setSer(BitacoraWebService ser) {
		this.ser = ser;
	}*/

	/**
	 * @return the cveProject
	 */
	public String getCveProject() {
		return cveProject;
	}

	/**
	 * @param cveProject the cveProject to set
	 */
	public void setCveProject(String cveProject) {
		this.cveProject = cveProject;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
}
