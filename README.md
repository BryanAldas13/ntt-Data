# DevOps Project - NTT DATA

Este proyecto es una API REST desarrollada con **Spring Boot** que implementa autenticación basada en **JWT (JSON Web Tokens)** y está diseñada para ser desplegada en un entorno de Kubernetes utilizando **Minikube**. El proyecto incluye un pipeline de CI/CD implementado con **GitHub Actions** para automatizar la construcción, pruebas y despliegue de la aplicación.

---

## 📋 Descripción del Proyecto

El proyecto es una API REST que incluye:
- Autenticación basada en JWT.
- Endpoints protegidos con Spring Security.
- Integración con Spring Boot Actuator para monitoreo.
- Validación de solicitudes con Jakarta Validation API.
- Configuración de CI/CD para automatizar el proceso de construcción y despliegue.

---

## 🛠️ Dependencias Utilizadas

El proyecto utiliza las siguientes dependencias principales:

- **Spring Boot Starter Web**: Para construir aplicaciones web con Spring MVC.
- **Spring Boot Starter Security**: Para implementar seguridad en la aplicación.
- **Spring Boot Starter Actuator**: Para monitorear y gestionar la aplicación.
- **JJWT (Java JWT)**: Para la generación y validación de JWT.
- **Lombok**: Para reducir el código boilerplate.
- **Spring Boot Starter Validation**: Para validar las solicitudes entrantes.
- **Spring Boot DevTools**: Para desarrollo rápido con reinicio automático.

Puedes encontrar todas las dependencias en el archivo [`pom.xml`](pom.xml).

---

## 🐳 Dockerización

La aplicación ha sido dockerizada y la imagen está disponible en **Docker Hub**. Para construir y subir la imagen Docker, se utiliza el siguiente comando:

```bash
docker build -t <dockerhub-username>/ms-devops:<version> .
docker push <dockerhub-username>/ms-devops:<version>

## 🚀 Infraestructura en Kubernetes

La infraestructura del proyecto se implementó en **Minikube**, un entorno local de Kubernetes. Los componentes principales son:

1. **Deployment**: Define la aplicación y utiliza la imagen Docker alojada en Docker Hub.
2. **Service**: Expone la aplicación dentro del clúster.
3. **Ingress Controller**: Gestiona el tráfico entrante y utiliza un dominio personalizado (`ms-devops.local`).

### Configuración del Ingress

El Ingress está configurado para redirigir el tráfico al servicio de la aplicación. El dominio personalizado `ms-devops.local` se resolvió mediante la modificación del archivo `/etc/hosts` en el sistema local.

---

## 🔄 Pipeline de CI/CD con GitHub Actions

El pipeline de CI/CD está configurado en GitHub Actions y se divide en las siguientes fases:

### 1. **Build**
- **Objetivo**: Compilar el proyecto y generar el archivo `.jar`.
- **Pasos**:
  - Checkout del código.
  - Configuración de Java y Maven.
  - Instalación de dependencias.
  - Compilación del proyecto con `mvn clean package`.
  - Guardado del archivo `.jar` como artefacto para la fase de pruebas.

### 2. **Test**
- **Objetivo**: Ejecutar las pruebas unitarias.
- **Pasos**:
  - Descarga del artefacto generado en la fase de Build.
  - Ejecución de pruebas con `mvn test`.

### 3. **Docker**
- **Objetivo**: Construir y subir la imagen Docker a Docker Hub.
- **Pasos**:
  - Checkout del código.
  - Inicio de sesión en Docker Hub.
  - Definición de la versión de la imagen (usando el SHA del commit o una versión personalizada).
  - Construcción y subida de la imagen Docker.
  - Actualización de la etiqueta `latest` (opcional).

---

## 🖥️ Despliegue en Minikube

Para desplegar la aplicación en Minikube, se siguieron los siguientes pasos:

1. **Iniciar Minikube**:
   ```bash
   minikube start
