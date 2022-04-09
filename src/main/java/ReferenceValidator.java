import java.util.Arrays;

public class ReferenceValidator {

    //main method
    public static void main(String[] args) {
        System.out.println(calculateReferenceNumber(new int[]{1,2,3}));
    }

    public static String calculateReferenceNumber(int[] invoiceNumber) {
        int[] series = {7, 3, 1, 7, 3, 1, 7, 3, 1, 7, 3, 1, 7, 3, 1, 7, 3, 1};
        long checkingNumber = 0;
        if (invoiceNumber.length < 3 || invoiceNumber.length > 18) {
            return "Invalid invoice number";
        } else {
            int j = invoiceNumber.length - 1;
            for (int i = 0; i < invoiceNumber.length; i++) {
                checkingNumber += invoiceNumber[i] * series[j];
                j--;
            }

            checkingNumber = (long)(Math.ceil(checkingNumber/10.0) * 10) - checkingNumber;
        }
        String result = Arrays.toString(invoiceNumber).replaceAll("\\[|\\]|,|\\s", "") + Long.toString(checkingNumber);

        if (result.length() > 5) {
            StringBuilder sb = new StringBuilder(result);
            int j = 0;
            for (int i = result.length(); i > 0; i--) {
                if (j % 5 == 0 && j != 0) {
                    sb.insert(i, " ");
                }
                j++;
            }
            result = sb.toString();
        }
        return result;
    }
}