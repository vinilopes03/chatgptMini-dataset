/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__database_addCookieServlet_15.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE113_HTTP_Response_Splitting.s01;
import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.net.URLEncoder;

public class CWE113_HTTP_Response_Splitting__database_addCookieServlet_15 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        switch (6)
        {
        case 6:
            data = ""; /* Initialize data */
            // Read data from a database
            {
                Connection connection = null;
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try
                {
                    connection = IO.getDBConnection();
                    preparedStatement = connection.prepareStatement("select name from users where id=0");
                    resultSet = preparedStatement.executeQuery();
                    data = resultSet.getString(1);
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
                }
                finally
                {
                    // Close database objects
                    try { if (resultSet != null) resultSet.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing ResultSet", exceptSql); }
                    try { if (preparedStatement != null) preparedStatement.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql); }
                    try { if (connection != null) connection.close(); } catch (SQLException exceptSql) { IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql); }
                }
            }
            break;
        default:
            data = null; // This will not run
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", data);
                response.addCookie(cookieSink); // Potential flaw
            }
            break;
        default:
            // This will not run
            break;
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        switch (5)
        {
        case 6:
            data = null; // This will not run
            break;
        default:
            data = "foo"; // Hardcoded string
            break;
        }

        switch (7)
        {
        case 7:
            if (data != null)
            {
                Cookie cookieSink = new Cookie("lang", URLEncoder.encode(data, "UTF-8")); // URLEncoded
                response.addCookie(cookieSink); // Safe inclusion
            }
            break;
        default:
            // This will not run
            break;
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}