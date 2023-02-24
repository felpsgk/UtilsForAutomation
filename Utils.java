public class Utils {
  
  protected void defineWait(WebDriver driver, int time) {    
    WebDriverWait waitTime = new WebDriverWait(driver, (long) time);
  }
  
  protected boolean waitTheTimeForBy(By locator, int time) {    
    WebDriverWait waitTime = new WebDriverWait(driver, (long) time);
    try {        
      waitTime.until(ExpectedConditions.visibilityOfElementLocated(locator));        
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
      waitTime.until(ExpectedConditions.visibilityOfElementLocated(locator));        
      result = true;  // Elemento foi encontrado
    } catch (Exception var4) {        
      result = false;  // Elemento NÃO foi encontrado 
    }
  }
}
