package controller;

import jpa.Cylinders;
import jpa.CylinderTransaction;
import java.util.Collection;
import facade.CylindersFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cylindersController")
@ViewScoped
public class CylindersController extends AbstractController<Cylinders> {

    @Inject
    private GasInfoController gasTypeIdController;

    // Flags to indicate if child collections are empty
    private boolean isCylinderTransactionCollectionEmpty;

    public CylindersController() {
        // Inform the Abstract parent controller of the concrete Cylinders Entity
        super(Cylinders.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        gasTypeIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCylinderTransactionCollectionEmpty();
    }

    public boolean getIsCylinderTransactionCollectionEmpty() {
        return this.isCylinderTransactionCollectionEmpty;
    }

    private void setIsCylinderTransactionCollectionEmpty() {
        Cylinders selected = this.getSelected();
        if (selected != null) {
            CylindersFacade ejbFacade = (CylindersFacade) this.getFacade();
            this.isCylinderTransactionCollectionEmpty = ejbFacade.isCylinderTransactionCollectionEmpty(selected);
        } else {
            this.isCylinderTransactionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CylinderTransaction
     * entities that are retrieved from Cylinders and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CylinderTransaction page
     */
    public String navigateCylinderTransactionCollection() {
        Cylinders selected = this.getSelected();
        if (selected != null) {
            CylindersFacade ejbFacade = (CylindersFacade) this.getFacade();
            Collection<CylinderTransaction> selectedCylinderTransactionCollection = ejbFacade.findCylinderTransactionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CylinderTransaction_items", selectedCylinderTransactionCollection);
        }
        return "/app/cylinderTransaction/index";
    }

    /**
     * Sets the "selected" attribute of the GasInfo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGasTypeId(ActionEvent event) {
        Cylinders selected = this.getSelected();
        if (selected != null && gasTypeIdController.getSelected() == null) {
            gasTypeIdController.setSelected(selected.getGasTypeId());
        }
    }

}
