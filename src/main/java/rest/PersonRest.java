package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/rest/*")
public class PersonRest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		out.println("Http method       :" + req.getMethod());
		out.println("Path info         :" + req.getPathInfo());
		out.println("ParameterMap      :" + req.getParameterMap());
		out.println("ParameterMap size :" + req.getParameterMap().size());
	    req.getParameterMap()
	       .entrySet()
	       .forEach(
	    		map -> out.println(map.getKey() + ":" + map.getValue()[0])
	    	);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Http method       :" + req.getMethod());
		out.println("Path info         :" + req.getPathInfo());
		out.println("ParameterMap      :" + req.getParameterMap());
		out.println("ParameterMap size :" + req.getParameterMap().size());
		req.getParameterMap()
	       .entrySet()
	       .forEach(
	    		map -> out.println(map.getKey() + ":" + map.getValue()[0])
	       );
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Http method       :" + req.getMethod());
		out.println("Path info         :" + req.getPathInfo());
		out.println("ParameterMap      :" + req.getParameterMap());
		out.println("ParameterMap size :" + req.getParameterMap().size());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("Http method       :" + req.getMethod());
		out.println("Path info         :" + req.getPathInfo());
		out.println("ParameterMap      :" + req.getParameterMap());
		out.println("ParameterMap size :" + req.getParameterMap().size());
	}

}
