/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_addCookieServlet_08.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 08 Control flow: if(privateReturnsTrue()) and if(privateReturnsFalse())
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

import java.util.logging.Level;

public class CWE113_HTTP_Response_Splitting__File_addCookieServlet_08 extends AbstractTestCaseServlet
{
    private boolean privateReturnsTrue()
    {
        return true;
    }

    private boolean privateReturnsFalse()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = "";
        if (privateReturnsTrue())
        {
            File file = new File("C:\\data.txt");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                data = reader.readLine(); // POTENTIAL FLAW: Read data from a file
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
        }

        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // POTENTIAL FLAW: Input not verified before inclusion in the cookie
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if (privateReturnsTrue())
        {
            data = "foo"; // FIX: Use a hardcoded string
        }
        else
        {
            data = null; // Ensure data is initialized
        }

        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // Potentially safe since data is known
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}