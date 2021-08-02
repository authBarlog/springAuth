package com.example.demo.student;

import org.springframework.stereotype.Repository;

@Repository
public class RequestCounter {
    private int requestCount;

    public void increment() {
        requestCount++;
    }

    public int getRequestCount() {
        return requestCount;
    }
}
