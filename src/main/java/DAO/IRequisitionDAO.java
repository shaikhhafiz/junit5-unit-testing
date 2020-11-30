package DAO;

import model.Requisition;

import java.util.List;

public interface IRequisitionDAO {
    Requisition create(Requisition requisition);
    Requisition getById(int id);
    Requisition update(Requisition requisition);
    List<Requisition> getList();
}
