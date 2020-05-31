package khj.study;

public class Calculator implements Runnable {       // Runnable 클래스 상속
    @Override
    public void run() {     // run 메소드 구현
        long current = 1L;
        long max = 20000L;  // 이 숫자 범위 내에서 소수 구하기
        long numPrimes = 0L;

        System.out.printf("Thread '%s': 시작\n", Thread.currentThread().getName());
        while (current <= max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': 종료. 소수: %d\n", Thread.currentThread().getName(), numPrimes);
    }

    /**
     * @param number: The number
     * @return boolean value. 소수일경우 true
     */
    private boolean isPrime(long number) { // 소수 구하기
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
