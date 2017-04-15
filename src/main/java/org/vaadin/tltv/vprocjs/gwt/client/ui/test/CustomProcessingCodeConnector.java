package org.vaadin.tltv.vprocjs.gwt.client.ui.test;

import org.vaadin.tltv.vprocjs.gwt.client.ui.ProcessingCode;
import org.vaadin.tltv.vprocjs.gwt.client.ui.ProcessingCodeConnector;
import org.vaadin.tltv.vprocjs.test.server.CustomProcessingCodeExtension;

import com.vaadin.shared.ui.Connect;

@Connect(CustomProcessingCodeExtension.class)
public class CustomProcessingCodeConnector extends ProcessingCodeConnector {

    @Override
    public ProcessingCode getProcessingJavaCode(String codeClass) {
        if (ProcessingCodeImplTest.class.getName().equals(codeClass)) {
            return new ProcessingCodeImplTest();

        }
        return null;
    }
}
