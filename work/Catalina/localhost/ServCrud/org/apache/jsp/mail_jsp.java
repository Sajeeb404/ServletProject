/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.88
 * Generated at: 2024-10-22 09:38:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1729564944941L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Send Email</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <h1>Welcome to My Website</h1>\r\n");
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"#home\">Home</a></li>\r\n");
      out.write("            <li><a href=\"#about\">About</a></li>\r\n");
      out.write("             <li><a href=\"file.jsp\">File Upload</a></li>\r\n");
      out.write("\r\n");
      out.write("            <li><a href=\"fileServlet\">File</a></li>\r\n");
      out.write("            <li><a href=\"viewUser\">User</a></li>\r\n");
      out.write("            <li><a href=\"logout\">Logout</a></li>\r\n");
      out.write("            <li><a href=\"pdfServlet\">PDF</a></li>\r\n");
      out.write("            <li><a href=\"#contact\">Contact</a></li>\r\n");
      out.write("            <li><a href=\"mail.jsp\">Mail Me</a></li>\r\n");
      out.write("\r\n");
      out.write("            <li><img src=\"userImage\" alt=\"User Image\" width=\"100\" height=\"100\" />\r\n");
      out.write("</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  body {\r\n");
      out.write("  font-family: Arial, sans-serif;\r\n");
      out.write("  margin: 0;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  line-height: 1.6;\r\n");
      out.write("  background-color: #f4f4f4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("header {\r\n");
      out.write("  background: #35424a;\r\n");
      out.write("  color: #ffffff;\r\n");
      out.write("  padding: 10px 20px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul {\r\n");
      out.write("  list-style: none;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li {\r\n");
      out.write("  display: inline;\r\n");
      out.write("  margin: 0 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li a {\r\n");
      out.write("  color: #ffffff;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul li a:hover {\r\n");
      out.write("  text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("main {\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("section {\r\n");
      out.write("  background: #ffffff;\r\n");
      out.write("  margin: 20px 0;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("  border-radius: 5px;\r\n");
      out.write("  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("footer {\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  padding: 10px 0;\r\n");
      out.write("  background: #35424a;\r\n");
      out.write("  color: #ffffff;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  bottom: 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("    <form action=\"sendEmail\" method=\"post\">\r\n");
      out.write("        To: <input type=\"email\" name=\"to\" required><br>\r\n");
      out.write("        Subject: <input type=\"text\" name=\"subject\" required><br>\r\n");
      out.write("        Body:<br><textarea name=\"body\" required></textarea><br>\r\n");
      out.write("        <input type=\"submit\" value=\"Send Email\">\r\n");
      out.write("    </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
