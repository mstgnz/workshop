import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="CelalBayar"
)

cursor = mydb.cursor()

# Her bir crud işlemi için methodlar detaylı yazılacaktır

def fetchOne(sql):
    cursor.execute(sql)
    result = cursor.fetchone()
    return result

def fetchAll(sql):
    cursor.execute(sql)
    result = cursor.fetchall()
    return result

def column(tablo):
    sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '{}' AND table_name = '{}'".format(mydb.database, tablo)
    result = [i[0] for i in fetchAll(sql)]
    return result

def exists(tablo):
    sql = "SELECT * FROM information_schema.tables WHERE table_schema = '{}' AND table_name = '{}'".format(mydb.database, tablo)
    result = fetchOne(sql)
    return result

def tableList():
    tableList = cursor.execute("SHOW DATABASES")
    result = [x[0] for x in tableList]
    return result

def select(sql, tablo):
    #columns =  column(tablo)
    result = fetchAll(sql)
    return result

def insert(sql):
    result = fetchOne(sql)
    return result

def update(sql):
    result = fetchOne(sql)
    return result

def delete(sql):
    result = fetchOne(sql)
    return result

def create(sql):
    result = fetchOne(sql)
    return result


#print(fetchAll("select * from ogrencibilgi where id=2"))
#print(select("select * from ogrencibilgi", "ogrencibilgi"))
