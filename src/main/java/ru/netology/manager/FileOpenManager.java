package ru.netology.manager;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FileOpenManager {
    private Map<String, String> extdata;

    private String makeExtCase(String ext) {

        return ext.toLowerCase();
    }

    public void registerExt(String ext, String app) {
        if (extdata.containsKey(makeExtCase(ext))) {
            return;
        }
        extdata.put(ext, app);
    }

    public String getAppByExt(String ext) {
        return extdata.get(makeExtCase(ext));
    }

    public void unregisterExt(String ext) {
        if (extdata.containsKey(makeExtCase(ext))) {
            extdata.remove(ext);
        }
    }

    public List<String> getAllExt() {
        List<String> list = new ArrayList<>(extdata.keySet());
        return list.stream().sorted().collect(Collectors.toList());
    }

    public Collection<String> getAllApp() {
        List<String> list = new ArrayList<>(extdata.values());
        return list.stream().sorted().collect(Collectors.toList());
    }
}
