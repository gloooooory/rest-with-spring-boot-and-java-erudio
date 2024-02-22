package br.com.erudio.utils;

public class DoubleConvert {

    public static Double convertToDouble (String strNumber) throws Exception {
        if(strNumber == null)
            throw new Exception("Cant be null");

        String number = strNumber.replaceAll(",", ".");

        if(isNumeric(strNumber)) return Double.parseDouble(number);

        return 0D;
    }

    public static boolean isNumeric(String strNumber) throws Exception {
        if(strNumber == null)
            throw new Exception("Cant be null");
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
