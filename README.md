Proyecto DevOps - API Rest
Este proyecto consiste en una API Rest desarrollada con Spring Boot para NTT Data. La API implementa autenticación basada en JWT y está diseñada para proporcionar un servicio seguro y escalable.

Dependencias
El proyecto está basado en Spring Boot y utiliza las siguientes dependencias clave:

Spring Boot para el desarrollo de la API.
Spring Boot DevTools para mejorar el desarrollo con reinicios automáticos.
Lombok para simplificar el código y evitar boilerplate.
JUnit para pruebas unitarias.
JWT para la gestión de la autenticación.
Spring Boot Actuator para monitoreo y métricas de la aplicación.
Spring Boot Security para gestionar la seguridad de la API.
Spring Boot Validation para validaciones de entrada.
Dockerización y Docker Hub
La aplicación ha sido dockerizada y subida a Docker Hub para su distribución y ejecución en cualquier entorno. Se utiliza un Dockerfile para crear una imagen de la aplicación, que se encuentra disponible en Docker Hub.

CI/CD con GitHub Actions
El proyecto utiliza GitHub Actions para implementar un pipeline CI/CD. Este pipeline se encarga de:

Construir la aplicación.
Ejecutar pruebas automáticas.
Crear la imagen Docker.
Subir la imagen a Docker Hub.
Desplegar la aplicación en un clúster Minikube.
Infraestructura en Minikube
La infraestructura está desplegada en Minikube, ejecutándose en un entorno virtual basado en Ubuntu. El despliegue utiliza los siguientes componentes:

Deployment: Un despliegue que utiliza la imagen Docker desde Docker Hub.
Service: Exposición de la aplicación a través de un servicio de Kubernetes.
Ingress Controller: Configurado con un dominio personalizado ms-devops-local, que permite el acceso externo a la aplicación en Minikube.
Acceso a la API
Una vez que el Ingress Controller esté configurado correctamente, podrás acceder a la API utilizando el dominio personalizado ms-devops-local dentro de Minikube.

Ejemplo de uso
Para probar la API, realiza una solicitud HTTP con el token JWT obtenido al iniciar sesión. La API requerirá un nuevo token para cada solicitud y una clave x-api-key fija.
