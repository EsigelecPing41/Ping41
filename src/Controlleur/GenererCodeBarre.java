package Controlleur;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.jbarcodebean.model.Code128;
import jbarcodebean.*;
/**
 * Servlet implementation class GenererCodeBarre
 */
@WebServlet("/GenererCodeBarre")
public class GenererCodeBarre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JBarcodeBean bb;
	public static final int LABEL_BOTTOM = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenererCodeBarre() {
    	
        super();
        System.out.println("on passe la");
        bb = new JBarcodeBean();
        bb.setCodeType(new Code128());
        bb.setLabelPosition(LABEL_BOTTOM);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("image/gif");
	        OutputStream out = resp.getOutputStream();
	 
	        bb.setCode("76200");
	      
	         int width = 100;
	         int height = 100;
	 
	         // Create buffered image that does not support transparency
	         BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	 
	        BufferedImage bi = bb.draw(bimage);
	        ImageIO.write(bi,"GIF",out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
