package se.su.dsv.bivsim.pages.CommonAllCases.General;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class ContentPanel extends Panel {
    public ContentPanel(String id, String content) {
        super(id);

        add(new Label("content", content));

    }
}
