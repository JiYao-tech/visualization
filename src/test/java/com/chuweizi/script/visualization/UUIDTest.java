package com.chuweizi.script.visualization;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
}
