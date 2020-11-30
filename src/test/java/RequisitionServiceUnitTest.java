import DAO.IRequisitionDAO;
import model.Requisition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.RequisitionServiceImpl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class RequisitionServiceUnitTest {

    @Mock
    IRequisitionDAO dao;

    @InjectMocks
    private RequisitionServiceImpl service;

    @BeforeEach
    public  void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRequisitionsReturnsSingletonList() {
        when(dao.getList()).thenReturn(Collections.singletonList(new Requisition()));
        List<Requisition> requisitions = service.getList();
        Assertions.assertTrue(requisitions.size() > 0);
    }

    @Test
    public void createRequisitionTestReturnsData() {
        Requisition model = this.buildRequisition();
        when(dao.create(model)).thenReturn(model);
        Requisition createdModel = service.create(model);
        Assertions.assertEquals(createdModel.getId(), 0);
    }

    @Test
    void createRequisitionWithNullReferenceNoThrowsException() {
        //Arrange
        Requisition model = this.buildRequisition();
        model.setRefNo(null);
        when(dao.create(model)).thenReturn(model);

        //Act
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {service.create(model);});
        String expectedMessage = "Ref no can't be null";

        //Assert
        Assertions.assertTrue(exception.getMessage().contains(expectedMessage));
    }

    private Requisition buildRequisition(){
        Requisition requisition = new Requisition();
        requisition.setId(0);
        requisition.setRefNo("Test ref");
        requisition.setReqDate(new Date());
        return requisition;
    }

}
