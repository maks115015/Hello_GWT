package client.i18n;

import com.google.gwt.i18n.client.ConstantsWithLookup;

/**
 * Created by maks(avto12@i.ua) on 15.02.2016.
 */
public interface MyMessage extends ConstantsWithLookup {

    @DefaultStringValue("Good morning, World!")
    String morning();

    @DefaultStringValue("Good day, World!")
    String day();

    @DefaultStringValue("Good evening, World!")
    String evening();

    @DefaultStringValue("Good night, World!")
    String night();


}

