package com.lanchplace.util;

import java.time.LocalTime;

public class TimeUtil {
    public static boolean isElevenAm(LocalTime time, LocalTime deadLine) {
        return (time.compareTo(deadLine)<11);
    }
}
