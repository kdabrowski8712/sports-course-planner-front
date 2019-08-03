package com.kdabrowski8712.sportcourseplannerfrontend.views;

import com.kdabrowski8712.sportcourseplannerfrontend.domain.Book;
import com.kdabrowski8712.sportcourseplannerfrontend.service.BookService;
import com.kdabrowski8712.sportcourseplannerfrontend.views.base.BaseView;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//@Route(value = MainView.ROUTE , layout = MainLayout.class)
//@RouteAlias(value = "", layout = MainLayout.class)
//@HtmlImport("css/styles.html")

@StyleSheet("css/styles.css")
public class MainView extends BaseView {

    private BookService bookService = BookService.getInstance();
    private Grid<Book> grid = new Grid<>(Book.class);

    public MainView() {

        Anchor a1 = new Anchor("http://www.wp.pl", "MenuItem1");
        Anchor a2 = new Anchor("http://www.wp.pl", "MenuItem2");
        Anchor a3 = new Anchor("http://www.wp.pl", "Login");

        VerticalLayout headerVLayout = new VerticalLayout();
        HorizontalLayout menu = new HorizontalLayout();
        menu.setWidthFull();

        headerVLayout.setPadding(false);
        headerVLayout.setSpacing(false);
        menu.setPadding(false);
        menu.setSpacing(false);

        headerVLayout.getStyle().set("margin-left", "20px");
        // menu.getStyle().set("margin-left","20px");

        Span logoSpan = new Span();
        logoSpan.setText("Logo");

        menu.add(a1);
        menu.add(a2);
        menu.add(a3);

        a3.getStyle().set("margin-left", "auto");

        headerVLayout.add(logoSpan);
        headerVLayout.add(menu);

        header.add(headerVLayout);

        UseFormLayout fl = new UseFormLayout();
        content.add(fl);

    }

//        Anchor a1 = new Anchor("http://www.wp.pl","MenuItem1");
//        Anchor a2 = new Anchor("http://www.wp.pl","MenuItem2");
//        Anchor a3 = new Anchor("http://www.wp.pl","MenuItem3");
//        Anchor a4 = new Anchor("http://www.wp.pl","MenuItem4");
//
//
//        Button btn1 = new Button("Clck me1");
//        Button btn2 = new Button("Clck me2");
//        Button btn3 = new Button("Click me3");
//        Button btn4 = new Button("Click me4");
//
//        HorizontalLayout flexLayout = new HorizontalLayout();
//        flexLayout.setWidthFull();
//        flexLayout.getStyle().set("flex-wrap", "wrap");
//
//        flexLayout.add(a1);
//        flexLayout.add(a2);
//        flexLayout.add(a3);
//        flexLayout.add(a4);
//
//        a4.setId("login");
//
//
//
//
//       // flexLayout.add(btn1);
//       // flexLayout.add(btn2);
//      //  flexLayout.add(btn3);
//       // flexLayout.add(btn4);
//
//        btn3.setId("button3");
//        //btn3.getStyle().set("margin-left","auto");
//
//        //btn3.getStyle().set("margin-left","5px");
//        btn4.getStyle().set("margin-right","10px");
//        btn4.getStyle().set("margin-left","5px");
//
//        btn2.getStyle().set("margin-left","5px");
//
//        VerticalLayout vlayout = new VerticalLayout();
//
//        Div div1 = new Div();
//        div1.add("Div1");
//
//        vlayout.add( new TextField("Name"));
//        vlayout.add(new TextArea("Description"));
//
//        NumberField price = new NumberField("Price");
//        price.setSuffixComponent(new Span("Euro"));
//        price.setStep(0.0);
//        vlayout.add(price);
//
//        vlayout.add(new DatePicker("Available"));
//
//        ComboBox<String> category = new ComboBox<>("Category");
//        category.setItems("A","B","C");
//        vlayout.add(category);
//
//
//        Button save = new Button("save");
//        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        Button cancel = new Button("Cancel");
//
//        HorizontalLayout buttons = new HorizontalLayout(save,cancel);
//        vlayout.add(buttons);
//
//
//        //Div div2 = new Div();
//        //div2.add("Div2");
//
//        //vl.add(div1);
//
//        add(flexLayout);
//        add(vlayout);

    public void refresh() {
        grid.setItems(bookService.getBooks());

    }
}
