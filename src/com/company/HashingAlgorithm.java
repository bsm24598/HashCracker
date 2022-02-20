package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class HashingAlgorithm {

    /**
     * Class Fields
     */
    private int hashType;
    private Hash hash;
    private File wordListDirectory;
    private long totalPasswordsSearched;
    private String crackedPassword;
    private boolean passwordFound;

    /**
     * Constructor
     * @param hashType
     * @param hash
     * @param wordListDirectory
     */
    public HashingAlgorithm(int hashType, Hash hash, File wordListDirectory) {
        this.hashType = hashType;
        this.hash = hash;
        this.wordListDirectory = wordListDirectory;
        this.totalPasswordsSearched = 0;
        this.crackedPassword = "";
        this.passwordFound = false;
    }

    /**
     * Reads each file in the Dictionary wordlist
     * directory. Each line of each file is read
     * and then sent to a compareHash method in
     * an attempt to crack the hash.
     */
    public void crackHash() {
        BufferedReader reader;
        try {
            for(File file : wordListDirectory.listFiles()) {
                if(file.exists() && file.isFile() && file.canRead()) {
                    System.out.println("Searching File --> " + file.getName());
                    reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while(line != null) {
                        line = reader.readLine();
                        totalPasswordsSearched += 1;
                        if(line != null) {
                            this.passwordFound = compareHashes(line, this.hashType);
                            if(this.passwordFound) {
                                this.crackedPassword = line.strip();
                                return;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * The compareHashes() method compares the original
     * hash to each hashed line of each file in the di-
     * ctionary directory that is provided by the user.
     * Once a hash is matched, the password is confirm-
     * ed as found.
     * @param line
     * @param hashType
     * @return boolean
     * @throws NoSuchAlgorithmException
     */
    private boolean compareHashes(String line, int hashType) throws NoSuchAlgorithmException {
        MessageDigest md;
        if(hashType == 1) {
            md = MessageDigest.getInstance("MD5");
        } else if(hashType == 2) {
            md = MessageDigest.getInstance("SHA1");
        } else {
            md = MessageDigest.getInstance("SHA-256");
        }
        md.update(line.strip().getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String lineHash = Hex.encodeHexString(digest);
        return lineHash.equals(this.hash.getHash());
    }

    /**
     * Gets the Hash object
     * @return Hash
     */
    public Hash getHash() {
        return hash;
    }

    /**
     * Gets the total number of passwords
     * searched during the cracking process.
     * @return long
     */
    public long getTotalPasswordsSearched() {
        return totalPasswordsSearched;
    }

    /**
     * Gets the clear text cracked password
     * @return String
     */
    public String getCrackedPassword() {
        return crackedPassword;
    }

    /**
     * Gets whether or not the password
     * has been found by the hashing
     * algorithm.
     * @return
     */
    public boolean isPasswordFound() {
        return passwordFound;
    }
}
