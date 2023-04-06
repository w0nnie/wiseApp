package org.wiseApp.wise.service;

import org.wiseApp.wise.entity.Wise;
import org.wiseApp.wise.repository.WiseRepository;
import java.util.List;

public class WiseService {


    private WiseRepository wiseRepository;
    public WiseService() {
        wiseRepository = new WiseRepository();
    }

    public long write(String wiseName, String writer) {
        return wiseRepository.write(wiseName, writer);
    }

    public List<Wise> findAll() {
        return wiseRepository.findAll();
    }

    public void remove(Wise wise) {
        wiseRepository.remove(wise);
    }

    public Wise findById(int id) {
        return wiseRepository.findById(id);
    }

    public void update(Wise wise, String newName, String newWriter) {
        wiseRepository.update(wise, newName, newWriter);
    }
}
