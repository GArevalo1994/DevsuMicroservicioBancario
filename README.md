# PRUEBA TÉCNICA DEVSU

El siguiente proyecto realizado en **Spring Boot** sigue los requerimientos expuestos en la prueba técnica, donde se realizó la creación de **dos microservicios en Java**.

---

## 📬 Colección Postman

Dentro del proyecto se encuentra la **colección creada en Postman**, donde se puede consultar la documentación de los endpoints junto con sus respectivos ejemplos de request y response.

---

## 🗄️ Esquemas y Scripts de Base de Datos

También se incluyen los esquemas de ambas bases de datos y un **script SQL** para la creación de tablas, así como ejemplos para insertar datos de prueba.

---

## 🚀 Instrucciones para levantar el proyecto

Desde la **raíz del proyecto**, donde están ubicados los archivos `.env` y `docker-compose.yml`, ejecuta los siguientes comandos en tu terminal:

```bash
docker-compose up --build -d
```
Después de levantar todo, puedes verificar que los contenedores estén activos con:

```bash
docker ps -a
