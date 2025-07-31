/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__connect_tcp_setHeaderServlet_15.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: setHeaderServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to setHeader()
* Flow Variant: 15 Control flow: switch(6) and switch(7)
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

public class CWE113_HTTP_Response_Splitting__connect_tcp_setHeaderServlet_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = ""; /* Initialize data */
        {
            Socket socket = null;
            BufferedReader readerBuffered = null;
            InputStreamReader readerInputStream = null;
            try
            {
                socket = new Socket("host.example.org", 39544);
                readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);
                data = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                try { if (readerBuffered != null) { readerBuffered.close(); } } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO); }
                try { if (readerInputStream != null) { readerInputStream.close(); } } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO); }
                try { if (socket != null) { socket.close(); } } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO); }
            }
        }

        if (data != null)
        {
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }
    }

    /* Use a hardcoded string */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = "foo"; // FIX: Use a hardcoded string
        
        if (data != null)
        {
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}