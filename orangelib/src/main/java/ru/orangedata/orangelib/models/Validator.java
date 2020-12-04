package ru.orangedata.orangelib.models;

import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Validator {

    protected static String NEW_LINE = "\n";
    private static String ISO8601 = "^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$";
    private static String ERR = "incorrect field :";

    public abstract String validate();

    protected String check(String fieldName, String value, int min, int max, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            if (value.length() >= min && value.length() <= max) {
                return "";
            } else {
                return ERR + fieldName + NEW_LINE;
            }
        }
    }

    protected String check(String fieldName, Double value, int digitsAfterPoint, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            if (value % 1 == 0)
                return "";
            else {
                String text = Double.toString(Math.abs(value));
                int integerPlaces = text.indexOf('.');
                int decimalPlaces = text.length() - integerPlaces - 1;
                if (decimalPlaces <= digitsAfterPoint) {
                    return "";
                } else {
                    return ERR + fieldName + NEW_LINE;
                }
            }
        }
    }

    protected String check(String fieldName, List<? extends Validator> value, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            StringBuilder str = new StringBuilder();
            for (Validator v : value) {
                if (!v.validate().equals("")) {
                    str.append(v.validate() + "\n");
                    break;
                }
            }
            return str.toString();
        }
    }

    protected String checkBase64(String fieldName, String value, int min, int max, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            byte[] data = Base64.getDecoder().decode(value);
            if (data.length >= min && data.length <= max) {
                return "";
            } else {
                return ERR + fieldName + NEW_LINE;
            }
        }
    }

    protected String check(String fieldName, Integer value, int min, int max, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            if (value >= min && value <= max) {
                return "";
            } else {
                return ERR + fieldName + NEW_LINE;
            }
        }
    }

    protected String check(String fieldName, List<String> value, int min, int max, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            boolean valid = true;
            for (String s : value) {
                if (s.length() >= min && s.length() <= max) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return "";
            } else {
                return ERR + fieldName + NEW_LINE;
            }
        }
    }

    protected String checkDate(String fieldName, String value, boolean nullable) {
        if (value == null) {
            if (nullable)
                return "";
            else
                return ERR + fieldName + NEW_LINE;
        } else {
            if (!Pattern.matches(ISO8601, value)) {
                return ERR + fieldName + NEW_LINE;
            } else {
                return "";
            }
        }
    }

}
