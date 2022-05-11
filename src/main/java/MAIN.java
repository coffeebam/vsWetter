import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MAIN {

    public MAIN(){
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        COMPARE compare = new COMPARE();
        compare.fetchData();
    }

}
