package com.example.demo;

import com.example.demo.protobuf.Proto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.integration.leader.Context;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

@RestController
@RequestMapping("/")
public class TestResource {

    ServerResponse.Context context;

    @Autowired
    StreamBridge stream;

    @GetMapping("/push")
    public void pushMessage(){
//        List<HttpMessageConverter<?>> httpMessageConverters = context.messageConverters();
//        System.out.println(httpMessageConverters);
//        httpMessageConverters.forEach(System.out::println);

        Proto.InvoiceDetails test = Proto.InvoiceDetails.newBuilder().addName("test").build();
        stream.send("createProductEventPublisher-out-0", test, MimeType.valueOf("application/x-protobuf"));
    }
}
