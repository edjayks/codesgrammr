package demo.codesgrammr.property;

import org.springframework.beans.factory.annotation.Value;

public class JavaPrimitiveDataTypesProperties {

    @Value("${byte.value}")
    private byte myByte;

    @Value("${short.number}")
    private short myShort;

    @Value("${int.number}")
    private int myInt;

    @Value("${long.number}")
    private long myLong;

    @Value("${float.number}")
    private float myFloat;

    @Value("${double.number}")
    private double myDouble;

    @Value("${boolean.value}")
    private boolean myBoolean;

    @Value("${char.value}")
    private char myChar;

    @Override
    public String toString() {
        return "JavaPrimitiveDataTypesProperties{" +
                "myByte=" + myByte +
                ", myShort=" + myShort +
                ", myInt=" + myInt +
                ", myLong=" + myLong +
                ", myFloat=" + myFloat +
                ", myDouble=" + myDouble +
                ", myBoolean=" + myBoolean +
                ", myChar=" + myChar +
                '}';
    }
}
