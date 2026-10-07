package com.example.reply.data

data class Email(
    val id: Long,
    val sender: String,
    val subject: String,
    val body: String,
    val mailbox: MailboxType = MailboxType.Inbox,
    val createdAt: String = "Hace 20 min"
)

enum class MailboxType {
    Inbox, Drafts, Sent, Spam
}