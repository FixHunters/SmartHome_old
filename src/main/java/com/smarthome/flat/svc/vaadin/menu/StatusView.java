package com.smarthome.flat.svc.vaadin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smarthome.flat.svc.controller.ApplicationController;
import com.smarthome.flat.svc.vaadin.menu.utils.ViewUtils;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author Jan Pojezdala
 */
public class StatusView extends Composite implements View {

	private static final Logger log = LoggerFactory.getLogger(StatusView.class);

	ViewUtils viewUtils = new ViewUtils();

	public StatusView(ApplicationController controller) {
		setCompositionRoot(roomLayout(controller));
	}

	public HorizontalLayout roomLayout(ApplicationController controller) {

		HorizontalLayout content = new HorizontalLayout();
		content.setSizeFull();
		content.addComponent(viewUtils.showGrid());
		return content;
	}

}
