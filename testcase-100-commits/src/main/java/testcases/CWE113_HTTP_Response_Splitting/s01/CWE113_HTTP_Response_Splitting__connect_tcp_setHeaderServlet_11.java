/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_setHeaderServlet_11.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 11 Control flow: if(IO.staticReturnsTrue()) and if(IO.staticReturnsFalse())
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;

public class CWE113_HTTP_Response_Splitting__connect_tcp_setHeaderServlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implementation from previous commit
    }

    /* goodG2B1() - use goodsource and badsink by changing first IO.staticReturnsTrue() to IO.staticReturnsFalse() */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsFalse())
        {
            data = null; // Ensure data is initialized
        }
        else
        {
            data = "foo"; // FIX: Use a hardcoded string
        }

        if (IO.staticReturnsTrue())
        {
            if (data != null)
            {
                response.setHeader("Location", "/author.jsp?lang=" + data); // POTENTIAL FLAW
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        // Add more good implementations later
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}