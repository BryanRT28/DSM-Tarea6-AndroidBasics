package com.example.reply.data

object LocalEmailsDataProvider {
    val allEmails = listOf(
        Email(
            id = 1L,
            sender = "Google Developers",
            subject = "Novedades en Jetpack Compose 2026",
            body = "Descubre las últimas mejoras en rendimiento, Material 3 y compatibilidad de diseños adaptables para pantallas grandes y plegables.",
            mailbox = MailboxType.Inbox
        ),
        Email(
            id = 2L,
            sender = "UNMSM - FISI",
            subject = "Convocatoria Proyectos de Desarrollo de Sistemas",
            body = "Estimados estudiantes, se inicia el registro de propuestas tecnológicas para el ciclo actual. Favor de revisar las bases adjuntas.",
            mailbox = MailboxType.Inbox
        ),
        Email(
            id = 3L,
            sender = "Android Basics Team",
            subject = "Insignia Diseños Adaptables Obtenida",
            body = "¡Felicitaciones! Has completado exitosamente la Ruta 3 de adaptación a diferentes tamaños de pantalla en Jetpack Compose.",
            mailbox = MailboxType.Inbox
        ),
        Email(
            id = 4L,
            sender = "GitHub Notifications",
            subject = "Nuevo commit en tu repositorio DSM-Tarea5",
            body = "Los cambios han sido integrados correctamente en la rama main. El flujo de CI/CD completó la compilación sin errores.",
            mailbox = MailboxType.Inbox
        )
    )

    val defaultEmail = allEmails[0]
}