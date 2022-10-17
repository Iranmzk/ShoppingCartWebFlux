import exceptions.ApiNotFoundException;
import lombok.AllArgsConstructor;
import model.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class WalmartIntegration {
    private final WebClient webClientWalmart;

    public Mono<Data> findProductsDetails(String usItemId) {
        return webClientWalmart.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products/v3/get-details?usItemId="
                                .concat(usItemId))
                        .queryParam("usItemId", usItemId)
                        .build())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, (ClientResponse response)
                        -> response.bodyToMono(ApiNotFoundException.class))
                .bodyToMono(Data.class);

    }
}
