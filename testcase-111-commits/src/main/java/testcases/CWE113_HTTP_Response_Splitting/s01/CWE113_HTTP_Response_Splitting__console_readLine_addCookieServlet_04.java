/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_04.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: console_readLine Read data from the console using readLine()
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 04 Control flow: if(PRIVATE_STATIC_FINAL_TRUE) and if(PRIVATE_STATIC_FINAL_FALSE)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__console_readLine_addCookieServlet_04 extends AbstractTestCaseServlet
{
    private static final boolean PRIVATE_STATIC_FINAL_TRUE = true;
    private static final boolean PRIVATE_STATIC_FINAL_FALSE = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // Method to be implemented in future commits
    }

    // Additional method signatures for good cases will go here in future commits
}

public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
{
    String data;
    if (PRIVATE_STATIC_FINAL_TRUE)
    {
        data = ""; // Initialize data
        {
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
        }
    }
    else
    {
        data = null; // Ensure data is initialized
    }

    if (PRIVATE_STATIC_FINAL_TRUE)
    {
        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
            response.addCookie(cookieSink);
        }
    }
}

private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
{
    String data;
    if (PRIVATE_STATIC_FINAL_FALSE)
    {
        data = null; // This block will never execute
    }
    else
    {
        /* FIX: Use a hardcoded string */
        data = "foo";
    }

    if (PRIVATE_STATIC_FINAL_TRUE)
    {
        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
            response.addCookie(cookieSink);
        }
    }
}

private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
{
    String data;
    if (PRIVATE_STATIC_FINAL_TRUE)
    {
        /* FIX: Use a hardcoded string */
        data = "foo";
    }
    else
    {
        data = null; // This block will never execute
    }

    if (PRIVATE_STATIC_FINAL_TRUE)
    {
        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            /* POTENTIAL FLAW: Input not verified before inclusion in the cookie */
            response.addCookie(cookieSink);
        }
    }
}