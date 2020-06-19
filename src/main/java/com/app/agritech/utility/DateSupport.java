package com.app.agritech.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSupport {

    public static final String DEFAULT_DATE_TIME_FORMAT = "dd MMM yyyy h:mm a";

    public static final String DEFAULT_DATE_FORMAT = "dd MMM yyyy";

    public static String convertDateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

}
