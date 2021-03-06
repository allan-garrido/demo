package com.example.demo.visual;

import com.example.demo.domain.Estudiante;
import com.example.demo.domain.EstudianteRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alumno on 10/07/2017.
 */

@SpringUI

public class Principal extends UI{

    @Autowired
    EstudianteRepository repository;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout verticalLayout = new VerticalLayout();
        //verticalLayout.addComponent(new Button("Hola"));

        Grid<Estudiante> grid=new Grid<>();

        grid.addColumn(Estudiante::getId)
                .setCaption("Id");
        grid.addColumn(Estudiante::getNombre)
                .setCaption("Nombre");
        grid.addColumn(Estudiante::getEdad)
                .setCaption("Edad");

        TextField nombre=new TextField("Nombre");
        TextField edad=new TextField("Edad");

        Button button = new Button("Agregar");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
               Estudiante e=new Estudiante();

               e.setNombre(nombre.getValue());
               e.setEdad(Integer.parseInt(edad.getValue()));

               //pasando los datos a la base de datos por medio del repositorio
                repository.save(e);
                //añadiendo el repositorio al grid
                grid.setItems(repository.findAll());

                nombre.clear();
                edad.clear();

                Notification.show("Estudiante añadido");
            }
        });

        //añadiendo los componentes a la página
        verticalLayout.addComponents(nombre,edad,button,grid);

        setContent(verticalLayout);
    }
}
