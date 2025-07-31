/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_addCookieServlet_14.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 14 Control flow: if(IO.staticFive==5) and if(IO.staticFive!=5)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__File_addCookieServlet_14 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive == 5)
        {
            data = ""; /* Initialize data */
            {
                File file = new File("C:\\data.txt");
                FileInputStream streamFileInput = null;
                InputStreamReader readerInputStream = null;
                BufferedReader readerBuffered = null;
                try
                {
                    /* read string from file into data */
                    streamFileInput = new FileInputStream(file);
                    readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    data = readerBuffered.readLine(); // POTENTIAL FLAW: Read data from a file
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* Close stream reading objects */
                    try { if (readerBuffered != null) readerBuffered.close(); } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO); }
                    try { if (readerInputStream != null) readerInputStream.close(); } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO); }
                    try { if (streamFileInput != null) streamFileInput.close(); } catch (IOException exceptIO) { IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO); }
                }
            }
        }
        else
        {
            data = null; // Ensure data is initialized
        }

        if (IO.staticFive == 5 && data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // POTENTIAL FLAW: Input not verified before inclusion in the cookie
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive == 5)
        {
            data = "foo"; // FIX: Use a hardcoded string
        }
        else
        {
            data = null; // Ensure data is initialized
        }

        if (IO.staticFive == 5 && data != null)
        {
            Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // FIX: URL encode the data
            response.addCookie(cookieSink); // Safe to add now
        }
    }

    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive != 5)
        {
            data = null; // Will not run but ensures data is initialized before the Sink
        }
        else
        {
            data = "foo"; // FIX: Use a hardcoded string
        }

        if (IO.staticFive == 5 && data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // Still a potential flaw, but a safe value is used
        }
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (IO.staticFive == 5)
        {
            data = "foo"; // FIX: Use a hardcoded string
        }
        else
        {
            data = null; // Ensure data is initialized
        }

        if (IO.staticFive == 5 && data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // Still a potential flaw, but a safe value is used
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}