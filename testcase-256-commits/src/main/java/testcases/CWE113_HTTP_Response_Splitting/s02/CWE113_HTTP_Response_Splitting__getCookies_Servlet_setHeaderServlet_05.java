/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__getCookies_Servlet_setHeaderServlet_05.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__getCookies_Servlet_setHeaderServlet_05 extends AbstractTestCaseServlet
{
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            data = ""; /* initialize data in case there are no cookies */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue(); // Read data from the first cookie
            }
        }
        else
        {
            data = null;
        }

        if (privateTrue)
        {
            if (data != null)
            {
                response.setHeader("Location", "/author.jsp?lang=" + data); // Potential flaw
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
    }

    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateFalse)
        {
            data = null;
        }
        else
        {
            data = "foo"; // Use a hardcoded string
        }

        if (privateTrue)
        {
            if (data != null)
            {
                response.setHeader("Location", "/author.jsp?lang=" + data); // Still a potential flaw
            }
        }
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            data = "foo"; // Use a hardcoded string
        }
        else
        {
            data = null;
        }

        if (privateTrue)
        {
            if (data != null)
            {
                response.setHeader("Location", "/author.jsp?lang=" + data); // Still a potential flaw
            }
        }
    }

    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (privateTrue)
        {
            data = ""; /* initialize data in case there are no cookies */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue(); // Read data from the first cookie
            }
        }
        else
        {
            data = null;
        }

        if (privateFalse)
        {
            IO.writeLine("Benign, fixed string");
        }
        else
        {
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8"); // Good practice
                response.setHeader("Location", "/author.jsp?lang=" + data); // Safe
            }
        }
    }

    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            data = ""; /* initialize data in case there are no cookies */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue(); // Read data from the first cookie
            }
        }
        else
        {
            data = null;
        }

        if (privateTrue)
        {
            if (data != null)
            {
                data = URLEncoder.encode(data, "UTF-8"); // Good practice
                response.setHeader("Location", "/author.jsp?lang=" + data); // Safe
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}