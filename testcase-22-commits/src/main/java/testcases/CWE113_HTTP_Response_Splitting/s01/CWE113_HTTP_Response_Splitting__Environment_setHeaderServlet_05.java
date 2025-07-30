/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_05.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: Environment Read data from an environment variable
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_05 extends AbstractTestCaseServlet
{
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateTrue)
        {
            data = System.getenv("ADD"); // POTENTIAL FLAW
        }
        else
        {
            data = null; // This code will never run
        }

        if (privateTrue)
        {
            if (data != null)
            {
                response.setHeader("Location", "/author.jsp?lang=" + data); // POTENTIAL FLAW
            }
        }
    }

    public void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Good source, bad sink implementation to be added
    }

    public void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Good source, bad sink implementation to be added
    }

    public void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Bad source, good sink implementation to be added
    }

    public void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Bad source, good sink implementation to be added
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Combine all good methods
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}