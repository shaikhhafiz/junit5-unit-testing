package model;

import lombok.Data;

import java.util.Date;

@Data
public class Requisition {
    private int id;
    private String refNo;
    private Date reqDate;
}
