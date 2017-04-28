package ru.vasilyev.enums;


public enum JSPPath {

    INDEX_JSP("/jsp/index.jsp"),
    INPUT_FIELD_JSP("/jsp/inputfield.jsp");

    String value;


    JSPPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
