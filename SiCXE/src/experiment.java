import java.io.FileNotFoundException;
import java.math.BigInteger;

public class experiment {

    private static String hexToBin(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }

    public static void opCode()
    {
        System.out.println("hello");
        String hex = "18";
        StringBuilder bin = new StringBuilder();
        bin.append(hexToBin(hex));
        System.out.println(bin);
        System.out.println(bin.length());
        bin.deleteCharAt(7);
        bin.deleteCharAt(6);
        System.out.println(bin);
        System.out.println(bin.length());


        //APPENDING NIXBPE
        bin.append("100100");
        System.out.println(bin);
        System.out.println(bin.length());

        //Converting binary to HEX
        int hexStop=0;
        String opCode="";
        for (int i=0;i<bin.length()-1;i++){
            System.out.println("\n\n");
            System.out.println("I in this iteration:");
            System.out.println(i);

            System.out.println("Binary");
            String binText = bin.substring(i,i+4);
            System.out.println(binText);
            System.out.println("HEX");
            opCode += Integer.toHexString(Integer.parseInt(binText,2));
            System.out.println(binText);


            i+=3;
        }
        System.out.println("\n\n\n");
        System.out.println("OPCODE");
        System.out.println(opCode);
    }

    public static void main(String args[]) throws FileNotFoundException{
        String test = "#5000";
        String test1 = "#omar";
        String omar = "";
        int yes = 0;
        try
        {
            yes = Integer.parseInt(test.substring(1,test.length()),16);
            yes = Integer.parseInt(test1,16);
        }
        catch (Exception e)
        {
            omar = test1.substring(1,test1.length());
        }
        System.out.println(omar);
        System.out.println(yes);
    }



    //Else Condition PASS TWO
    /*
    if(name.get(i).split(",").length > 1){
                    String objC=opCodeSearch(funct.get(i));
                    String indexed[] = name.get(i).split(",");
                    String address = labelAddressSearch(indexed[0], label, locctr);
                    String indexAdd = "8000";
                    //Since we add 8000 hex not 8000 decimal we'll parse it with base 16 and add to address only not whole Object code.
                    address = Integer.toHexString(Integer.parseInt(address,16) + Integer.parseInt(indexAdd,16));
                    address = "0".repeat(4-address.length()) + address;
                    objcode.add(objC+address.toUpperCase(Locale.ROOT));
                }
                else
                {
                    String objC=opCodeSearch(funct.get(i));
                    String address = labelAddressSearch(name.get(i), label, locctr);
                    objcode.add(objC+address);
                }
     */

    /*

     */


}
