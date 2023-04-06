package org.wiseApp.wise.repository;

import org.wiseApp.wise.entity.Wise;
import java.util.ArrayList;
import java.util.List;

public class WiseRepository {

    private List<Wise> wiseList;
    private int wiseCount;

    public WiseRepository() {
        wiseList = new ArrayList<>();
        wiseCount = 0;
    }


    public long write(String wiseName, String writer) {
        wiseCount++;
        Wise wise = new Wise(wiseCount, wiseName, writer);
        wiseList.add(wise);
        return wiseCount;
    }

    public List<Wise> findAll() {
        return wiseList;
    }

    public void remove(Wise wise) {
        wiseList.remove(wise);
    }

    public Wise findById(int id) {
        for (Wise wise : wiseList) {
            if (wise.getId() == id) {
                return wise;
            }
        }
        return null;
    }

    public void update(Wise wise, String newName, String newWriter) {
        wise.wiseUpdate(newName, newWriter);
    }
}
