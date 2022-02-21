package com.company;

import java.util.regex.*;

public class Hash {

    /**
     * Class Fields
     */
    private boolean hashIsValid;
    private final String hash;
    private int hashType;
    private String clearText;

    /**
     * Constructor
     * @param hash
     */
    public Hash(String hash) {
        this.hash = hash;
        this.hashIsValid = checkMd5Hash(this.hash);
        this.hashType = 0;
        this.clearText = "";
    }

    /**
     * The checkMd5Hash() method provides simple validation
     * checks for an MD5 Hash.
     * @param userHash
     * @return boolean
     */
    private boolean checkMd5Hash(String userHash) {
        String regex = "^[a-zA-Z0-9]+$";
        return Pattern.matches(regex, userHash) && userHash.length() == 32;
    }

    /**
     * The checkSha1Hash() method provides simple validation
     * checks for a SHA1 Hash.
     * @param userHash
     * @return boolean
     */
    private boolean checkSha1Hash(String userHash) {
        String regex = "^[a-zA-Z0-9]+$";
        return Pattern.matches(regex, userHash) && userHash.length() == 40;
    }

    /**
     * The checkSha256Hash() method provides simple validation
     * checks for an SHA-256 Hash.
     * @param userHash
     * @return boolean
     */
    private boolean checkSha256Hash(String userHash) {
        String regex = "^[a-zA-Z0-9]+$";
        return Pattern.matches(regex, userHash) && userHash.length() == 64;
    }

    /**
     * The isHashValid() method checks whether a
     * hash is valid using three different methods.
     * 1. checkMd5HAsh
     * 2. checkSha1Hash
     * 3. cehckSha256Hash
     * These may be compiled or expanded in the
     * future.
     * @param hashOption
     * @return boolean
     */
    public boolean isHashValid(int hashOption) {
        switch (hashOption) {
            case 1:
                return checkMd5Hash(this.hash);
            case 2:
                return checkSha1Hash(this.hash);
            case 3:
                return checkSha256Hash(this.hash);
        }
        return false;
    }

    /**
     * Gets the user hash string
     * @return String
     */
    public String getHash() {
        return hash;
    }

    /**
     * Gets the type of hashing algorithm
     * to be used.
     * @return int
     */
    public int getHashType() {
        return this.hashType;
    }

    /**
     * Gets the clear text string of
     * the hash that was cracked.
     * @return String
     */
    public String getClearText() {
        return this.clearText;
    }

    /**
     * Sets the Hashing algorithm type
     * @param type
     */
    public void setHashType(int type) {
        this.hashType = type;
    }

    /**
     * Sets the clear text hash string
     * @param text
     */
    public void setClearText(String text) {
        this.clearText = text;
    }
}
