import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstNumber = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        byte secondNumber = Byte.parseByte(scanner.nextLine());
        if (firstNumber == "0" || secondNumber == 0 || firstNumber == "")
        {
            System.out.println(0);
            return;
        }
        byte product = 0;
        byte numberInMind = 0;
        byte remainder = 0;
        StringBuilder result = new StringBuilder();
        for (int i = firstNumber.length() - 1; i >= 0 ; i--)
        {
            product = (byte)(Byte.parseByte(firstNumber.charAt(i) + "") * secondNumber + numberInMind);
            numberInMind = (byte)(product / 10);
            remainder = (byte)(product % 10);
            result.append(remainder);
            if (i == 0 && numberInMind != 0)
            {
                result.append(numberInMind);
            }
        }
        char[] resultToCharArr = result.toString().toCharArray();
        for(int i = 0; i < resultToCharArr.length / 2; i++)
        {
            char temp = resultToCharArr[i];
            resultToCharArr[i] = resultToCharArr[resultToCharArr.length - i - 1];
            resultToCharArr[resultToCharArr.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(resultToCharArr).replaceAll("[\\[\\], ]", ""));
    }
}