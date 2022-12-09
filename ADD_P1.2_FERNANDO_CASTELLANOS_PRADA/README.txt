El programa se accede a través de la clase MAINP12

Una vez accedes te pide ingresar usuario y contraseña, en este caso si el usuario no es administrador entra de todas formas al juego.

Si es administrador tiene más opciones que si no lo es.

El flujo del programa es el siguiente:
1- Nada más cargar el programa crea el fichero XML con unas preguntas iniciales, si el XML ya está creado no hace nada.
2- Accede al menu donde se encuentran las diferentes opciones:
	- 1 - Jugar: El programa lee del XML las preguntas y las carga en un ArrayList, el programa va mostrando las preguntas
		y los resultados de las mismas. Una vez acabado el juego crea un PDF, el nombre de este PDF son las iniciales al
		registrar la puntuación.
	- 2 - Añadir preguntas: Pregunta por consola que pregunta y respuestas quiere incorporar, una vez se complete se escriben en el XML.
	- 3 - Importar preguntas: Lee el archivo preguntas.xls e incorpora estas preguntas al XML.
	- 4 - Ver records: Lee el TXT lo guarda en un arrayList lo ordena y lo muestra de mayor a menor.
	- 5 - Instrucciones: Carga del DAO el arrayList con las preguntas cargadas y da las instrucciones, del arraYlist saca el número
		de preguntas que contiene el juego en ese momento.

Se han creado diferentes paquetes para gestionar todo el programa:
- add.p12.DAO
	- DAOService: Da servicio a las operaciones que hay que realizar con los DAO de preguntaDAO y UsuarioDAO.
	- PreguntaDAO: Es desde donde se accede al ArrayList de preguntas.
	- Usuario: Clase POJO de usuario del login inicial.
	- UsuarioDAO: Es desde donde se accede al Arraylist de usuarios.
- add.p12.juego: Desde este paquete se gestiona todo lo relacionado con el juego, puntuación, gestion de records, etc.
	- Juego: Esta clase gestiona todo el juego y va haciendo peticiones de operaciones a la clase JuegoService.
	- JuegoService: Tiene operaciones requeridas por la clase Juego.
	- Puntuación: Es la clase POJO para registrar una puntuacion.
	- Record: La clase POJO para los records.
- add.p12.main: Es desde donde se accede al juego.
	- MainP12: Es la clase desde donde se accede al juego, cuando necesita realizar alguna operacion lo solicita a la clase
		MainService.
	- MainService: Gestiona las operaciones del Main.
- add.p12.menu: Se gestionan las diferentes opciones y operaciones del menu.
	- Menu: Es una clase que tiene los dos tipos de menús diferentes, hace peticiones a la clase MenuService cada vez que se elije
		un menu.
	- MenuService: Esta clase sirve para realizar las operaciones por la clase Menu.
- add.p12.PDF: 
	- CrearPDF: Sirve para la creación de PDFs una vez se acabe la partida.
- add.p12.pregunta:
	- Pregunta: Clase POJO de pregunta.
- add.p12.XLS:
	- LeerXLS: Sirve para la lectura de la importacion de excel.
- add.p12.XML:Se gestionan las diferentes operaciones que se pueden hacer con un XML.
	- EscribirXML: Todas las peticiones se realizan a través del POJO pregunta y se escriben en el XML.
	- LeerXML: Es la clase encargada de leer la información del XML realizando el método devolviendo un ArrayList de preguntas.