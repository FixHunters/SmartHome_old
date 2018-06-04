package com.smarthome.flat.svc;

import java.util.Iterator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.*;

/**
 * Main UI class
 * Shows different layouts.
 * <b>Note:</b> the code in this class is *on purpose* written the way it is written.
 */
@SuppressWarnings("serial")
public class LayoutsUI extends UI {

	private static final String[] CAPTIONS = new String[]{"Button", "Another button", "Yet another button with long caption", "Some button"};

	private static final Button.ClickListener LISTENER = new Button.ClickListener() {
		
		@Override
		public void buttonClick(ClickEvent event) {
			Notification.show("A button labelled '"+((Button)event.getSource()).getCaption()+"' was clicked.");
		}
	};
	
	@Override
	protected void init(VaadinRequest request) {
		TabSheet tabs = new TabSheet();
		tabs.addTab(this.getHorizontalLayoutsTab()).setCaption("Horizontal layouts");
		tabs.addTab(this.getVerticalLayoutsTab()).setCaption("Vertical layouts");
		tabs.addTab(this.getGridLayoutsTab()).setCaption("Grid layouts");
		tabs.setSizeFull();
		setContent(tabs);
		
	}

	protected void addButtonsTo(Layout layout) {
		for(String s: CAPTIONS)			
			layout.addComponent(new Button(s, LISTENER));
	}

	protected void setButtonsAlignment(AbstractOrderedLayout layout) {
		Alignment[] alignments = new Alignment[]{Alignment.TOP_LEFT, Alignment.BOTTOM_RIGHT, Alignment.MIDDLE_CENTER, Alignment.TOP_RIGHT};
		int alignindex = 0;
		Iterator<Component> iterator = layout.getComponentIterator();
		while(iterator.hasNext())
			layout.setComponentAlignment(iterator.next(), alignments[alignindex++]);
	}
	
	protected Component getGridLayoutsTab() {
		GridLayout main = new GridLayout(2, 3);
		main.setSizeFull();
		
		GridLayout layout = new GridLayout(2, 2);
		layout.setCaption("As constructed");
		this.addButtonsTo(layout);
		main.addComponent(layout);

		layout = new GridLayout(4, 4);
		layout.setWidth("300px");
		layout.setHeight("150px");
		layout.setCaption("Custom component span, components no size full");
		layout.addComponent(new Button("Top-left"), 0, 0, 0, 0);
		layout.addComponent(new Button("Two columns"), 1, 2, 2, 2);
		layout.addComponent(new Button("Two rows"), 0, 1, 0, 2);
		layout.addComponent(new Button("2x2"), 1, 0, 2, 1);
		layout.addComponent(new Button("Full row"), 0, 3, 2, 3);
		layout.addComponent(new Button("Full column"), 3, 0, 3, 3);
		main.addComponent(layout);

		layout = new GridLayout(4, 4);
		layout.setWidth("300px");
		layout.setHeight("150px");
		layout.setCaption("Custom component span, components no size full");
		layout.addComponent(new Button("Top-left"), 0, 0, 0, 0);
		layout.addComponent(new Button("Two columns"), 1, 2, 2, 2);
		layout.addComponent(new Button("Two rows"), 0, 1, 0, 2);
		layout.addComponent(new Button("2x2"), 1, 0, 2, 1);
		layout.addComponent(new Button("Full row"), 0, 3, 2, 3);
		layout.addComponent(new Button("Full column"), 3, 0, 3, 3);
		Iterator<Component> iterator = layout.getComponentIterator();
		while(iterator.hasNext())
			iterator.next().setSizeFull();
		main.addComponent(layout);

		layout = new GridLayout(4, 4);
		layout.setWidth("300px");
		layout.setHeight("150px");
		layout.setCaption("Custom component span, components no size full");
		layout.addComponent(new Button("Top-left"), 0, 0, 0, 0);
		layout.addComponent(new Button("Two columns"), 1, 2, 2, 2);
		layout.addComponent(new Button("Two rows"), 0, 1, 0, 2);
		layout.addComponent(new Button("2x2"), 1, 0, 2, 1);
		layout.addComponent(new Button("Full row"), 0, 3, 2, 3);
		layout.addComponent(new Button("Full column"), 3, 0, 3, 3);
		int align = 0;
		Alignment[] alignment = new Alignment[]{Alignment.TOP_LEFT, Alignment.MIDDLE_CENTER, Alignment.BOTTOM_RIGHT, Alignment.MIDDLE_CENTER, Alignment.BOTTOM_RIGHT, Alignment.TOP_CENTER};
		iterator = layout.getComponentIterator();
		while(iterator.hasNext())
			layout.setComponentAlignment(iterator.next(), alignment[align++]);
		main.addComponent(layout);
		
		layout = new GridLayout(2, 2);
		layout.setCaption("Expand ratios");
		layout.setSizeFull();
		this.addButtonsTo(layout);
		iterator = layout.getComponentIterator();
		while(iterator.hasNext()) {
			Component c = iterator.next();
			if(iterator.hasNext())
			  c.setWidth("100%");
			layout.setComponentAlignment(c, Alignment.MIDDLE_CENTER);
		}
		layout.setColumnExpandRatio(0, 1.0f);
		layout.setColumnExpandRatio(1, 2.0f);
		layout.setRowExpandRatio(0, 4.0f);
		layout.setRowExpandRatio(1, 1.0f);
		main.addComponent(layout);
		
		return main;
	}
	
	protected Component getVerticalLayoutsTab() {
		HorizontalLayout main = new HorizontalLayout();
		main.setSpacing(true);
		main.setSizeFull();
		
		VerticalLayout layout = new VerticalLayout();
		layout.setCaption("As constructed");
		layout.setWidth("25%");
		this.addButtonsTo(layout);
		main.addComponent(layout);

		layout = new VerticalLayout();
		layout.setCaption("Full height and alignment");
		layout.setWidth("25%");
		layout.setHeight("100%");
		this.addButtonsTo(layout);
		this.setButtonsAlignment(layout);
		main.addComponent(layout);
		
		layout = new VerticalLayout();
		layout.setCaption("full height, expand ratio = 1, buttons 100% height");
		layout.setHeight("100%");
		layout.setWidth("25%");
		this.addButtonsTo(layout);
		Iterator<Component> iterator = layout.getComponentIterator();
		while(iterator.hasNext()) {
			Button btn = (Button)iterator.next();
			btn.setHeight("100%");
			layout.setExpandRatio(btn, 1.0f);
		}
		main.addComponent(layout);		

		layout = new VerticalLayout();
		layout.setCaption("height 300px, expand ratio = 1, 2, 3, 4, buttons no 100% height");
		layout.setHeight("300px");
		layout.setWidth("25%");
		this.addButtonsTo(layout);
		float expand = 1.0f;
		iterator = layout.getComponentIterator();
		while(iterator.hasNext()) {
			Button btn = (Button)iterator.next();
			layout.setExpandRatio(btn, expand++);
		}
		main.addComponent(layout);		
		
		
		return main;
	}
	
	protected Component getHorizontalLayoutsTab() {
		FormLayout main = new FormLayout();
		HorizontalLayout layout = new HorizontalLayout();
		layout.setCaption("As constructed");
		this.addButtonsTo(layout);		
		main.addComponent(layout);
		
		layout = new HorizontalLayout();
		layout.setCaption("With spacing and margin");
		layout.setSpacing(true);
		layout.setMargin(true);
		this.addButtonsTo(layout);		
		main.addComponent(layout);

		layout = new HorizontalLayout();
		layout.setCaption("No spacing, full width");
		this.addButtonsTo(layout);		
		layout.setWidth("100%");
		main.addComponent(layout);

		layout = new HorizontalLayout();
		layout.setCaption("full width and custom alignment");
		this.addButtonsTo(layout);
		this.setButtonsAlignment(layout);
		layout.setWidth("100%");
		main.addComponent(layout);		

		layout = new HorizontalLayout();
		layout.setCaption("No spacing, width 300px");
		this.addButtonsTo(layout);		
		layout.setWidth("300px");
		main.addComponent(layout);

		layout = new HorizontalLayout();
		layout.setCaption("No spacing, width 500px, expand ratios = 1");
		layout.setWidth("500px");
		this.addButtonsTo(layout);
		Iterator<Component> iterator = layout.getComponentIterator();
		while(iterator.hasNext()) {
			Button btn = (Button)iterator.next();
			btn.setWidth("100%");
			layout.setExpandRatio(btn, 1.0f);
		}
		main.addComponent(layout);

		layout = new HorizontalLayout();
		layout.setCaption("(buttons must have 100% width!)");
		layout.setWidth("500px");
		this.addButtonsTo(layout);
		iterator = layout.getComponentIterator();
		while(iterator.hasNext())
			layout.setExpandRatio(iterator.next(), 1.0f);
		main.addComponent(layout);

		layout = new HorizontalLayout();
		layout.setCaption("full width, expand ratios = 1, 2, 3, 4");
		layout.setWidth("100%");
		this.addButtonsTo(layout);
		iterator = layout.getComponentIterator();
		float expand = 1.0f;
		while(iterator.hasNext()) {
			Button btn = (Button)iterator.next();
			btn.setWidth("100%");
			layout.setExpandRatio(btn, expand++);
		}
		main.addComponent(layout);
		
		layout = new HorizontalLayout();
		layout.setCaption("buttons not 100%, expand ratios = 1, 2, 3, 4");
		layout.setWidth("100%");
		this.addButtonsTo(layout);
		iterator = layout.getComponentIterator();
		expand = 1.0f;
		while(iterator.hasNext())
			layout.setExpandRatio(iterator.next(), expand++);
		main.addComponent(layout);
		
		return main;
	}
	
}