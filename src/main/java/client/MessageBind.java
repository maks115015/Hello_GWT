package client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

/**
 * Created by maks(avto12@i.ua) on 07.02.2016.
 */
public class MessageBind {
    interface MessageBindUiBinder extends UiBinder<DivElement, MessageBind> {
    }

    private static MessageBindUiBinder ourUiBinder = GWT.create(MessageBindUiBinder.class);

    @UiField
    SpanElement nameSpan;

    private DivElement root;

    public MessageBind() {
        root = ourUiBinder.createAndBindUi(this);
    }

    public Element getElement() {
        return root;
    }

    public void setName(String name) { nameSpan.setInnerText(name); }
}