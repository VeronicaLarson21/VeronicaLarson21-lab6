import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonalTester{ 

    @Test
    public void rotateTester1(){
        Rotor testRot = new Rotor("ABZ", 't');
        boolean bool = testRot.rotate();
        assertEquals("ZAB",testRot.getRotorValue());
    }

    @Test
    public void rotateTester2(){
        Rotor testRot = new Rotor("ABZEDQRSTUVWZYZOPEQZSLSNRISDNRODFGGHHAOE", 't');
        boolean bool = testRot.rotate();
        assertEquals("EABZEDQRSTUVWZYZOPEQZSLSNRISDNRODFGGHHAO",testRot.getRotorValue());
    }

    @Test
    public void rotateTester3(){
        Rotor[] rotorArr = new Rotor[3];
        rotorArr[0] = new Rotor("ABC", 'A');
        rotorArr[1] = new Rotor("QRS", 'Q');
        rotorArr[2] = new Rotor("XYZ", 'X');
        for(int i = 0; i<8; i++){
            rotate(rotorArr);
        }
        String[] compArr = {"ABC","QRS","XYZ"};
        String[] actArr = {rotorArr[0].getRotorValue(),rotorArr[1].getRotorValue(),rotorArr[2].getRotorValue()};
        assertEquals(compArr,actArr);
    }
    
    private void rotate(Rotor[] rotors){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
}

