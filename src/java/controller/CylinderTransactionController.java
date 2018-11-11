package controller;

import jpa.CylinderTransaction;
import facade.CylinderTransactionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cylinderTransactionController")
@ViewScoped
public class CylinderTransactionController extends AbstractController<CylinderTransaction> {

    @Inject
    private CustomersController customerIdController;
    @Inject
    private CylindersController cylinderIdController;

    public CylinderTransactionController() {
        // Inform the Abstract parent controller of the concrete CylinderTransaction Entity
        super(CylinderTransaction.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        customerIdController.setSelected(null);
        cylinderIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Customers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomerId(ActionEvent event) {
        CylinderTransaction selected = this.getSelected();
        if (selected != null && customerIdController.getSelected() == null) {
            customerIdController.setSelected(selected.getCustomerId());
        }
    }

    /**
     * Sets the "selected" attribute of the Cylinders controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCylinderId(ActionEvent event) {
        CylinderTransaction selected = this.getSelected();
        if (selected != null && cylinderIdController.getSelected() == null) {
            cylinderIdController.setSelected(selected.getCylinderId());
        }
    }

}
