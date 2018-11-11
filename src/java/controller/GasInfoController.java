package controller;

import jpa.GasInfo;
import jpa.PriceConfiguration;
import jpa.Cylinders;
import java.util.Collection;
import facade.GasInfoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "gasInfoController")
@ViewScoped
public class GasInfoController extends AbstractController<GasInfo> {

    // Flags to indicate if child collections are empty
    private boolean isPriceConfigurationCollectionEmpty;
    private boolean isCylindersCollectionEmpty;

    public GasInfoController() {
        // Inform the Abstract parent controller of the concrete GasInfo Entity
        super(GasInfo.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPriceConfigurationCollectionEmpty();
        this.setIsCylindersCollectionEmpty();
    }

    public boolean getIsPriceConfigurationCollectionEmpty() {
        return this.isPriceConfigurationCollectionEmpty;
    }

    private void setIsPriceConfigurationCollectionEmpty() {
        GasInfo selected = this.getSelected();
        if (selected != null) {
            GasInfoFacade ejbFacade = (GasInfoFacade) this.getFacade();
            this.isPriceConfigurationCollectionEmpty = ejbFacade.isPriceConfigurationCollectionEmpty(selected);
        } else {
            this.isPriceConfigurationCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of PriceConfiguration
     * entities that are retrieved from GasInfo and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PriceConfiguration page
     */
    public String navigatePriceConfigurationCollection() {
        GasInfo selected = this.getSelected();
        if (selected != null) {
            GasInfoFacade ejbFacade = (GasInfoFacade) this.getFacade();
            Collection<PriceConfiguration> selectedPriceConfigurationCollection = ejbFacade.findPriceConfigurationCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PriceConfiguration_items", selectedPriceConfigurationCollection);
        }
        return "/app/priceConfiguration/index";
    }

    public boolean getIsCylindersCollectionEmpty() {
        return this.isCylindersCollectionEmpty;
    }

    private void setIsCylindersCollectionEmpty() {
        GasInfo selected = this.getSelected();
        if (selected != null) {
            GasInfoFacade ejbFacade = (GasInfoFacade) this.getFacade();
            this.isCylindersCollectionEmpty = ejbFacade.isCylindersCollectionEmpty(selected);
        } else {
            this.isCylindersCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cylinders entities that
     * are retrieved from GasInfo and returns the navigation outcome.
     *
     * @return navigation outcome for Cylinders page
     */
    public String navigateCylindersCollection() {
        GasInfo selected = this.getSelected();
        if (selected != null) {
            GasInfoFacade ejbFacade = (GasInfoFacade) this.getFacade();
            Collection<Cylinders> selectedCylindersCollection = ejbFacade.findCylindersCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cylinders_items", selectedCylindersCollection);
        }
        return "/app/cylinders/index";
    }

}
