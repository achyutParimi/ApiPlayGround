package com.apiplayground.apirepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apiplayground.model.PropertyInfo;
import com.apiplayground.model.RealEstateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class ApiRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public  void addRealEstateDataFromRapid(List<RealEstateRecord> realEstateRecordList){
        String sql =
                "insert into property_info (street_num, street, property_type, zip_code, state, last_sales_date, last_sales_amount, max_sales_amount, total_records)\n" +
                        "\t     values(:STREET_NUMBER, :STREET, :PROPERTY_TYPE, :ZIPCODE, :STATE, :lastSalesDate, :lastSalesAmount, :maxSalesAmount, :TotalRecords)\n";
/*
        for (RealEstateRecord record : realEstateRecordList) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("STREET_NUMBER", record.get_id().getSTREET_NUMBER());
            paramMap.put("STREET", record.get_id().getSTREET());
            paramMap.put("PROPERTY_TYPE", record.get_id().getPROPERTY_TYPE());
            paramMap.put("ZIPCODE",
                    Integer.valueOf(record.get_id().getZIPCODE()));
            paramMap.put("STATE", record.get_id().getSTATE());
            paramMap.put("lastSalesDate", record.getLastSalesDate());
            paramMap.put("lastSalesAmount", record.getLastSalesAmount());
            paramMap.put("maxSalesAmount", record.getMaxSalesAmount());
            paramMap.put("TotalRecords", record.getTotalRecords());

            namedParameterJdbcTemplate.update(sql, paramMap);
        }
*/
        //List<Map<String, Object>> batchParameters = new ArrayList<>();
        List<MapSqlParameterSource> parameterSources = new ArrayList<MapSqlParameterSource>();

        // Populate batchParameters list with parameter maps
        for (RealEstateRecord record : realEstateRecordList) {
            MapSqlParameterSource paramMap = new MapSqlParameterSource();
            paramMap.addValue("STREET_NUMBER", record.get_id().getSTREET_NUMBER());
            paramMap.addValue("STREET", record.get_id().getSTREET());
            paramMap.addValue("PROPERTY_TYPE", record.get_id().getPROPERTY_TYPE());
            paramMap.addValue("ZIPCODE", Integer.valueOf(record.get_id().getZIPCODE()));
            paramMap.addValue("STATE", record.get_id().getSTATE());
            paramMap.addValue("lastSalesDate", record.getLastSalesDate());
            paramMap.addValue("lastSalesAmount", record.getLastSalesAmount());
            paramMap.addValue("maxSalesAmount", record.getMaxSalesAmount());
            paramMap.addValue("TotalRecords", record.getTotalRecords());

            parameterSources.add(paramMap);
        }

        //int[] updateCounts = jdbcTemplate.batchUpdate(sql, batchParameters.toArray(new batchParameters.size()));
        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources.toArray(new MapSqlParameterSource[parameterSources.size()]));

    }

    public List<PropertyInfo> getRealEstateRecords(){
        String sql =
                "SELECT * from property_info";

        RowMapper<PropertyInfo> rm = new RowMapper<PropertyInfo>() {
            @Override
            public PropertyInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new PropertyInfo(
                        rs.getString("street_num"),
                        rs.getString("street"),
                        rs.getString("property_type"),
                        rs.getInt("zip_code"),
                        rs.getString("state"),
                        rs.getDate("last_sales_date"),
                        rs.getFloat("last_sales_amount"),
                        rs.getFloat("max_sales_amount"),
                        rs.getInt("total_records"),
                        rs.getInt("real_estate_id"),
                        rs.getDate("last_modified_date")
                );
            }
        };

        List<PropertyInfo> result = jdbcTemplate.query(sql,rm);
        return result;
    }
}
