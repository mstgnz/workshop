use test;

/* 
    test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
*/
create table employee(
    id integer primary key,
    name VARCHAR(50) not null,
    birthday DATE not null,
    email VARCHAR(100) not null
)

/*
    Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
*/
odev8-mock.sql


/*
    Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
*/
update employe set name="Mesut" where email="mesutgenez@hotmail.com";
update employe set name="Mesut" where id=1 and email="mesutgenez@hotmail.com";
update employe set name="Mesut", birthday="1985-09-17" where email="mesutgenez@hotmail.com";
update employe set email="mesutgenez@hotmail.com", birthday="1985-09-17" where id=1;
update employe set birthday="1985-09-17" where id=1 and name="Mesut";


/*
    Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
*/
delete from employee where id=1;
delete from employee where email="mesutgenez@hotmail.com";
delete from employee where name="Mesut";
delete from employee where birthday="1985-09-17";
delete from employee where email="mesutgenez@hotmail.com" and birthday="1985-09-17";
delete from employee where name="Mesut" and email not in ("mesutgenez@hotmail.com");
