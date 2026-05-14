package com.hspedu.abstract_;

public class AA extends Template {
    public void job() {
        long num = 0;
        for (long i = 0; i < 10000000; i++) {
            num += i;
        }
    }
}
