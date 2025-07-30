package testcases.CWE113_HTTP_Response_Splitting.s01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__Environment_addCookieServlet_10Test {

    @Test
    void testCWE113_HTTPResponseSplitting() throws Exception {
        String maliciousInput = "en-US%0d%0aSet-Cookie:evil=1";
        System.setProperty("ADD", maliciousInput); // Simulate environment variable
        CWE113_HTTP_Response_Splitting__Environment_addCookieServlet_10 instance = new CWE113_HTTP_Response_Splitting__Environment_addCookieServlet_10();
        HttpServletResponse response = mock(HttpServletResponse.class);

        try {
            instance.bad(null, response);
        } catch (Throwable t) {
            fail("Vulnerability fixed or not triggered: Exception occurred");
        }

        ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);
        verify(response).addCookie(cookieCaptor.capture());
        Cookie added = cookieCaptor.getValue();

        boolean isVulnerable = added.getValue().contains("\r") || 
                             added.getValue().contains("\n") || 
                             added.getValue().contains("%0d%0a");
        assertTrue(isVulnerable, 
            "Vulnerability fixed or input sanitized: CRLF not propagated to cookie value");
    }
}