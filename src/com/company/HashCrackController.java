package com.company;

import java.io.File;
import java.util.*;


public class HashCrackController {

    /**
     * Class Fields
     */
    private boolean menuFlag;
    private boolean isHashValid;
    private final Scanner scanner = new Scanner(System.in);
    private File wordlistDirectoryPath;


    /**
     * Constructor
     */
    public HashCrackController() {
        this.menuFlag = true;
        this.isHashValid = false;
    }

    /**
     * The run() method controls the flow of the program and
     * displays whether the password hash was cracked or not.
     */
    public void run() {
        displayMenu();
        int hashingOption  = selectHashingAlgorithm();
        Hash userHash = getUserHash(hashingOption);
        userHash.setHashType(hashingOption);
        getDictionaryFolderPath();
        HashingAlgorithm hashingAlgorithm = new HashingAlgorithm(
                userHash.getHashType(), userHash, wordlistDirectoryPath
        );
        hashingAlgorithm.crackHash();
        printClosingMenu(hashingAlgorithm);
    }

    /**
     * The selectHashingAlgorithm() method gets input
     * from the user and determines which hashing al-
     * gorithm should be used.
     * @return int
     */
    private int selectHashingAlgorithm() {
        while(menuFlag) {
            String userInput = scanner.nextLine();
            userInput = userInput.strip();
            switch (userInput) {
                case "1":
                    System.out.println("\nMD5 Hashing Algorithm Selected");
                    menuFlag = false;
                    return 1;
                case "2":
                    System.out.println("\nSHA-1 Hashing Algorithm Selected");
                    menuFlag = false;
                    return 2;
                case "3":
                    System.out.println("\nSHA-256 Hashing Algorithm Selected");
                    menuFlag = false;
                    return 3;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }
        return 1;
    }

    /**
     * The getUserHash() method gets a hash from the
     * user and performs simple validation checks to
     * ensure they have submitted a valid string.
     * @param hashOption
     * @return
     */
    private Hash getUserHash(int hashOption) {
        //while hash is not confirmed to be valid
        while(!isHashValid) {
            System.out.println("Enter Hash: ");
            String userHashInput = scanner.nextLine();
            Hash hash = new Hash(userHashInput.strip());
            if(hash.isHashValid(hashOption)) {
                this.isHashValid = true;
                return hash;
            } else {
                System.out.println("Please enter a valid Hash");
            }
        }
        return null;
    }

    /**
     * The getDictionaryFolderPath() method gets a folder
     * path from the user, ensures it is a directory that
     * does exist, can be read, and has contents. If an
     * invalid path is provided, the prompt will loop for
     * a valid file path.
     */
    private void getDictionaryFolderPath() {
        boolean pathIsValid = false;
        File f;
        while(!pathIsValid) {
            System.out.println("\nPlease provide the File Path to the Directory Containing your Wordlists");
            System.out.println("Enter Path: ");
            String filePath = scanner.nextLine();
            try {
                f = new File(filePath);
                if(f.exists() && f.isDirectory() && f.canRead()) {
                    String[] files = f.list();
                    if(files.length < 1) {
                        System.out.println("" +
                                "Folder Is Empty \n" +
                                "Please provide a Folder Path with Dictionary Files"
                        );
                    } else {
                        this.wordlistDirectoryPath = f;
                        pathIsValid = true;
                    }
                }
            } catch(Error error) {
                System.out.println("Error Validating File Path");
                System.out.println("Please Provide a Valid File Path");
            }
        }
    }

    /**
     * The displayMenu() method will display the
     * welcome menu and hashing algorithm options.
     */
    private void displayMenu() {
        System.out.println("=".repeat(40));
        System.out.println("Hash Crack");
        System.out.println("=".repeat(40));
        System.out.println("-".repeat(40));
        System.out.println("1 - MD5 Hashing Algorithm");
        System.out.println("2 - SHA-1 Hashing Algorithm");
        System.out.println("3 - SHA-256 Hashing Algorithm");
        System.out.println("-".repeat(40));
        System.out.println("Please select a Hashing Algorithm from Above");
        System.out.println("\nEnter Number: ");
    }

    /**
     * The printClosingMenu() method will display the
     * closing menu and whether or not the password
     * was cracked. It will also display how many
     * password file lines were read during the
     * cracking process.
     * @param hashingAlgorithm
     */
    private void printClosingMenu(HashingAlgorithm hashingAlgorithm) {
        if(hashingAlgorithm.isPasswordFound()) {
            System.out.println("\n" + "$".repeat(50));
            System.out.println("Password Found: " + hashingAlgorithm.getCrackedPassword());
            System.out.println("Lines Searched: " + hashingAlgorithm.getTotalPasswordsSearched());
            System.out.println("$".repeat(50));
        } else {
            System.out.println("\n" + ":( ".repeat(15));
            System.out.println("Password Not Found");
            System.out.println("Lines Searched: " + hashingAlgorithm.getTotalPasswordsSearched());
            System.out.println(":( ".repeat(15));
        }
    }
}
