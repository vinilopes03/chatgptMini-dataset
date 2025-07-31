/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_addCookieServlet_05.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 05 Control flow: if(privateTrue) and if(privateFalse)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__File_addCookieServlet_05 extends AbstractTestCaseServlet
{
    private boolean privateTrue = true;
    private boolean privateFalse = false;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = "";
        if (privateTrue)
        {
            File file = new File("C:\\data.txt");
            try (FileInputStream streamFileInput = new FileInputStream(file);
                 InputStreamReader readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                 BufferedReader readerBuffered = new BufferedReader(readerInputStream)) {
                data = readerBuffered.readLine(); // Read data from a file
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
        }

        if (privateTrue && data != null)
        {
            Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // URL encoding
            response.addCookie(cookieSink); // Add cookie safely
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = "foo"; // Hardcoded string
        if (privateTrue && data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // Add cookie safely
        }
    }

    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = "";
        if (privateTrue)
        {
            File file = new File("C:\\data.txt");
            try (FileInputStream streamFileInput = new FileInputStream(file);
                 InputStreamReader readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
                 BufferedReader readerBuffered = new BufferedReader(readerInputStream)) {
                data = readerBuffered.readLine(); // Read data from a file
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
        }

        if (privateTrue && data != null)
        {
            Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // URL encoding
            response.addCookie(cookieSink); // Add cookie safely
        }
    }

    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}