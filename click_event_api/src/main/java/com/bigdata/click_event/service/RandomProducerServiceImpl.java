package com.bigdata.click_event.service;

import com.bigdata.click_event.model.ClickRequest;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Qualifier("random")
public class RandomProducerServiceImpl implements ProducerService {

    @Autowired
    ProducerKafka producerKafka;
    
    Gson gson;
    JSONObject jsonObject;
    List<String> cities;
    List<String> clicks;
    Random random;
    long offset;
    long end;
    
    @PostConstruct
    public void init(){
        gson = new Gson();
        jsonObject = new JSONObject();
        random = new Random();
        cities = Arrays.asList("İstanbul", "Ankara", "İzmir", "Bursa", "Antalya", "Van", "Trabzon",
                "Edirne", "Nevşehir", "Hatay", "Denizli", "Kahramanmaraş", "Samsun");
        clicks = Arrays.asList("Log-in", "Anasayfa", "Siparislerim", "Favorilerim", "Kampanyalar",
                "Sepetim", "IndirimKuponlarim", "Kategoriler", "YeniSezon", "CanliDestek");

        offset = Timestamp.valueOf("2023-04-01 00:00:00").getTime();
        end = Timestamp.valueOf("2023-04-01 23:59:59").getTime();


    }
            
    @Override
    public ClickRequest producer(ClickRequest request) {
        while (true){

            long diff = end - offset + 1;
            Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
            int deviceId = random.nextInt(3000 - 2000) + 2000;

            request.setDeviceId(String.valueOf(deviceId));
            request.setCurrent_ts(rand.toString());
            request.setRegion(cities.get(random.nextInt(cities.size())));
            request.setClick(clicks.get(random.nextInt(clicks.size())));
            String jsonData = gson.toJson(request);
            System.out.println(jsonData);
            producerKafka.send(jsonData);
        }
    }
}
