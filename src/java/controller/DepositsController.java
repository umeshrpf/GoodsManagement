package controller;

import jpa.Deposits;
import facade.DepositsFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "depositsController")
@ViewScoped
public class DepositsController extends AbstractController<Deposits> {

    @Inject
    private CustomersController customerIdController;

    public DepositsController() {
        // Inform the Abstract parent controller of the concrete Deposits Entity
        super(Deposits.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        customerIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Customers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomerId(ActionEvent event) {
        Deposits selected = this.getSelected();
        if (selected != null && customerIdController.getSelected() == null) {
            customerIdController.setSelected(selected.getCustomerId());
        }
    }

}
