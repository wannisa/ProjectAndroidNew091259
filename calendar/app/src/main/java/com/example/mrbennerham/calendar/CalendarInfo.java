package com.example.mrbennerham.calendar;

import com.google.api.client.util.Objects;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;

/**
 * Created by MR.BENNERHAM on 10/30/2016.
 */
public class CalendarInfo implements Comparable<CalendarInfo>, Cloneable {

    String id;
    String summary;


    @Override
    public String toString() {
        return Objects.toStringHelper(CalendarInfo.class).add("id", id).add("summary", summary)
                .toString();
    }

    public int compareTo(CalendarInfo other) {
        return summary.compareTo(other.summary);
    }


}
