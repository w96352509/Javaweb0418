package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/servlet/*")
public class WatermarkFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 建立自己的 Response 物件
		MyResponse myResp = new MyResponse(res);
		chain.doFilter(req, myResp);
		// 取得回傳的 HTML 原始碼
		String html = myResp.getHTMLSource();
		// html 中將入浮水印
		html = html.replaceAll("<body", "<body background='/JavaWeb-20220418/image/watermark.jpg' ");
		// 將資料重寫回給瀏覽器
		res.getWriter().print(html);
	}
	
}
