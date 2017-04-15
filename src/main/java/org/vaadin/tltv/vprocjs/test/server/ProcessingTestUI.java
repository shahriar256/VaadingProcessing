package org.vaadin.tltv.vprocjs.test.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.Action;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.v7.data.Property.ValueChangeEvent;
import com.vaadin.v7.data.Property.ValueChangeListener;
import com.vaadin.v7.data.util.FilesystemContainer;
import com.vaadin.v7.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.v7.ui.Tree;

/**
 * Test bench UI for ProcessingJs.
 *
 * @author Tltv
 *
 */
@Title("ProcessingJs Add-on Demo")
public class ProcessingTestUI extends UI {

    private static final long serialVersionUID = -2006622339916372647L;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ProcessingTestUI.class, widgetset = "org.vaadin.tltv.vprocjs.gwt.ProcessingJsWidgetset")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(false);
        setContent(layout);

        HorizontalLayout captionLayout = new HorizontalLayout();
        captionLayout.setSpacing(true);
        captionLayout.setMargin(new MarginInfo(true, false, false, true));

        TabSheet tabsheet = new TabSheet();

        tabsheet.addTab(new ProcessingSimpleJavaCodeTest(), "This");

        layout.addComponentsAndExpand(tabsheet);


        layout.addComponent(captionLayout);
    }



    /**
     * Returns path to the Java source folder. By default, returns absolute path
     * pointing to webapp/WEB-INF/src. Absolute path is detected dynamically and
     * it may be null when web container runs the application within a war
     * package.
     *
     * @return Absolute path to the Java source files.
     */
    public String getSourcePath() {
        String path = getSession().getService().getBaseDirectory().getAbsolutePath() + File.separator + "WEB-INF"
                + File.separator + "classes";
        return path;
    }
}
