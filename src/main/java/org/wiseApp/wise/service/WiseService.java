package org.wiseApp.wise.service;

import org.wiseApp.Util;
import org.wiseApp.wise.entity.Wise;
import org.wiseApp.wise.repository.WiseRepository;
import java.util.List;
import java.util.stream.Collectors;

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

    public void build() {

        List<Wise> wises = wiseRepository.findAll();

        Util.file.mkdir("prodBuild");

        String json = "[" + wises
                .stream()
                .map(wise -> wise.toJson())
                .collect(Collectors.joining(",\n")) + "]";

        Util.file.saveToFile("prodBuild/data.json", json);
    }
}
