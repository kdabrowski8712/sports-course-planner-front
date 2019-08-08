package com.kdabrowski8712.sportcourseplannerfrontend.views.instructor;

import com.kdabrowski8712.sportcourseplannerfrontend.views.base.BaseView;
import com.vaadin.flow.component.html.Anchor;


public class InstructorBaseView extends BaseView {

    private Anchor mItem4;

    public InstructorBaseView() {
        mItem1.setText("My courses");
        mItem2.setText("My individual lessons");
        mItem3.setText("My schedule");

        setHandlers();
    }

    private void setHandlers() {

        mItem1.setHref(CoursesListView.ROUTE);
    }

}
