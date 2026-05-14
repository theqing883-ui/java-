package com.hspedu.abstract_;

public class BB extends Template {
    public void job() {
        long num = 0;
        for (long i = 0; i < 1000000; i++) {
            num *= i;
        }

    }
}
