package org.wiseApp.wise.controller;

import org.wiseApp.Container;
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

    public void remove(String command) {


        // 정리 끝
    }
}
