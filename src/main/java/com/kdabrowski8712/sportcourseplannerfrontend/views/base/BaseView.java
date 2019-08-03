package com.kdabrowski8712.sportcourseplannerfrontend.views.base;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@StyleSheet("css/styles.css")
public class BaseView extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    public static final String ROUTE = "ex1";
    public static final String TITLE = "Exercise 1";
    protected HorizontalLayout layout;

    protected Div navigation;
    protected Div content;
    protected Div header;
    protected Footer footer;
    protected Anchor mItem1;
    protected Anchor mItem2;
    protected Anchor mItem3;
    protected Anchor mItem4;
    protected Span logoSpan;


    public BaseView() {
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        header = new Div();
        //header.getStyle().set("padding-top","25px");
        header.getStyle().set("flex-shrink", "0");

        header.setClassName("header");
        header.setHeight("70px");

        layout = new HorizontalLayout();
        createTextLayout();

        footer = new Footer();
        footer.getStyle().set("flex-shrink", "0");
        //footer.getStyle().set("justify-content","center");

        Span sp = new Span();
        sp.setText("This is the footer area. My height is 100 pixels");
        // footer.setText("This is the footer area. My height is 100 pixels");
        footer.add(sp);
        footer.setClassName("footer");
        footer.setHeight("40px");

        add(header);
        add(layout);
        add(footer);

        createMenuAndlogo();

        expand(layout);


    }

    private void createTextLayout() {

        //  navigation = new Div();
        ////     navigation.setClassName("navigation");
        //    navigation.setText("This is the navigation area. My width is 25% of the ApplicationLayout.");
        //     navigation.setWidth("25%");

        content = new Div();
        //content.getStyle().set("display","flex");
        content.getStyle().set("display", "grid");
        //content.getStyle().set("padding-top","10px");
        // content.getStyle().set("padding-right","10px");
        // content.getStyle().set("flex-grow","1");
        content.setClassName("content");
        //content.setText("This is the content area");
        content.setWidth("100%");
        content.getStyle().set("align-content", "flex-start");

        //    layout.add(navigation);
        layout.add(content);
        layout.expand(content);
        layout.setDefaultVerticalComponentAlignment(Alignment.AUTO);

    }

    private void createMenuAndlogo() {

        mItem1 = new Anchor("http://www.wp.pl", "MenuItem1");
        mItem2 = new Anchor("http://www.wp.pl", "MenuItem2");
        mItem3 = new Anchor("http://www.wp.pl", "MenuItem3");
        mItem4 = new Anchor("http://www.wp.pl", "Login");

        VerticalLayout headerVLayout = new VerticalLayout();
        HorizontalLayout menu = new HorizontalLayout();
        menu.setWidthFull();

        headerVLayout.setPadding(false);
        headerVLayout.setSpacing(false);
        menu.setPadding(false);
        menu.setSpacing(false);

        headerVLayout.getStyle().set("margin-left", "20px");
        // menu.getStyle().set("margin-left","20px");

        logoSpan = new Span();
        logoSpan.setText("Logo");

        menu.add(mItem1);
        menu.add(mItem2);
        menu.add(mItem3);
        menu.add(mItem4);

        mItem4.getStyle().set("margin-left", "auto");

        headerVLayout.add(logoSpan);
        headerVLayout.add(menu);

        header.add(headerVLayout);
    }


}
