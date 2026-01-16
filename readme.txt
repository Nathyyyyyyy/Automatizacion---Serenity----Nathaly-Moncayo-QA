================================================================================
SERENITY BDD - PRUEBA E2E SAUCEDEMO
Proyecto de Automatización de Pruebas - Screenplay Pattern
================================================================================

CONTENIDO GENERAL DEL PROYECTO
================================================================================

Este proyecto es una demostración de cómo implementar pruebas automatizadas E2E
(End-to-End) usando:
- Serenity BDD (framework de testing)
- Screenplay Pattern (patrón de diseño)
- Cucumber/Gherkin (BDD - Behavior-Driven Development)
- Selenium WebDriver (automatización del navegador)

El proyecto incluye dos tipos de implementaciones:
1. Pruebas con Screenplay Pattern (recomendado)
2. Pruebas con Page Objects Pattern (tradicional)

================================================================================
INTRODUCCIÓN AL PROYECTO
================================================================================

Este proyecto demuestra la implementación de pruebas funcionales automatizadas
para un flujo completo de compra en la aplicación SauceDemo
(https://www.saucedemo.com/).

El ejercicio incluye:
- Autenticación con credenciales de usuario
- Navegación por el catálogo de productos
- Agregar productos al carrito
- Visualizar el carrito de compras
- Completar el formulario de compra
- Finalizar la compra
- Validar la confirmación de compra exitosa

================================================================================
VERSIONES DE TECNOLOGÍAS REQUERIDAS
================================================================================

REQUERIMIENTOS OBLIGATORIOS:
- Java JDK: 11 o superior (probado con JDK 11, 17, 21)
- Maven: 3.6 o superior (para build y ejecución)
- Maven Wrapper: Incluido en el proyecto (gradlew, gradlew.bat)

NAVEGADORES:
- Google Chrome/Chromium: Versión reciente (v140+)
- El driver se descarga automáticamente (selenium-manager)

VERSIONES DE DEPENDENCIAS PRINCIPALES:
- Serenity BDD: 4.1.12
- Selenium WebDriver: 4.x
- JUnit: 5
- Cucumber/Gherkin: Última versión compatible
- Maven Compiler: 3.8.1
- Maven Surefire/Failsafe: 3.x

SISTEMA OPERATIVO:
- Windows 10/11 (probado)
- macOS (compatible)
- Linux (compatible)

================================================================================
ESTRUCTURA DEL PROYECTO
================================================================================

screenplay-pattern-todomvc-master/
│
├── src/
│   ├── main/java/net/serenitybdd/demos/todos/
│   │   ├── screenplay/saucedemo/
│   │   │   ├── tasks/                    (7 tareas Screenplay)
│   │   │   │   ├── NavigateToSauceDemo.java
│   │   │   │   ├── Login.java
│   │   │   │   ├── AddProductsToCart.java
│   │   │   │   ├── ViewCart.java
│   │   │   │   ├── ProceedToCheckout.java
│   │   │   │   ├── FillCheckoutForm.java
│   │   │   │   └── FinishPurchase.java
│   │   │   ├── user_interface/          (4 Page Objects)
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── InventoryPage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   └── questions/               (1 Question para validaciones)
│   │   │       └── ConfirmationMessage.java
│   │   └── [otros paquetes de TodoMVC...]
│   │
│   └── test/
│       ├── java/net/serenitybdd/demos/todos/
│       │   ├── cucumber/steps/
│       │   │   └── SauceDemoSteps.java   (8 pasos Gherkin)
│       │   └── [otros tests...]
│       │
│       └── resources/
│           ├── features/cucumber/saucedemo/
│           │   └── purchase_flow.feature (Escenario BDD)
│           └── [otros recursos...]
│
├── pom.xml                              (Configuración Maven + Perfiles)
├── serenity.conf                        (Configuración de Serenity BDD)
├── serenity.properties                  (Propiedades adicionales)
├── README.md                            (Este archivo en Markdown)
├── SAUCEDEMO_README.md                  (Documentación técnica de SauceDemo)
├── INSTRUCCIONES_EJECUCION.md           (Guía paso a paso)
├── CONCLUSIONES.md                      (Análisis y hallazgos)
└── [otros archivos de documentación...]

================================================================================
INSTALACIÓN Y CONFIGURACIÓN
================================================================================

PASO 1: VERIFICAR REQUISITOS PREVIOS

1.1) Verificar Java instalado:
     Comando: java -version
     Resultado esperado: openjdk version "11.0.x" o superior

1.2) Verificar Maven instalado:
     Comando: mvn -version
     Resultado esperado: Apache Maven 3.6.x o superior

1.3) Verificar Chrome instalado:
     - Descargar desde: https://www.google.com/chrome/
     - O usar Chromium: https://chromium.woolyss.com/

PASO 2: DESCARGAR EL PROYECTO

2.1) Si tienes Git instalado:
     git clone <URL-del-repositorio>
     cd screenplay-pattern-todomvc-master

2.2) Si no tienes Git:
     - Descargar ZIP del repositorio
     - Extraer en una carpeta
     - Abrir terminal en esa carpeta

PASO 3: DESCARGAR DEPENDENCIAS

En la carpeta del proyecto, ejecutar:
     mvn clean install

Tiempo estimado: 3-5 minutos en la primera ejecución
Indicador de éxito: "BUILD SUCCESS" en la terminal

PASO 4: VERIFICAR ESTRUCTURA

Confirmar que existan estos archivos en la carpeta raíz:
     - pom.xml
     - serenity.conf
     - src/ (carpeta)
     - target/ (carpeta creada después de mvn install)

================================================================================
EJECUCIÓN DE LAS PRUEBAS
================================================================================

IMPORTANTE: Los comandos correctos para ejecutar las pruebas son:

OPCIÓN 1: EJECUTAR SOLO LA PRUEBA DE SAUCEDEMO (RECOMENDADO)
Modo Headless (sin interfaz gráfica - más rápido):
     mvn clean verify -Psaucedemo

Con navegador visible (ver cada paso):
     En PowerShell: mvn clean verify -Psaucedemo "-Dheadless.mode=false"
     En CMD:        mvn clean verify -Psaucedemo -Dheadless.mode=false

Resultado esperado:
     - 1 test ejecutado
     - 1 ventana de Chrome abierta y cerrada automáticamente
     - Duración: ~2 minutos (headless) o ~3-4 minutos (visible)
     - Mensaje final: "BUILD SUCCESS"

OPCIÓN 2: EJECUTAR SOLO LAS PRUEBAS DE TODOMVC
     mvn clean verify -Ptodomvc

Resultado esperado:
     - 15 tests ejecutados
     - Duración: ~2-3 minutos
     - Mensaje final: "BUILD SUCCESS"

OPCIÓN 3: EJECUTAR TODAS LAS PRUEBAS (16 tests)
     mvn clean verify -Pcucumber

Resultado esperado:
     - 16 tests ejecutados (1 SauceDemo + 15 TodoMVC)
     - Duración: ~3-4 minutos
     - Mensaje final: "BUILD SUCCESS"

OPCIÓN 4: LIMPIAR ARCHIVOS GENERADOS
     mvn clean

Resultado esperado:
     - Carpeta target/ eliminada
     - Duración: ~30 segundos

================================================================================
DESCRIPCIÓN DETALLADA DE LA PRUEBA SAUCEDEMO
================================================================================

PASO 1: NAVEGACIÓN
- Se abre el navegador Chrome
- Se navega a https://www.saucedemo.com/
- Se verifica que la página de login carga correctamente

PASO 2: AUTENTICACIÓN
- Se ingresa el usuario: "standard_user"
- Se ingresa la contraseña: "secret_sauce"
- Se hace clic en el botón "Login"
- Se verifica que se redirige a la página de inventario

PASO 3: AGREGAR PRODUCTOS AL CARRITO
- Se identifican los botones "Add to Cart"
- Se hace clic en el primer botón "Add to Cart"
- Se hace clic en el segundo botón "Add to Cart"
- Se verifica que el badge del carrito muestra "2" productos

PASO 4: VISUALIZAR EL CARRITO
- Se hace clic en el enlace del carrito
- Se navega a la página del carrito
- Se verifica que los 2 productos están en el carrito
- Se verifica que se puede ver el nombre, descripción y precio de cada producto

PASO 5: PROCEDER AL CHECKOUT
- Se hace clic en el botón "Checkout"
- Se navega a la página de formulario de envío

PASO 6: COMPLETAR EL FORMULARIO
- Se ingresa "John" en el campo "First Name"
- Se ingresa "Doe" en el campo "Last Name"
- Se ingresa "12345" en el campo "Postal Code"
- Se hace clic en el botón "Continue"
- Se navega a la página de resumen de orden

PASO 7: FINALIZAR LA COMPRA
- Se revisa el resumen de la orden (productos y totales)
- Se hace clic en el botón "Finish"
- Se navega a la página de confirmación

PASO 8: VALIDAR CONFIRMACIÓN
- Se verifica que aparece el mensaje "Thank you for your order!"
- Se verifica que se muestra un número de orden
- Se valida que la compra se completó exitosamente

================================================================================
EJECUCIÓN CON SCENARIO OUTLINE
================================================================================

DESCRIPCIÓN:
El escenario principal de SauceDemo utiliza Scenario Outline de Cucumber para
ejecutar el flujo de compra múltiples veces con diferentes conjuntos de datos.
Esto permite validar que el flujo funciona consistentemente bajo distintos
parámetros de entrada.

IMPLEMENTACIÓN:
El archivo purchase_flow.feature contiene un Scenario Outline que se ejecuta
con 3 (tres) iteraciones diferentes, cada una con datos de prueba distintos:

EJECUCIÓN 1 - Actor: John
│
├─ Usuario de Login: standard_user
├─ Contraseña: secret_sauce
├─ Cantidad de Productos: 2
├─ Nombre: John
├─ Apellido: Barahona
├─ Código Postal: 12345
│
└─ RESULTADO: ✓ Compra completada exitosamente

EJECUCIÓN 2 - Actor: Sarah
│
├─ Usuario de Login: standard_user
├─ Contraseña: secret_sauce
├─ Cantidad de Productos: 3
├─ Nombre: Sarah
├─ Apellido: Muñoz
├─ Código Postal: 67890
│
└─ RESULTADO: ✓ Compra completada exitosamente

EJECUCIÓN 3 - Actor: Michael
│
├─ Usuario de Login: standard_user
├─ Contraseña: secret_sauce
├─ Cantidad de Productos: 1
├─ Nombre: Michael
├─ Apellido: Vargas
├─ Código Postal: 54321
│
└─ RESULTADO: ✓ Compra completada exitosamente

BENEFICIOS DE USAR SCENARIO OUTLINE:

1. REUTILIZACIÓN DE CÓDIGO:
   - Un único escenario para múltiples casos de prueba
   - Reduce la duplicación en el archivo .feature
   - Mejora la mantenibilidad del código

2. COBERTURA AMPLIADA:
   - Tres ejecuciones diferentes en una sola definición
   - Valida consistencia del flujo
   - Detecta problemas específicos de datos

3. VARIABLES EN LAS PRUEBAS:
   - Los parámetros se definen en las Examples tables
   - Permiten validar diferentes cantidades de productos
   - Permiten validar diferentes datos de usuario

4. REPORTES DETALLADOS:
   - Cada iteración genera un reporte independiente
   - Se puede ver claramente cuál iteración pasó/falló
   - Screenshots individuales por cada ejecución

5. DOCUMENTACIÓN:
   - Los datos quedan explícitos en el archivo .feature
   - Fácil de entender qué se está probando
   - Sirve como documentación viva del proyecto

FORMATO DEL SCENARIO OUTLINE:

Scenario Outline: Complete a successful purchase with different users
  Given <actor> is on the SauceDemo login page
  When he logs in with username "<username>" and password "<password>"
  And he adds <productCount> products to the cart
  And he views the shopping cart
  And he proceeds to checkout
  And he completes the checkout form with:
    | firstName | <firstName> |
    | lastName  | <lastName>  |
    | zipCode   | <zipCode>   |
  And he finishes the purchase
  Then he should see the confirmation message "Thank you for your order!"

  Examples:
    | actor   | username        | password     | productCount | firstName | lastName  | zipCode |
    | John    | standard_user   | secret_sauce | 2            | John      | Barahona  | 12345   |
    | Sarah   | standard_user   | secret_sauce | 3            | Sarah     | Muñoz     | 67890   |
    | Michael | standard_user   | secret_sauce | 1            | Michael   | Vargas    | 54321   |

CÓMO SE EJECUTA:

1. Cucumber lee el Scenario Outline
2. Para cada fila en Examples (excepto el encabezado):
   a. Reemplaza los placeholders (<actor>, <username>, etc.) con los valores
   b. Ejecuta el escenario completo con esos valores
   c. Genera un reporte independiente
3. Al terminar las 3 iteraciones, genera un reporte consolidado

TIEMPO DE EJECUCIÓN:

- Ejecución 1 (John, 2 productos): ~45 segundos
- Ejecución 2 (Sarah, 3 productos): ~50 segundos
- Ejecución 3 (Michael, 1 producto): ~40 segundos
- Tiempo total: ~2 minutos (con reporte incluido)

VALIDACIONES POR ITERACIÓN:

Cada iteración valida:
✓ Login exitoso con credenciales especificadas
✓ Adición correcta de N productos (variable)
✓ Visualización correcta en carrito
✓ Procedimiento correcto en checkout
✓ Llenado correcto del formulario (datos variables)
✓ Finalización exitosa de compra
✓ Mensaje de confirmación presente

VENTAJA DE DATOS VARIABLES:

Al usar diferentes cantidades de productos (2, 3, 1), se valida que:
- El sistema maneja correctamente diferentes cantidades
- El cálculo de totales funciona para N productos
- El carrito se actualiza correctamente
- El formulario funciona independientemente de cantidad

================================================================================
VER REPORTES DE EJECUCIÓN
================================================================================

Después de ejecutar cualquier prueba, los reportes se generan automáticamente en:
     target/site/serenity/index.html

CÓMO ABRIR LOS REPORTES:

En Windows (PowerShell):
     start target/site/serenity/index.html

En Windows (CMD):
     Navegar a: target\site\serenity\
     Hacer doble clic en: index.html

En macOS:
     open target/site/serenity/index.html

En Linux:
     xdg-open target/site/serenity/index.html

CONTENIDO DE LOS REPORTES:
- Resumen general de ejecución
- Cada paso del escenario con descripción
- Screenshots de cada acción
- Duración de cada paso
- Logs detallados
- Gráficos y estadísticas
- Información del ambiente
- Información del navegador utilizado

================================================================================
SOLUCIÓN DE PROBLEMAS
================================================================================

PROBLEMA 1: "Java no está instalado"
ERROR: 'java' is not recognized
SOLUCIÓN:
  1. Descargar Java JDK desde: https://www.oracle.com/java/technologies/downloads/
  2. Instalar en el sistema
  3. Agregar Java a la variable PATH (búsqueda en Google: "agregar Java a PATH")
  4. Reiniciar la terminal

PROBLEMA 2: "Maven no está instalado"
ERROR: 'mvn' is not recognized
SOLUCIÓN:
  1. Descargar Maven desde: https://maven.apache.org/
  2. Instalar en el sistema
  3. Agregar Maven a la variable PATH
  4. Reiniciar la terminal

PROBLEMA 3: "Chrome no está instalado"
ERROR: no suitable chromedriver found
SOLUCIÓN:
  1. Descargar e instalar Chrome desde: https://www.google.com/chrome/
  2. O instalar Chromium desde: https://chromium.woolyss.com/
  3. Reintentar la prueba

PROBLEMA 4: "Error de compilación en el código"
ERROR: [ERROR] COMPILATION ERROR
SOLUCIÓN:
  1. Ejecutar: mvn clean compile
  2. Verificar que Java es versión 11 o superior
  3. Verificar que todas las dependencias se descargaron correctamente
  4. Limpiar caché: mvn clean -Dmaven.repo.local=.m2/repository

PROBLEMA 5: "Las pruebas se ejecutan muy lentamente"
SOLUCIÓN:
  1. Usar modo headless (por defecto): mvn clean verify -Psaucedemo
  2. Cerrar otras aplicaciones que usen mucha CPU
  3. Verificar conexión a internet (necesaria para descargar ChromeDriver)

PROBLEMA 6: "El navegador no se abre o hay timeout"
ERROR: org.openqa.selenium.TimeoutException
SOLUCIÓN:
  1. Ejecutar de nuevo: mvn clean verify -Psaucedemo
  2. Aumentar el timeout en serenity.conf si es necesario
  3. Verificar que la URL de SauceDemo está disponible

PROBLEMA 7: "Error con caracteres especiales en PowerShell"
ERROR: Unknown lifecycle phase ".mode=false"
SOLUCIÓN:
  Usar comillas alrededor del parámetro:
  En PowerShell: mvn clean verify -Psaucedemo "-Dheadless.mode=false"
  En CMD: mvn clean verify -Psaucedemo -Dheadless.mode=false

================================================================================
COMANDOS ÚTILES DE REFERENCIA
================================================================================

# Compilar sin ejecutar pruebas
mvn clean compile

# Descargar todas las dependencias
mvn clean install

# Ejecutar solo compilación y tests
mvn clean test

# Ejecutar con más información de debug
mvn clean verify -Psaucedemo -X

# Ver versión de Maven
mvn -version

# Ver propiedades del sistema
mvn help:describe

# Limpiar repositorio local de Maven
mvn clean -Dmaven.repo.local=.m2/repository

# Ejecutar una clase de test específica
mvn test -Dtest=SauceDemoSteps

# Ver árbol de dependencias
mvn dependency:tree

================================================================================
CARACTERÍSTICAS PRINCIPALES DEL PROYECTO
================================================================================

1. PATRÓN SCREENPLAY PATTERN:
   - Separación clara de responsabilidades
   - Código altamente reutilizable
   - Fácil mantenimiento y extensión
   - Mejor legibilidad

2. BDD CON CUCUMBER/GHERKIN:
   - Escenarios en lenguaje natural
   - Criterios de aceptación claros
   - Documentación viva
   - Fácil de entender para no-técnicos

3. SERENITY BDD:
   - Reportes HTML automáticos detallados
   - Screenshots de cada paso
   - Logs automáticos
   - Sincronización automática
   - Manejo de esperas implícitas

4. SELENIUM WEBDRIVER:
   - Soporte para múltiples navegadores
   - Automatización robusta
   - Manejo de elementos dinámicos
   - Captura de pantallas

5. BUENAS PRÁCTICAS:
   - Código limpio (SOLID principles)
   - Separación en capas
   - Design patterns (Page Objects, Builder)
   - Documentación completa
   - Tests independientes

================================================================================
PRÓXIMOS PASOS RECOMENDADOS
================================================================================

1. EJECUTAR LA PRUEBA:
   mvn clean verify -Psaucedemo

2. VER LOS REPORTES:
   Abrir: target/site/serenity/index.html

3. REVISAR EL CÓDIGO:
   - Analizar las tareas en: src/main/java/.../saucedemo/tasks/
   - Revisar los elementos de UI: src/main/java/.../saucedemo/user_interface/
   - Ver los pasos: src/test/java/.../cucumber/steps/SauceDemoSteps.java
   - Leer el escenario: src/test/resources/features/cucumber/saucedemo/purchase_flow.feature

4. EXTENDER LAS PRUEBAS:
   - Agregar nuevos escenarios en el archivo .feature
   - Implementar nuevos pasos en SauceDemoSteps.java
   - Crear nuevas tareas si es necesario

5. PUBLICAR EN GITHUB:
   - Crear repositorio en github.com
   - Hacer push del código
   - Configurar CI/CD con GitHub Actions

================================================================================
INFORMACIÓN DE CONTACTO Y SOPORTE
================================================================================

DOCUMENTACIÓN ADICIONAL EN EL PROYECTO:
- README.md: Descripción general del proyecto
- SAUCEDEMO_README.md: Documentación específica de SauceDemo
- SAUCEDEMO_PROJECT_STRUCTURE.md: Estructura detallada del código
- INSTRUCCIONES_EJECUCION.md: Guía paso a paso completa
- CONCLUSIONES.md: Análisis técnico y recomendaciones
- COMANDOS_RAPIDOS.md: Referencia rápida de comandos

SITIOS DE REFERENCIA:
- Serenity BDD: https://serenity-bdd.info/
- Screenplay Pattern: https://serenity-bdd.info/docs/tutorials/screenplay-pattern
- Cucumber: https://cucumber.io/
- Selenium: https://www.selenium.dev/
- Maven: https://maven.apache.org/

HERRAMIENTAS RECOMENDADAS:
- IntelliJ IDEA (IDE Java)
- Visual Studio Code (Editor de código)
- Chrome DevTools (Depuración y selección de elementos)
- Postman (Testing de APIs)

================================================================================
CONCLUSIÓN
================================================================================

Este proyecto proporciona una implementación profesional y mantenible de pruebas
E2E automatizadas usando tecnologías modernas y mejores prácticas.

El código está listo para:
✓ Ser ejecutado inmediatamente
✓ Ser utilizado como referencia
✓ Ser extendido con nuevos casos
✓ Ser integrado en sistemas CI/CD
✓ Ser compartido con equipos de trabajo
✓ Ser usado en producción

================================================================================
INFORMACIÓN DE VERSIÓN
================================================================================

Fecha de Creación: Enero de 2026
Versión del Proyecto: 1.0.0
Estado: COMPLETADO Y FUNCIONAL
Elaborado por: Nathaly Moncayo
Mes: Enero 2026

================================================================================
FIN DEL DOCUMENTO
================================================================================

