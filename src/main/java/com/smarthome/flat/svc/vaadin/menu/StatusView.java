package com.smarthome.flat.svc.vaadin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.smarthome.flat.svc.controller.ApplicationController;
import com.smarthome.flat.svc.db.DBSupport;
import com.smarthome.flat.svc.model.Sensors;
import com.smarthome.flat.svc.vaadin.menu.utils.ViewUtils;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author Jan Pojezdala
 */
@Controller
@RestController
public class StatusView extends Composite implements View {

	private static final Logger log = LoggerFactory.getLogger(StatusView.class);

/*	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DBSupport dbSupport;

	private DBSupport getDbSupport() {
		if (dbSupport == null) {
			dbSupport = new DBSupport(jdbcTemplate);
			log.debug("TppsApiController:: dbSupport created " + dbSupport);
		}
		return dbSupport;
	}*/
	
	private Sensors sensors = new Sensors();
	
	@Autowired
	private ApplicationController controller = new ApplicationController();
	

	ViewUtils viewUtils = new ViewUtils();
    public StatusView() {
        setCompositionRoot(roomLayout());
    }
    
    public HorizontalLayout roomLayout(){
    	
    	//ApplicationController applicationController = new ApplicationController();
    	
    	// Set the root layout for the UI
    	HorizontalLayout content = new HorizontalLayout();
    	content.setSizeFull();
    	
    	
    	sensors.setId(9);
    	sensors.setHumidity("999");
    	sensors.setSoil_moisture("989");
    	sensors.setTemperature("59");
    	
    	
    	content.addComponent(new Button("Click Me!",
			    event -> controller.insertMeasuredData(sensors)));
    	    	
		return content;   	
    }
	
	

}
