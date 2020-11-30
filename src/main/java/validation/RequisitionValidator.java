package validation;

import model.Requisition;

public class RequisitionValidator {

  public void validateRequisition(Requisition requisition) {
    if(requisition.getRefNo() == null){
      throw new RuntimeException("Ref no can't be null");
    }
  }
}
