public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        /*
            Steps to Decrypt(starts with last char)
            1. Find char on outer rotor(searchbychar)
            2. Find char on same space in middle rotor(searchbyindex)
            3. Find that char on outer rotor(searchbychar)
            4. Output char at same space as previous on inside rotor(searchbyindex)
            5. Rotate accordingly
        */

        //To facilitate a iterative approach to this problem, we convert the message to a charArray
        char[] convertedMessage = message.toCharArray();

        //We also create a char array to hold the decrypted string
        char[] decryptedMessage = new char[convertedMessage.length];

        //For the iterative method two helper variables are created
        int index = -1;
        char curChar = '!';

        //An iterative approach is the best way to tackle this
        for(int i = 0; i < convertedMessage.length; i++){
            //Step 1 as noted above
            index = rotors[2].indexOf(convertedMessage[i]);
            //Step 2 as noted above
            curChar = rotors[1].charAt(index);
            //Step 3 as noted above
            index = rotors[2].indexOf(curChar);
            //Step 4 as noted above
            curChar = rotors[0].charAt(index);
            //Step 5 as noted above
            rotate();
            //Just adding the decrypted output char to our array in the right spot
            decryptedMessage[i] = curChar;
        }

        //This just turns the charArray of the encrypted message into a string we can output
        String decryptedMsg = new String(decryptedMessage);

        return decryptedMsg;
    }


    
    public String encrypt(String message){
        /* 
            Steps to Encrypt(starts with first char)
            1. Find char on inner rotor (searchbychar)
            2. Find char on same space on outer rotor(searchbyindex)
            3. Find outer rotor char on middle rotor(searchbychar)
            4. Output that outor rotor char
            5. Rotate inside rotor, if reached original pos after, rotate next wheel
        */

        //To facilitate a iterative approach to this problem, we convert the message to a charArray
        char[] convertedMessage = message.toCharArray();

        //We also create a char array to hold the encrypted string
        char[] encryptedMessage = new char[convertedMessage.length];

        //For the iterative method two helper variables are created
        int index = -1;
        char curChar = '!';

        //An iterative approach is the best way to tackle this
        for(int i = 0; i < convertedMessage.length; i++){
            //Step 1 as noted above
            index = rotors[0].indexOf(convertedMessage[i]);
            //Step 2 as noted above
            curChar = rotors[2].charAt(index);
            //Step 3 as noted above
            index = rotors[1].indexOf(curChar);
            //Step 4 as noted above
            curChar = rotors[2].charAt(index);
            //Step 5 as noted above
            rotate();
            //Just adding the encrypted output char to our array in the right spot
            encryptedMessage[i] = curChar;
        }

        //This just turns the charArray of the encrypted message into a string we can output
        String encryptedMsg = new String(encryptedMessage);

        return encryptedMsg;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
