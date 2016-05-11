package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.SupplierEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ProductEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ProductReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ProductsListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Henry Benito on 4/21/2016.
 */
public class ProductSteps {
    @And("^I search \"([^\"]*)\" in products$")
    public void I_search_in_products(String name) throws Throwable {
        Search openERPSearch = new Search();

        ProductsListView productsListView = new ProductsListView();
        try {
            productsListView.clickOnRecord(name);
        } catch(NoSuchElementException nsse) {
            openERPSearch.advancedSearch("Name",name);
            Thread.sleep(3000);
            productsListView.clickOnRecord(name);
        }
        Thread.sleep(3000);
    }

    @And("^I modify the product with these \"([^\"]*)\" data$")
    public void I_modify_the_product_with_these_data(String tab, List<Product> inputData) throws Throwable {
        ProductEditForm productEditForm = new ProductEditForm();
        productEditForm.selectTab(tab);
        for (Product p : inputData) {
            productEditForm.modifyData(p);
            Thread.sleep(3000);
        }
    }

    @And("^I verify the product has( not|)? these \"([^\"]*)\" data$")
    public void I_verify_the_product_has_these_data(String hasOrNot, String tab, List<Product> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }
        ProductReadForm productReadForm = new ProductReadForm();
        productReadForm.selectTab(tab);

        for (Product item : expectedData) {
            Boolean auxResult = item.contains(shouldBeAble, productReadForm.getDataFromUI(item));
            if (auxResult) {result = true;}
        }
        Assert.assertTrue(result);
    }
}
