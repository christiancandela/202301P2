# Ejercicio: Diplomado

Un profesor de la Universidad del Quindío está interesado en la construcción de un sistema que le permita realizar la gestión de los estudiantes de un diplomado y sus notas. Para el profesor es importante poder calcular la definitiva de sus estudiantes, así como conocer quienes ganaron o perdieron un determinado parcial. Así mismo desea poder generar estadísticas de las notas basadas en género.

De cada estudiante se desea conocer su número de identificación, su nombre, su apellido, su correo electrónico, sus notas y su género.

El sistema debe permitir adicionar estudiantes a un diplomado, así mismo debe permitirse registrar las notas de dichos estudiantes.
El sistema debe permitir cancelar la inscripción de un estudiante al diplomado, siempre y cuando aún no se hayan sacado notas de dicho diplomado.
En caso de equivocarse al registrar una nota de un estudiante, debe ser posible modificar la nota.

De cada diplomado es importante conocer su nombre, su fecha de inicio, su fecha de finalización, su costo y los estudiantes registrados en el mismo.


Como ingenieros encargados del proyecto deberán generar un diagrama de clase con el diseño de una posible solución identificando con claridad los atributos y métodos de acceso. Adicionalmente, deberá identificar las funcionalidades de cada una de las clases.

Después de tener el diagrama de clases deberá diseñar las pruebas para cada uno de los métodos de sus clases.

Finalmente, deberán crear un prototipo a partir de su diagrama de clases y las pruebas diseñadas el cual contengas las pruebas unitarias. Para los métodos de acceso tenga en cuenta establecer las restricciones a las que haya lugar y generar las excepciones necesarias. 


# Soluciones

Basado en el ejercicio anterior se pueden generar varias soluciones. 

## [Diplomado 01](./diplomado_01)
Esta primera versión ilustra una posible solución, sin embargo, esta limitado a que cada instancia de estudiante solo pertenezca a un diplomado.



Genere versiones que no tengan este tipo de limitación 