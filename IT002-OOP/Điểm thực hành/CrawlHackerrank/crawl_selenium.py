import pandas as pd
from selenium import webdriver
from selenium import webdriver
import chromedriver_binary  # Adds chromedriver binary to path
from selenium.webdriver.common.by import By
import requests
def valid_url(url):
    req = requests.get(url)
    print( req.status_code)

def read_score_sheet(class_name, sub_class):
    sheet = pd.read_excel('../' + class_name + '/' + sub_class + '.xlsx')
    return sheet

def crawl_score(class_name, join_class, sub_class, lab, contest_name):
    df = read_score_sheet(class_name, sub_class)

    for i in range(1, 100):
        url = 'https://www.hackerrank.com/contests/' + contest_name + '/leaderboard/' + str(i)

        print(url)
        driver = webdriver.Chrome()
        driver.get(url)
        table = driver.find_element(by=By.XPATH, value = '//*[@id="leaders"]')
        data = [item.text for item in table.find_elements(by = By.XPATH, value = '//*[@class="leaderboard-list-view"]')]
        if len(data) == 0:
            driver.quit()
            df.to_excel('../' + class_name + '/' + sub_class + '.xlsx', index=False)
            return
  
    
        for item in data:
            item_collection = item.splitlines()
            id = (item_collection[1])[-8:]
            if id.isdigit():
                id = int(id)
                print(item_collection)
                score = float(item_collection[2])
                time = item_collection[3]
                index = (df.index[df['ID'] == id].tolist())
                df.loc[index, lab] = score

    driver.quit()
    df.to_excel('../' + class_name + '/' + sub_class + '.xlsx', index=False)

class_name = 'it002n24'

for class_name in ['it002n211', 'it002n212']:
    for join_class in [1,2]:
        for lab in [1,2,3,4,5]:
            sub_class = class_name + str(join_class)
            contest_name = f'bai-tap-thuc-hanh-lab-{lab}-{class_name[:5]}-{class_name[5:]}-{join_class}'
            # contest_name = f'bai-tap-thuc-hanh-lab-{lab}-{class_name}-{join_class}'
            print(contest_name)
            crawl_score(class_name, join_class, sub_class, lab, contest_name)