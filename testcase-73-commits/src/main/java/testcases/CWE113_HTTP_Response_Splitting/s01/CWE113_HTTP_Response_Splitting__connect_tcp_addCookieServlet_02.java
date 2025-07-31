package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__connect_tcp_addCookieServlet_02 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (true)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    socket = new Socket("host.example.org", 39544);
                    /* read input from socket */
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
                    // Cleanup code omitted for brevity
                }
            }
        }
        if (true)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8"));
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
        data = "foo"; // Good source: hardcoded string
        if (true)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                response.addCookie(cookieSink); // Potential flaw: unverified input
            }
        }
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        data = "foo"; // Good source: hardcoded string
        if (true)
        {
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                response.addCookie(cookieSink); // Potential flaw: unverified input
            }
        }
    }

    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implement goodB2G1 method
    }

    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Implement goodB2G2 method
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}