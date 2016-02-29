package org.kaushik.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.messanger.model.Profile;

public class Database {

private static Map <Long,Message> messages = new HashMap<Long, Message>();
private static Map <Long,Profile> profiles = new HashMap<Long,Profile>();


public static Map<Long, Message> getMessages() {
	return messages;
}

public static void setMessages(Map<Long, Message> messages) {
	Database.messages = messages;
}

public static Map<Long, Profile> getProfiles() {
	return profiles;
}

public static void setProfiles(Map<Long, Profile> profiles) {
	Database.profiles = profiles;
}


	
	
}
