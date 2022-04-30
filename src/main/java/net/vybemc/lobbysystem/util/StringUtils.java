package net.vybemc.lobbysystem.util;

public class StringUtils{

    public static String getMainPrefix(){
        return "§8[§6§lVybeMC§8] §7";
    }

    public static String getLobbyPrefix(){
        return "§8[§5§lLobby§8] §7";
    }

    public static String replaceColorCodes(String string){
        return string.replaceAll("&", "§");
    }

    public static String getNoPermMessage(){
        return "§cYou don't have permission to use this command!";
    }

}
