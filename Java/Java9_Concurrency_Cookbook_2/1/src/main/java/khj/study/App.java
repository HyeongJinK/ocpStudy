package khj.study;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 스레드
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 우선순위 번호
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);   // 1
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);   // 5
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);   // 10

        Thread threads[];
        Thread.State status[];

        /**
         * 10개의 스레드 생성
         * 짝수 번호 5개는 최대 우선순위
         * 홀수 번호 5개는 최하 우선순위
         * */
        threads = new Thread[10];
        status = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        // 텍스트에 정보 저장
        try (FileWriter file = new FileWriter(".\\log.txt"); PrintWriter pw = new PrintWriter(file);) {
            // 스레드 상태 저장
            for (int i = 0; i < 10; i++) {
                pw.println("Main : 스레드 상태 " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            // 스레드 시작
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            /**
             * 스레드가 완료될 때까지 기다린다.
             * */
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method 스레드 상태를 파일에 작성한다.
     * @param pw: PrintWriter to write the data
     * @param thread: Thread whose information will be written
     * @param state: Old state of the thread
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
