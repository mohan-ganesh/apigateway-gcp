package com.apigateway.cloudfunctions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;

public class CFHttpFunction implements HttpFunction {

    private static Logger logger = Logger.getLogger(CFHttpFunction.class);

    @Override
    public void service(HttpRequest request, HttpResponse response)
            throws IOException {


        BufferedWriter writer = response.getWriter();
        writer.write("Hello World!");

    }
}