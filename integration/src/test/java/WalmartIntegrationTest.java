import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Data;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

//@AutoConfigureMockWebServiceClient
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = WalmartIntegrationTest.class)
class WalmartIntegrationTest {

    private WalmartIntegration integration;
    private static ClientAndServer server;

    @BeforeAll
    static void start() {
        server = startClientAndServer();
    }

    @BeforeEach
    void setUpWeb() {
        var webClient = WebClient.builder()
                .baseUrl(String.format("http://localhost:%d", server.getPort()))
                .build();

        integration = new WalmartIntegration(webClient);
    }

    @AfterAll
    static void afterAll() {
        server.stop();
    }

    @Test
    void findProductsDetails() throws JsonProcessingException {
        var expect = WalmartIntegrationStub.dataExpected();

        var httpRequest = HttpRequest.request()
                .withPath("/products/v3/get-details")
                .withQueryStringParameter("usItemId", "841765146")
                .withMethod("GET");

        var mapper = new ObjectMapper();

        var body = mapper.writeValueAsString(WalmartIntegrationStub.integrationResponse());

        var response = HttpResponse.response(body)
                .withStatusCode(HttpStatus.OK.value())
                .withHeader(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE);

        server.when(httpRequest).respond(response);

        StepVerifier.create(integration.findProductsDetails("841765146"))
                .assertNext((Data data) ->
                        assertEquals(expect, data))
                .verifyComplete();
    }
}