/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__File_setHeaderServlet_15.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: File Read data from file (named c:\data.txt)
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
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__File_setHeaderServlet_15 extends AbstractTestCaseServlet {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = ""; // Initialize data

        // Try to read from a file
        File file = new File("C:\\data.txt");
        FileInputStream streamFileInput = null;
        InputStreamReader readerInputStream = null;
        BufferedReader readerBuffered = null;
        try {
            streamFileInput = new FileInputStream(file);
            readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            data = readerBuffered.readLine(); // Read data from the file
        } catch (IOException exceptIO) {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        } finally {
            // Close resources
            try {
                if (readerBuffered != null) readerBuffered.close();
                if (readerInputStream != null) readerInputStream.close();
                if (streamFileInput != null) streamFileInput.close();
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error closing streams", exceptIO);
            }
        }

        // Set header with potentially unsafe data
        if (data != null) {
            data = URLEncoder.encode(data, "UTF-8"); // Encode data to prevent HTTP Response Splitting
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
    }

    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = "foo"; // Use a hardcoded string
        response.setHeader("Location", "/author.jsp?lang=" + data);
    }

    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = "foo"; // Use a hardcoded string
        response.setHeader("Location", "/author.jsp?lang=" + data);
    }

    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = ""; // Initialize data
        File file = new File("C:\\data.txt");
        FileInputStream streamFileInput = null;
        InputStreamReader readerInputStream = null;
        BufferedReader readerBuffered = null;
        try {
            streamFileInput = new FileInputStream(file);
            readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            data = readerBuffered.readLine(); // Read data from the file
        } catch (IOException exceptIO) {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        } finally {
            try {
                if (readerBuffered != null) readerBuffered.close();
                if (readerInputStream != null) readerInputStream.close();
                if (streamFileInput != null) streamFileInput.close();
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error closing streams", exceptIO);
            }
        }

        // Encode data to prevent HTTP Response Splitting
        if (data != null) {
            data = URLEncoder.encode(data, "UTF-8");
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }
    }

    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String data = ""; // Initialize data
        File file = new File("C:\\data.txt");
        FileInputStream streamFileInput = null;
        InputStreamReader readerInputStream = null;
        BufferedReader readerBuffered = null;
        try {
            streamFileInput = new FileInputStream(file);
            readerInputStream = new InputStreamReader(streamFileInput, "UTF-8");
            readerBuffered = new BufferedReader(readerInputStream);
            data = readerBuffered.readLine(); // Read data from the file
        } catch (IOException exceptIO) {
            IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
        } finally {
            try {
                if (readerBuffered != null) readerBuffered.close();
                if (readerInputStream != null) readerInputStream.close();
                if (streamFileInput != null) streamFileInput.close();
            } catch (IOException exceptIO) {
                IO.logger.log(Level.WARNING, "Error closing streams", exceptIO);
            }
        }

        // Encode data to prevent HTTP Response Splitting
        if (data != null) {
            data = URLEncoder.encode(data, "UTF-8");
            response.setHeader("Location", "/author.jsp?lang=" + data);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        mainFromParent(args);
    }
}