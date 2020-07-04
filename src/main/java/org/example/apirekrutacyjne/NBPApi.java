package org.example.apirekrutacyjne;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Log4j
public class NBPApi {
    private final static String API_BID_ASK_ENDPOINT = "http://api.nbp.pl/api/exchangerates/rates/C/{currency}/{startDate}/{endDate}/?format-json";

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public void requestBidAskRates(NBPApiParameters parameters) {
        String requestUrl = prepareRequestURL(parameters);
        log.info("Request URL:" + requestUrl);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
               log.info("Response: " + response.body());
            } else
                log.error("Error: " + response.statusCode());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String prepareRequestURL(NBPApiParameters parameters) {
        return API_BID_ASK_ENDPOINT
                .replaceAll("\\{currency\\}", parameters.getCurrency().getShortName())
                .replaceAll("\\{startDate\\}", parameters.getStartDate().toString())
                .replaceAll("\\{endDate\\}", parameters.getEndDate().toString());
    }

}
