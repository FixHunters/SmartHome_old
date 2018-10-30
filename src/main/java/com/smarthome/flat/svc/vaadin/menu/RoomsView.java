package com.smarthome.flat.svc.vaadin.menu;

import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import com.smarthome.flat.svc.vaadin.menu.utils.ViewUtils; 
import com.vaadin.icons.VaadinIcons; 
import com.vaadin.navigator.View; 
import com.vaadin.ui.Alignment; 
import com.vaadin.ui.Component; 
import com.vaadin.ui.Composite; 
import com.vaadin.ui.HorizontalLayout; 
import com.vaadin.ui.*; 
import com.vaadin.ui.Layout; 
import com.vaadin.ui.VerticalLayout; 
import com.vaadin.ui.themes.ValoTheme; 

public class RoomsView extends Composite implements View { 
	public RoomsView() 
	{ 
		connectToDatabase(); 
		setCompositionRoot(roomLayout()); 
	} 
	
	public VerticalLayout roomLayout() 
	{ 
		// Set the root layout for the UI---------------------------------------------------------------- 
		VerticalLayout content = new VerticalLayout(); 
		content.setSizeFull(); 
		//----------------------------------------------------------------------------------------------- 
	
		//Panel------------------------------------------------------------------------------------------ 
		//Title---------------------------------------------------------------------------------- 
		HorizontalLayout titleLayout = new HorizontalLayout(); 
		Label title = new Label("Living Room"); 
		title.addStyleName(ValoTheme.LABEL_H1); 
		titleLayout.addComponent(title); 
		content.addComponent(titleLayout); 
		//Tabulators----------------------------------------------------------------------------- 
		Panel panel = new Panel(); 
		panel.setHeight("500px");	//TODO change hardcode value 
		panel.setWidth("950px");	//TODO change hardcode value 
		content.addComponent(panel); 
		HorizontalLayout tabLayout = new HorizontalLayout(); 
		panel.setContent(tabLayout); 
		TabSheet tabsheet = new TabSheet(); 
		tabsheet.setHeight(panel.getHeight()-50,panel.getHeightUnits()); 
		tabsheet.setWidth(panel.getWidth()-2,panel.getWidthUnits()); 
		tabsheet.addStyleNames(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS, ValoTheme.TABSHEET_FRAMED); 
		tabLayout.addComponent(tabsheet); 
	
		// Status tab 
		VerticalLayout status = new VerticalLayout(); 
		Label temperature = new Label("Temperature: 11°C"); 
		Label light = new Label("Light: OFF"); 
		Label humidity = new Label("Humidity: 70%"); 
		status.addComponent(temperature); 
		status.addComponent(light); 
		status.addComponent(humidity); 
		tabsheet.addTab(status, "Status", VaadinIcons.EYE); 
	
		// Settings tab 
		VerticalLayout settings = new VerticalLayout(); 
		settings.addComponent(new Label("settings tab")); 
		tabsheet.addTab(settings, "Settings", VaadinIcons.COG_O); 
	
		// Graphs tab 
		VerticalLayout graphs = new VerticalLayout(); 
		graphs.addComponent(new Label("graphs tab")); 
		tabsheet.addTab(graphs, "Graphs", VaadinIcons.SPLINE_CHART); 
		
	//----------------------------------------------------------------------------------------------- 
		return content; 
	} 
	
	void connectToDatabase() { 
		Connection con = null; 
		Statement cs; 
		try { 
			//Class.forName("com.postgresql.jdbc.Driver").newInstance(); 
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/baseService_db", 
			"masterUser", ""); 
			if(!con.isClosed()) 
				System.out.println("Successfully connected to " + 
				"Postgresql server using TCP/IP..."); 
			
			cs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
			ResultSet rs = cs.executeQuery("select * from certificates"); 
			while(rs.next()) 
			{ 
				System.out.println(rs.getInt(1)); 
			} 
	
		} catch(Exception e) { 
			System.err.println("Exception: " + e.getMessage()); 
		} finally { 
			try { 
				if(con != null) 
					con.close(); 
			} catch(SQLException e) {} 
		} 
	} 
}