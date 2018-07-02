package org.uc.exercise.tvd.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uc.exercise.tvd.service.impl.UserServiceImpl;

@WebServlet(name = "ImageProducer", urlPatterns = {"/getImage"})
public class ImageProducer extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4685461302987535179L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Integer _id = 0;
		String  id=request.getParameter("idImage");
        response.setContentType("image/png");

        try{
        	_id = new Integer(id);
        }catch(NumberFormatException err){
        	
        }
        byte[] img = new UserServiceImpl().getImage(_id);
        //ServletContext sc = getServletContext();
        InputStream is = new ByteArrayInputStream(img);

        BufferedImage bi = ImageIO.read(is);
        OutputStream os = response.getOutputStream();
        ImageIO.write(bi, "png", os);
    }
}
