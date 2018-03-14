package battlefield;

public class BF_1942 {
    static {
        System.out.println("1942");
    }
    public static void main(String[] args) {
        System.out.println(returnTry());
    }
    public static int returnTry(){
        int x=5;
        try {
            return retVal(x);
        }
        finally {
            x=6;
        }
    }
    public static int retVal(int x){
        return x;
    }
}

class Expantion{
    static {
        System.out.println("expan");
    }
}