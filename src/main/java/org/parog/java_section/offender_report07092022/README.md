# 20220907-1

Задачи экзамена по Java 07/09/2022 - экзаменуемый 1

Вы помогаете риэлторскому агентству оптимизировать свою работу.
Начали поступать жалобы, что риелторы приводят клиентов на один объект одновременно.
Перед вами стоит задача проанализировать данные и составлять отчет по нарушителям, которые чаще всего пересекаются с коллегами. 
Пересечением считается, если риелтор заходит на объект в тот момент, когда там уже находится его коллега. Нарушение идет
в счет всем участникам пересечения.
 
Результат следует вывести в файл следующим образом:
   - Каждая строка имеет формат <ФИО риелтора> - <кол-во нарушений>
   - Строки отсортированы по убыванию количества нарушений за весь период
   - Если количество нарушений совпадает, то сортируем по возрастанию ФИО риелтора
   - Имя результирующего файла result.txt
 
На вход подается три файла:
   - employee.csv:
       - Идентификатор риелтора
       - Фамилия
       - Имя
       - Отчество
   - realty.csv
       - Идентификатор объекта недвижимости
       - Тип недвижимости
       - Адрес
   - visit.csv
       - Идентификатор риелтора
       - Идентификатор объекта недвижимости
       - Дата/время прихода на объект
       - Дата/время ухода с объекта