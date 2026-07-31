# Sistema de Gestión de Notas 📚

![React](https://img.shields.io/badge/React-17.0.2-blue?logo=react)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.0-green?logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-24.0.1-blue?logo=docker)

Aplicación web para gestionar **alumnos, materias y notas**, desarrollada con **ReactJS + TypeScript** en el frontend y **Spring Boot + PostgreSQL** en el backend.  
La aplicación está preparada para ejecutarse mediante **Docker** y **Docker Compose**.

---

## Repositorios

- **Backend**: [https://github.com/BREINHZ/DianaTibisayPachecoMoreno.git](https://github.com/BREINHZ/DianaTibisayPachecoMoreno.git)
- **Frontend**: [https://github.com/BREINHZ/FrontDianaTibisayPachecoMoreno.git](https://github.com/BREINHZ/FrontDianaTibisayPachecoMoreno.git)

---

## Tecnologías utilizadas

### Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

### Frontend
- ReactJS + TypeScript
- React Router DOM
- Axios
- React Bootstrap
- CSS

### Contenedores
- Docker
- Docker Compose

---

## Funcionalidades

### Backend
- Registrar notas asociadas a un alumno y una materia.
- Listar notas por alumno mediante POST (`{ "alumnoId": 1 }`).
- Validación del valor de la nota (entre 1 y 5).
- CRUD básico para alumnos y materias.

### Frontend
- Registrar alumnos y materias.
- Registrar notas seleccionando un alumno y una materia existente.
- Listar notas por alumno en una tabla interactiva.
- Interfaz sencilla y responsiva con React Bootstrap.

### Contenedor
- Backend corriendo en `http://localhost:8099`.
- Frontend corriendo en `http://localhost:3000`.
- Base de datos PostgreSQL corriendo en `localhost:5432`.

---

## Instalación y Configuración

### Backend sin Docker

1. Clonar el repositorio:
```bash
git clone https://github.com/BREINHZ/DianaTibisayPachecoMoreno.git
cd DianaTibisayPachecoMoreno

