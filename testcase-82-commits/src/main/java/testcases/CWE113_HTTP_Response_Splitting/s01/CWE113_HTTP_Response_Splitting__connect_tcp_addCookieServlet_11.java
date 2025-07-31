/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_11.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-11.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
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
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_11 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    socket = new Socket("host.example.org", 39544);
                    readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    data = readerBuffered.readLine(); // POTENTIAL FLAW
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Clean up resources */
                    try { if (readerBuffered != null) readerBuffered.close(); } catch (IOException e) { /* ignored */ }
                    try { if (readerInputStream != null) readerInputStream.close(); } catch (IOException e) { /* ignored */ }
                    try { if (socket != null) socket.close(); } catch (IOException e) { /* ignored */ }
                }
            }
        }
        else
        {
            data = null; // Incidental: CWE 561 Dead Code
        }

        if(IO.staticReturnsTrue())
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // FIX: Use URLEncoder.encode
                response.addCookie(cookieSink);
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
        if (IO.staticReturnsFalse())
        {
            data = null; // Incidental: CWE 561 Dead Code
        }
        else
        {
            data = "foo"; // FIX: Use a hardcoded string
        }

        if (IO.staticReturnsTrue())
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data); // Potential flaw
                response.addCookie(cookieSink);
            }
        }
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        if (IO.staticReturnsTrue())
        {
            data = "foo"; // FIX: Use a hardcoded string
        }
        else
        {
            data = null; // Incidental: CWE 561 Dead Code
        }

        if (IO.staticReturnsTrue())
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data); // Potential flaw
                response.addCookie(cookieSink);
            }
        }
    }

    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    socket = new Socket("host.example.org", 39544);
                    readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    data = readerBuffered.readLine(); // POTENTIAL FLAW
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Clean up resources */
                    try { if (readerBuffered != null) readerBuffered.close(); } catch (IOException e) { /* ignored */ }
                    try { if (readerInputStream != null) readerInputStream.close(); } catch (IOException e) { /* ignored */ }
                    try { if (socket != null) socket.close(); } catch (IOException e) { /* ignored */ }
                }
            }
        }
        else
        {
            data = null; // Incidental: CWE 561 Dead Code
        }

        if (IO.staticReturnsFalse())
        {
            /* INCIDENTAL: CWE 561 Dead Code */
            IO.writeLine("Benign, fixed string");
        }
        else
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // FIX: Use URLEncoder.encode
                response.addCookie(cookieSink);
            }
        }
    }

    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticReturnsTrue())
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    socket = new Socket("host.example.org", 39544);
                    readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    data = readerBuffered.readLine(); // POTENTIAL FLAW
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Clean up resources */
                    try { if (readerBuffered != null) readerBuffered.close(); } catch (IOException e) { /* ignored */ }
                    try { if (readerInputStream != null) readerInputStream.close(); } catch (IOException e) { /* ignored */ }
                    try { if (socket != null) socket.close(); } catch (IOException e) { /* ignored */ }
                }
            }
        }
        else
        {
            data = null; // Incidental: CWE 561 Dead Code
        }

        if (IO.staticReturnsTrue())
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // FIX: Use URLEncoder.encode
                response.addCookie(cookieSink);
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}