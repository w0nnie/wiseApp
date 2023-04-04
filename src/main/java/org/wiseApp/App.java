package org.wiseApp;

import java.util.Scanner;

public class App {

    private final Scanner sc;

    App(Scanner sc) {
        this.sc =sc;
    }

    public void run() {
        System.out.println("=== 명언 앱 ===");
        while (true) {
            System.out.print("명령)");
            //좌우 공백 제거
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            }
        }
    }
}
