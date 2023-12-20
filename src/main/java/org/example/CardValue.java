package org.example;

public enum CardValue {

        TWO (13) ,
        THREE (12),
        FOUR (11),
        FIVE (10),
        SIX (9),
        SEVEN (8),
        EIGHT (7),
        NINE (6),
        TEN(5),
        JACK (4),
        QUEEN (3),
        KING (2),
        ACE (1);

        private int value;

        CardValue(int values) {
                this.value = values;
        }

        public int getValue(){
                return value;
        }
}
