package com.app.agritech.constant;

import java.util.HashMap;
import java.util.Map;

public enum States {

    AN("Andaman and Nicobar Islands", 35),
    AD("Andhra Pradesh", 37),
    AR("Arunachal Pradesh", 12),
    AS("Assam", 18),
    BH("Bihar", 10),
    CH("Chandigarh", 4),
    CT("Chattisgarh", 22),
    DN("Dadra and Nagar Haveli", 26),
    DD("Daman and Diu", 25),
    DL("Delhi", 07),
    GA("Goa", 30),
    GJ("Gujarat", 24),
    HR("Haryana", 6),
    HP("Himachal Pradesh", 2),
    JK("Jammu and Kashmir", 1),
    JH("Jharkhand", 20),
    KA("Karnataka", 29),
    KL("Kerala", 32),
    LD("Lakshadweep Islands", 31),
    MP("Madhya Pradesh", 23),
    MH("Maharashtra", 27),
    MN("Manipur", 14),
    ME("Meghalaya", 17),
    MI("Mizoram", 15),
    NL("Nagaland", 13),
    OR("Odisha", 21),
    PY("Pondicherry", 34),
    PB("Punjab", 3),
    RJ("Rajasthan", 8),
    SK("Sikkim", 11),
    TN("Tamil Nadu", 33),
    TS("Telangana", 36),
    TR("Tripura", 16),
    UP("Uttar Pradesh", 9),
    UT("Uttarakhand", 5),
    WB("West Bengal", 19);

    String name;

    int code;

    States( String name, int code ) {
        this.name = name;
        this.code = code;
    }

    String getName() {
        return name;
    }

    int getCode() {
        return code;
    }

    public static Map<Integer, String> getStateMap() {
        Map<Integer, String> states = new HashMap<>();
        for (States state : States.values()) {
            states.put( state.getCode(), state.name );
        }
        return states;
    }

}
