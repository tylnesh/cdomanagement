package com.lordsoftech.cdomanagment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StatusList {
    private List<Status> list;
}
