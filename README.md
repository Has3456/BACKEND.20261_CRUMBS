Crumbs — Backend NT 2026-1
Integrantes: Laura Patricia Torres Contreras, Habbleybdy Castrillon Calle

Descripción
Backend REST desarrollado en Spring Boot 3.x / Java 17 para Crumbs, una plataforma de psicología financiera que ayuda a los usuarios a identificar y controlar sus "migajas" (micro-gastos) diarios. El sistema expone un API CRUD completo sobre 5 entidades relacionadas (usuarios, gastos, categorías, comercios y medios de pago), permitiendo registrar el perfil del usuario, sus gastos y clasificarlos según necesidad, frecuencia y comportamiento de consumo, con persistencia en base de datos H2 en memoria.

Estructura del proyecto
BACKEND.20261_CRUMBS-develop/
│
├── src/main/java/com/proyecto_backend/crumbs/
│   ├── CrumbsApplication.java          # Punto de entrada de la app Spring Boot
│   │
│   ├── configuracion/
│   │   └── Cors.java                   # Configuración CORS (acceso abierto desde frontend)
│   │
│   ├── controladores/                  # Capa REST (@RestController)
│   │   ├── UsuarioControaldor.java
│   │   ├── GastoControlador.java
│   │   ├── CategoriaControlador.java
│   │   ├── ComercioControlador.java
│   │   └── MedioPagoControlador.java
│   │
│   ├── servicios/                      # Lógica de negocio
│   │   ├── UsuarioServicio.java
│   │   ├── GastoServicio.java
│   │   ├── CategoriaServicio.java
│   │   ├── ComercioServicio.java
│   │   └── MedioPagoServicio.java
│   │
│   ├── repositorios/                   # Acceso a datos (Spring Data JPA)
│   │   ├── IUsuarioRepositorio.java
│   │   ├── IGastoRepositorio.java
│   │   ├── ICategoriaRepositorio.java
│   │   ├── IComercioRepositorio.java
│   │   └── IMedioPagoRepositorio.java
│   │
│   └── modelos/                        # Entidades JPA
│       ├── Usuario.java
│       ├── Gasto.java
│       ├── Categoria.java
│       ├── Comercio.java
│       └── MedioPago.java
│
├── src/main/resources/
│   └── application.properties          # Configuración de BD H2 y JPA
│
├── data/                               # Archivos de la BD H2 (persistencia local)
├── pom.xml                             # Dependencias Maven
└── README.md

Modelo de datos (relaciones)
EntidadDescripciónRelaciónUsuarioPerfil del usuario (ocupación, nivel socioeconómico, ingresos, ubicación, género)1 → N con Gasto, Categoria, MedioPagoGastoRegistro de cada gasto (valor, fecha, tipo de necesidad, grado de necesidad, frecuencia)N → 1 con Usuario, Categoria, MedioPago, ComercioCategoriaClasificación del gasto (naturaleza, comportamiento esperado, periodicidad, límite operativo)1 → N con GastoComercioTiendas/negocios donde se gasta (segmento, canal de venta, calificación de confianza)1 → N con GastoMedioPagoMedios de pago usados (efectivo, crédito, etc.), con su propio límite operativo1 → N con Gasto

Endpoints expuestos
RecursoBase URLOperacionesUsuarioshttp://localhost:8080/api/v1/usuariosGET, GET/{id}, POST, PUT/{id}, DELETE/{id}Gastoshttp://localhost:8080/api/v1/gastosGET, GET/{id}, POST/{usuarioId}, PUT/{id}, DELETE/{id}Categoríashttp://localhost:8080/api/v1/categoriasGET, GET/{id}, POST/{usuarioId}, PUT/{id}, DELETE/{id}Comercioshttp://localhost:8080/api/v1/comerciosGET, GET/{id}, POST/{usuarioId}, PUT/{id}, DELETE/{id}Medios de pagohttp://localhost:8080/api/v1/medios-pagoGET, GET/{id}, POST/{usuarioId}, PUT/{id}, DELETE/{id}

Cómo ejecutar
1. Requisitos: Java 17 y Maven (o el wrapper incluido mvnw).
2. Levantar la aplicación
bash./mvnw spring-boot:run
La aplicación corre por defecto en el puerto 8080.
3. Consola de base de datos
H2 Console habilitada en:
http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:crumbs_db, usuario sa, sin contraseña)

5. CORS
Configurado para aceptar peticiones desde cualquier origen (*), habilitando GET, POST, PUT, DELETE, OPTIONS — pensado para ser consumido por un frontend o, como en el proyecto integrador análogo, por un pipeline de análisis de datos en Python.
