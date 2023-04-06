package org.wiseApp.wise.repository;

import org.wiseApp.wise.entity.Wise;
import org.wiseApp.wise.table.WiseTable;

import java.util.List;

public class WiseRepository {

    private WiseTable wiseTable;
    public WiseRepository() {
        wiseTable = new WiseTable();
    }


    public long write(String wiseName, String writer) {
        long id = wiseTable.getLastId() + 1;
        Wise wise = new Wise(id, wiseName, writer);
        return wiseTable.save(wise);
    }

    public List<Wise> findAll() {
        return wiseTable.findAll();
    }

    public void remove(Wise wise) {
        wiseTable.remove(wise);
    }

    public Wise findById(int id) {
        return wiseTable.findById(id);
    }

    public void update(Wise wise, String newName, String newWriter) {
        wiseTable.update(wise, newName, newWriter);
    }
}
