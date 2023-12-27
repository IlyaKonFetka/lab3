package itmo.other;

import itmo.enums.*;
import itmo.interfaces.Flyable;

import java.util.ArrayList;
import java.util.Date;

public class HumanWithPropeller
        extends Human
        implements Flyable {

    public static final String typeName = "'Human with propeller'";

    public HumanWithPropeller(int series,
                              int number,
                              Date dateOfBorn,
                              Country birthPlace,
                              String name,
                              Gender gender,
                              Location previousLocation,
                              Location location,
                              Property... properties) {
        super(series,
                number,
                dateOfBorn,
                birthPlace,
                name,
                gender,
                previousLocation,
                location,
                properties);
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

}
