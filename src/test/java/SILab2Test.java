import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    // CFG 23 - 17 + 2 = 8
    // CFG 7 + 1 = 8
    // CFG 8 = 8

    SILab2 siLab2 = new SILab2();

    @Test
    void testEveryStatement() {
        // user: null, allUsers: null
        // Nodes 1, 2, 16
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> siLab2.function(null, null));
        assertTrue(runtimeException.getMessage()
                .contains("The user argument is not initialized!"));

        // user: new User(null, null, null), allUsers: null
        // Nodes 1, 3, 4, 16
        runtimeException = assertThrows(RuntimeException.class,
                () -> siLab2.function(new User(null, null, null), null));
        assertTrue(runtimeException.getMessage()
                .contains("User already exists!"));

        // user: new User("185034", "password", null), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 6, 16
        assertFalse(siLab2.function(new User("185034", "password", null), new ArrayList<>()));

        // user: new User("185034", "password", ""), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, 8.2, 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", ""), new ArrayList<>()));

        // user: new User("185034", "password", "stefan.vasovski@students.finki.ukim.mk"), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, 8.2, 8.3, 9, 10, 11, 12, 13, 15, 16
        assertTrue(siLab2.function(new User("185034", "password", "stefan.vasovski@students.finki.ukim.mk"),
                new ArrayList<>()));
    }

    @Test
    void testEveryPath() {
        // user: null, allUsers: null
        // Nodes 1, 2, 16
        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> siLab2.function(null, null));
        assertTrue(runtimeException.getMessage()
                .contains("The user argument is not initialized!"));

        // user: new User(null, null, null), allUsers: null
        // Nodes 1, 3, 4, 16
        runtimeException = assertThrows(RuntimeException.class,
                () -> siLab2.function(new User(null, null, null), null));
        assertTrue(runtimeException.getMessage()
                .contains("User already exists!"));

        // user: new User("185034", "password", null), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 6, 16
        assertFalse(siLab2.function(new User("185034", "password", null), new ArrayList<>()));

        // user: new User("185034", "password", ""), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, 8.2, 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", ""), new ArrayList<>()));

        // Nodes 1, 3, 5, 7, 8.1, 8.2, 13, 15, 16 - NOT POSSIBLE (Cannot set flags to true)

        // user: new User("185034", "password", "asd"), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 11, 8.3), 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", "asd"),
                new ArrayList<>()));

        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 11, 8.3), 13, 15, 16 - NOT POSSIBLE (Cannot set flags to true)

        // user: new User("185034", "password", "@@@"), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 10, 11, 8.3), 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", "@@@"),
                new ArrayList<>()));

        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 10, 11, 8.3), 13, 15, 16 - NOT POSSIBLE (Cannot set flags to true)

        // user: new User("185034", "password", "..."), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 11, 12, 8.3), 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", "..."),
                new ArrayList<>()));

        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 11, 12, 8.3), 13, 15, 16 - NOT POSSIBLE (Cannot set flags to true)

        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 10, 11, 12, 8.3), 13, 14, 16 - NOT POSSIBLE (Char can not be both)

        // Nodes 1, 3, 5, 7, 8.1, (8.2, 9, 10, 11, 12, 8.3), 13, 15, 16 - NOT POSSIBLE (Char can not be both)

        // user: new User("185034", "password", "stefan.vasovski@students.finki.ukim.mk"), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, (mixed), 13, 15, 16
        assertTrue(siLab2.function(new User("185034", "password", "stefan.vasovski@students.finki.ukim.mk"),
                new ArrayList<>()));

        // user: new User("185034", "password", "asd@@@"), allUsers: new ArrayList<>()
        // Nodes 1, 3, 5, 7, 8.1, (mixed), 13, 14, 16
        assertFalse(siLab2.function(new User("185034", "password", "asd@@@"),
                new ArrayList<>()));
    }
}