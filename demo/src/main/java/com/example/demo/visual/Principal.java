package com.example.demo.visual;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by alumno on 10/07/2017.
 */

@SpringUI

public class Principal extends UI{

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(new Button("Hola"));

        setContent(verticalLayout);
    }
}
