package org.wiseApp.wise.controller;

import org.wiseApp.Container;
import org.wiseApp.Rq;
import org.wiseApp.wise.entity.Wise;

import java.util.*;

public class WiseController {

    private List<Wise> wiseList;
    private int wiseCount;

    public WiseController() {
        this.wiseList = new ArrayList<>();
        this.wiseCount = 0;
    }

    public void write() {
        System.out.print("명언 : ");
        String wiseName = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String writer = Container.getScanner().nextLine().trim();
        wiseCount++;
        Wise wise = new Wise(wiseCount, wiseName, writer);
        wiseList.add(wise);
        System.out.println(wiseCount + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("번호  /  작가  /  명언");
        System.out.println("--------------------------");
        for (int i = wiseList.size() - 1; i >= 0; i--) { // 2회반복
            System.out.printf("%d / %s / %s\n", wiseList.get(i).getId(), wiseList.get(i).getWriter(), wiseList.get(i).getWiseName());

        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if(id == -1)  {
            System.out.println("id를 입력하세요(정수)");
            return;
        }
        for (Wise wise : wiseList) {
            if (wise.getId() == id) {
                wiseList.remove(wise);
                System.out.printf("%d번이 삭제되었습니다. \n", id);
                return;
            }
        }
        System.out.println("해당 id의 명언이 존재하지 않습니다.");
    }
}
