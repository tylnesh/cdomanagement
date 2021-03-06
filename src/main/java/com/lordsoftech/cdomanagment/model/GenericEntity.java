package com.lordsoftech.cdomanagment.model;

import java.sql.Timestamp;

public interface GenericEntity<T> {

    Long getId();

    void update(T source);

    T createNewInstance();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();
}
