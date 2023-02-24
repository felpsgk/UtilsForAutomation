
public Class Utils {
  
  public void waitUntilPageReady() {   
    StopWatch timeOut = new StopWatch();   
    timeOut.start();   
    while (timeOut.getTime() <= this.timeOutDefault) {    
      if (this.javaScriptExecutor.executeScript("return document.readyState", new Object[0]).toString().equals("complete")) {     
        timeOut.stop();        
        break;      
      }  
    }
  }
  
  protected WebElement waitForElement(By locator) {    
    this.waitUntilPageReady();    
    DriverFactory.setWait.until(ExpectedConditions.presenceOfElementLocated(locator));    
    WebElement element = this.driver.findElement(locator);    
    this.wait.until(ExpectedConditions.elementToBeClickable(element));    
    return element;
  }
 
  protected boolean waitTheTimeForBy(By locator, int time) {    
    WebDriverWait waitTime = new WebDriverWait(driver, (long) time);
    try {        
      DriverFactory.setWait.until(ExpectedConditions.visibilityOfElementLocated(locator));        
      return true; 
    } catch (Exception var4) {        
      return false;    
    }    
  }
  
  protected boolean isElementNotPresentByTime(String driver, By locator, int time) {    
    WebDriverWait waitTime = new WebDriverWait(DriverFactory.getDriver(driver), time);    
    try {       
      DriverFactory.getDriver(driver).findElement(locator);     
      return false; // Elemento foi encontrado, portanto, NÃO esta ausente    
    } catch (NoSuchElementException e) {           
      return true; // Elemento NÃO foi encontrado, portanto, ESTÁ ausente    
    }
  }
  
  protected boolean returnIfElementIsVisible(By locator) {  
    WebDriverWait waitTime = new WebDriverWait(DriverFactory.getDriver(driver), time);    
    try {       
      DriverFactory.setWait.until(ExpectedConditions.visibilityOfElementLocated(locator));        
      result = true;  // Elemento foi encontrado
    } catch (Exception var4) {        
      result = false;  // Elemento NÃO foi encontrado 
    }
  }
  
  protected void click(By locator) {    
      WebElement element = null;   
      try {           
        element = waitTheTimeForBy(locator);           
        element.click();           
        return;     
      } catch (ElementClickInterceptedException | StaleElementReferenceException var6) {     
      } catch (WebDriverException var7) {   
      }  
  }
  
}
