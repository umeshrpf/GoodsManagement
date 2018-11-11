package controller;

import jpa.PriceConfiguration;
import facade.PriceConfigurationFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "priceConfigurationController")
@ViewScoped
public class PriceConfigurationController extends AbstractController<PriceConfiguration> {

    @Inject
    private CustomersController customerIdController;
    @Inject
    private GasInfoController gasTypeIdController;

    public PriceConfigurationController() {
        // Inform the Abstract parent controller of the concrete PriceConfiguration Entity
        super(PriceConfiguration.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        customerIdController.setSelected(null);
        gasTypeIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Customers controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomerId(ActionEvent event) {
        PriceConfiguration selected = this.getSelected();
        if (selected != null && customerIdController.getSelected() == null) {
            customerIdController.setSelected(selected.getCustomerId());
        }
    }

    /**
     * Sets the "selected" attribute of the GasInfo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGasTypeId(ActionEvent event) {
        PriceConfiguration selected = this.getSelected();
        if (selected != null && gasTypeIdController.getSelected() == null) {
            gasTypeIdController.setSelected(selected.getGasTypeId());
        }
    }

}
