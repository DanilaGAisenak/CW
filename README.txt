Программа по учету и комплектации фирм
информационными технологиями (ПО)

Клиент-серверное приложение для учёта комплектации фирм программным обеспечением

MVP:
1.	Регистрация пользователя (Фирмы) {
Регистрируем отдельно фирму, отдельно вносим то, что ниже
Получение информации о количестве рабочих станций, дата их покупки, установленном на них ПО, сроках действия лицензий, стоимость ПО, используемая ОС. }
2.Проверка срока действия лицензии ПО (Сравнить срок, указанный в информации о фирме с текущей датой)
3.Отслеживание срока эксплуатации Аппаратного Обеспечения (пользователь сам вводит срок окончания использования, мы оповещаем об этом) {
Расчетный срок эксплуатации ~ 3 года => Оставшийся расчётный срок использования … дней.
За n месяцев до окончания расчётного срока выдать напоминание о том, что срок использования подходит к концу.  }
4. Продление срока лицензии
5. Отказ от продления лицензии на ПО
6. Покупка лицензии на иное ПО { После оплаты, генерировать ключи и посылать клиенту. }
7. Авторизация пользователей
8. Просмотр информации о …
9. Просмотр действий за последние n дней
10. Фильтрация данных {
Показать по производителя MICROSOFT 
ИЛИ
Выбрать количество полей и вписать названия: «Срок службы АО, Установленное ПО, Срок лицензии ПО» }
11. Подсчёт стоимости лицензии на заданный срок {
Цена на 1 год * количество лет }
12. Сортировка данных
13. Автоматический подсчет суммы исходя из цены на 1 ключ * на количество ключей.
14. Оставить заявку на покупку АО
15. Ф-ия добавления продаваемого ПО (Админ)
16. Просмотр заявок
17. Аудит (Логировать действия пользователя)

Nice to have: 
1.	Выгрузить данные в текстовый файл (для печати)
2.	Процент комплектации фирмы ПО {
Какие программы на скольких машинах установлены.
Вывод: данным ПО укомплектовано n% от машин в фирме
}
