package com.smarthome.flat.svc.vaadin.menu;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.samples.gpio.ControlGpioExample;
import com.smarthome.flat.svc.controller.ApplicationController;
import com.smarthome.flat.svc.model.Sensors;
import com.smarthome.flat.svc.sensors.SoilHumidity;
import com.smarthome.flat.svc.sensors.TemperatureHumidity;
import com.smarthome.flat.svc.vaadin.menu.utils.ViewUtils;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Jan Pojezdala
 */
@SpringUI(path = "status")
public class TestView extends Composite implements View {

	private static final Logger log = LoggerFactory.getLogger(TestView.class);
	
	private Sensors sensors = new Sensors();

	TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
	
	ControlGpioExample controlGpioExample = new ControlGpioExample();
	
	SoilHumidity soilHumidity = new SoilHumidity();
	
	ViewUtils viewUtils = new ViewUtils();
	
    public TestView(ApplicationController controller) {
        setCompositionRoot(roomLayout(controller));
    }
    
    public VerticalLayout roomLayout(ApplicationController controller){
    	
    	VerticalLayout content = new VerticalLayout();
    	content.setSizeFull();  	
    	
/*    	content.addComponent(new Button("Show measured data!",
			    event -> controller.findAllSensorsData()));*/
    	       	
    	Button allData = new Button("Show AllData!");
    	allData.addClickListener(clickEvent ->
    	    Notification.show(controller.findAllData()));
    	content.addComponent(allData);
    	
    	
    	sensors.setId(11);
    	sensors.setHumidity("999");
    	sensors.setSoil_moisture("989");
    	sensors.setTemperature("59");
    	
    	Button insertData = new Button("Insert example Data!");
    	insertData.addClickListener(clickEvent ->
    	    controller.insertMeasuredData(sensors));
    	content.addComponent(insertData);
    	
    	Button temperature = new Button("Run temperature and humidity sensor!");
    	temperature.addClickListener(clickEvent ->
    		{
				try {
					temperatureHumidity.main();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
    	content.addComponent(temperature);
    	
    	Button gpioTest = new Button("Run gpio LED test!");
    	gpioTest.addClickListener(clickEvent ->
    		{
				try {
					controlGpioExample.main();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
    	content.addComponent(gpioTest);
    	
    	Button soilSensor = new Button("Run soil sensor test!");
    	soilSensor.addClickListener(clickEvent ->
    		{
				try {
					soilHumidity.main();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
    	content.addComponent(soilSensor);
    	
    	Button sentRequest = new Button("CALL jetty endpoint /example  ");
    	sentRequest.addClickListener(clickEvent ->
    		{
				try {
/*					HttpClient httpClient = new HttpClient();
					httpClient.start();
					Request request = httpClient.newRequest("http://http://localhost:8070/example/");
					request.method(HttpMethod.HEAD);
					//request.agent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0");
					ContentResponse response = request.send();
					System.out.println("HEaders :" + response.getHeaders());*/
					
/*					RestTemplate restTemplate = new RestTemplate();
					String fooResourceUrl
					  = "http://192.168.0.109:8070/example/";
					ResponseEntity<String> response
					  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
					//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
				    System.out.println("HEaders :" + response.toString());*/
					
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> response = restTemplate.exchange(
					  "http://localhost:8070/tst",
					  HttpMethod.GET,
					  null,
					  new ParameterizedTypeReference<String>(){});
					System.out.println("Response  :" + response.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
    	content.addComponent(sentRequest);
    	
		return content;   	
    }
    
    
/*    menu.addComponent(new Button("Click save data!",
		    event -> saveData()));
    
    menu.addComponent(new Button("Click select data!",
		    event -> controller.findAllSensorsData()));*/


    
}
