package com.processoseletivo.processoseletivo.utils;

public class RandomNumber {
    public int get(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}