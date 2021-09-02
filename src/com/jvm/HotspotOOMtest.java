package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class HotspotOOMtest {
    static class OOMObject{

    }

    public static void main(String[] args) {
        outOfMemory();
    }

    private static void outOfMemory() {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
