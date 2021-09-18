package demo.codesgrammr.property;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaWrapperDataTypesProperties {

    @Value("${byte.value}")
    private Byte myByte;

    @Value("${short.number}")
    private Short myShort;

    @Value("${int.number}")
    private Integer myInt;

    @Value("${long.number}")
    private Long myLong;

    @Value("${float.number}")
    private Float myFloat;

    @Value("${double.number}")
    private Double myDouble;

    @Value("${boolean.value}")
    private Boolean myBoolean;

    @Value("${char.value}")
    private Character myChar;

    @Value("${list.values}")
    private List myList;

    @Value("#{${map.values}}")
    private Map myMap;

    @Value("#{new java.text.SimpleDateFormat(\"yyyy-MM-dd\").parse(\"${date.value}\")}")
    private Date myDate;

    private LocalDate myLocalDate;

    @Value("${localdate.value}")
    public void setMyLocalDate(String myLocalDate) {
        this.myLocalDate = LocalDate.parse(myLocalDate);
    }

    @Override
    public String toString() {
        return "JavaWrapperDataTypesProperties{" +
                "myByte=" + myByte +
                ", myShort=" + myShort +
                ", myInt=" + myInt +
                ", myLong=" + myLong +
                ", myFloat=" + myFloat +
                ", myDouble=" + myDouble +
                ", myBoolean=" + myBoolean +
                ", myChar=" + myChar +
                ", myList=" + myList.stream().collect(Collectors.joining()) +
                ", myMap=" + myMap.entrySet().stream().map(entry -> entry.toString()).collect(Collectors.joining(",")) +
                ", myDate=" + myDate +
                ", myLocalDate=" + myLocalDate +
                '}';
    }
}
