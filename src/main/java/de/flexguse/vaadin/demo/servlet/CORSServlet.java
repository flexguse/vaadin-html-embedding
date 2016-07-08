/**
 * 
 */
package de.flexguse.vaadin.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.spring.server.SpringVaadinServlet;

/**
 * Cross Origin Resource Sharing servlet, found in
 * https://vaadin.com/blog/-/blogs/using-cors-with-vaadin.
 * 
 * @author Christoph Guse, christoph.guse@viega.de
 *
 */
public class CORSServlet extends SpringVaadinServlet {

	private static final long serialVersionUID = 140886632177342898L;

	/**
	 * Override to handle the CORS requests.
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Origin is needed for all CORS requests
		String origin = request.getHeader("Origin");

		if (isAllowedRequestOrigin(origin)) {

			// Handle a preflight "option" requests
			if ("options".equalsIgnoreCase(request.getMethod())) {

				response.addHeader("Access-Control-Allow-Origin", origin);
				response.setHeader("Allow", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS");

				// allow the requested method
				String method = request.getHeader("Access-Control-Request-Method");
				response.addHeader("Access-Control-Allow-Methods", method);

				// allow the requested headers
				String headers = request.getHeader("Access-Control-Request-Headers");
				response.addHeader("Access-Control-Allow-Headers", headers);

				response.addHeader("Access-Control-Allow-Credentials", "true");
				response.setContentType("text/plain");
				response.setCharacterEncoding("utf-8");
				response.getWriter().flush();
				return;
			} // Handle UIDL post requests
			else if ("post".equalsIgnoreCase(request.getMethod())) {
				response.addHeader("Access-Control-Allow-Origin", origin);
				response.addHeader("Access-Control-Allow-Credentials", "true");
				super.service(request, response);
				return;
			}
		}

		// All the other requests nothing to do with CORS
		super.service(request, response);

	}

	/**
	 * Check that the page Origin header is allowed.
	 */
	private boolean isAllowedRequestOrigin(String origin) {

		// return origin.matches(".*");
		return true;

	}

}
