/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookies_Servlet_addCookieServlet_16.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 16 Control flow: while(true)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getCookies_Servlet_addCookieServlet_16 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        data = ""; /* initialize data in case there are no cookies */

        // Read data from cookies
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null && cookieSources.length > 0)
        {
            /* POTENTIAL FLAW: Read data from the first cookie value */
            data = cookieSources[0].getValue();
        }

        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
            response.addCookie(cookieSink);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        // Use a hardcoded string
        data = "foo";

        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            /* Input is safe as it is hardcoded */
            response.addCookie(cookieSink);
        }
    }
}