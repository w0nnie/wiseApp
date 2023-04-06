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
            Rq rq = new Rq(command);

            switch (rq.getActionCode()) {
                case "목록":
                    wiseController.list();
                    break;
                case "등록":
                    wiseController.write();
                    break;

                case "종료":
                    systemController.exit();
                    return;
                case "삭제":
                    wiseController.remove(rq);
                    break;
                case "수정":
                    wiseController.update(rq);
                    break;
                case "빌드":
                    wiseController.build();
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }
}
