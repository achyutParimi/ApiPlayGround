package com.apiplayground.apicontroller;

import com.apiplayground.apiservice.ApiService;
import com.apiplayground.model.PropertyInfo;
import com.apiplayground.model.RealEstateRecord;
import com.apiplayground.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class APIController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/v1/realEstateRecordsRapid")
    public List<PropertyInfo> getRealEstateRecords() throws IOException, InterruptedException {

        return apiService.getRealEstateRecords();

    }
    @PostMapping(path="/v1/saveRecords")
    public void savetoDB() throws IOException, InterruptedException {

        apiService.savetoDB();
        System.out.println("POST CALL: saveRecords");

    }

}
