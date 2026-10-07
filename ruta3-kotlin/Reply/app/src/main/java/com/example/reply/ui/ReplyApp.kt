package com.example.reply.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Drafts
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reply.data.MailboxType

enum class ReplyNavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL
}

enum class ReplyContentType {
    LIST_ONLY, LIST_AND_DETAIL
}

@Composable
fun ReplyApp(
    windowSize: WindowWidthSizeClass,
    replyViewModel: ReplyViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val replyUiState by replyViewModel.uiState.collectAsState()

    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }

    ReplyAppContent(
        navigationType = navigationType,
        contentType = contentType,
        replyUiState = replyUiState,
        onTabPressed = { mailbox -> replyViewModel.updateCurrentMailbox(mailbox) },
        onEmailCardPressed = { email -> replyViewModel.updateDetailsScreenStates(email) },
        onDetailScreenBackPressed = { replyViewModel.resetHomeScreenStates() },
        modifier = modifier
    )
}

@Composable
fun ReplyAppContent(
    navigationType: ReplyNavigationType,
    contentType: ReplyContentType,
    replyUiState: ReplyUiState,
    onTabPressed: (MailboxType) -> Unit,
    onEmailCardPressed: (com.example.reply.data.Email) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        if (navigationType == ReplyNavigationType.NAVIGATION_RAIL) {
            ReplyNavigationRail(
                currentTab = replyUiState.currentMailbox,
                onTabPressed = onTabPressed
            )
        }

        Scaffold(
            bottomBar = {
                if (navigationType == ReplyNavigationType.BOTTOM_NAVIGATION) {
                    ReplyBottomNavigationBar(
                        currentTab = replyUiState.currentMailbox,
                        onTabPressed = onTabPressed
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (contentType == ReplyContentType.LIST_AND_DETAIL) {
                    ReplyListAndDetailContent(
                        replyUiState = replyUiState,
                        onEmailCardPressed = onEmailCardPressed
                    )
                } else {
                    if (replyUiState.isShowingHomepage) {
                        ReplyEmailList(
                            emails = replyUiState.currentMailboxEmails,
                            selectedEmail = replyUiState.currentSelectedEmail,
                            onEmailCardPressed = onEmailCardPressed
                        )
                    } else {
                        ReplyEmailDetail(
                            email = replyUiState.currentSelectedEmail,
                            isFullScreen = true,
                            onBackPressed = onDetailScreenBackPressed
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ReplyBottomNavigationBar(
    currentTab: MailboxType,
    onTabPressed: (MailboxType) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = currentTab == MailboxType.Inbox,
            onClick = { onTabPressed(MailboxType.Inbox) },
            icon = { Icon(Icons.Default.Inbox, contentDescription = "Inbox") },
            label = { Text("Recibidos") }
        )
        NavigationBarItem(
            selected = currentTab == MailboxType.Sent,
            onClick = { onTabPressed(MailboxType.Sent) },
            icon = { Icon(Icons.Default.Send, contentDescription = "Sent") },
            label = { Text("Enviados") }
        )
        NavigationBarItem(
            selected = currentTab == MailboxType.Drafts,
            onClick = { onTabPressed(MailboxType.Drafts) },
            icon = { Icon(Icons.Default.Drafts, contentDescription = "Drafts") },
            label = { Text("Borradores") }
        )
    }
}

@Composable
fun ReplyNavigationRail(
    currentTab: MailboxType,
    onTabPressed: (MailboxType) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        NavigationRailItem(
            selected = currentTab == MailboxType.Inbox,
            onClick = { onTabPressed(MailboxType.Inbox) },
            icon = { Icon(Icons.Default.Inbox, contentDescription = "Inbox") },
            label = { Text("Inbox") }
        )
        NavigationRailItem(
            selected = currentTab == MailboxType.Sent,
            onClick = { onTabPressed(MailboxType.Sent) },
            icon = { Icon(Icons.Default.Send, contentDescription = "Sent") },
            label = { Text("Enviados") }
        )
        NavigationRailItem(
            selected = currentTab == MailboxType.Drafts,
            onClick = { onTabPressed(MailboxType.Drafts) },
            icon = { Icon(Icons.Default.Drafts, contentDescription = "Drafts") },
            label = { Text("Borrador") }
        )
    }
}