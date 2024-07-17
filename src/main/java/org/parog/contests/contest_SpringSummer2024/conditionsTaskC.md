<h1 class="title">Яндекс (3 задание, Стажировка 2024, Контест)</h1>
<p><b>Время: 1 сек.<br>Память: 256 Мб<br>Сложность: Medium</b></p>
<p>С. Пересекающиеся отрезки</p>
<p>Даны два массива а и b длины N из целых чисел. Рассмотрим множество, состоящее из отрезков, соединяющих точки (0, а<sub>i</sub>) и (1, b<sub>i</sub>) для 1 ≤ i ≤ N. Найдите количество отрезков этого множества, которые не пересекаются с другими отрезками.</p>
<p>Например, если а = [1, 2, 3, 4, 5] и b = [4, 5, 1, 5, 6], получатся следующие отрезки:</p>
<img src="../../../../../resources/imgs/3.1.png"  alt=""/>
<p>Обратите внимание, что пересекающимися считаются отрезки, имеющие хотя бы одну общую точку. То есть отрезки, имеющие одинаковый конец, пересекаются. Например, на картинке отрезки, заданные точками [(0, 2), (1, 5)] и [(0,4), (1, 5)] считаются пересекающимися.</p>

<h2>Формат ввода</h2>
<p>В первой строке ввода находится единственное число N (1 ≤ N ≤ 3 * 10<sup>5</sup>) - количество отрезков.</p>
<p>В следующих N строках находится по два целых числа, разделенных пробелом - a<sub>i</sub> и b<sub>i</sub> (1 ≤ a<sub>i</sub>, b<sub>i</sub> ≤ 2 * N), задающие координаты і-го отрезка.</p>
<p>Гарантируется, что все отрезки, заданные во вводе различны, то есть при і &ne; ј выполнено не менее одного из условий а<sub>i</sub> &ne; a<sub>j</sub> и b<sub>i</sub> &ne; b<sub>j</sub>.</p>

<h2>Формат вывода</h2>
<p>Выведите единственное число - количество отрезков, которые не пересекаются с другими.</p>

<h2>Примечания</h2>
<p>В первом примере единственный отрезок, не пересекающийся с другими - отрезок с концами (0, 5) и (1,6).</p>

<h3>Примеры</h3>
<table class="sample-tests">
  <thead>
     <tr>
        <th>Ввод</th>
        <th>Вывод</th>
     </tr>
  </thead>
  <tbody>
     <tr>
        <td>5
        <br>1 4
        <br>2 5
        <br>3 1
        <br>4 5
        <br>5 6       
        </td>
        <td>1</td>
     </tr>
     <tr>
        <td>5
        <br>2 6
        <br>3 9
        <br>4 2
        <br>6 9
        <br>9 10      
        </td>
        <td>1</td>
     </tr>

  </tbody>
</table>