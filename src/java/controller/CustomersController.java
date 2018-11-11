package controller;

import jpa.Customers;
import jpa.PriceConfiguration;
import jpa.CylinderTransaction;
import jpa.Deposits;
import java.util.Collection;
import facade.CustomersFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "customersController")
@ViewScoped
public class CustomersController extends AbstractController<Customers> {

    // Flags to indicate if child collections are empty
    private boolean isPriceConfigurationCollectionEmpty;
    private boolean isCylinderTransactionCollectionEmpty;
    private boolean isDepositsCollectionEmpty;

    public CustomersController() {
        // Inform the Abstract parent controller of the concrete Customers Entity
        super(Customers.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPriceConfigurationCollectionEmpty();
        this.setIsCylinderTransactionCollectionEmpty();
        this.setIsDepositsCollectionEmpty();
    }

    public boolean getIsPriceConfigurationCollectionEmpty() {
        return this.isPriceConfigurationCollectionEmpty;
    }

    private void setIsPriceConfigurationCollectionEmpty() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            this.isPriceConfigurationCollectionEmpty = ejbFacade.isPriceConfigurationCollectionEmpty(selected);
        } else {
            this.isPriceConfigurationCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of PriceConfiguration
     * entities that are retrieved from Customers and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PriceConfiguration page
     */
    public String navigatePriceConfigurationCollection() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            Collection<PriceConfiguration> selectedPriceConfigurationCollection = ejbFacade.findPriceConfigurationCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PriceConfiguration_items", selectedPriceConfigurationCollection);
        }
        return "/app/priceConfiguration/index";
    }

    public boolean getIsCylinderTransactionCollectionEmpty() {
        return this.isCylinderTransactionCollectionEmpty;
    }

    private void setIsCylinderTransactionCollectionEmpty() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            this.isCylinderTransactionCollectionEmpty = ejbFacade.isCylinderTransactionCollectionEmpty(selected);
        } else {
            this.isCylinderTransactionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CylinderTransaction
     * entities that are retrieved from Customers and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CylinderTransaction page
     */
    public String navigateCylinderTransactionCollection() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            Collection<CylinderTransaction> selectedCylinderTransactionCollection = ejbFacade.findCylinderTransactionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CylinderTransaction_items", selectedCylinderTransactionCollection);
        }
        return "/app/cylinderTransaction/index";
    }

    public boolean getIsDepositsCollectionEmpty() {
        return this.isDepositsCollectionEmpty;
    }

    private void setIsDepositsCollectionEmpty() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            this.isDepositsCollectionEmpty = ejbFacade.isDepositsCollectionEmpty(selected);
        } else {
            this.isDepositsCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Deposits entities that
     * are retrieved from Customers and returns the navigation outcome.
     *
     * @return navigation outcome for Deposits page
     */
    public String navigateDepositsCollection() {
        Customers selected = this.getSelected();
        if (selected != null) {
            CustomersFacade ejbFacade = (CustomersFacade) this.getFacade();
            Collection<Deposits> selectedDepositsCollection = ejbFacade.findDepositsCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Deposits_items", selectedDepositsCollection);
        }
        return "/app/deposits/index";
    }

}
