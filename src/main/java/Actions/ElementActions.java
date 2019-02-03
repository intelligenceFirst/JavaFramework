package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 8/4/2018.
 */
public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) { this.driver = driver; }

    /**
     * <b>Description:</b> Clear the text from a page element.
     * @param pageElement
     * @throws Exception
     */
    public void clear(By pageElement) throws Exception {
        try {
            driver.findElement(pageElement).clear();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Clicks a page element.
     * @param pageElement
     * @exception TimeoutException Gets thrown if the click action takes longer than the default timeout.
     */
    public void click(By pageElement) {
        try {
            driver.findElement(pageElement).click();
        } catch (Exception e) {
            if (e.getMessage().contains("timed out")) {
                throw new TimeoutException();
            } else {
                throw e;
            }
        }
    }

    /**
     * <b>Description:</b> Submits a page or element.
     * @param pageElement
     * @exception TimeoutException Gets thrown if the submit action takes longer than the default timeout.
     */
    public void submit(By pageElement) {
        try {
            driver.findElement(pageElement).submit();
        } catch (Exception e) {
            if (e.getMessage().contains("timed out")) {
                throw new TimeoutException();
            } else {
                throw e;
            }
        }
    }

    /**
     * <b>Description:</b> Checks if an element is displayed or not.
     * @param pageElement
     * @return
     */
    public boolean isElementDisplayed(By pageElement) {
        boolean isDisplayed = false;
        try {
            isDisplayed = driver.findElement(pageElement).isDisplayed();
        } catch (Exception e) {
        }

        return isDisplayed;
    }

    /**
     * <b>Description:</b> Checks if an element is enabled or not.
     * @param pageElement
     * @return
     */
    public boolean isElementEnabled(By pageElement) {
        boolean isEnabled = false;
        try {
            isEnabled = driver.findElement(pageElement).isEnabled();
        } catch (Exception e) {
        }

        return isEnabled;
    }

    /**
     * <b>Description:</b> Checks if an element is selected or not.
     * @param pageElement
     * @return
     */
    public boolean isElementSelected(By pageElement) {
        boolean isSelected = false;
        try {
            isSelected = driver.findElement(pageElement).isSelected();
        } catch (Exception e) {
        }

        return isSelected;
    }

    /**
     * <b>Description:</b> Enters text into a page element.
     * @param pageElement
     * @param text
     */
    public void type(By pageElement, String text) {
        try {
            driver.findElement(pageElement).sendKeys(text);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Retrieves text from a page element.
     * @param pageElement
     * @return
     */
    public String getText(By pageElement) {
        String text = "";
        try {
            text = driver.findElement(pageElement).getText();
        } catch (Exception e) {
            throw e;
        }

        return text;
    }

    /**
     * <b>Description:</b> Retrieves the tag name of an element.
     * @param pageElement
     * @return
     */
    public String getTagName(By pageElement) {
        String name = "";
        try {
            name = driver.findElement(pageElement).getTagName();
        } catch (Exception e) {
            throw e;
        }

        return name;
    }

    /**
     * <b>Description:</b> Retrieves the css value of an element.
     * @param pageElement
     * @param cssAttribute
     * @return
     */
    public String getCssValue(By pageElement, String cssAttribute) {
        String value = "";
        try {
            value = driver.findElement(pageElement).getCssValue(cssAttribute);
        } catch (Exception e) {
            throw e;
        }

        return value;
    }

    /**
     * <b>Description:</b> Retrieves an attribute value of an element.
     * @param pageElement
     * @param attribute
     * @return
     */
    public String getAttribute(By pageElement, String attribute) {
        String a = "";
        try {
            a = driver.findElement(pageElement).getAttribute(attribute);
        } catch (Exception e) {
            throw e;
        }

        return a;
    }

    /**
     * <b>Description:</b> Selects a dropdown value or multi-select value by text.
     * @param dropdown
     * @param text
     */
    public void selectDropdownValueByText(By dropdown, String text) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Selects a dropdown value or multi-select value by index.
     * @param dropdown
     * @param index
     */
    public void selectDropdownValueByIndex(By dropdown, int index) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.selectByIndex(index);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Selects a dropdown value or multi-select value by value.
     * @param dropdown
     * @param value
     */
    public void selectDropdownValueByValue(By dropdown, String value) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.selectByValue(value);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Retrieves the first selected dropdown option.
     * @param dropdown
     * @return
     */
    public String getSelectedDropdownOption(By dropdown) {
        String option = "";
        try {
            Select select = new Select(driver.findElement(dropdown));
            option = select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            throw e;
        }

        return option;
    }

    /**
     * <b>Description:</b> Retrieves the selected dropdown options.
     * @param dropdown
     * @return
     */
    public List<String> getSelectedDropdownOptions(By dropdown) {
        List<WebElement> selectedOptionWebElements;
        List<String> selectedOptionStrings = new ArrayList<>();

        try {
            Select select = new Select(driver.findElement(dropdown));
            selectedOptionWebElements = select.getAllSelectedOptions();

            for (WebElement el : selectedOptionWebElements) {
                selectedOptionStrings.add(el.getText());
            }
        } catch (Exception e) {
            throw e;
        }

        return selectedOptionStrings;
    }

    /**
     * <b>Description:</b> Retrieves the selected dropdown options count.
     * @param dropdown
     * @return
     */
    public int getSelectedDropdownOptionsCount(By dropdown) {
        int count;

        try {
            Select select = new Select(driver.findElement(dropdown));
            count = select.getAllSelectedOptions().size();
        } catch (Exception e) {
            throw e;
        }

        return count;
    }

    /**
     * <b>Description:</b> Checks if a given dropdown option is selected.
     * @param dropdown
     * @param option
     * @return
     */
    public boolean isDropdownOptionSelected(By dropdown, String option) {
        boolean isSelected = false;

        try {
            List<String> selectedOptions = getSelectedDropdownOptions(dropdown);

            for (String o : selectedOptions) {
                if (o.equals(option)) {
                    isSelected = true;
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return isSelected;
    }

    /**
     * <b>Description:</b> Retrieves the dropdown options.
     * @param dropdown
     * @return
     */
    public List<WebElement> getDropdownOptions(By dropdown) {
        List<WebElement> options;

        try {
            Select select = new Select(driver.findElement(dropdown));
            options = select.getOptions();
        } catch (Exception e) {
            throw e;
        }

        return options;
    }

    /**
     * <b>Description:</b> Retrieves the dropdown option count.
     * @param dropdown
     * @return
     */
    public int getDropdownOptionsCount(By dropdown) {
        int count;

        try {
            count = getDropdownOptions(dropdown).size();
        } catch (Exception e) {
            throw e;
        }

        return count;
    }

    /**
     * <b>Description:</b> Checks whether the page element is multi-select.
     * @param pageElement
     * @return
     */
    public boolean isMultiSelect(By pageElement) {
        boolean isMulti = false;

        try {
            Select select = new Select(driver.findElement(pageElement));
            isMulti = select.isMultiple();
        } catch (Exception e) {
            throw e;
        }

        return isMulti;
    }

    /**
     * <b>Description:</b> Deselects all selected dropdown options.
     * @param dropdown
     */
    public void deselectAll(By dropdown) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.deselectAll();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Deselects a dropdown option by text.
     * @param dropdown
     * @param text
     */
    public void deselectByText(By dropdown, String text) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.deselectByVisibleText(text);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Deselects a dropdown option by index.
     * @param dropdown
     * @param index
     */
    public void deselectByIndex(By dropdown, int index) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.deselectByIndex(index);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Deselects a dropdown option by value.
     * @param dropdown
     * @param value
     */
    public void deselectByValue(By dropdown, String value) {
        try {
            Select select = new Select(driver.findElement(dropdown));
            select.deselectByValue(value);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Hovers over a page element.
     * @param pageElement
     */
    public void hover(By pageElement) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(pageElement)).build().perform();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Hovers over a page element and waits for a given element to be visible.
     * @param pageElement
     * @param waitElement
     * @param maxWaitTimeInSeconds
     */
    public void hover(By pageElement, By waitElement, int maxWaitTimeInSeconds) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(pageElement)).build().perform();

            waitForElementToBeDisplayed(waitElement, maxWaitTimeInSeconds);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Hovers over a page element and clicks a sub-element.
     * @param topElement
     * @param subElement
     */
    public void hoverAndClick(By topElement, By subElement) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(topElement)).click(driver.findElement(subElement)).build().perform();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Hovers over a page element and clicks a sub-element.
     * @param topElement
     * @param subElement
     * @param maxWaitTimeInSeconds
     */
    public void hoverAndClick(By topElement, By subElement, int maxWaitTimeInSeconds) {
        try {
            hover(topElement);
            waitForElementToBeDisplayed(subElement, maxWaitTimeInSeconds);
            click(subElement);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Switches to an iFrame by name.
     * @param iframeName
     */
    public void switchToIframe(String iframeName) {
        try {
            driver.switchTo().frame(iframeName);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Switches to default content.
     */
    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Retrieves a list of web elements from a page.
     * This method should be used when trying to retrieve a list of elements that are not located in a Select element (such as a dropdown or list box).
     * If you want to create a list of elements from a Select element then you should use {@link #getDropdownOptions(By)}
     * @param element
     * @return
     */
    public List<WebElement> getElementsAsList(By element) {
        List<WebElement> elements = null;

        try {
            elements = driver.findElements(element);
        } catch (Exception e) {
            throw e;
        }

        return elements;
    }

    /**
     * <b>Description:</b> Waits for an element to be displayed.
     * @param pageElement
     * @param timeoutInSeconds
     */
    public void waitForElementToBeDisplayed(By pageElement, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(pageElement));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Waits for an element to not be displayed.
     * @param pageElement
     * @param timeoutInSeconds
     */
    public void waitForElementToNotBeDisplayed(By pageElement, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(pageElement));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Waits for an element to be clickable.
     * @param pageElement
     * @param timeoutInSeconds
     */
    public void waitForElementToBeClickable(By pageElement, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(pageElement));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Waits for an alert to be displayed.
     * @param timeoutInSeconds
     */
    public void waitForAlertToBeDisplayed(int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            throw e;
        }
    }
}
