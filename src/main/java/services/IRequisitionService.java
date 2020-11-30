package services;

import model.Requisition;

import java.util.List;

public interface IRequisitionService {
    Requisition create(Requisition requisition);
    Requisition getById(int id);
    Requisition update(Requisition requisition);
    List<Requisition> getList();
}
