package com.company;

import static org.junit.jupiter.api.Assertions.*;

class HashTest {

    /////////////////////////////////////////
    // MD5 Hash Tests
    ////////////////////////////////////////

    @org.junit.jupiter.api.Test
    void checkMd5Hash1() {
        //valid MD5 Hash - 32 AlphaNumeric Characters
        //Option 1 Selected
        Hash hash = new Hash("5f4dcc3b5aa765d61d8327deb882cf99");
        assertTrue(hash.isHashValid(1));
    }

    @org.junit.jupiter.api.Test
    void checkMd5Hash2() {
        //Invalid MD5 Hash - 31 AlphaNumeric Characters
        //Option 1 Selected
        Hash hash = new Hash("5f4dcc3b5aa765d61d8327deb882cf9");
        assertFalse(hash.isHashValid(1));
    }

    @org.junit.jupiter.api.Test
    void checkMd5Hash3() {
        //Invalid MD5 Hash - More than 32 Characters
        //Option 1 Selected
        Hash hash = new Hash("5f4dcc3b5aa765d61d8327deb882cf99234");
        assertFalse(hash.isHashValid(1));
    }

    @org.junit.jupiter.api.Test
    void checkMd5Hash4() {
        //Invalid MD5 Hash - 32 Characters with space
        //Option 1 Selected
        Hash hash = new Hash("5f4dcc3b5aa765d 1d8327deb882cf99");
        assertFalse(hash.isHashValid(1));
    }

    @org.junit.jupiter.api.Test
    void checkMd5Hash5() {
        //Invalid MD5 Hash - 32 Characters with special character
        //Option 1 Selected
        Hash hash = new Hash("5f4dcc3b5aa765d61d8327deb88#cf99");
        assertFalse(hash.isHashValid(1));
    }

    /////////////////////////////////////////
    // SHA-1 Hash Tests - Option 2
    ////////////////////////////////////////

    @org.junit.jupiter.api.Test
    void checkSha1Hash1() {
        //Valid SHA1 Hash - 40 Characters Long
        //Option 2 Selected
        Hash hash = new Hash("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8");
        assertTrue(hash.isHashValid(2));
    }

    @org.junit.jupiter.api.Test
    void checkSha1Hash2() {
        //Invalid SHA1 Hash - 39 Characters Long
        //Option 2 Selected
        Hash hash = new Hash("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd");
        assertFalse(hash.isHashValid(2));
    }

    @org.junit.jupiter.api.Test
    void checkSha1Hash3() {
        //Invalid SHA1 Hash - 41 Characters Long
        //Option 2 Selected
        Hash hash = new Hash("5baa61e4c9b93f3f0682250b6cf8331b7ee68fddd");
        assertFalse(hash.isHashValid(2));
    }

    @org.junit.jupiter.api.Test
    void checkSha1Hash4() {
        //Invalid SHA1 Hash - 40 Characters Long with space
        //Option 2 Selected
        Hash hash = new Hash("5baa6 e4c9b93f3f0682250b6cf8331b7ee68fdd");
        assertFalse(hash.isHashValid(2));
    }
    /////////////////////////////////////////
    // SHA-256 Hash Tests - Option 3
    ////////////////////////////////////////

    @org.junit.jupiter.api.Test
    void checkSha256Hash1() {
        //Valid SHA256 Hash - 64 Characters Long
        //Option 3 Selected
        Hash hash = new Hash("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        assertTrue(hash.isHashValid(3));
    }

    @org.junit.jupiter.api.Test
    void checkSha256Hash2() {
        //Invalid SHA256 Hash - 63 Characters Long
        //Option 3 Selected
        Hash hash = new Hash("e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        assertFalse(hash.isHashValid(3));
    }

    @org.junit.jupiter.api.Test
    void checkSha256Hash3() {
        //Invalid SHA256 Hash - 65 Characters Long
        //Option 3 Selected
        Hash hash = new Hash("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d84");
        assertFalse(hash.isHashValid(3));
    }

    @org.junit.jupiter.api.Test
    void checkSha256Hash4() {
        //Invalid SHA1 Hash - 64 Characters Long with space
        //Option 3 Selected
        Hash hash = new Hash("5e884898da28047151d0e56f8dc6292773603d0d6aabbd 62a11ef721d1542d8");
        assertFalse(hash.isHashValid(3));
    }
}