package it.uniroma3.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/*" })
public class AuthFilterServlet implements Filter {

	public AuthFilterServlet() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			// check whether session variable is set
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession ses = req.getSession(false);

			String reqURI = req.getRequestURI();

			if (ses != null && ses.getAttribute("username") != null) // L'utente
																		// è
																		// loggato
			{
				if (ses.getAttribute("role").equals("admin")) // L'utente è
																// amministratore
				{
					chain.doFilter(request, response); // Amministratore può
														// accedere ovunque
				} else if (ses.getAttribute("role").equals("paziente")) { // l'utente
																			// è
																			// un
																			// paziente
					if (reqURI.indexOf("/amministrazione/") >= 0) // Paziente
																	// vuole
																	// accedere
																	// ad
																	// amministrazione
					{
						res.sendRedirect(req.getContextPath() + "/index.html"); // Riporta
																				// ad
																				// home
					} else {
						chain.doFilter(request, response);
					}
				}
			} else { // L'utente non è loggato
				if (reqURI.indexOf("/amministrazione/") >= 0) // Guest vuole
																// accedere a
																// amministratore
				{
					res.sendRedirect(req.getContextPath() + "/index.html");
				} else if (reqURI.indexOf("/utente/") >= 0) // Guest vuole
															// accedere a utente
				{
					res.sendRedirect(req.getContextPath() + "/index.html");
				} else {
					chain.doFilter(request, response);
				}
			}

		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
	} // doFilter

	@Override
	public void destroy() {

	}
}