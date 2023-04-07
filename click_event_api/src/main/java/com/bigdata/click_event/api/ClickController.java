package com.bigdata.click_event.api;

import com.bigdata.click_event.model.ClickRequest;
import com.bigdata.click_event.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class ClickController {
    @Autowired
    @Qualifier("click")
    ProducerService producerService;
    @PostMapping("/click")
    public ClickRequest clickEvent(@RequestBody ClickRequest request){
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        request.setCurrent_ts(timestamp.toString());
        return producerService.producer(request);

    }
}
