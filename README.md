# Java HashCracker

### Educational Hash Cracker Written in Java

This is an educational hash/password cracker that can be used for Capture the Flag (CTF) competitions. 

1. Download and run the jar file
2. Select your Hashing Algorithm
3. Input your Hashed password
4. Provide a directory path to where your wordlist/dictionary files are located

Example directory: /home/{user}/wordlists

Example directory structure:

<pre>
wordlists/
├── english-words.txt
├── general.txt
├── large_files
│   ├── crackstation.txt
│   └── rockyou.txt
├── passwords.txt
├── sports
│   ├── baseball.txt
│   └── football.txt
└── words.txt
</pre>

Example Hashes to try:

- **MD5 Hash**     - 482c811da5d5b4bc6d497ffa98491e38
- **SHA1 Hash**    - cbfdac6008f9cab4083784cbd1874f76618d2a97
- **SHA-256 Hash** - ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f

![password-found](https://user-images.githubusercontent.com/49283017/154895284-97ba8903-7cb7-4725-b3f6-a2a396f860d7.gif)

**Wordlists**:

[Crackstation](https://crackstation.net/crackstation-wordlist-password-cracking-dictionary.htm)
