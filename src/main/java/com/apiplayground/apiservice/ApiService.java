package com.apiplayground.apiservice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.apiplayground.apirepository.ApiRepository;
import com.apiplayground.model.PropertyInfo;
import com.apiplayground.model.RealEstateRecord;
import com.apiplayground.model.ResponseData;
import com.apiplayground.rapidapiclient.RapidApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    private ApiRepository apiRepository;

    public List<PropertyInfo> getRealEstateRecords() throws IOException, InterruptedException {
        return apiRepository.getRealEstateRecords();
    }

    public void savetoDB()throws IOException, InterruptedException {
        RapidApiClient test = new RapidApiClient();
        List<RealEstateRecord> realEstateRecordList = test.aggregateData();
        apiRepository.addRealEstateDataFromRapid(realEstateRecordList);
    }
}
