package com.example.springnatvkg.utols;
import com.example.springnatvkg.utols.models.Language;
import java.util.Locale;

public final class ResourceBundle {
    private ResourceBundle(){}

    private static final java.util.ResourceBundle messagesRu = java.util.ResourceBundle.getBundle("ru", Locale.forLanguageTag("ru"));
    private static final java.util.ResourceBundle messagesKg = java.util.ResourceBundle.getBundle("kg", Locale.forLanguageTag("kg"));

    public static String periodMessages(Language language,String key) {

        switch (language){
            case KG:
                return messagesKg.getString(key);
            case RU:
                return messagesRu.getString(key);
            default:
                return messagesRu.getString(key);
        }
    }






}
