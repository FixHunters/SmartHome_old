package com.smarthome.flat.svc;
/*package com.example.RaspberryGpio;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

@SpringUI
@Theme("valo")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout content = new VerticalLayout();
		setContent(content);
		
		///////////////
		Video v = new Video( "video" ); // Instantiate video player widget.
		// Specify a list of your video in one or more formats.
		// Different browsers support various different video formats.
		v.setSources( 
		    new ExternalResource( "http://www.example.com/media/example_video.mp4" ),
		    new ExternalResource( "http://www.example.com/media/example_video.ogv" ) 
		); 
		v.setWidth( "640px" ); // Set size of the video player's display area on-screen.
		v.setHeight( "360px" );
		content.addComponent( v ); // Add the component to the window or layout.
		//////////////////////
		
		MenuBar barmenu = new MenuBar();
		content.addComponent(barmenu);
		
		// A feedback component
		final Label selection = new Label("-");
		content.addComponent(selection);

		// Define a common menu command for all the menu items.
		MenuBar.Command mycommand = new MenuBar.Command() {
		    public void menuSelected(MenuItem selectedItem) {
		        selection.setValue("Ordered a " +
		                           selectedItem.getText() +
		                           " from menu.");
		    }
		};
		
		// A top-level menu item that opens a submenu
		MenuItem drinks = barmenu.addItem("Beverages", null, null);

		// Submenu item with a sub-submenu
		MenuItem hots = drinks.addItem("Hot", null, null);
		hots.addItem("Tea",
		    new ThemeResource("icons/tea-16px.png"),    mycommand);
		hots.addItem("Coffee",
		    new ThemeResource("icons/coffee-16px.png"), mycommand);

		// Another submenu item with a sub-submenu
		MenuItem colds = drinks.addItem("Cold", null, null);
		colds.addItem("Milk",      null, mycommand);
		colds.addItem("Weissbier", null, mycommand);

		// Another top-level item
		MenuItem snacks = barmenu.addItem("Snacks", null, null);
		snacks.addItem("Weisswurst", null, mycommand);
		snacks.addItem("Bratwurst",  null, mycommand);
		snacks.addItem("Currywurst", null, mycommand);

		// Yet another top-level item
		MenuItem servs = barmenu.addItem("Services", null, null);
		servs.addItem("Car Service", null, mycommand);
		
		MenuItem drinkss = barmenu.addItem("Beverages", null, null);

		// A sub-menu item after a separator
		drinkss.addSeparator();
		drinkss.addItem("Quit Drinking", null, null);
		
		
				// First set the root content for the UI
		VerticalLayout content = new VerticalLayout();
		setContent(content);

		// Set the content size to full width and height
		content.setSizeFull();

		// Add a title area on top of the screen. This takes
		// just the vertical space it needs.
		com.vaadin.ui.Label mylabel = new Label("hello");
		content.addComponent(mylabel);

		// Add a menu-view area that takes rest of vertical space
		HorizontalLayout menuview = new HorizontalLayout();
		menuview.setSizeFull();
		content.addComponent(menuview);
		
		Panel panel = new Panel("This is a Panel");
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.addComponent(new Label("Hello!"));
		panel.setContent(panelContent);

		// Set the panel as the content of the UI
		setContent(panel);
		
	}

}
*/