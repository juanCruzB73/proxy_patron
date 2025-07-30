🚀 Ejemplo del Patrón Proxy en Spring Boot
🔍 ¿Qué es el patrón Proxy?

🧱 El Proxy es un patrón estructural que actúa como un intermediario entre el cliente y el objeto real, permitiendo:

✨ Controlar el acceso
🛡️ Agregar seguridad
🧾 Realizar logs y auditorías
🔁 Manejar transacciones automáticamente
🧠 ¿Cómo se implementa el Proxy en este proyecto?
🧩 Funcionalidad	⚙️ Implementación	🤖 ¿Quién actúa como Proxy?
🔐 Seguridad	@PreAuthorize("hasRole('ADMIN')")	Proxy de Spring Security que valida los roles antes de ejecutar.
💳 Transacciones	@Transactional	Proxy de Spring Transaction que maneja commit/rollback automáticamente.
📜 Auditoría (Logs)	@Aspect con @Around	Proxy de Spring AOP que intercepta el método para registrar actividad.
🧼 Encapsulamiento	La clase de servicio está "limpia"	Todo lo hacen los proxies sin modificar el código original.
✅ Explicación técnica del patrón Proxy en este ejemplo
🧩 Aspecto	🛠️ Implementación	🕵️‍♂️ ¿Dónde está el proxy?
🔐 Seguridad	@PreAuthorize("hasRole('ADMIN')")	Spring genera un proxy que verifica el rol antes de llamar al método.
💳 Transacción	@Transactional	El proxy comienza, hace commit o rollback automáticamente.
📜 Logs/Auditoría	@Aspect + @Around	Proxy AOP intercepta llamadas para registrar actividad.
🧼 Código limpio	BancoServiceImpl	No contiene lógica de seguridad, logs ni transacciones explícitas.
🛠️ ¿Cómo funciona internamente?

Spring genera clases proxy dinámicamente en tiempo de ejecución:

    Si la clase implementa una interfaz 👉 usa JDK Dynamic Proxy

    Si no 👉 usa CGLIB Proxy (subclase dinámica)

📦 Ejemplo: cuando ejecutás esto desde tu controlador:

bancoService.transferir(1L, 2L, 1000);

⚙️ En realidad, el proxy ejecuta algo parecido a esto:

if (user.hasRole("ADMIN")) {
    startTransaction();
    log("➡️ Entrando al método transferir...");
    bancoServiceImpl.transferir(...);
    log("✅ Saliendo del método transferir.");
    commit();
} else {
    throw new AccessDeniedException("🚫 No autorizado");
}

🧪 Cómo probar la API en Postman
1️⃣ Configurar la petición

    Método: POST

    URL: http://localhost:8080/api/transferir

2️⃣ Autenticación Basic Auth

    Andá a la pestaña Authorization

    Elegí Basic Auth

    Usuario: admin

    Contraseña: admin123

3️⃣ Parámetros

En la pestaña Params, agregá:
Key	Value
origen	1
destino	2
monto	1000
4️⃣ Enviar petición

Presioná Send
👉 Si todo funciona bien, recibirás:

"Transferencia realizada"

🧰 Tecnologías usadas

    ☕ Spring Boot

    🔐 Spring Security

    🔁 Spring AOP

    🐘 PostgreSQL

    🗃️ Spring Data JPA

🧠 ¿Qué aprendiste?

    ✔️ Cómo Spring usa proxies para agregar funcionalidades sin tocar tu lógica de negocio.

    ✔️ Cómo auditar, proteger y encapsular funciones usando anotaciones.

    ✔️ Que este patrón te permite escribir código más limpio, desacoplado y mantenible.
