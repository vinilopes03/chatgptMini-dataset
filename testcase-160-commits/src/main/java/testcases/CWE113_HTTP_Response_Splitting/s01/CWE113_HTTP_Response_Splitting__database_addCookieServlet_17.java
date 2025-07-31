/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__database_addCookieServlet_17.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 113 HTTP Response Splitting
* BadSource: database Read data from a database
* GoodSource: A hardcoded string
* Sinks: addCookieServlet
*    GoodSink: URLEncode input
*    BadSink : querystring to addCookie()
* Flow Variant: 17 Control flow: for loops
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

public class CWE113_HTTP_Response_Splitting__database_addCookieServlet_17 extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = ""; // Initialize data

        // Read data from a database
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            connection = IO.getDBConnection();
            preparedStatement = connection.prepareStatement("select name from users where id=0");
            resultSet = preparedStatement.executeQuery();
            data = resultSet.getString(1); // POTENTIAL FLAW: Read data from a database query resultset
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
        }
        finally
        {
            // Close database objects
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        if (data != null)
        {
            Cookie cookieSink = new Cookie("lang", data);
            response.addCookie(cookieSink); // POTENTIAL FLAW: Input not verified before inclusion in the cookie
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        // To be implemented
    }
}