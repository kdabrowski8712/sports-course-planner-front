package com.kdabrowski8712.sportcourseplannerfrontend.views;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;


@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
@StyleSheet("css/styles.css")
public class UseFormLayout extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public UseFormLayout() {

        setSizeFull();
        getStyle().set("border", "2px solid red");
        FormLayout fl = new FormLayout();


        TextField firstName = new TextField();
        firstName.setWidth("100%");
        FormLayout.FormItem fiterm1 = fl.addFormItem(firstName, "First name:");
        fiterm1.getStyle().set("--vaadin-form-item-label-width", "5em");
        fiterm1.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");

        fl.getElement().appendChild(ElementFactory.createBr());
        TextField lastName = new TextField();
        lastName.setWidth("100%");
        FormLayout.FormItem fitem = fl.addFormItem(lastName, "Last name:");
        fitem.getStyle().set("--vaadin-form-item-label-width", "5em");
        fitem.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");


        fl.getElement().appendChild(ElementFactory.createBr());
        TextField email = new TextField();
        email.setWidth("100%");
        FormLayout.FormItem emailFL = fl.addFormItem(email, "e-mail:");
        emailFL.getElement().setAttribute("colspan", "2");
        emailFL.getStyle().set("--vaadin-form-item-label-width", "5em");
        emailFL.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");

        FlexLayout phoneLayout = new FlexLayout();
        phoneLayout.setWrapMode(FlexLayout.WrapMode.WRAP);
        phoneLayout.setAlignItems(Alignment.END);
        phoneLayout.setWidth("100%");
        TextField phone = new TextField();

        phoneLayout.add(phone, new Checkbox("Do bot call"));
        phoneLayout.expand(phone);

        FormLayout.FormItem phoneItem = fl.addFormItem(phoneLayout, "Phone");
        phoneItem.getStyle().set("--vaadin-form-item-label-width", "5em");
        phoneItem.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");
        phoneItem.getElement().setAttribute("colspan", "2");

        PasswordField password = new PasswordField();
        password.setWidth("100%");
        FormLayout.FormItem passwordFL = fl.addFormItem(password, "Password");
        passwordFL.getStyle().set("--vaadin-form-item-label-width", "5em");
        passwordFL.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");

        fl.getElement().appendChild(ElementFactory.createBr());

        PasswordField repeatPassword = new PasswordField();
        repeatPassword.setWidth("100%");
        FormLayout.FormItem represtPasswordFL = fl.addFormItem(repeatPassword, "Password");
        represtPasswordFL.getStyle().set("--vaadin-form-item-label-width", "5em");
        represtPasswordFL.getStyle().set("--vaadin-form-item-label-spacing", "0.5em");


        add(fl);
    }
}
