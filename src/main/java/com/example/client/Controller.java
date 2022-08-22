package com.example.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.*;

@RestController
public class Controller {



    @RequestMapping("/resttest")
    public String testRest() throws URISyntaxException {
        ExecutorService service=Executors.newSingleThreadExecutor();
        final Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                HttpEntity<?> httpEntity = new HttpEntity<Object>("Prashanth");
                RestTemplate restTemplate=new RestTemplate();
                URI uri = new URI("http://localhost:8090/api/rest");
                String future =restTemplate.postForObject(uri,httpEntity, String.class);
                return "";
            }
        });
        try {
            submit.get(0, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("************************");
        }


        return "helo";
    }

}
