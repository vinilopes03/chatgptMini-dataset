/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_02.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-02.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_02 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = ""; /* Initialize data */
        InputStreamReader readerInputStream = null;
        BufferedReader readerBuffered = null;
        /* read user input from console with readLine */
        try
        {
            readerInputStream = new InputStreamReader(System.in, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            /* POTENTIAL FLAW: Read data from the console using readLine */
            data = readerBuffered.readLine();
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        }
        finally
        {
            try
            {
                if (readerBuffered != null)
                {
                    readerBuffered.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
            }

            try
            {
                if (readerInputStream != null)
                {
                    readerInputStream.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
            }
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
        // Implementation will go here
    }
}