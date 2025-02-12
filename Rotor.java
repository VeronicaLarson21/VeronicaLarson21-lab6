public class Rotor {

    //Represents the characters of the rotor (26 letters of alphabet+# representing a space between the last and first
    private String rotorValues;
    //Represents the char that starts at the top of the rotor
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        //Until I get the rest of this figured out I am leaving this functionality out
        //while(!this.rotate());
            
    }

    /// @brief Rotates the rotor one click, and returns true if the rotor is at its original case when completed
    /// @return True if the rotor is in starting position
    public boolean rotate(){

      //To facilitate a iterative approach first the rotor string is converted to a char array, and we record the last element of that (the moved one)
      char[] convertedRotor = rotorValues.toCharArray();
      char movedChar = convertedRotor[convertedRotor.length];

      //To accomplish rotation a iterative loop is used to shift each element accordingly
      for(int i = convertedRotor.length-1; i>=1; i--){
          convertedRotor[i]=convertedRotor[i-1];
      }
      //Once this loop is done, all values are correct except at zero
      convertedRotor[0] = movedChar;

      //Then we turn the array into a string and make it the class var
      rotorValues = new String(convertedRotor);

      //Then for the return we compare the og 0th char and the current 0th char
      if(convertedRotor[0]==startChar){
          return true;
      }
      else{
          return false;
      }
    }
    
    /// @brief Returns the index of the input char in the rotor
    /// @param c The char for the function to look for
    /// @return The index of the char if it exists in the rotor, if it doesnt, -1
    public int indexOf(char c){
        //To facilitate a iterative approach, we convert the rotor string first
        char[] convertedRotor = rotorValues.toCharArray();

        //To find the string we use a iterative loop
        for(int i = 0; i<convertedRotor.length; i++){
            //If the current value is the value to look for, we simply return the current index
            if(convertedRotor[i]==c){
                return i;
            }
        }

        //If the function hasnt returned a value yet, the char doesnt exist in the rotor string
        return -1;
    }
    /// @brief Returns the char at a given index of the current rotor value
    /// @param idx The index to return the char from
    /// @return The char at the index if the index is valid, if the index is not valid, returns !
    public char charAt(int idx){
        //To make this easier we convert the rotor value to a char array first
        char[] convertedRotor = rotorValues.toCharArray();

        //Then before we acess, we check to make sure that the input is valid
        if( idx<0 || idx > convertedRotor.length-1){
            return '!';
        }
        else{
            return convertedRotor[idx];
        }
    }
}
    
