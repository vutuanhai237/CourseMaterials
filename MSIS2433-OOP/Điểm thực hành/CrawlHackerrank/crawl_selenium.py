import pandas as pd
from selenium import webdriver
from selenium import webdriver
import chromedriver_binary  # Adds chromedriver binary to path
from selenium.webdriver.common.by import By

class_name = 'msis2433-n12-cttt-1'
file_name = 'MSIS2433.N12.CTTT.1.xlsx'
lab = 5
contest_name = 'lab-' + str(lab) + '-' + class_name
print(contest_name)

def read_score_sheet():
    sheet = pd.read_excel('../' + file_name)
    return sheet

def crawl_score():
    df = read_score_sheet()
    index = df.index
    num_rows = len(index)
    num_pages = int(num_rows / 10)
    
    for i in range(1, num_pages + 1):
        url = 'https://www.hackerrank.com/contests/' + contest_name + '/leaderboard/' + str(i)
        driver = webdriver.Chrome()
        driver.get(url)
        table = driver.find_element(by=By.XPATH, value = '//*[@id="leaders"]')

        data = [item.text for item in table.find_elements(by = By.XPATH, value = '//*[@class="leaderboard-list-view"]')]

        
        for item in data:
            item_collection = item.splitlines()
            id = (item_collection[1])[-8:]
            if id.isdigit():
                id = int(id)
                print(id)
                print(item_collection)
                score = float(item_collection[2])
                time = item_collection[3]
                index = (df.index[df['ID'] == id].tolist())
                df.loc[index, lab] = score

    driver.quit()
    df.to_excel('../' + file_name, index=False)

crawl_score()