package com.junitcourse._04_mocking.wireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.junitcourse._04_mocking.BookStore;
import com.junitcourse._04_mocking.dao.BookStoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookStoreTestWithServerMock {
    @Mock
    private BookStoreDao dao;

    @Test
    public void findStore() throws IOException {
        BookStore store = new BookStore(dao);

        // Create server mock to replay the following endpoint: "http://localhost:8090/stores/findStoreForBook/1"

        int port = 8090;
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        String storeName = "Stimazky, Tel-Aviv";

        stubFor(get(urlEqualTo("/stores/findStoreForBook/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(storeName)));

        String shops = store.getShopsWithBooks(1);

        assertThat(shops).isEqualTo(storeName);

        wireMockServer.stop();
    }

}