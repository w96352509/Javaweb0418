package captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 自動產出 0000 ~ 9999 之間的認證碼(含干擾圖像)
// 並將該碼放到 session 屬性中以便比對

@WebServlet("/captcha/authcodeimage")
public class AuthCodeImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 產生驗證碼 04d 位數不夠補0
		String authCode = String.format("%04d", new Random().nextInt(10000));
		System.out.println("authCode:"+authCode);
	    
		// 將驗證碼保留在 session 中以便後驗證
		req.getSession().setAttribute("authCode", authCode);
        
		// 產生驗證碼圖片
		try {             // 畫                       型態   二進回傳
			ImageIO.write(getAuthCodeImage(authCode),"JPEG",resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	   // 產生驗證碼圖片方法
	   // awt 視窗文件 -> BufferedImage 在記憶體中繪圖
	   private BufferedImage getAuthCodeImage(String authCode) {
		   // 建立圖像暫存區                      寬  高   印刷Type
		   BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
	       // 建立畫布
		   Graphics g = img.getGraphics();
		   // 設定顏色
		   g.setColor(Color.yellow);
		   // 塗滿畫布背景(x,y,x,y) 左上(x,y)右下(x,y)
		   g.fillRect(0, 0, 80, 30);
		   // 設定顏色
		   g.setColor(Color.black);
		   // 設定字型(字體 , 字樣 , 尺寸)
		   g.setFont(new Font("新細明體", Font.PLAIN, 30));
           // 繪文字(呈現字,x,y)
		   g.drawString(authCode,10,23);
		   return img;
	   }
	
}
