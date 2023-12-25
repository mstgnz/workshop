use test;

/* 
    city tablosu ile country tablosunda bulunan şehir (city) ve ülke (country) isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.
*/
select city.name, country.name from city inner join country on country.id = city.country_id;

/*
    customer tablosu ile payment tablosunda bulunan payment_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.
*/
select payment.payment_id, customer.first_name, customer.last_name from customer inner join payment on payment.customer_id = customer_id;


/*
    customer tablosu ile rental tablosunda bulunan rental_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.
*/
select rental.rental_id, customer.first_name, customer.last_name from customer inner join rental on rental.customer_id = customer.id;