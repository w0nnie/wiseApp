package org.wiseApp;

import java.util.Scanner;

public class App {

    private final Scanner sc;

    App(Scanner sc) {
        this.sc =sc;
    }

    public void run() {
        String wise = "";
        String writer = "";
        System.out.println("=== 명언 앱 ===");
        while (true) {
            System.out.print("명령)");
            //좌우 공백 제거
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            }

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                wise = sc.nextLine().trim();
                System.out.print("작가 : ");
                writer = sc.nextLine().trim();
            }
        }
    }
}
