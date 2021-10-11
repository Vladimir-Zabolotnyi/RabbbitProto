package com.example.demo;

import com.example.demo.protobuf.Proto;
import java.io.Serializable;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
//import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.messaging.converter.ProtobufMessageConverter;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.SerializationUtils;
import sigma.software.leovegas.drugstore.api.protobuf.Proto2;

@Configuration
public class RabbitHandler {

    @Bean
    public Consumer<Proto2.InvoiceDetails> createProductEventHandler()  {
        System.out.print("Consumer was activated.");
        return new Consumer<Proto2.InvoiceDetails>() {

            @Override
            public void accept(Proto2.InvoiceDetails my) {
                System.out.println("Consumer was activated.");
                System.out.println(my);
//                System.out.println(my.toString() + "\n" + my.getPayload());
//
//                byte[] bytes = my.getPayload();
//                Object o = SerializationUtils.deserialize(bytes);
//                Proto.InvoiceDetails p = (Proto.InvoiceDetails)o;
//                System.out.println(p.toString());

            }
        };
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class My implements Serializable {
    String name;
}
