package services;

import DAO.IRequisitionDAO;
import lombok.RequiredArgsConstructor;
import model.Requisition;
import validation.RequisitionValidator;

import java.util.List;

@RequiredArgsConstructor
public class RequisitionServiceImpl implements IRequisitionService{

    private final IRequisitionDAO dao;
    private final RequisitionValidator validation = new RequisitionValidator();

    public Requisition create(Requisition requisition) {
        validation.validateRequisition(requisition);
        return dao.create(requisition);
    }

    public Requisition getById(int id) {
        return dao.getById(id);
    }

    public Requisition update(Requisition requisition) {
        return dao.update(requisition);
    }

    public List<Requisition> getList() {
        return dao.getList();
    }
}
