import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class main {

    public static String registerAddress(String register){

        for (int i=0;i<registerArr.length-1;i++){
            if (register.equalsIgnoreCase(registerArr[i][0]))
            {
                return registerArr[i][1];
            }
        }
        return "--";
    }

    private static final String[][] registerArr = new String[8][2];

    public static void initializeRegisters () {
        registerArr[0] = new String[]{"A", "00"};
        registerArr[1] = new String[]{"X", "01"};
        registerArr[2] = new String[]{"B", "04"};
        registerArr[3] = new String[]{"S", "05"};
        registerArr[4] = new String[]{"T", "06"};
        registerArr[5] = new String[]{"F", "07"};
        registerArr[6] = new String[]{"R1", "08"};
        registerArr[7] = new String[]{"R2", "09"};
    }




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

    public static String formatSearch(String fun){
        for (int i = 0;i<59;i++){
            if (OPTAB[i][0].equalsIgnoreCase(fun)){
                return(OPTAB[i][1]).toUpperCase(Locale.ROOT);
            }
        }
        return "00";
    }

    public static String asciiConv(String testS)
    {
        String opC = "";
        for(int i=2;i<testS.length()-1;i++)
        {

            int t = (int) testS.charAt(i);

            opC = opC + t;

        }
        return opC;
    }

    public static String opCodeSearch(String fun){
        for (int i = 0;i<59;i++){
            if (OPTAB[i][0].equalsIgnoreCase(fun)){
                return(OPTAB[i][2]);
            }
        }
        return "--";
    }

    public static String labelAddressSearch(String label, ArrayList labels, ArrayList locTr){
        for(int i=0;i<labels.size();i++){
            if(label.equalsIgnoreCase((String) labels.get(i))){
                String address = (String) locTr.get(i);
                address = "0".repeat(4-address.length()) + address;
                return address.toUpperCase(Locale.ROOT);
            }
        }
        return "0000";
    }

    private static final String[][] OPTAB = new String[59][3];

    public static void initialize () {
        OPTAB[0] = new String[] {"FIX", "1", "C4"};
        OPTAB[1] = new String[] {"FLOAT", "1", "C0"};
        OPTAB[2] = new String[] {"HIO", "1", "F4"};
        OPTAB[3] = new String[] {"NORM", "1", "C8"};
        OPTAB[4] = new String[] {"SIO", "1", "F0"};
        OPTAB[5] = new String[] {"TIO", "1", "F8"};
        OPTAB[6] = new String[] {"ADDR", "2", "90"};
        OPTAB[7] = new String[] {"CLEAR", "2", "B4"};
        OPTAB[8] = new String[] {"COMPR", "2", "A0"};
        OPTAB[9] = new String[] {"DIVR", "2", "9C"};
        OPTAB[10] = new String[] {"MULR", "2", "98"};
        OPTAB[11] = new String[] {"RMO", "2", "AC"};
        OPTAB[12] = new String[] {"SHIFTL", "2", "A4"};
        OPTAB[13] = new String[] {"SHIFTR", "2", "A8"};
        OPTAB[14] = new String[] {"SUBR", "2", "94"};
        OPTAB[15] = new String[] {"SVC", "2", "B0"};
        OPTAB[16] = new String[] {"TIXR", "2", "B8"};
        OPTAB[17] = new String[] {"ADD", "3", "18"};
        OPTAB[18] = new String[] {"ADDF", "3", "58"};
        OPTAB[19] = new String[] {"AND", "3", "40"};
        OPTAB[20] = new String[] {"COMP", "3", "28"};
        OPTAB[21] = new String[] {"COMPF", "3", "88"};
        OPTAB[22] = new String[] {"DIV", "3", "24"};
        OPTAB[23] = new String[] {"DIVF", "3", "64"};
        OPTAB[24] = new String[] {"J", "3", "3C"};
        OPTAB[25] = new String[] {"JEQ", "3", "30"};
        OPTAB[26] = new String[] {"JGT", "3", "34"};
        OPTAB[27] = new String[] {"JLT", "3", "38"};
        OPTAB[28] = new String[] {"JSUB", "3", "48"};
        OPTAB[29] = new String[] {"LDA", "3", "00"};
        OPTAB[30] = new String[] {"LDB", "3", "68"};
        OPTAB[31] = new String[] {"LDCH", "3", "50"};
        OPTAB[32] = new String[] {"LDF", "3", "70"};
        OPTAB[33] = new String[] {"LDL", "3", "08"};
        OPTAB[34] = new String[] {"LDS", "3", "6C"};
        OPTAB[35] = new String[] {"LDT", "3", "74"};
        OPTAB[36] = new String[] {"LDX", "3", "04"};
        OPTAB[37] = new String[] {"LPS", "3", "D0"};
        OPTAB[38] = new String[] {"MUL", "3", "20"};
        OPTAB[39] = new String[] {"MULF", "3", "60"};
        OPTAB[40] = new String[] {"OR", "3", "44"};
        OPTAB[41] = new String[] {"RD", "3", "D8"};
        OPTAB[42] = new String[] {"RSUB", "3", "4C"};
        OPTAB[43] = new String[] {"SSK", "3", "EC"};
        OPTAB[44] = new String[] {"STA", "3", "0C"};
        OPTAB[45] = new String[] {"STB", "3", "78"};
        OPTAB[46] = new String[] {"STCH", "3", "54"};
        OPTAB[47] = new String[] {"STF", "3", "80"};
        OPTAB[48] = new String[] {"STI", "3", "D4"};
        OPTAB[49] = new String[] {"STL", "3", "14"};
        OPTAB[50] = new String[] {"STS", "3", "7C"};
        OPTAB[51] = new String[] {"STSW", "3", "E8"};
        OPTAB[52] = new String[] {"STT", "3", "84"};
        OPTAB[53] = new String[] {"STX", "3", "10"};
        OPTAB[54] = new String[] {"SUB", "3", "1C"};
        OPTAB[55] = new String[] {"SUBF", "3", "5C"};
        OPTAB[56] = new String[] {"TD", "3", "E0"};
        OPTAB[57] = new String[] {"TIX", "3", "2C"};
        OPTAB[58] = new String[] {"WD", "3", "DC"};
    }

    public static void main(String args[]) throws FileNotFoundException {

        initialize();
        initializeRegisters();
        ArrayList<String> label = new ArrayList<>();
        ArrayList<String> funct = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> locctr = new ArrayList<>();
        ArrayList<String> objcode = new ArrayList<>();
        ArrayList<String> hteRecords = new ArrayList<>();
        int base=0;

        File assem1 = new File("inSIC.txt");

        Scanner scan = new Scanner(assem1);

        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] lineArr = line.split(" ");

            if(lineArr.length == 3)
            {
                label.add(lineArr[0]);
                funct.add(lineArr[1]);
                name.add(lineArr[2]);
            }
            else if(lineArr.length == 2)
            {
                label.add("-");
                funct.add(lineArr[0]);
                name.add(lineArr[1]);
            }
            else if(lineArr.length == 1)
            {
                label.add("-");
                funct.add(lineArr[0]);
                name.add("-");
            }
        }

        //printing everything
        for(int x=0; x<label.size(); x++)
        {
            if(label.get(x) != "-")
            {
                System.out.println(label.get(x) + " " + funct.get(x) + " " + name.get(x));
            }
            else{ System.out.println(funct.get(x) + " " + name.get(x));}
        }


        //PASS ONE
        locctr.add(name.get(0));
        locctr.add(name.get(0));

        for (int i=1; i<funct.size();i++)
        {
            if (funct.get(i).equalsIgnoreCase("END"))
            {
                locctr.add(locctr.get(i));
                break;
            }
            else if(funct.get(i).equalsIgnoreCase("base"))
            {
                locctr.add(locctr.get(i));
                for (int z=0;z<funct.size();z++)
                {
                    if (label.get(z).equalsIgnoreCase(name.get(i)))
                    {
                        base = Integer.parseInt(name.get(z),16);
                    }
                }
                System.out.println("\n\nBASE="+base);
            }
            else if(funct.get(i).equalsIgnoreCase("resw")){
                int reswDec = Integer.parseInt(name.get(i))*3 + Integer.parseInt(locctr.get(i),16);
                locctr.add(Integer.toHexString(reswDec));
                continue;
            }
            else if(funct.get(i).equalsIgnoreCase("resb")){
                int resbDec = Integer.parseInt(name.get(i)) + Integer.parseInt(locctr.get(i),16);
                locctr.add(Integer.toHexString(resbDec));
                continue;
            }
            else if(funct.get(i).equalsIgnoreCase("byte")){
                if(name.get(i).startsWith("x")){
                    int len = name.get(i).length() - 3;
                    int byteDec = len/2 + Integer.parseInt(locctr.get(i),16);
                    locctr.add(Integer.toHexString(byteDec));
                }
                else if (name.get(i).startsWith("c")){

                    int len = name.get(i).length() - 3;
                    int byteDec = len + Integer.parseInt(locctr.get(i),16);
                    locctr.add(Integer.toHexString(byteDec));
                }
                continue;
            }
            else if(funct.get(i).equalsIgnoreCase("word")){
                String wordArr[] = name.get(i).split(",");
                if (wordArr.length > 1){
                    int loc = Integer.parseInt(locctr.get(i),16 );
                    loc = loc+wordArr.length*3;
                    locctr.add(Integer.toHexString(loc).toUpperCase(Locale.ROOT));
                }
                else{
                    int loc = Integer.parseInt(locctr.get(i),16 );
                    loc = loc+3;
                    locctr.add(Integer.toHexString(loc).toUpperCase(Locale.ROOT));
                }
                continue;
            }
            else if(funct.get(i).startsWith("+")){
                int loc = Integer.parseInt(locctr.get(i),16 );
                loc = loc+4;
                locctr.add(Integer.toHexString(loc).toUpperCase(Locale.ROOT));
            }
            else if((formatSearch(funct.get(i)).equalsIgnoreCase("2")) || (formatSearch(funct.get(i)).equalsIgnoreCase("1")))
            {
                int loc = Integer.parseInt(locctr.get(i),16);
                loc += Integer.parseInt(formatSearch(funct.get(i)));
                locctr.add(Integer.toHexString(loc).toUpperCase());
                continue;
            }
            else{
                int loc = Integer.parseInt(locctr.get(i),16 );
                loc = loc+3;
                locctr.add(Integer.toHexString(loc).toUpperCase(Locale.ROOT));
            }

        }

        //Symbol Table
        HashMap<String, String> symbolTable = new HashMap<String, String>();
        for (int z=0;z<label.size()-1;z++)
        {
            if (!(label.get(z).equalsIgnoreCase("-"))){
                symbolTable.put(label.get(z),locctr.get(z));
            }
        }


        //PASS TWO
        for(int i=0;i<funct.size();i++)
        {
            if(funct.get(i).equalsIgnoreCase("start") || funct.get(i).equalsIgnoreCase("end") || funct.get(i).equalsIgnoreCase("resw") || funct.get(i).equalsIgnoreCase("resb") || funct.get(i).equalsIgnoreCase("base"))
            {
                objcode.add("-");
            }
            else if(funct.get(i).equalsIgnoreCase("byte"))
            {
                if (name.get(i).startsWith("x")){
                    objcode.add(name.get(i).substring(2,name.get(i).length()-1));
                }
                else if(name.get(i).startsWith("c")){
                    objcode.add(asciiConv(name.get(i)));
                }
            }
            else if(funct.get(i).equalsIgnoreCase("word")){
                    String objC = Integer.toHexString(Integer.parseInt(name.get(i)));
                    if (objC.length()<6){
                        objC = "0".repeat(6-objC.length()) + objC;
                    }
                    objcode.add(objC);
            }
            else
            {
                if (formatSearch(funct.get(i)).equalsIgnoreCase("1"))
                {
                    objcode.add(opCodeSearch(funct.get(i)));
                }

                else if (formatSearch(funct.get(i)).equalsIgnoreCase("2"))
                {
                    StringBuilder tempObjCode = new StringBuilder();
                    tempObjCode.append(opCodeSearch(funct.get(i)));
                    String registers[] = name.get(i).split(",");
                    
                    if (registers.length>1){
                        tempObjCode.append(registerAddress(registers[0]));
                        tempObjCode.append(registerAddress(registers[1]));
                    }
                    
                    else{
                        tempObjCode.append(registerAddress(registers[0]));
                        tempObjCode.append("00");
                    }
                    
                    String finalObjectCode = tempObjCode.toString();
                    objcode.add(finalObjectCode);
                }

                else if (formatSearch(funct.get(i)).equalsIgnoreCase("3")){
                    StringBuilder tempObjCode = new StringBuilder();
                    tempObjCode.append(hexToBin(opCodeSearch(funct.get(i))));
                    tempObjCode.deleteCharAt(7);
                    tempObjCode.deleteCharAt(6);
                    tempObjCode.append("000000");
                    String disp="X";
                    if(name.get(i).contains(",")){
                        tempObjCode.setCharAt(8, '1');
                        String labelSplit[] = name.get(i).split(",");

                        int address = Integer.parseInt(symbolTable.get(labelSplit[0]),16);
                        address = address - Integer.parseInt(locctr.get(i+1),16);
                        if (address>=Integer.parseInt("-2048",16) && address<=Integer.parseInt("2047",16))
                        {
                            tempObjCode.setCharAt(10,'1');
                            disp = Integer.toHexString(address);
                        }
                        else
                        {
                            tempObjCode.setCharAt(9,'1');
                            disp = Integer.toHexString(Integer.parseInt(symbolTable.get(labelSplit[0]),16) - base);
                        }

                    }

                    if(name.get(i).startsWith("#")){
                        tempObjCode.setCharAt(7, '1');
                        String value = name.get(i).substring(1,name.get(i).length());

                        /*#50 -> convert the 50 to hex and store in disp
                         #THREE -> throw exception and do whats in catch block*/
                        try
                        {
                            value = Integer.toHexString(Integer.parseInt(value));
                            disp = "0".repeat(3-value.length()) + value;
                        }
                        catch(Exception e)
                        {

                            int address = Integer.parseInt(symbolTable.get(value),16);
                            address = address - Integer.parseInt(locctr.get(i+1),16);

                            if (address>=Integer.parseInt("-2048",16) && address<=Integer.parseInt("2047",16))
                            {
                                tempObjCode.setCharAt(10,'1');
                                disp = Integer.toHexString(address);
                            }

                            else
                            {
                                tempObjCode.setCharAt(9,'1');
                                disp = Integer.toHexString(Integer.parseInt(symbolTable.get(value),16) - base);
                            }

                        }
                    }
                    else if(name.get(i).startsWith("@")){
                        tempObjCode.setCharAt(6, '1');
                        String value = name.get(i).substring(1,name.get(i).length());
                        int address = Integer.parseInt(symbolTable.get(value),16);
                        address = address - Integer.parseInt(locctr.get(i+1),16);

                        if (address>=Integer.parseInt("-2048",16) && address<=Integer.parseInt("2047",16))
                        {
                            tempObjCode.setCharAt(10,'1');
                            disp = Integer.toHexString(address);
                        }

                        else
                        {
                            tempObjCode.setCharAt(9,'1');
                            disp = Integer.toHexString(Integer.parseInt(symbolTable.get(value),16) - base);
                        }
                    }
                    else
                    {
                        tempObjCode.setCharAt(6, '1');
                        tempObjCode.setCharAt(7, '1');
                    }

                    if (disp.equalsIgnoreCase("X"))
                    {
                        tempObjCode.setCharAt(9,'1');
                        tempObjCode.setCharAt(10,'1');
                        int address = Integer.parseInt(symbolTable.get(name.get(i)),16);
                        address = address - Integer.parseInt(locctr.get(i+1),16);
                        if (address>=Integer.parseInt("-2048",16) && address<=Integer.parseInt("2047",16))
                        {
                            tempObjCode.setCharAt(10,'1');
                            disp = Integer.toHexString(address).toUpperCase(Locale.ROOT);
                        }
                        else
                        {
                            tempObjCode.setCharAt(9,'1');
                            disp = Integer.toHexString(Integer.parseInt(symbolTable.get(name.get(i)),16) - base);
                        }
                    }

                    String finalObjCode="";
                    for (int y=0;y<tempObjCode.length();y++)
                    {
                        String binaryText = tempObjCode.substring(y,y+4);
                        finalObjCode += Integer.toHexString(Integer.parseInt(binaryText,2));
                        y+=3;
                    }
                    objcode.add(finalObjCode.toUpperCase(Locale.ROOT)+"0".repeat(3-disp.length())+disp.toUpperCase(Locale.ROOT));
                }

                else
                {
                    objcode.add("4");
                }
            }
        }




        String progLength = Integer.toHexString(Integer.parseInt(locctr.get(locctr.size()-1),16) - Integer.parseInt(locctr.get(0),16));
        progLength = "0".repeat(6-progLength.length()) + progLength;
        String progName = name.get(name.size()-1);
        progName = "0".repeat(6-progName.length()) + progName;
        String hteStart = "Hn^"+progName+"^"+( "0".repeat(6 - locctr.get(0).length()) + locctr.get(0))+ "^" + progLength;
        hteRecords.add(hteStart);

        int k = 1;
        while( !(funct.get(k).equalsIgnoreCase("end")) )
        {
            if (funct.get(k).equalsIgnoreCase("resw") || funct.get(k).equalsIgnoreCase("resb") ){
                k=k+1;
                continue;
            }

            String startAddress = locctr.get(k);
            String endAddress = "";
            String opcodes = "";

            int i=0;
            while(i<10 && !(funct.get(k).equalsIgnoreCase("resw")) && !(funct.get(k).equalsIgnoreCase("resb")) && !(funct.get(k).equalsIgnoreCase("end")) )
            {
                if (funct.get(k).equalsIgnoreCase("resw") || funct.get(k).equalsIgnoreCase("resb") || funct.get(k).equalsIgnoreCase("end"))
                {
                    k=k-1;
                    break;
                }
                if(funct.get(k).equalsIgnoreCase("base"))
                {
                    endAddress = locctr.get(k+1);
                    k=k+1;
                    continue;
                }
                opcodes = opcodes + objcode.get(k);
                endAddress = locctr.get(k+1);
                i=i+1;
                k=k+1;
            }

            String textLength = Integer.toHexString(Integer.parseInt(endAddress,16) - Integer.parseInt(startAddress,16));
            textLength = "0".repeat(2-textLength.length()) + textLength;

            String hteText = "Tn^"+ "0".repeat(6-startAddress.length()) + startAddress + "^" +textLength+"^"+opcodes;

            hteRecords.add(hteText);
        }

        String hteEnd = "En^" + ( "0".repeat(6 - locctr.get(0).length()) + locctr.get(0));
        hteRecords.add(hteEnd);

        System.out.println("\n\n\n\nSymbol Table");
        System.out.println("---------------------");
        System.out.println("Label\tAddress\n");
        for (int i=0;i<label.size();i++){
            if ( !(label.get(i).equalsIgnoreCase("-")) )
            {
                System.out.println(label.get(i) + "\t" + locctr.get(i));
            }
        }




        //printing everything
        System.out.println("\n\n\n\nLOCATION LABEL INSTRUCTION REFERENCE OBJECTCODE\n");
        for(int x=0; x<label.size(); x++)
        {
            if(label.get(x) != "-")
            {
                System.out.println(locctr.get(x) +" "+ label.get(x) + " " + funct.get(x) + " " + name.get(x) + " " + objcode.get(x));
            }
            else{ System.out.println(locctr.get(x) +" "+funct.get(x) + " " + name.get(x) + " " + objcode.get(x));}
        }

        System.out.println("\nHTE Records: ");
        System.out.println("\n");
        for(int i = 0;i<hteRecords.size();i++)
        {
            System.out.println(hteRecords.get(i));
        }
    }
}