import com.example.integration.model.*;

public class WalmartIntegrationStub {
    static Data dataExpected() {
        return Data.builder()
                .data(DataResponse.builder()
                        .product(Product.builder()
                                .usItemId("841765146")
                                .segment("Electronics")
                                .type("Video Game Console")
                                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense" +
                                        "Controller W/ Pulse Headset Limited Bundle")
                                .priceInfo(PriceInfo.builder()
                                        .currentPrice(CurrentPrice.builder()
                                                .price(769.00)
                                                .currencyUnit("USD")
                                                .build())
                                        .build())
                                .description("Explore uncharted virtual territories and slay dragons with this sleek" +
                                        " Sony PlayStation 5 gaming console. The 825GB SSD allows ultra-fast load times," +
                                        " while 3-D audio output produces crisp acoustics. This Sony  PlayStation 5 gaming console " +
                                        "supports haptic feedback for effortless communication in multiplayer setups," +
                                        " and adaptive triggers allow immersive gameplay.")
                                .build())
                        .build())
                .build();
    }

    static Data integrationResponse() {
        return Data.builder()
                .data(DataResponse.builder()
                        .product(Product.builder()
                                .usItemId("841765146")
                                .segment("Electronics")
                                .type("Video Game Console")
                                .name("PlayStation 5 Digital Edition with PS5 Starlight Blue DualSense" +
                                        "Controller W/ Pulse Headset Limited Bundle")
                                .priceInfo(PriceInfo.builder()
                                        .currentPrice(CurrentPrice.builder()
                                                .price(769.00)
                                                .currencyUnit("USD")
                                                .build())
                                        .build())
                                .description("Explore uncharted virtual territories and slay dragons with this sleek" +
                                        " Sony PlayStation 5 gaming console. The 825GB SSD allows ultra-fast load times," +
                                        " while 3-D audio output produces crisp acoustics. This Sony  PlayStation 5 gaming console " +
                                        "supports haptic feedback for effortless communication in multiplayer setups," +
                                        " and adaptive triggers allow immersive gameplay.")
                                .build())
                        .build())
                .build();
    }
}
