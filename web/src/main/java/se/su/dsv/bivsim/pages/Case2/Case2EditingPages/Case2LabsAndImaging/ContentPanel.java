package se.su.dsv.bivsim.pages.Case2.Case2EditingPages.Case2LabsAndImaging;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class ContentPanel extends Panel {
    public ContentPanel(String id, String content) {
        super(id);

        add(new Label("content", content));
    }
}
