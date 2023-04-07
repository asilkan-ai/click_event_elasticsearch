## Click Event Project

For many companies, customer event data is important. That is why they develop various methods to track this data. They aim to make more sales by obtaining and analyzing the data. <br><br>
This project aims to track customer events through a sample e-commerce site. The structure of this project is given in the image below. <br><br>

![click_event_model](https://user-images.githubusercontent.com/73762823/230680083-c381f78c-9398-4311-8fc4-02928c7afa41.png)


<br>

This project provides end-to-end real-time data streaming and visualization. Clicks made on the e-commerce web page are sent as post requests and are handled by this API. It is produced to Kafka through the API. The data received from Kafka is sent to Elasticsearch and can be easily visualized in Kibana.

<br><br>

![image](https://user-images.githubusercontent.com/73762823/230680727-ba98325c-3608-4de7-877a-f916e1775733.png)

<br><br>

The data generated as a result of the events on the web page can be visualized with a dashboard like the one below. However, since it is not possible to produce such fake data, random data was generated for the dashboard below. In the project, there are two implementations that generate random data and generate only the data of the events on the page. You can use whichever one you want :) <br><br>


![image](https://user-images.githubusercontent.com/73762823/230680906-6efa297b-65d9-45c5-8dae-36852a865350.png)
