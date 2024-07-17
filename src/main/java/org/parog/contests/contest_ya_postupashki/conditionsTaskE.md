### Задача 4 - E. Близость

|                        | Все языки |
| ---------------------- | --------- |
| Ограничения по времени | 4 секунды |
| Ограничения памяти     | 256MB     |
Определим близость двух целочисленных массивов как длину их наибольшего совпадающего префикса (см. примечание).

Примеры:
- ﻿﻿Близость [1, 2, 1, 3] и [1, 2, 3, 2] равна 2 — префикс [1, 2] совпадает;
- ﻿﻿Близость [1, 2, 3] и [3, 2, 1] равна 0.

Дано n целочисленных массивов a1, а2,..., аn.

Необходимо вычислить сумму близостей массивов аi и аj для каждой пары 1 ≤ i < j≤ n.
#### Формат ввода
Первая строка содержит одно целое число n (1 ≤ n ≤ 3 * 10^5) — количество массивов.
Каждый массив задаётся двумя строками.

Первая строка описания массива содержит единственное целое число ki (1 < k ≤ 3 * 10^5) -
размер і-го массива.

Вторая строка описания содержит ki целых чисел aij (1 ≤ aij ≤ 10^9) - элементы i-го
массива.

Гарантируется, что сумма от i=1 до n, где ki <= 3 * 10^5
#### Формат вывода
Выведите единственное целое число — суммарную попарную близость массивов.
#### Примеры

| Ввод                                     | Вывод |
| ---------------------------------------- | ----- |
| 3<br>2<br>1 2<br>2 <br>1 3<br>3<br>1 2 3 | 4     |
| 3<br>1<br>5<br>2 <br>1 2<br>3<br>5 1 2   | 1     |
