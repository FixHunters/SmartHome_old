package com.smarthome.flat.svc;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SpringUI(path = "/home")
@Theme("valo")
public class NavigationUI extends UI{
    public NavigationUI() {
		super();
	}
	public static final String VIEW_NAME = "";
    
	@Autowired
	private SpringViewProvider viewProvider;
	
	private ViewGreeter ViewGreeter;
	
	private ViewScopedView viewScopedView;
	
	public GridLayout grid;
	
    @Override
    public void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		final CssLayout topBar = new CssLayout();
		final CssLayout viewLayout = new CssLayout();
		
        // navigation2 bar ************
        final CssLayout navigationBar = new CssLayout();
		
		layout.addComponent(topBar);
		layout.addComponent(viewLayout);
		
		
		/* Horizontalne menu bar */
        // Create Navigator, use the UI content layout to display the views
        Navigator navigator = new Navigator(this, viewLayout);
        navigator.addProvider(viewProvider);
        
        // Add some Views
        navigator.addView(MainView.NAME, new MainView()); // no fragment

        // #count will be a new instance each time we navigate to it, counts:
        navigator.addView(CountView.NAME, SecretView.class);

        // The Navigator attached to the UI will automatically navigate to the initial fragment once
        // the UI has been initialized.
        for (String s : new String[]{"HOME - MainView", "MENU1 - secredView"}) {
			topBar.addComponent(this.createNavigationButtonNavigator(s, navigator));
		}
        
    

        
     // Create a grid layout
        grid = new GridLayout(3, 3);
        
        grid.setWidth(400, Sizeable.Unit.PIXELS);
        grid.setHeight(200, Sizeable.Unit.PIXELS);

        /*	Lave horizontalne buttony	*/
        Button topleft = new Button("Top Left");
        grid.addComponent(topleft, 0, 0);
        grid.setComponentAlignment(topleft, Alignment.TOP_LEFT);
        
        Button topleft2 = new Button("Top Left2");
        grid.addComponent(topleft2, 0, 1);
        grid.setComponentAlignment(topleft2, Alignment.TOP_LEFT);
        
    	final Grid viewContainer = new Grid();
        viewContainer.setSizeFull();
        grid.addComponent(viewContainer, 1, 1);
        
        navigationBar.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        navigationBar.addComponent(createNavigationButton("UI Scoped View",
                NavigationUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        
        grid.addComponent(navigationBar, 0, 2);
        grid.setComponentAlignment(navigationBar, Alignment.TOP_LEFT);
        layout.addComponent(grid);

        layout.setSpacing(false);
        setContent(layout);
    
    }
    
	private Button createNavigationButtonNavigator(final String state, final Navigator navigator) {
		return new Button("Go to " + state, new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent arg0) {
				 navigator.navigateTo("count");
			}
		});
	}
    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(viewName);
			}
		});
        return button;
    }
    
    
}
