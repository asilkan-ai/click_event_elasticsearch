package com.bigdata.click_event.service;

import com.bigdata.click_event.model.ClickRequest;

public interface ProducerService {

    ClickRequest producer(ClickRequest request);
}
