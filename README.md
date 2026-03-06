# Sistema de Gestión de Cortes y Asignación a Talleres

## Descripción

Este proyecto consiste en una aplicación fullstack para la gestión de **cortes de producción y su asignación a talleres de confección**.

El sistema permite registrar talleres, gestionar cortes de producción y realizar asignaciones de dichos cortes a talleres disponibles, permitiendo llevar control sobre qué cortes se encuentran asignados y cuáles aún están pendientes.

La aplicación fue desarrollada siguiendo una arquitectura cliente-servidor, utilizando un backend en **Spring Boot** y un frontend en **Angular**.

---

## Tecnologías utilizadas

Backend
- Java 17
- Spring Boot
- Gradle
- H2 Database

Frontend
- Angular
- TypeScript
- HTML / CSS
- Tailwing


## Cómo ejecutar el proyecto

### Backend

1. Clonar repositorio


git clone https://github.com/usuario/repositorio


2. Entrar al proyecto


cd backend


3. Ejecutar


./gradlew bootRun


API disponible en:


http://localhost:8080


Consola H2:


http://localhost:8080/h2-console


### Frontend

1. Entrar a la carpeta frontend


cd frontend


2. Instalar dependencias


npm install


3. Ejecutar


ng serve


Aplicación disponible en:


http://localhost:4200

## Modelo del sistema

El sistema se compone de las siguientes entidades principales:

### Taller
Representa un taller de confección al cual se le pueden asignar cortes.

Campos principales:
- id
- nombre

---

### Corte
Representa un corte de producción disponible para ser confeccionado.

Campos principales:
- id
- referencia
- cantidad
- estado (SIN_ASIGNAR / ASIGNADO)

---

### Asignación de Taller
Representa la asignación de un corte específico a un taller.

Campos principales:
- id
- confeccionista
- fechaEstimada
- taller
- corte

---

## Funcionalidades implementadas

### Gestión de talleres
- Crear talleres
- Listar talleres registrados

### Gestión de cortes
- Crear cortes
- Listar cortes disponibles
- Control de estado del corte (asignado / sin asignar)

### Gestión de asignaciones
- Asignar un corte disponible a un taller
- Listar asignaciones existentes
- Eliminar asignaciones
- Al eliminar una asignación, el corte vuelve a estado **SIN_ASIGNAR**

### Validaciones
- Todos los campos deben estar completos antes de crear una asignación
- Solo se pueden asignar cortes que estén disponibles



## Autor

Jose Luis Garcés  
Ingeniero Electrónico – Desarrollador Fullstack
