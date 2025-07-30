package testcases.CWE113_HTTP_Response_Splitting.s01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import javax.servlet.http.*;

public class CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_06Test {

    @Test
    void testCWE113_HTTPResponseSplitting() throws Exception {
        String maliciousInput = "en-US%0d%0aSet-Cookie:evil=1";
        CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_06 instance = new CWE113_HTTP_Response_Splitting__Environment_setHeaderServlet_06();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock the environment variable to return the malicious input
        when(System.getenv("ADD")).thenReturn(maliciousInput);

        try {
            instance.bad(request, response);
        } catch (Throwable t) {
            fail("Vulnerability fixed or not triggered: Exception occurred");
        }

        ArgumentCaptor<String> headerCaptor = ArgumentCaptor.forClass(String.class);
        verify(response).setHeader(headerCaptor.capture(), anyString());
        String headerValue = headerCaptor.getValue();

        boolean isVulnerable = headerValue.contains("\r") || 
                               headerValue.contains("\n") || 
                               headerValue.contains("%0d%0a");
        assertTrue(isVulnerable, 
            "Vulnerability fixed or input sanitized: CRLF not propagated to header value");
    }
}