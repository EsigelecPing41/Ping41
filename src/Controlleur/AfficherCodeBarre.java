package Controlleur;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code128;

public class AfficherCodeBarre extends HttpServlet {

	JBarcodeBean bb;
    public static final int LABEL_BOTTOM = 0;
 
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        bb = new JBarcodeBean();
        bb.setCodeType(new Code128());
        bb.setLabelPosition(LABEL_BOTTOM);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
     // Create buffered image that does not support transparency
     
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("image/gif");
        OutputStream out = response.getOutputStream();
        int width = 500;
        int height = 500;
    	bb = (JBarcodeBean)request.getAttribute("codebarre");
    	BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage bi = bb.draw(bimage);
        ImageIO.write(bi,"GIF",out);	
    }
}
