package me.SavageUser.CustomDeaths;

import io.github.aleksandarharalanov.chatguard.ChatGuard;

public class ChatGuardUtil {

    public static Core plugin;

    public ChatGuardUtil(Core plugin) {
        ChatGuardUtil.plugin = plugin;
    }

    public static boolean hasWebhookURL() {
        if (ChatGuard.getDiscord().getString("webhook-url").isEmpty()) return false;
        else return true;
    }
}
