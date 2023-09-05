package com.employees.test.repositories;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;



@Repository
public class ReadRepository {
    
    @Value("${api.url.employees}")
    private String apiUrlAllEmployees;

    @Value("${api.url.employee}")
    private String apiUrlEmployee;

    public StringBuilder getEmployeesApi() throws IOException {
        URL url = new URL(apiUrlAllEmployees);
        return getApiResponse(url);
    }

    public StringBuilder getEmployeeApi(int idEmployee) throws IOException {
        URL url = new URL(apiUrlEmployee + idEmployee);
                System.out.println(url);
                System.out.println(url);
                System.out.println(url);
                System.out.println(url);
                System.out.println(url);
                System.out.println(url);

        System.out.println(apiUrlAllEmployees);
        System.out.println(idEmployee);
        return getApiResponse(url);
    }

    private StringBuilder getApiResponse(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
    
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response;
        }
    }

}
