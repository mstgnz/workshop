import requests
import xmltodict
import json

try:
    url = "https://www.tcmb.gov.tr/kurlar/today.xml"

    doviz = input("Döviz Kodu Giriniz : ")
    miktar = float(input("Miktar : "))
    result = 0

    response = requests.get(url)
    data = json.loads(json.dumps(xmltodict.parse(response.content)))

    for i in data['Tarih_Date']['Currency']:
        if i['@Kod'] == doviz:
            result = miktar * float(i['ForexBuying'])

    print("{} {} {} Türk Lirasıdır".format(miktar, doviz, result))

except:
    print("Bir hata oldu sanki")
