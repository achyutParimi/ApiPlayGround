package com.apiplayground.model;

import java.util.Date;

//Creating POJO using Java 17 version, until earlier versions we use to use class, from Java17 onwards we use record
public record PropertyInfo(

        String street_num,
        String street,
        String property_type,
        int zip_code,
        String state,
        Date last_sales_date,

        float last_sales_amount,
        float max_sales_amount,
        int total_records,
        int real_estate_id,
        Date last_modified_date

        ) {
        @Override
        public String street_num() {
                return street_num;
        }

        @Override
        public String street() {
                return street;
        }

        @Override
        public String property_type() {
                return property_type;
        }

        @Override
        public int zip_code() {
                return zip_code;
        }

        @Override
        public String state() {
                return state;
        }

        @Override
        public Date last_sales_date() {
                return last_sales_date;
        }

        @Override
        public float last_sales_amount() {
                return last_sales_amount;
        }

        @Override
        public float max_sales_amount() {
                return max_sales_amount;
        }

        @Override
        public int total_records() {
                return total_records;
        }

        @Override
        public int real_estate_id() {
                return real_estate_id;
        }

        @Override
        public Date last_modified_date() {
                return last_modified_date;
        }
}
