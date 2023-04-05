package org.wiseApp;

import org.wiseApp.system.controller.SystemController;
import org.wiseApp.wise.controller.WiseController;

public class App {
    public void run() {

        SystemController systemController = new SystemController();
        WiseController wiseController = new WiseController();
        System.out.println("=== 명언 앱 ===");
        while (true) {
            System.out.print("명령)");
            //좌우 공백 제거
            String command = Container.getScanner().nextLine().trim();

            if (command.equals("종료")) {
                systemController.exit();
                break;
            }

            if (command.equals("등록")) {
                wiseController.write();
            }

            if (command.equals("목록")) {
                wiseController.list();
            }

            if (command.startsWith("삭제")) {
                Rq rq = new Rq(command);

                System.out.printf("actionCode : %s\n", rq.getActionCode());
                System.out.printf("Params : %s\n", rq.getParams("id"));
                System.out.printf("writer : %s\n", rq.getParams("writer"));
                System.out.printf("content : %s\n", rq.getParams("content"));
                wiseController.remove(command);
            }
        }
    }
}
