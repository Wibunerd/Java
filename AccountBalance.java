import mypack.*;
class AccountBalance {
    public static void main(String[] args){
        mypack.Balance[] current = new mypack.Balance[3];
        current[0] = Balance("Mike", 10000);
        current[1] = Balance("Jason", 20000);
        current[2] = Balance("Jack", -5000);

        for(int i = 0; i<3; i++){
            current[i].show();
        }
    }
}