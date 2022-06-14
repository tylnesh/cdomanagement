package com.lordsoftech.cdomanagment.model;

import java.sql.Time;
import java.sql.Timestamp;

public interface GenericEntity<T> {

    Long getId();

    void update(T source);

    T createNewInstance();

    Time getCreatedAt();

    Time getUpdatedAt();
}