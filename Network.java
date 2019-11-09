import java.util.Scanner;

public class Network {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Router router = new Router(n);
        int tc = sc.nextInt();
        for(int i = 0; i < tc; ++i){
            String name = sc.next();
            String type = sc.next();
            Device device = new Device(name, type, router);
            device.start();
        }
        sc.close();
    }
}
