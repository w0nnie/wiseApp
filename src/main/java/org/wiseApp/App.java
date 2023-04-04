package org.wiseApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner sc;

    App(Scanner sc) {
        this.sc =sc;
    }

    public void run() {
        List<Wise> wiseList = new ArrayList<>();
        int wiseCount = 0;
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
                String wiseName = sc.nextLine().trim();
                System.out.print("작가 : ");
                String writer = sc.nextLine().trim();
                wiseCount++;
                Wise wise = new Wise(wiseCount, wiseName, writer);
                wiseList.add(wise);
                System.out.println(wiseCount + "번 명언이 등록되었습니다.");
            }

            if (command.equals("목록")) {
                System.out.println("번호  /  작가  /  명언");
                System.out.println("--------------------------");
                for (int i = wiseList.size() - 1; i >= 0; i--) { // 2회반복
                    System.out.printf("%d / %s / %s\n", wiseList.get(i).getId(), wiseList.get(i).getWriter(), wiseList.get(i).wiseName);
                }
            }
        }
    }
}
