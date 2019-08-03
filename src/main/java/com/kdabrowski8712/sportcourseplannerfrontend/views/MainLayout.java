package com.kdabrowski8712.sportcourseplannerfrontend.views;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

@HtmlImport("styles.html")
public class MainLayout extends VerticalLayout implements RouterLayout {

    private FlexLayout childWrapper = new FlexLayout();

    public MainLayout() {
        setSizeFull();

        final H1 title = new H1("Layout Exercise");

        HorizontalLayout mainContent = new HorizontalLayout();
        add(title, mainContent);
        expand(mainContent);

        setAlignItems(Alignment.STRETCH);
        setAlignSelf(Alignment.CENTER, title);

        final VerticalLayout menuBar = new VerticalLayout();
        menuBar.add(new RouterLink(MainView.TITLE, MainView.class));
        menuBar.add(new RouterLink(UseFormLayout.TITLE, UseFormLayout.class));
        // menuBar.add(new RouterLink(UseVadinBoard.TITLE, UseVadinBoard.class));
        // menuBar.setAlignItems(Alignment.CENTER);
        //  add(menuBar);
        setSizeFull();
        menuBar.setWidth("20%");
        menuBar.getStyle().set("backgroundColor", "#EEE");
        menuBar.setAlignItems(Alignment.CENTER);

        childWrapper.setHeightFull();
        childWrapper.setWidth("80%");
        mainContent.add(menuBar, childWrapper);
        mainContent.setAlignItems(Alignment.STRETCH);
        mainContent.expand(childWrapper);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        childWrapper.getElement().appendChild(content.getElement());
    }
}
