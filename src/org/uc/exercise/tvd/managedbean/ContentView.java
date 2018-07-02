package org.uc.exercise.tvd.managedbean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.uc.exercise.tvd.constantes.Constantes;
import org.uc.exercise.tvd.service.impl.UserServiceImpl;
import org.uc.exercise.tvd.vo.UserVO;


@ManagedBean(name="contentView", eager=true)
@ViewScoped
public class ContentView implements View {
	
	private UserVO user;
	private List<UserVO> users;
	private StreamedContent imagen;
	private Boolean ga;
	private Boolean gb;
	private Boolean gc;
	private Boolean gd;
	private Boolean grpe;
	private Boolean gf;
	private Boolean gg;
	private Boolean gh;
	
	private Boolean hh;
	private Boolean pp;
	
	private String message;
	
    @PostConstruct
    public void init() {
    
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	hh = Boolean.FALSE;
    	pp = Boolean.FALSE;
    	
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().getSession(true);   
        user = (UserVO)context.getExternalContext().getSessionMap().get("usuario");
        message = Constantes.WELCOME;
        
        if(user != null){
        	message = message.replace("$1", user.getNombre() + " " + user.getPaterno() + " " +
                    user.getMaterno()); 

        	if(user.getRol().contains("Arquitecto")){
        		users = new UserServiceImpl().getUsers();
        		System.out.println("------------->" + users.size());
        	}        	
        } else if(user == null){
        	message = message.replace("$1", "desconocido"); 
        	try{
        		FacesContext.getCurrentInstance().getExternalContext().redirect(LGN);
        	}catch(IOException err){}
        }
    	
    }
    
    public void pairs(){
    	pp = Boolean.TRUE;
    	
    	hh = Boolean.FALSE;
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	message = Constantes.CROSS;
    }
    
    public void histo(){
    	hh = Boolean.TRUE;
    	
    	pp = Boolean.FALSE;
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	message = Constantes.HISTO;
    }

    public void grupoa(){
    	ga = Boolean.TRUE;
    	
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOA;
    }
    
    public void grupob(){
    	gb = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOB;
    }
    
    public void grupoc(){
    	gc = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOC;
    }
    
    public void grupod(){
    	gd = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOD;
    }
    
    public void grupoe(){
    	grpe = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOE;
    }
    
    public void grupof(){
    	gf = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOF;
    }
    
    public void grupog(){
    	gg = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gh = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOG;
    }
    
    public void grupoh(){
    	gh = Boolean.TRUE;
    	
    	ga = Boolean.FALSE;
    	gb = Boolean.FALSE;
    	gc = Boolean.FALSE;
    	gd = Boolean.FALSE;
    	grpe = Boolean.FALSE;
    	gf = Boolean.FALSE;
    	gg = Boolean.FALSE;
    	
    	pp = Boolean.FALSE;
    	hh = Boolean.FALSE;
    	message = Constantes.GRUPOH;
    }
    
    public void close(){
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        try{
    		FacesContext.getCurrentInstance().getExternalContext().redirect(LGN);
    	}catch(IOException err){}
    }
	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
	}

	/**
	 * @return the image
	 */
	public StreamedContent  getImagen() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            if(user != null && user.getFoto() != null){
            	String mimeType = "image/jpg";
            	return new DefaultStreamedContent(new ByteArrayInputStream(user.getFoto()),
            			mimeType,"");
            } else {
            	return new DefaultStreamedContent();
            }
        }
		
	}

	/**
	 * @return the users
	 */
	public List<UserVO> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	/**
	 * @return the ga
	 */
	public Boolean getGa() {
		return ga;
	}

	/**
	 * @param ga the ga to set
	 */
	public void setGa(Boolean ga) {
		this.ga = ga;
	}

	/**
	 * @return the gb
	 */
	public Boolean getGb() {
		return gb;
	}

	/**
	 * @param gb the gb to set
	 */
	public void setGb(Boolean gb) {
		this.gb = gb;
	}

	/**
	 * @return the gc
	 */
	public Boolean getGc() {
		return gc;
	}

	/**
	 * @param gc the gc to set
	 */
	public void setGc(Boolean gc) {
		this.gc = gc;
	}

	/**
	 * @return the gd
	 */
	public Boolean getGd() {
		return gd;
	}

	/**
	 * @param gd the gd to set
	 */
	public void setGd(Boolean gd) {
		this.gd = gd;
	}

	

	/**
	 * @return the grpe
	 */
	public Boolean getGrpe() {
		return grpe;
	}

	/**
	 * @param grpe the grpe to set
	 */
	public void setGrpe(Boolean grpe) {
		this.grpe = grpe;
	}

	/**
	 * @return the gf
	 */
	public Boolean getGf() {
		return gf;
	}

	/**
	 * @param gf the gf to set
	 */
	public void setGf(Boolean gf) {
		this.gf = gf;
	}

	/**
	 * @return the gg
	 */
	public Boolean getGg() {
		return gg;
	}

	/**
	 * @param gg the gg to set
	 */
	public void setGg(Boolean gg) {
		this.gg = gg;
	}

	/**
	 * @return the gh
	 */
	public Boolean getGh() {
		return gh;
	}

	/**
	 * @param gh the gh to set
	 */
	public void setGh(Boolean gh) {
		this.gh = gh;
	}

	/**
	 * @return the hh
	 */
	public Boolean getHh() {
		return hh;
	}

	/**
	 * @param hh the hh to set
	 */
	public void setHh(Boolean hh) {
		this.hh = hh;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the pp
	 */
	public Boolean getPp() {
		return pp;
	}

	/**
	 * @param pp the pp to set
	 */
	public void setPp(Boolean pp) {
		this.pp = pp;
	}

	

    
	
	
}
