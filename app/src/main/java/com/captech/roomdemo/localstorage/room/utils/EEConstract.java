package com.captech.roomdemo.localstorage.room.utils;

/**
 *
 * Created by lorence on 06/11/2017.
 */

public class EEConstract {
    /**
     * DB_NAME
     */
    public static final String DB_NAME = "car_supper";

    /*
     * TABLE Car
     * Some attributes of super car.
     */
    public static class EECar {
        public static final String TABLE = "car";
        /* --------------------------------------------- */
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String BRAND = "brand";
        public static final String SPEED = "speed";
        public static final String COLOR = "color";
        public static final String ENGINE = "engine";
        public static final String PRICE = "price";
        public static final String MAX_SPEED = "max_speed";
        public static final String ACCELERATE_100S = "accelerate";
        public static final String MODE_ID = "mode_id";
        public static final String MODE = "mode";
    }

    /*
     * TABLE Mode Car
     * Some attributes of super car.
     */
    public static class EEUser {
        public static final String TABLE = "model";
        /* --------------------------------------------- */
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }
}
