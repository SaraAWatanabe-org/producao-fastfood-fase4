package com.challange.order.status.fastfood.service;

import com.challange.order.status.fastfood.config.Exception.StatusException;
import com.challange.order.status.fastfood.model.Lunch;
import com.challange.order.status.fastfood.model.enums.LunchStatus;
import com.challange.order.status.fastfood.repository.LunchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class OrderPrepareService {

    private final LunchRepository lunchRepository;

    @Value("${production.service.url}")
    private String productionServiceUrl;

    private final ObjectMapper objectMapper;

    public Lunch editLunchStatus(Long lunchId, String newStatus) {

        if (newStatus == null ) {
            throw new StatusException("Status cannot be null or empty");
        }

        Lunch lunch = lunchRepository.findById(lunchId).orElse(null);

        if (lunch == null) {
            throw new StatusException("Lunch not found for id: " + lunchId);
        }

        LunchStatus lunchStatus = LunchStatus.fromDescricao(newStatus);
        lunch.setStatus(lunchStatus);

        try {
            Lunch save = lunchRepository.save(lunch);

            if(save != null) {
                httpRequestOrderLunch(lunchId, newStatus);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lunch;
    }

    public Lunch prepareLunch(Lunch lunch) {
        Lunch save = null;
        try {
            save = lunchRepository.save(lunch);

            if(save != null){
                httpRequestOrderLunch(save.getId(), save.getStatus().getDescricao());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return save;

    }

    private void httpRequestOrderLunch(Long lunchId, String newStatus) {
        HttpClient httpClient = HttpClient.newHttpClient();

        String url = String.format("%s/lunch/%s/webhook?status=%s",
                productionServiceUrl,
                lunchId,
                newStatus != null ? newStatus : "undefined");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.noBody())
                .header("Content-Type", "application/json")
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 400) {
                throw new StatusException(String.format("Erro %d ao enviar requisição para o serviço de pedido: %s",
                        response.statusCode(), response.body()));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("Erro ao enviar requisição para a URL: %s", url),e);
        }
    }

}
