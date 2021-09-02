package com.example.homecookBackend.classes; /**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateTrabalhoDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(TrabalhoPersistentManager.instance());
			TrabalhoPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
