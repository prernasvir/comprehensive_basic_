import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    yield driver
    driver.quit()

def test_process_discovery(browser):
    # 1. Open the Automation Anywhere website.
    browser.get("https://www.automationanywhere.com/")

    # 2. Do Mouse over on Products.
    products_menu = browser.find_element(By.XPATH, "//a[contains(text(), 'Products')]")
    action = ActionChains(browser)
    action.move_to_element(products_menu).perform()

    # 3. Click on Process Discovery.
    process_discovery_link = browser.find_element(By.XPATH, "//a[contains(text(), 'Process Discovery')]")
    process_discovery_link.click()

    # 4. Verify that it's navigating to the correct URL.
    expected_url = "https://www.automationanywhere.com/products/process-discovery"
    assert browser.current_url == expected_url, f"Expected URL: {expected_url}, Actual URL: {browser.current_url}"

if __name__ == "__main__":
    pytest.main(['-v', 'test_automationanywhere.py'])
