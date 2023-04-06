package org.wiseApp.wise.controller;

import org.wiseApp.Container;
import org.wiseApp.Rq;
import org.wiseApp.wise.entity.Wise;
import org.wiseApp.wise.service.WiseService;

import java.util.*;

public class WiseController {

    private WiseService wiseService;
    public WiseController() {
        wiseService = new WiseService();
    }

    public void write() {
        System.out.print("명언 : ");
        String wiseName = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String writer = Container.getScanner().nextLine().trim();

        long id = wiseService.write(wiseName, writer);
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        List<Wise> wiseList = wiseService.findAll();

        System.out.println("번호  /  작가  /  명언");
        System.out.println("--------------------------");

        for (int i = wiseList.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", wiseList.get(i).getId(), wiseList.get(i).getWriter(), wiseList.get(i).getWiseName());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if(id == -1)  {
            System.out.println("삭제할 id를 입력하세요(정수)");
            return;
        }

        Wise wise = wiseService.findById(id);
        if (wise == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n",id);
            return;
        }

        wiseService.remove(wise);
        System.out.printf("%d번이 삭제되었습니다. \n", id);

    }

    public void update(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if(id == -1)  {
            System.out.println("수정할 id를 입력하세요(정수)");
            return;
        }

        Wise wise = wiseService.findById(id);
        if (wise == null) {
            System.out.printf("%d번 명언이 존재하지 않습니다.\n",id);
            return;
        }
        System.out.print("명언 : ");
        String newName = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String newWriter = Container.getScanner().nextLine().trim();

        wiseService.update(wise, newName, newWriter);

        System.out.printf("%d번이 수정되었습니다. \n", id);
    }
}
