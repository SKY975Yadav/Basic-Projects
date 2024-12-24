import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

class FindNextBigPrimeNumber {
    public static BigInteger find(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.valueOf(2);
        }
        BigInteger candidate = num.add(BigInteger.ONE);
        if (candidate.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            candidate = candidate.add(BigInteger.ONE);
        }
        while (!isPrime(candidate)) {
            candidate = candidate.add(BigInteger.valueOf(2));
        }
        return candidate;
    }

    private static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) return false;
        if (num.compareTo(BigInteger.valueOf(3)) <= 0) return true;
        if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) || num.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO))
            return false;
        for (BigInteger i = BigInteger.valueOf(5); i.multiply(i).compareTo(num) <= 0; i = i.add(BigInteger.valueOf(6))) {
            if (num.mod(i).equals(BigInteger.ZERO) || num.mod(i.add(BigInteger.valueOf(2))).equals(BigInteger.ZERO))
                return false;
        }
        return true;
    }
}

public class FindingNextBigPrimeNumber {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter number of tests : ");
        int tests = sc1.nextInt();
        while (tests > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number : ");
            BigInteger number = new BigInteger(sc.nextLine());
            System.out.println(FindNextBigPrimeNumber.find(number));
            tests--;
        }
    }
}