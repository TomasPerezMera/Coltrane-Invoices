# Coltrane-Invoices - Sistema de Facturación Para *El Rincón de Coltrane*

API REST para la gestión de ventas de un E-Commerce de vinilos de jazz, "El Rincon De Coltrane" [ https://tomasperezmera.github.io/rinconDeColtrane/ ].


<a href="https://time.now">World Time API by Time.Now</a>

---

## Tecnologías
- Java 17
- Spring Boot 3.2.5
- MySQL 8.0
- Maven 3.9
- Swagger/OpenAPI 2.2.0

## Funciones Principales
* CRUD completo de Clientes
* CRUD completo de Productos
* Generación de Facturas con validaciones
* Reducción automática de stock
* Búsqueda con filtros parciales
* Documentación interactiva con Swagger

## Configuración

### Prerrequisitos
- JDK 17 o superior
- MySQL 8.0 o superior
- Maven 3.6+

### Base de Datos

1. **Crear la base de datos:**
```sql
CREATE DATABASE invoices_db;
```

2. **Ejecutar scripts SQL** (en orden):
   - `src/main/resources/base_de_datos/schema.sql` (estructura)
   - `src/main/resources/base_de_datos/productos_data.sql` (datos iniciales)

3. **Configurar credenciales** en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/invoices_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## Ejecución

**Desde terminal:**
```bash
mvn clean install
mvn spring-boot:run
```

**Desde Eclipse:**
- Click derecho en proyecto → Run As → Spring Boot App

La aplicación corre en: `http://localhost:8080`

## Documentación API

**Acceder a Swagger UI:**
```
http://localhost:8080/swagger-ui/index.html
```

### Endpoints Principales

**Clientes:**
- `POST /api/customers` - Crear cliente
- `GET /api/customers` - Listar todos los clientes
- `GET /api/customers/{id}` - Obtener cliente por ID
- `GET /api/customers/search?dni={dni}` - Buscar cliente con filtros
- `PUT /api/customers/{id}` - Actualizar cliente
- `DELETE /api/customers/{id}` - Eliminar cliente

**Productos:**
- `POST /api/products` - Crear producto
- `GET /api/products` - Listar todos los productos
- `GET /api/products/{id}` - Obtener producto por ID
- `GET /api/products/search?name={name}` - Buscar productos por nombre
- `PUT /api/products/{id}` - Actualizar producto
- `DELETE /api/products/{id}` - Eliminar producto

**Facturas:**
- `POST /api/invoices` - Crear factura (realizar venta)
- `GET /api/invoices` - Listar todas las facturas
- `GET /api/invoices/{id}` - Obtener factura por ID

Ver documentación completa en Swagger.

## Pruebas

**Colección de Postman incluida:** `ColtraneInvoices.postman_collection.json`

Importar en Postman para probar todos los endpoints con ejemplos.

## Validaciones Implementadas

- Cliente y productos deben existir
- Stock suficiente antes de procesar venta
- DNI único por cliente
- Precios y stock no negativos
- Reducción automática de stock post-venta
- Precios históricos inmutables en facturas

---

Proyecto desarrollado para "Programación con Java 3.0", Comisión #76340, Alumno Tomás Pérez Mera.-