package com.kdabrowski8712.sportcourseplannerfrontend.views;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import javafx.scene.chart.Chart;

@Route(value = UseVadinBoard.ROUTE, layout = MainLayout.class)
public class UseVadinBoard extends VerticalLayout {
    public static final String ROUTE = "ex3";
    public static final String TITLE = "Exercise 3";

    public UseVadinBoard() {
        setSizeFull();
        Div div = new Div();
        div.setText("Replace me with a vaadin board");
        add(div);
    }

    private Chart getColumnChart() {

        return null;
    }

    private Chart getPieChart() {
        return null;
    }

    private Chart getFunnelChart() {
        return null;
    }
}