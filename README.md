# API REST for Nursery Management

Este proyecto es una API REST construida con **Spring Boot** que implementa autenticación y autorización usando **JWT (JSON Web Tokens)** almacenados en **cookies HttpOnly**.

---

## 🧱 Tecnologías usadas

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-green)
![Spring Security](https://img.shields.io/badge/Spring%20Security-4.0.2-green)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-4.0.2-green)
![Hibernate](https://img.shields.io/badge/Hibernate-6.5-orange)
![JWT](https://img.shields.io/badge/JWT-jjwt%20v0.11.5-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18.1-blue)
![Maven](https://img.shields.io/badge/Maven-3.x-red)

---

## 🚀 Características

✅ Autenticación con JWT  
✅ Tokens guardados en cookies **HttpOnly**  
✅ Filtro JWT para validar token en cada request  
✅ Endpoints protegidos por roles (ADMIN / USER)  
✅ Endpoint `/profile` para obtener información del usuario logueado  
✅ Logout que elimina la cookie JWT  
✅ API REST **stateless**  
✅ Enpoints para obtener y modificar información en la base de datos

---

## 📌 Endpoints

### 🔹 Product

| Método | Endpoint                   | Descripción                          |
| ------ | -------------------------- | ------------------------------------ |
| GET    | `/api/product`             | Obtención de datos de un producto    |
| GET    | `/api/product/{productId}` | Obtención de un producto según su id |
| POST   | `/api/product`             | Creación de producto                 |
| PUT    | `/api/product/{productId}` | Edición de un proudcto               |
| DELETE | `/api/product/{productId}` | Hace un soft delete de un produco    |

### 🔹 Formats

| Método | Endpoint                  | Descripción                         |
| ------ | ------------------------- | ----------------------------------- |
| GET    | `/api/formats`            | Obtención de datos de un formato    |
| GET    | `/api/formats/{formatId}` | Obtención de un formato según su id |
| POST   | `/api/formats`            | Creación de formato                 |
| PUT    | `/api/formats/{formatId}` | Edición de un formato               |
| DELETE | `/api/formats/{formatId}` | Hace un soft delete de un formato   |

### 🔹 Servicios

| Método | Endpoint                      | Descripción                          |
| ------ | ----------------------------- | ------------------------------------ |
| GET    | `/api/servicios`              | Obtención de datos de un servicio    |
| GET    | `/api/servicios/{servicioId}` | Obtención de un servicio según su id |
| POST   | `/api/servicios`              | Creación de servicio                 |
| PUT    | `/api/servicios/{servicioId}` | Edición de un servicio               |
| DELETE | `/api/servicios/{servicioId}` | Hace un soft delete de un servicio   |

### 🔹 Cart

| Método | Endpoint                                  | Descripción                                |
| ------ | ----------------------------------------- | ------------------------------------------ |
| GET    | `/api/cart`                               | Obtención de datos de todos los carritos   |
| GET    | `/api/cart/{cartId}`                      | Obtención de un carrito según su id        |
| POST   | `/api/cart`                               | Creación de carrito                        |
| DELETE | `/api/cart/{servicioId}`                  | Hace un soft delete de un carrito          |
| POST   | `/api/cart/{cartId}/item/{productId}`     | Agrega un producto a un carrito específico |
| PUT    | `/api/cart/{cartId}/item/{productId}`     | Edita un producto específico de un carrito |
| DELETE | `/api/cart/{cartId}/item/{productId}`     | Eliminar un producto de un carrito         |
| POST   | `/api/cart/{cartId}/service/{servicioId}` | Agrega un servicio a un carrito específico |
| PUT    | `/api/cart/{cartId}/service/{servicioId}` | Edita un servicio específico de un carrito |
| DELETE | `/api/cart/{cartId}/service/{servicioId}` | Eliminar un servicio de un carrito         |

### 🔹 Auth

| Método | Endpoint           | Descripción                             |
| ------ | ------------------ | --------------------------------------- |
| POST   | `/api/auth/login`  | Autentica usuario y devuelve cookie JWT |
| POST   | `/api/auth/logout` | Elimina cookie JWT                      |

### 🔹 Usuario

| Método | Endpoint                | Descripción                    |
| ------ | ----------------------- | ------------------------------ |
| GET    | `/api/users`            | Lista usuarios (protegido)     |
| POST   | `/api/users`            | Crear usuario (protegido)      |
| PUT    | `/api/users/{userName}` | Actualizar usuario (protegido) |

### 🔹 Perfil

| Método | Endpoint   | Descripción                        |
| ------ | ---------- | ---------------------------------- |
| GET    | `/profile` | Devuelve info del usuario logueado |

---
