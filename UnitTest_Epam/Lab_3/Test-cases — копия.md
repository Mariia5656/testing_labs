ТЕСТ КЕЙСЫ
1) CООБЩЕНИЕ-УВЕДОМЛЕНИЕ ПРИ ВЫБОРЕ МАКСИМАЛЬНО ДОПУСТИМОГО ЧИСЛА ПАССАЖИРОВ:
Set up:
Зайти на www.aircanada.com
Steps:
1.	В форме бронирования находим поле PASSANGERS
2.	В поле PASSANGERS нажимаем на выпадающее меню
3.	В поле Adult выбираем 10 пассажиров

Expected result: Появляется уведомление «You have selected more than 9 passengers. Find more about travelling as a group»

2) СООБЩЕНИЕ О НЕВОЗМОЖНОСТИ ПУТЕШЕСТВИЯ РЕБЕНКА ВОЗРАСТОМ МЕНЬШЕ 8 БЕЗ СОПРОВОЖДЕНИЯ ВЗРОСЛОГО:
Set up:
Зайти на www.aircanada.com
Steps:
1.	В форме бронирования находим поле PASSANGERS
2.	В поле Passanger нажимаем на выпадающее меню
3.	В поле Adult выбираем 0 взрослых
4.	В поле Youth выбираем 0 подростков
5.	В поле Children выбираем 1 ребенка
6.	Нажать на кнопку Find

Expected result: «Children under age 8 must travel with an adult age 16 or older. Children ages 8 to 11 can travel alone but you'll need to contact Air Canada Reservations at least 48 hours before departure to purchase their ticket and request our Unaccompanied Minor service.»

3) НЕПОЛНОЕ ЗАПОЛНЕНИЕ ПОЛЕЙ:
Set up:
Зайти на www.aircanada.com
Steps:
1.	В форме бронирования оставить все поля незаполненными
2.	Нажать на кнопку «Find»

Expected result: «We can't seem to locate the destination you've entered. Please try again.»

4) ВВОД НЕВЕРНОГО «PROMOTION CODE»
Set up:
Зайти на www.aircanada.com
Steps:
1.	Заполнить все поля (FROM, TO DEPART, RETURN, PASSANGER) валидными данными, кроме поля PROMOTION CODE
2.	Вводим не валидный promotion code в поле PROMOTION CODE
3.	Нажать кнопку Find

Expected result: «The Promotion Code you entered doesn't exist or is expired. Make sure you entered it correctly»

5) ПОИСК СТАТУСА ПОЛЕТА НЕВОЗМОЖЕН:
Set up:
Зайти на www.aircanada.com
Steps:
1.	Заходим в раздел Flight Status
2.	Вводим не валидный номер рейса в поле АС FLIGHT NUMBER
3.	Нажать кнопку Find

Expected result: поле подсвечивается уведомлением «The flight number you entered appears to be incorrect. Please validate the flight number and try again»

6) СООБЩЕНИЕ ОБ ОШИБКЕ ПРИ ВВОДЕ НЕПРАВИЛЬНОГО ГОРОДА:
Set up:
Зайти на www.aircanada.com
Steps:
1.	В форме бронирования находим поле FROM
2.	Вводим не валидное название города в поле FROM

Expected result: поле подсвечивается уведомлением «We weren't able to find the location you're looking for. Please try re-entering it or choose another location.
Note: When you enter a country, region, state, province or city name in the search field, a choice of destinations will be displayed»

7) НЕВОЗМОЖНОСТЬ ВЫБОРА ДАТЫ ПРИЛЕТА РАНЕЕ ДАТЫ ВЫЛЕТА:
Set up:
Зайти на www.aircanada.com
Steps:
1.	В форме бронирования находим поля DEPART и RETURN
2.	Выбираем дату вылета в поле DEPART из открывшегося (после клика на поле) календаря
3.	Выбираем дату прилета в поле RETURN из открывшегося календаря, которая раньше, чем дата вылета

Expected result: выбранная в RETURN дата автоматически переносится на поле DEPART, а поле RETURN остается пустым

8) ПРОСМОТР МОИХ ЗАКАЗОВ И ПОЛЕТОВ:
Set up:
Зайти на www.aircanada.com
Steps:
1.	Перейти в раздел My Bookings
2.	Ввести не валидные данные в поле BOOKING REFERENCE
3.	Нажать кнопку Find

Expected result: поле подсвечивается уведомлением «Your Booking Reference is a sequence comprised of six letters and/or numbers. It can be found on the Itinerary/Receipt you received after completing your booking. Please make any necessary corrections and try again, or call Air Canada Reservations for assistance»

9) ПРОЦЕНТ БРОНИ В КОНКРЕТНОЙ ГОСТИНИЦЕ УВЕЛИЧИВАЕТСЯ:
Set up:
Зайти на www.aircanada.com
Steps:
1.	Зайти в раздел брони гостиниц и отелей Hotels
2.	Ввести валидные данные во все поля (LOCATION, DEPART, RETURN)
3.	В поле GUESTS нажимаем на выпадающий список
4.	Заполняем поля Adults и Children
5.	Нажимаем кнопку Add a room
6.	Поля Adult и Children заполняем значениями «0»
7.	Нажимаем Find

Expected result: Уведомление под полем GUESTS «Please select at least one adult guest per room»


10) НЕВОЗМОЖНОСТЬ ВОЗВРАТА АВТОМОБИЛЯ РАНЬШЕ ВРЕМЕНИ ЕГО ВЫЗОВА:
Set up:
Зайти на www.aircanada.com
Steps:
1.	Зайти в раздел заказа автомобилей Cars
2.	Выбрать время вызова в блоке Pick-up

Expected result: Время возврата в блоке Return автоматически становится таким же, как и в блоке Pick-up.
