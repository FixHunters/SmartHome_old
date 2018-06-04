package com.smarthome.flat.svc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewScopedView.VIEW_NAME, ui = NavigationUI.class)
public class ViewScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "view";

    // a new instance will be created for every view instance
    @Autowired
    private ViewGreeter viewGreeter;
    

    // the same instance will be used by all views of the UI
 /*   @Autowired
    private Greeter uiGreeter;*/
    
    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a view scoped view"));
        
		final VerticalLayout layout = new VerticalLayout();
		final CssLayout topBar = new CssLayout();
		final CssLayout viewLayout = new CssLayout();
		
		layout.addComponent(topBar);
		layout.addComponent(viewLayout);
		
	//	setContent(layout);
        
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
        layout.setExpandRatio(viewContainer, 1.0f);
        addComponent(new Label("This is a view scoped viesssssssssssssw"));
        
        addComponent(new Label("This is a view scoped view"));
     //   addComponent(new Label(uiGreeter.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
        addComponent(new Panel(viewGreeter.showPanel()));
        addComponent(new Panel(viewGreeter.showGrid()));
        

        //Navigator navigator = new Navigator(this, viewContainer);
    //    navigator.addProvider(viewProvider);*/
    }
    
    public void show() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a view scoped view"));
        
		final VerticalLayout layout = new VerticalLayout();
		final CssLayout topBar = new CssLayout();
		final CssLayout viewLayout = new CssLayout();
		
		layout.addComponent(topBar);
		layout.addComponent(viewLayout);
		
	//	setContent(layout);
        
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
        layout.setExpandRatio(viewContainer, 1.0f);
        addComponent(new Label("This is a view scoped viesssssssssssssw"));
        
        addComponent(new Label("This is a view scoped view"));
     //   addComponent(new Label(uiGreeter.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
        addComponent(new Panel(viewGreeter.showPanel()));
        addComponent(new Panel(viewGreeter.showGrid()));

        //Navigator navigator = new Navigator(this, viewContainer);
    //    navigator.addProvider(viewProvider);*/
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }

}