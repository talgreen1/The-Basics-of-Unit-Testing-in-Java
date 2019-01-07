package com.junitcourse._05_mocking.wireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.junitcourse._05_mocking.BookStore;
import com.junitcourse._05_mocking.dao.BookStoreDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class _02_BookStoreTestWithServerMock {
    @Mock
    private BookStoreDao dao;

    @Test
    public void findStore() throws IOException {
        BookStore store = new BookStore(dao);

        // Create server mock to replay the following endpoint: "http://localhost:8090/stores/findStoreForBook/1"
        String store1 = "Stimazky, Tel-Aviv";
        String store2 = "Tsomet Sfarim, Haifa";
        String storeNames = store1 + ";" + store2;


        int port = 8090;
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        //Create stub for the find stores api. This tells the mock server how to response for the request
        stubFor(get(urlEqualTo("/stores/findStoreForBook/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(storeNames)));

        // execute the 'getShopsWithBooks' method - it will use the mock server
        String[] shops = store.getShopsWithBooks(1);

        //Verify that the store executed get request to the mock server
        verify(getRequestedFor(urlEqualTo("/stores/findStoreForBook/1")));

        //Verify that the return value from the 'getShopsWithBooks' contains the correct values
        assertThat(shops).contains(store1, store2);

        wireMockServer.stop();
    }

}