package com.apiplayground.rapidapiclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.apiplayground.model.RealEstateRecord;
import com.apiplayground.model.ResponseData;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class RapidApiClient {

    public List<RealEstateRecord> aggregateData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://real-estate-records.p.rapidapi.com/search/zipcode?zipcode=10019&page=1"))
                .header("X-Rapidapi-Key", "28a3d41b57msh6aa13b814f50c0ep181acfjsne6aef7f124a3")
                .header("X-Rapidapi-Host", "real-estate-records.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson = new Gson();
        ResponseData responseData = gson.fromJson(response.body(), ResponseData.class);

        return responseData.getData();

    }

}
