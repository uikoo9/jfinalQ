package com.uikoo9.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Response工具类
 * 1.将json写到前台
 * 2.生成验证码图片，页面配合
 * 		<script>
			function reload() {
				document.getElementById('theImg').src = 'img?ts=' + new Date().getTime();
			}
		</script>
		<img id="theImg" src="img" onclick="javascript:reload();"/>
 * @author uikoo9
 * @version 0.0.2.20140515
 */
public class QResponseUtil {
	
	/**
	 * 将json写到前台
	 * @param response
	 * @param jsonObject
	 * @throws Exception
	 */
	public static void write(HttpServletResponse response, Object object) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println(object.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 生成验证码图片
	 * @param response
	 * @return 随机的字符
	 */
	public static String img(HttpServletResponse response){
		return createImg(response, 100, 30, Color.DARK_GRAY, Color.YELLOW);
	}
	
	/**
	 * 生成验证码图片
	 * @param response
	 * @param width 	宽
	 * @param height 	高
	 * @return 			随机字符
	 */
	public static String img(HttpServletResponse response, int width, int height){
		return createImg(response, width, height, Color.DARK_GRAY, Color.YELLOW);
	}
	
	/**
	 * 生成验证码图片
	 * @param response
	 * @param width		宽
	 * @param height	高
	 * @param bcolor	背景颜色
	 * @param fcolor	文字颜色
	 * @return			随机字符
	 */
	public static String img(HttpServletResponse response, int width, int height, Color bcolor, Color fcolor){
		return createImg(response, width, height, bcolor, fcolor);
	}
	
	/**
	 * 生成图片
	 * @param response
	 * @param width
	 * @param height
	 * @return
	 */
	private static String createImg(HttpServletResponse response, int width, int height, Color bcolor, Color fcolor){
		try {
			String randomString = getRandomString();

			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bi.createGraphics();
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
			g.setColor(bcolor);
			g.fillRect(0, 0, width, height);
			g.setColor(fcolor);
			g.drawString(randomString, 18, 20);
			for (int i = 0; i < 20; i++) {
				g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
			}
			
			// 转成JPEG格式
			response.setContentType("image/jpeg");
			ServletOutputStream out = response.getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(bi);
			out.flush();
			
			return randomString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private static Random random = new Random();
	private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static String getRandomString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return sb.toString();
	}
	
}
